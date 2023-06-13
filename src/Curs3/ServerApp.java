package Curs3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;


public class ServerApp {
    private int port;
    private CopyOnWriteArrayList<ReadWrite> connections;
    private List<FileToSend> listFiles;

    public ServerApp(int port) {
        this.port = port;
        connections = new CopyOnWriteArrayList<>();
        listFiles = new ArrayList<>();
    }

    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен...");

            while (true) {

                // подключать клиента не нужно в отдельном потоке,
                // только взаимодействовать с ним
                Socket socket = serverSocket.accept();
                ReadWrite readWrite = new ReadWrite(socket);

                // нет смысла проверять через contains, новый объект, никогда не вернет true при сравнении ссылок
                connections.add(readWrite);
                // нет смысла проверять, если socket - null, значит accept вылетит с ошибкой,
                // инструкции дальше не пойдут
                // if(socket == null) System.out.println("socket is null");

                // у потока слишком много инструкций, лучше вынести их в отдельный класс
                new Thread(() ->
                {
                    while (true) {

                        Message requestMessage = read(readWrite);

                        // если сообщение - null, значит соединение с клиентов потеряно,
                        // удаляем его из коллекции и закрываем readWrite без проверок
                        // socket и readWrite не могут быть null к этому моменту
                        // использование removeIf - лишнее, достаточно remove,
                        // тк нужно удалить один объект

                        if (requestMessage == null) {
                            //при открытии клиента  автоматически происходит
                            //первое обращение к серверу с пустым сообщением
                            System.out.println("Потеряна связь с клиентом!");
                            //закрываем соединение
                            connections.remove(readWrite);
                            readWrite.close();
                            // если соединение разорвано, то и работать с клиентом не получится,
                            // в потоке больше нет смысла
                            return;
                        }

                        System.out.println("Есть связь с клиентом!");

                        if ("stop".equals(requestMessage.getTextOnly())) {
                           // закрываем соединение, как и при message == null
                           connections.remove(readWrite);
                           readWrite.close();
                           return;
                        }
                        if ("Требуется список файлов".equals(requestMessage.getTextOnly())
                            || "Запрос на файл".equals(requestMessage.getText())) {
                            //посылаем текущему клиенту перечень файлов или запрошенный файл
                            try {
                                    sendResponse(readWrite, requestMessage);
                                } catch (IOException e) {
                                    // закрываем соединение, как и при message == null
                                    connections.remove(readWrite);
                                    readWrite.close();
                                    return;
                                }
                            }else {
                                // в остальных случаях прочитанное сообщение
                                // должно быть разослано всем клиентам за исключением текущего
                                if("Загрузка файла на сервер".equals(requestMessage.getTextOnly()))
                                {
                                    //добавляем файл в список файлов
                                    System.out.println("Test");
                                    listFiles.add(requestMessage.getFileToSend());
                                }

                                connections.forEach(connection ->
                                {
                                    // рассылка должна быть в try - catch,
                                    // если соединение из списка будет разорвано, его нужно удалить
                                    try {
                                        if (!connection.equals(readWrite)) {
                                            sendResponse(connection, requestMessage);
                                        }
                                    } catch (IOException e) {
                                        connections.remove(connection);
                                        connection.close();
                                    }

                                });
                            }
                        }
                }).start();
            }
        } catch (IOException e) {
            System.out.println("Ошибка создания serverSocket, например, указанный порт занят");
            e.printStackTrace();
        }
    }

    private void sendResponse(ReadWrite readWrite, Message requestMessage) throws IOException { // выполнение запрошенной задачи
        Message responseMessage;
        String text = null;
        FileToSend fileToSend = null;
        if (requestMessage == null) {
            text = "Задача не может быть выполнена";
        } else {
            if (requestMessage.getFileToSend() == null) {
                if ("Требуется список файлов".equals(requestMessage.getTextOnly())) {
                    StringBuilder list = new StringBuilder();
                    for (int i = 0; i < listFiles.size(); i++) {
                        list.append("Файл: " + listFiles.get(i).getFileName() + "\n"
                                + "Описание файла: " + listFiles.get(i).getFileDescription());
                    }
                    if(listFiles.size() == 0) text = "Файлы отсутствуют";
                    else  text = list.toString();
                } else if ("Запрос на файл".equals(requestMessage.getTextOnly())) {
                    for (int i = 0; i < listFiles.size(); i++) {
                        if (requestMessage.getUploadFile().equals(listFiles.get(i).getFileName())) {
                            fileToSend = listFiles.get(i);
                            break;
                        }
                    }
                    if(fileToSend == null)
                    {
                        text = "Указанный файл отсутствует";
                    }
                } else {
                    text = requestMessage.getText();
                }
            } else {
                text = requestMessage.getTextOnly();
                fileToSend = requestMessage.getFileToSend();
            }

        }
        responseMessage = new Message(text, fileToSend, null);
        write(readWrite, responseMessage);
    }

    private void write(ReadWrite readWrite, Message message) throws IOException {
        readWrite.writeMessage(message); // отправка сообщения клиенту
    }

    private Message read(ReadWrite readWrite) {
        Message fromClient = null;
        try {
            fromClient = readWrite.readMessage(); // чтение сообщения от клиента
        } catch (IOException e) {
            System.out.println("Ошибка во время чтения");
        }
        return fromClient;
    }

    public static void main(String[] args) {

        ServerApp serverApp = new ServerApp(2222);
        serverApp.run();

    }
}
