package Curs3;

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
    private final int N = 256; //число символов в описании
    private final double Mb = 0.5;  //размер файла в мегабайтах
    private InetSocketAddress remote;

    // При создании клиента в конструктор передается экземпляр InetSocketAddress,
    // который хранит IP сервера и порт.
    public ClientApp(InetSocketAddress remote) {
        this.remote = remote;
    }

    public void run() throws IOException{
        // Thread.sleep(млс);

        Socket socket = new Socket(remote.getHostString(), remote.getPort());
        ReadWrite readWrite = new ReadWrite(socket);
        new Thread(()-> {
            FileToSend fileToSend = null;
            String uploadFile = null;
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Введите текст");
                System.out.println("Для загрузки файла наберите '1'");
                System.out.println("Для получения списка файлов с сервера наберите '2'");
                System.out.println("Для направления запроса на выбранный файл из списка нажмите '3'");
                System.out.println("Для выхода наберите 'stop'");
                String text = scanner.nextLine();
                // И так до тех пор, пока пользователь не введет '/exit'
                if ("1".equals(text)) {
                    System.out.println("Введите путь к файлу");
                    String fileName = scanner.nextLine();
                    System.out.println("Введите описание файла");
                    String description = scanner.nextLine();

                    try {
                        fileToSend = new FileToSend(fileName, description);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                    if (fileToSend == null) {
                        System.out.println("Ваш файл несуществует");
                        continue;
                    }
                    if (fileToSend.getFileSize() / 1048576 > Mb) {
                        System.out.println("Размер файла больше " + String.valueOf(Mb) + " Мб.");
                        continue;
                    }
                    if (fileToSend.getFileDescription().length() > N) {
                        System.out.println(" Описание файла больше " + String.valueOf(N) + " символов");
                        continue;
                    }
                    text = "Загрузка файла на сервер";
                }
                if ("2".equals(text)) {
                    text = "Требуется список файлов";
                }
                if ("3".equals(text)) {
                    System.out.println("Введите имя выбранного файла");
                    uploadFile = scanner.nextLine();
                    text = "Запрос на файл";
                }
                Message message = new Message(text, fileToSend, uploadFile);
                // 2.4. отправляет сообщение на сервер
                try {
                    readWrite.writeMessage(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

            // 2.2. устанавливает соединение с сервером

                // 2.3. создает экземпляр сообщения

                // 2.5. получает ответ
                Message fromServer = readWrite.readMessage();
                // 2.6. выводит полученный ответ в консоль
                System.out.println(fromServer.getText());


    }

    public static void main(String[] args) {
        String ip = "127.0.0.1";
        int port = 2222;
        InetSocketAddress remote = new InetSocketAddress(ip, port);

        ClientApp clientApp = new ClientApp(remote);
        try {
            clientApp.run();
        } catch (IOException e) {
            e.printStackTrace();
        }

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
