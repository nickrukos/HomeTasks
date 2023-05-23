package hw18;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;




// 2.7. ��������� ���������� � ��������


public class ClientApp {
    private InetSocketAddress remote;

    // ��� �������� ������� � ����������� ���������� ��������� InetSocketAddress,
    // ������� ������ IP ������� � ����.
    public ClientApp(InetSocketAddress remote) {
        this.remote = remote;
    }

    public void run(){
        // Thread.sleep(���);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            // 2.1. ����������� ����� ��������� (������) � ������������
            System.out.println("������� ����� ��� /exit ��� ������");
            String text = scanner.nextLine();
            // � ��� �� ��� ���, ���� ������������ �� ������ '/exit'
            if ("/exit".equals(text)) return;

            // 2.2. ������������� ���������� � ��������
            try (Socket socket = new Socket(remote.getHostString(), remote.getPort());
                 ReadWrite readWrite = new ReadWrite(socket)){
                // 2.3. ������� ��������� ���������
                Message message = new Message(text);
                // 2.4. ���������� ��������� �� ������
                readWrite.writeMessage(message);
                // 2.5. �������� �����
                Message fromServer = readWrite.readMessage();
                // 2.6. ������� ���������� ����� � �������
                System.out.println(fromServer.getText());
            } catch (UnknownHostException e) {
                System.out.println("������ � IP �������");
            } catch (IOException e) {
                System.out.println("������ �� ��������");
            }
        }
    }

    public static void main(String[] args) {
        String ip = "127.0.0.1";
        int port = 2222;
        InetSocketAddress remote = new InetSocketAddress(ip, port);

        ClientApp clientApp = new ClientApp(remote);
        clientApp.run();

        /*
        InetSocketAddress local = new InetSocketAddress(ip, 1111);

        Socket socket = new Socket();
        // Socket socket = new Socket(ip, port); // ���������� � ��������� ��������
        // Socket socket = new Socket(remote.getHostString(), remote.getPort());
        OutputStream output = null;
        InputStream input = null;
        try {
            // socket.bind(local);
            System.out.println(socket.isBound());

            socket.connect(remote, 10000); // ���������� � ��������� ��������
            System.out.println(socket.isConnected());

            System.out.println(socket.getReceiveBufferSize());
            System.out.println(socket.getSendBufferSize());
            System.out.println(socket.getLocalSocketAddress());
            System.out.println(socket.getRemoteSocketAddress());

            output = socket.getOutputStream();
            input = socket.getInputStream();

            output.write(11);
            System.out.println(input.read());
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (input != null) input.close();
                if (output != null) output.close();
                socket.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        */

    }
}
