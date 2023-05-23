package hw18;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import hw18.ReadWrite;
import hw18.Message;

public class ServerApp {
    private int port;
    private Map<String, Task> tasksMap;

    // ѕри создании сервера в конструктор передаетс€ номер порта (int),
    // по которому клиенты смогут подключатьс€ к серверу.
    public ServerApp(int port) {
        this.port = port;
        tasksMap = new HashMap<>();
    }

    public void run(){
        try (ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("—ервер запущен...");

            while (true) {
                Socket socket = serverSocket.accept(); // устанавливает соединение с клиентом
                try (ReadWrite readWrite = new ReadWrite(socket)){
                    sendResponse(readWrite, read(readWrite));
                } /*catch (ClassCastException e) {
                    System.out.println(" ласс Message не найден");
                }*/ catch (IOException e){
                    System.out.println("ќшибка во врем€ создани€ объекта");
                }
            }
        } catch (IOException e) {
            System.out.println("ќшибка создани€ serverSocket, например, указанный порт зан€т");
            e.printStackTrace();
        }
    }

    private void sendResponse(ReadWrite readWrite, Message requestMessage) { // выполнение запрошенной задачи
        Message responseMessage;
        if (requestMessage == null || !tasksMap.containsKey(requestMessage.getText())) {
            responseMessage = new Message("«адача не может быть выполнена");
        } else {
            responseMessage = tasksMap.get(requestMessage.getText()).execute(this);
        }
        write(readWrite, responseMessage);
    }

    private void write(ReadWrite readWrite, Message message) {
        try {
            readWrite.writeMessage(message); // отправка сообщени€ клиенту
        } catch (IOException e) {
            System.out.println("ќшибка отправки сообщени€");
        }
    }


    private Message read(ReadWrite readWrite){
        Message fromClient = null;
        try {
            fromClient = readWrite.readMessage(); // чтение сообщени€ от клиента
        } catch (IOException e) {
            System.out.println("ќшибка во врем€ чтени€");
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
            return new Message(builder.toString());
        });

        Task requests = new Task("/requests", "количество успешно обработанных запросов", serverApp -> {
            long numberOfRequests = serverApp.getTasksMap().values().stream()
                    .mapToLong(Task::getExecuted).sum();
            return new Message(String.valueOf(numberOfRequests));
        });

        Task popular = new Task("/popular", "название самого попул€рного запроса", serverApp -> {
            String taskName = serverApp.getTasksMap().values().stream()
                    .filter(task -> task.getExecuted() > 0)
                    .max(Comparator.comparing(Task::getExecuted))
                    .flatMap(task -> task.getName().describeConstable())
                    .orElse("нет выполненных запросов");
            return new Message(taskName);
        });

        ServerApp serverApp = new ServerApp(2222);

        serverApp.addTask(help);
        serverApp.addTask(requests);
        serverApp.addTask(popular);

        serverApp.run();
        /*
        ServerSocket serverSocket = null; // позволит установить соединение
        // с клиентскими программами
        OutputStream output = null; // позволит отправл€ть данные
        InputStream input = null; // позволит получать данные


        try {
            serverSocket = new ServerSocket(2222); // прив€зка серверной программы к указанному порту.
            // ServerSocket слушает указанный порт...
            System.out.println("—ервер запущен");

            while (true) {
                Socket socket = serverSocket.accept(); // ...и устанавливает соединение при по€влении клиента
                System.out.println("Ќовое подключение");

                System.out.println(socket.getLocalSocketAddress());
                System.out.println(socket.getRemoteSocketAddress());

                output = socket.getOutputStream(); // дл€ отправки данных по socket соединению
                input = socket.getInputStream(); // дл€ получени€ данных по socket соединению

                // ObjectInputStream objectInput = new ObjectInputStream(input); // десериализаци€
                // ObjectOutputStream objectOutput = new ObjectOutputStream(output); // сериализаци€

                // ожидание, когда в inputStream по€в€тс€ данные
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
