package hw18;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;




// 2.7. закрывает соединение с сервером


public class ClientApp {
    private InetSocketAddress remote;

    // При создании клиента в конструктор передается экземпляр InetSocketAddress,
    // который хранит IP сервера и порт.
    public ClientApp(InetSocketAddress remote) {
        this.remote = remote;
    }

    public void run(){
        // Thread.sleep(млс);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            // 2.1. запрашивает текст сообщения (запрос) у пользователя
            System.out.println("Введите текст или /exit для выхода");
            String text = scanner.nextLine();
            // И так до тех пор, пока пользователь не введет '/exit'
            if ("/exit".equals(text)) return;

            // 2.2. устанавливает соединение с сервером
            try (Socket socket = new Socket(remote.getHostString(), remote.getPort());
                 ReadWrite readWrite = new ReadWrite(socket)){
                // 2.3. создает экземпляр сообщения
                Message message = new Message(text);
                // 2.4. отправляет сообщение на сервер
                readWrite.writeMessage(message);
                // 2.5. получает ответ
                Message fromServer = readWrite.readMessage();
                // 2.6. выводит полученный ответ в консоль
                System.out.println(fromServer.getText());
            } catch (UnknownHostException e) {
                System.out.println("Ошибка в IP сервера");
            } catch (IOException e) {
                System.out.println("Сервер не отвечает");
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
        // Socket socket = new Socket(ip, port); // соединение с удаленным сервером
        // Socket socket = new Socket(remote.getHostString(), remote.getPort());
        OutputStream output = null;
        InputStream input = null;
        try {
            // socket.bind(local);
            System.out.println(socket.isBound());

            socket.connect(remote, 10000); // соединение с удаленным сервером
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
