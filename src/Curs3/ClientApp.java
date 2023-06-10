package Curs3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientApp {
    private final int N = 256; //����� �������� � ��������
    private final double Mb = 0.5;  //������ ����� � ����������
    private InetSocketAddress remote;
    boolean flag;

    // ��� �������� ������� � ����������� ���������� ��������� InetSocketAddress,
    // ������� ������ IP ������� � ����.
    public ClientApp(InetSocketAddress remote) {
        this.remote = remote;
    }

    public void run() throws IOException, InterruptedException {

        Socket socket = new Socket(remote.getHostString(), remote.getPort());
        ReadWrite readWrite = new ReadWrite(socket);
        Thread threadIn =  new Thread(()-> {
            FileToSend fileToSend = null;
            String uploadFile = null;
            Scanner scanner = new Scanner(System.in);
            while (true) {
                if(readWrite == null) break;
                System.out.println("������� �����");
                System.out.println("��� �������� ����� �������� '1'");
                System.out.println("��� ��������� ������ ������ � ������� �������� '2'");
                System.out.println("��� ����������� ������� �� ��������� ���� �� ������ ������� '3'");
                System.out.println("��� ������� ������� ���������� �������� 'stop'");
                System.out.println("��� ������� ������� ���������� �������� 'exit'");
                String text = scanner.nextLine();
                if("exit".equals(text))
                {
                    System.out.println("��������� ������");
                    flag = true;
                    break;
                }
                if ("1".equals(text)) {
                    System.out.println("������� ���� � �����");
                    String fileName = scanner.nextLine();
                    System.out.println("������� �������� �����");
                    String description = scanner.nextLine();

                    try {
                        fileToSend = new FileToSend(fileName, description);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (fileToSend == null) {
                        System.out.println("��� ���� ������������");
                        continue;
                    }
                    if (fileToSend.getFileSize() / 1048576 > Mb) {
                        System.out.println("������ ����� ������ " + String.valueOf(Mb) + " ��.");
                        continue;
                    }
                    if (fileToSend.getFileDescription().length() > N) {
                        System.out.println(" �������� ����� ������ " + String.valueOf(N) + " ��������");
                        continue;
                    }
                    text = "�������� ����� �� ������";
                }
                if ("2".equals(text)) {
                    text = "��������� ������ ������";
                }
                if ("3".equals(text)) {
                    System.out.println("������� ��� ���������� �����");
                    uploadFile = scanner.nextLine();
                    text = "������ �� ����";
                }
                Message message = new Message(text, fileToSend, uploadFile);
                try {
                    readWrite.writeMessage(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread threadOut = new Thread(()->
        {
            while(true)
            {
                Message fromServer = null;
                try {
                    if(!flag) {
                        fromServer = readWrite.readMessage();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if(fromServer == null) break;
                System.out.println(fromServer.getText());
            }

        });
        threadIn.start();
        threadOut.start();
        threadIn.join();
     //   threadOut.join();
        if(readWrite != null)
        {
            readWrite.close();
        }
        else
        {
            if(socket != null) socket.close();
        }
    }

    public static void main(String[] args) {
        String ip = "127.0.0.1";
        int port = 2222;
        InetSocketAddress remote = new InetSocketAddress(ip, port);

        ClientApp clientApp = new ClientApp(remote);
        try {
            clientApp.run();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
