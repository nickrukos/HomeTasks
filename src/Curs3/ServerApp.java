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
            System.out.println("������ �������...");

            while (true) {
                Socket socket = serverSocket.accept(); // ������������� ���������� � ��������
                try (ReadWrite readWrite = new ReadWrite(socket)){
                    sendResponse(readWrite, read(readWrite));
                } /*catch (ClassCastException e) {
                    System.out.println("����� Message �� ������");
                }*/ catch (IOException e){
                    System.out.println("������ �� ����� �������� �������");
                }
            }
        } catch (IOException e) {
            System.out.println("������ �������� serverSocket, ��������, ��������� ���� �����");
            e.printStackTrace();
        }
    }

    private void sendResponse(ReadWrite readWrite, Message requestMessage) { // ���������� ����������� ������
        Message responseMessage;
        String text = null, upload = null;
        FileToSend fileToSend = null
        if (requestMessage == null)
        {
            responseMessage = new Message("������ �� ����� ���� ���������", null,null);
        }
        else
        {
            if(requestMessage.getFileToSend() == null)
            {
                if("��������� ������ ������".equals(requestMessage.getText()))
                {
                    StringBuilder list = new StringBuilder();
                    for(int i=0;i<listFiles.size();i++)
                    {
                        list.append("����: " + listFiles.get(i).getFileName() + "\n"
                                    + "�������� �����: " + listFiles.get(i).getFileDescription());
                    }
                    responseMessage = new Message(list.toString(),null, null);
                }
                responseMessage = requestMessage;
            }
            responseMessage = new Message(requestMessage.getFileDescription(),null);
        }
        //write(readWrite, responseMessage);  �������� �����
    }

    private void write(ReadWrite readWrite, Message message) {
        try {
            readWrite.writeMessage(message); // �������� ��������� �������
        } catch (IOException e) {
            System.out.println("������ �������� ���������");
        }
    }


    private Message read(ReadWrite readWrite){
        Message fromClient = null;
        try {
            fromClient = readWrite.readMessage(); // ������ ��������� �� �������
        } catch (IOException e) {
            System.out.println("������ �� ����� ������");
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
        Task help = new Task("/help", "������ ��������� �������� � �� ��������", serverApp -> {
            StringBuilder builder = new StringBuilder();
            for (Task task: serverApp.getTasksMap().values()) {
                builder.append(task.getName())
                        .append(" - ")
                        .append(task.getDescription())
                        .append("\n");
            }
            return new Message(builder.toString(), null);
        });

        Task requests = new Task("/requests", "���������� ������� ������������ ��������", serverApp -> {
            long numberOfRequests = serverApp.getTasksMap().values().stream();
            return new Message(String.valueOf(numberOfRequests),null);
        });

        Task popular = new Task("/popular", "�������� ������ ����������� �������", serverApp -> {
            String taskName = serverApp.getTasksMap().values().stream());
            return new Message(taskName,null);
        });

        ServerApp serverApp = new ServerApp(2222);

        serverApp.addTask(help);
        serverApp.addTask(requests);
        serverApp.addTask(popular);

        serverApp.run();
        /*
        ServerSocket serverSocket = null; // �������� ���������� ����������
        // � ����������� �����������
        OutputStream output = null; // �������� ���������� ������
        InputStream input = null; // �������� �������� ������


        try {
            serverSocket = new ServerSocket(2222); // �������� ��������� ��������� � ���������� �����.
            // ServerSocket ������� ��������� ����...
            System.out.println("������ �������");

            while (true) {
                Socket socket = serverSocket.accept(); // ...� ������������� ���������� ��� ��������� �������
                System.out.println("����� �����������");

                System.out.println(socket.getLocalSocketAddress());
                System.out.println(socket.getRemoteSocketAddress());

                output = socket.getOutputStream(); // ��� �������� ������ �� socket ����������
                input = socket.getInputStream(); // ��� ��������� ������ �� socket ����������

                // ObjectInputStream objectInput = new ObjectInputStream(input); // ��������������
                // ObjectOutputStream objectOutput = new ObjectOutputStream(output); // ������������

                // ��������, ����� � inputStream �������� ������
                System.out.println(input.read()); // ������ ������ �� inputStream
                output.write(2); // �������� ������ � outputStream
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
