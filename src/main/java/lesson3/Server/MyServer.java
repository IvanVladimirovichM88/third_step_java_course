package lesson3.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

    ClientHandler clientHandler;
    final int PORT = 1000;

    public MyServer(){
        final MyServer SERVER = this;

        new Thread(new Runnable() {

            ServerSocket serverSocket= null;
            Socket socket= null;

            @Override
            public void run() {
                try {
                    serverSocket = new ServerSocket(PORT);
                    System.out.println( " Server started ");

                    while(true) {
                        socket = serverSocket.accept();
                        clientHandler = new ClientHandler(SERVER, socket);
                        System.out.println("This client connecting  - " + socket.toString());
                    }


                } catch (IOException e) {
                    e.printStackTrace();
                }finally {

                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    try {
                        serverSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();

    }
}
