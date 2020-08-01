package lesson3.CLient;

import lesson3.Server.ClientHandler;
import lesson3.Student;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class MyClient {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    final String IP_ADDRESS = "localhost";
    final int PORT = 1000;

    Scanner consoleIn;

    public MyClient(){
        try {
            socket = new Socket(IP_ADDRESS,PORT);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        String string = in.readUTF();
                        System.out.println("server send -> "+ string);

                        Student student = new Student("Vasiliy", 25);

                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
                        objectOutputStream.writeObject(student);
                        objectOutputStream.close();
                        System.out.println("message send");

                    }catch (IOException e){
                        e.printStackTrace();
                    }finally {
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
