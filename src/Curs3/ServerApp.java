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
        try (ServerSocket serverSocket = new ServerSocket(port))
        {
            System.out.println("������ �������...");
            while (true)
            {

                new Thread(()->
                {
                   try
                   {
                       Socket socket = serverSocket.accept();
                       ReadWrite readWrite = new ReadWrite(socket);
                       if(!connections.contains(readWrite)) connections.add(readWrite);
                       if(socket == null) System.out.println("socket is null");
                       Message requestMessage = read(readWrite);
                       if(requestMessage != null)
                       {
                           System.out.println("���� ����� � ��������!");
                           if("stop".equals(requestMessage.getText()))
                           {
                               //��������� ����������
                               connections.removeIf(x->Objects.equals(x,readWrite));
                               readWrite.close();
                               socket.close();
                           }
                           else if("��������� ������ ������".equals(requestMessage.getText())
                                   || "������ �� ����".equals(requestMessage.getText()))
                           {
                               //�������� �������� ������� �������� ������ ��� ����������� ����
                               sendResponse(readWrite,requestMessage);
                           }
                           else
                           {
                               //� ��������� ������� ����������� ���������
                               //������ ���� ��������� ���� �������� �� ����������� ��������
                               connections.forEach(connection->
                               {
                                    if(!connection.equals(readWrite))
                                    {
                                        sendResponse(connection,requestMessage);
                                    }
                               });
                           }
                       }
                       else
                       {
                           //Message = null
                           System.out.println("�������� ����� � ��������!");
                           //��������� ����������
                           if(readWrite != null)
                           {
                               connections.removeIf(x -> Objects.equals(x, readWrite));
                               readWrite.close();
                           }
                           else
                           {
                               if(socket != null) socket.close();
                           }
                       }
                   }
                   catch (IOException e)
                   {
                       System.out.println("������ �� ����� �������� �������");
                   }
                }).start();
            }
        }
        catch (IOException e)
        {
            System.out.println("������ �������� serverSocket, ��������, ��������� ���� �����");
            e.printStackTrace();
        }
    }

    private void sendResponse(ReadWrite readWrite, Message requestMessage) { // ���������� ����������� ������
        Message responseMessage;
        String text = null;
        FileToSend fileToSend = null;
        if (requestMessage == null)
        {
            text = "������ �� ����� ���� ���������";
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
                    text = list.toString();
                }
                else if("������ �� ����".equals(requestMessage.getText()))
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

    public static void main(String[] args) {

        ServerApp serverApp = new ServerApp(2222);
        serverApp.run();

    }
}
