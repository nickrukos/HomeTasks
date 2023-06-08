package Curs3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;


public class ServerApp {
    private int port;
    //private boo
    CopyOnWriteArrayList<ReadWrite> connections;
    private List<FileToSend> listFiles;

    public ServerApp(int port) {
        this.port = port;
        connections = new CopyOnWriteArrayList<>();
        listFiles = new ArrayList<>();
    }

    public void run(){
        try (ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Сервер запущен...");

            while (true)
            {
                Socket socket = serverSocket.accept();
                new Thread( ()->{
                                    try (ReadWrite readWrite = new ReadWrite(socket))
                                    {
                                        if(readWrite != null)
                                        {
                                            if(!connections.contains(readWrite)) connections.add(readWrite);
                                        }
                                        else throw new IOException("Отсутствует связь с клиентом");
                                        Message requestMessage = read(readWrite);
                                        if("stop".equals(requestMessage.getText()))
                                        {
                                            //закрываем соединение
                                            connections.removeIf(x->Objects.equals(x,readWrite));
                                            readWrite.close();
                                        }
                                        else if("Требуется список файлов".equals(requestMessage.getText())
                                                || "Запрос на файл".equals(requestMessage.getText()))
                                        {
                                            //посылаем текущему клиенту перечень файлов или запрошенный файл
                                            sendResponse(readWrite,requestMessage);
                                        }
                                        else
                                        {
                                            //в остальных случаях прочитанное сообщение
                                            //должно быть разослано всем клиентам за исключением текущего
                                            connections.forEach(connection->{
                                                                                if(!connection.equals(readWrite))
                                                                                {
                                                                                    sendResponse(connection,requestMessage);
                                                                                }
                                                                            });
                                        }
                                        //sendResponse(readWrite, );
                                    } /*catch (ClassCastException e) {
                                    System.out.println("Класс Message не найден");
                                }*/ catch (IOException e){
                                        System.out.println("Ошибка во время создания объекта");
                                    }
                                }).start();
            }
        } catch (IOException e) {
            System.out.println("Ошибка создания serverSocket, например, указанный порт занят");
            e.printStackTrace();
        }
    }

    private void sendResponse(ReadWrite readWrite, Message requestMessage) { // выполнение запрошенной задачи
        Message responseMessage;
        String text = null;
        FileToSend fileToSend = null;
        if (requestMessage == null)
        {
            text = "Задача не может быть выполнена";
        }
        else
        {
            if(requestMessage.getFileToSend() == null)
            {
                if("Требуется список файлов".equals(requestMessage.getText()))
                {
                    StringBuilder list = new StringBuilder();
                    for(int i=0;i<listFiles.size();i++)
                    {
                        list.append("Файл: " + listFiles.get(i).getFileName() + "\n"
                                    + "Описание файла: " + listFiles.get(i).getFileDescription());
                    }
                    text = list.toString();
                }
                else if("Запрос на файл".equals(requestMessage.getText()))
                {
                    for (int i = 0; i < listFiles.size(); i++) {
                        if(requestMessage.getUploadFile() == listFiles.get(i).getFileName()) {
                            fileToSend = listFiles.get(i);
                            break;
                        }
                    }
                }
                else
                {
                    text = requestMessage.getText();
                }
            }
            else
            {
                text = requestMessage.getText();
                fileToSend = requestMessage.getFileToSend();
            }

        }
        responseMessage = new Message(text,fileToSend,null);
        write(readWrite, responseMessage);
    }

    private void write(ReadWrite readWrite, Message message) {
        try {
            readWrite.writeMessage(message); // отправка сообщения клиенту
        } catch (IOException e) {
            System.out.println("Ошибка отправки сообщения");
        }
    }

    private Message read(ReadWrite readWrite){
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
