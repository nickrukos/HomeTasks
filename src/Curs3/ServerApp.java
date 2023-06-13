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
            System.out.println("������ �������...");

            while (true) {

                // ���������� ������� �� ����� � ��������� ������,
                // ������ ����������������� � ���
                Socket socket = serverSocket.accept();
                ReadWrite readWrite = new ReadWrite(socket);

                // ��� ������ ��������� ����� contains, ����� ������, ������� �� ������ true ��� ��������� ������
                connections.add(readWrite);
                // ��� ������ ���������, ���� socket - null, ������ accept ������� � �������,
                // ���������� ������ �� ������
                // if(socket == null) System.out.println("socket is null");

                // � ������ ������� ����� ����������, ����� ������� �� � ��������� �����
                new Thread(() ->
                {
                    while (true) {

                        Message requestMessage = read(readWrite);

                        // ���� ��������� - null, ������ ���������� � �������� ��������,
                        // ������� ��� �� ��������� � ��������� readWrite ��� ��������
                        // socket � readWrite �� ����� ���� null � ����� �������
                        // ������������� removeIf - ������, ���������� remove,
                        // �� ����� ������� ���� ������

                        if (requestMessage == null) {
                            //��� �������� �������  ������������� ����������
                            //������ ��������� � ������� � ������ ����������
                            System.out.println("�������� ����� � ��������!");
                            //��������� ����������
                            connections.remove(readWrite);
                            readWrite.close();
                            // ���� ���������� ���������, �� � �������� � �������� �� ���������,
                            // � ������ ������ ��� ������
                            return;
                        }

                        System.out.println("���� ����� � ��������!");

                        if ("stop".equals(requestMessage.getTextOnly())) {
                           // ��������� ����������, ��� � ��� message == null
                           connections.remove(readWrite);
                           readWrite.close();
                           return;
                        }
                        if ("��������� ������ ������".equals(requestMessage.getTextOnly())
                            || "������ �� ����".equals(requestMessage.getText())) {
                            //�������� �������� ������� �������� ������ ��� ����������� ����
                            try {
                                    sendResponse(readWrite, requestMessage);
                                } catch (IOException e) {
                                    // ��������� ����������, ��� � ��� message == null
                                    connections.remove(readWrite);
                                    readWrite.close();
                                    return;
                                }
                            }else {
                                // � ��������� ������� ����������� ���������
                                // ������ ���� ��������� ���� �������� �� ����������� ��������
                                if("�������� ����� �� ������".equals(requestMessage.getTextOnly()))
                                {
                                    //��������� ���� � ������ ������
                                    System.out.println("Test");
                                    listFiles.add(requestMessage.getFileToSend());
                                }

                                connections.forEach(connection ->
                                {
                                    // �������� ������ ���� � try - catch,
                                    // ���� ���������� �� ������ ����� ���������, ��� ����� �������
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
            System.out.println("������ �������� serverSocket, ��������, ��������� ���� �����");
            e.printStackTrace();
        }
    }

    private void sendResponse(ReadWrite readWrite, Message requestMessage) throws IOException { // ���������� ����������� ������
        Message responseMessage;
        String text = null;
        FileToSend fileToSend = null;
        if (requestMessage == null) {
            text = "������ �� ����� ���� ���������";
        } else {
            if (requestMessage.getFileToSend() == null) {
                if ("��������� ������ ������".equals(requestMessage.getTextOnly())) {
                    StringBuilder list = new StringBuilder();
                    for (int i = 0; i < listFiles.size(); i++) {
                        list.append("����: " + listFiles.get(i).getFileName() + "\n"
                                + "�������� �����: " + listFiles.get(i).getFileDescription());
                    }
                    if(listFiles.size() == 0) text = "����� �����������";
                    else  text = list.toString();
                } else if ("������ �� ����".equals(requestMessage.getTextOnly())) {
                    for (int i = 0; i < listFiles.size(); i++) {
                        if (requestMessage.getUploadFile().equals(listFiles.get(i).getFileName())) {
                            fileToSend = listFiles.get(i);
                            break;
                        }
                    }
                    if(fileToSend == null)
                    {
                        text = "��������� ���� �����������";
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
        readWrite.writeMessage(message); // �������� ��������� �������
    }

    private Message read(ReadWrite readWrite) {
        Message fromClient = null;
        try {
            fromClient = readWrite.readMessage(); // ������ ��������� �� �������
        } catch (IOException e) {
            System.out.println("������ �� ����� ������");
        }
        return fromClient;
    }

    public static void main(String[] args) {

        ServerApp serverApp = new ServerApp(2222);
        serverApp.run();

    }
}
