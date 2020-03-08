package tcp;

import java.io.*;
import java.net.*;

public class EchoServer {
    private static final int THREADSIZE = 10;
    public static void main(String[] args) throws Exception {
        Socket clientSocket = null;
        ServerSocket listenSocket = new ServerSocket(8189);
        System.out.println("Server listening at 8189");

        for(int i = 0; i < THREADSIZE; i++){
            Thread thread = new Thread(){
                public void run(){
                    while(true){
                        try {
                            Socket client = listenSocket.accept();
                            System.out.println("Accepted connection from client");
                            ServerThread.execute(client);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            thread.start();
        }
    }
}