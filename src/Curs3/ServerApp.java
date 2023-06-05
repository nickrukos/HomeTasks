package Curs3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;


public class ServerApp {
    private int port;
    //private boo
    private Map<String, Task> tasksMap;
    private List<FileToSend> listFiles;

    public ServerApp(int port) {
        this.port = port;
        tasksMap = new HashMap<>();
        listFiles = new ArrayList<>();
    }

    public void run(){
        try (ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Сервер запущен...");

            while (true) {
                Socket socket = serverSocket.accept(); // устанавливает соединение с клиентом
                try (ReadWrite readWrite = new ReadWrite(socket)){
                    sendResponse(readWrite, read(readWrite));
                } /*catch (ClassCastException e) {
                    System.out.println("Класс Message не найден");
                }*/ catch (IOException e){
                    System.out.println("Ошибка во время создания объекта");
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка создания serverSocket, например, указанный порт занят");
            e.printStackTrace();
        }
    }

    private void sendResponse(ReadWrite readWrite, Message requestMessage) { // выполнение запрошенной задачи
        Message responseMessage;
        String text = null, upload = null;
        FileToSend fileToSend = null
        if (requestMessage == null)
        {
            responseMessage = new Message("Задача не может быть выполнена", null,null);
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
                    responseMessage = new Message(list.toString(),null, null);
                }
                responseMessage = requestMessage;
            }
            responseMessage = new Message(requestMessage.getFileDescription(),null);
        }
        //write(readWrite, responseMessage);  рассылка потом
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

    public void addTask(Task task) {
        tasksMap.put(task.getName(), task);
    }

    public Map<String, Task> getTasksMap(){
        return Collections.unmodifiableMap(tasksMap);
    }


    public static void main(String[] args) {
        Task help = new Task("/help", "список доступных запросов и их описание", serverApp -> {
            StringBuilder builder = new StringBuilder();
            for (Task task: serverApp.getTasksMap().values()) {
                builder.append(task.getName())
                        .append(" - ")
                        .append(task.getDescription())
                        .append("\n");
            }
            return new Message(builder.toString(), null);
        });

        Task requests = new Task("/requests", "количество успешно обработанных запросов", serverApp -> {
            long numberOfRequests = serverApp.getTasksMap().values().stream();
            return new Message(String.valueOf(numberOfRequests),null);
        });

        Task popular = new Task("/popular", "название самого популярного запроса", serverApp -> {
            String taskName = serverApp.getTasksMap().values().stream());
            return new Message(taskName,null);
        });

        ServerApp serverApp = new ServerApp(2222);

        serverApp.addTask(help);
        serverApp.addTask(requests);
        serverApp.addTask(popular);

        serverApp.run();
        /*
        ServerSocket serverSocket = null; // позволит установить соединение
        // с клиентскими программами
        OutputStream output = null; // позволит отправлять данные
        InputStream input = null; // позволит получать данные


        try {
            serverSocket = new ServerSocket(2222); // привязка серверной программы к указанному порту.
            // ServerSocket слушает указанный порт...
            System.out.println("Сервер запущен");

            while (true) {
                Socket socket = serverSocket.accept(); // ...и устанавливает соединение при появлении клиента
                System.out.println("Новое подключение");

                System.out.println(socket.getLocalSocketAddress());
                System.out.println(socket.getRemoteSocketAddress());

                output = socket.getOutputStream(); // для отправки данных по socket соединению
                input = socket.getInputStream(); // для получения данных по socket соединению

                // ObjectInputStream objectInput = new ObjectInputStream(input); // десериализация
                // ObjectOutputStream objectOutput = new ObjectOutputStream(output); // сериализация

                // ожидание, когда в inputStream появятся данные
                System.out.println(input.read()); // чтение данных из inputStream
                output.write(2); // отправка данных в outputStream
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (input != null) input.close();
                if (output != null) output.close();
                if (serverSocket != null) serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        */
    }
}
