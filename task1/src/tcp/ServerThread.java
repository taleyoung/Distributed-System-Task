package tcp;

import java.io.*;
import java.net.*;

public class ServerThread implements Runnable {

    private Socket client = null;
    public ServerThread(Socket client){
        this.client = client;
    }

    public static void execute(Socket client){
        try{
            PrintStream out = new PrintStream(client.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String line = null;
            while((line=in.readLine())!=null) {
                System.out.println("ServerThread - Message from client:" + line);
                out.println(line);
                out.flush();
            }
            client.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        execute(client);
    }

}