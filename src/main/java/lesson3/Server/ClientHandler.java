package lesson3.Server;

import lesson3.Student;

import java.io.*;
import java.net.Socket;

public class ClientHandler {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private MyServer server;

    public ClientHandler(MyServer server, Socket socket){
        try {
            this.socket = socket;
            this.server = server;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());

            final Socket SOCKET = this.socket;

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        sendMessage("connect OK!");

                        while (true) {
                            ObjectInputStream objectInputStream = new ObjectInputStream(in);
                            Student student =null;
                            try {
                                 student = (Student)objectInputStream.readObject();
                            } catch (ClassNotFoundException e) {
                                e.printStackTrace();
                            }finally {
                                objectInputStream.close();
                            }

                            student.info();

                            break;


                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {

                        try {
                            in.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        try {
                            out.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            SOCKET.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }).start();

        }catch (IOException e){
            e.printStackTrace();
        }

    }


    public void sendMessage(String msg){
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
