import java.net.*;
import java.io.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Server{
    public static void main(String args[]){
        DatagramSocket socket = null;
        int serverPort = 6789;
        try{
            socket = new DatagramSocket(serverPort);
            byte[] buffer = new byte[10];
            BlockingQueue<DatagramPacket> blockingQueue = new LinkedBlockingQueue();
            while(true){
                DatagramPacket request = new DatagramPacket(buffer, buffer.length);
                socket.receive(request);
                blockingQueue.put(request);
                ServerThread thread = new ServerThread(buffer, socket, blockingQueue);
                thread.start();
            }
        } catch (SocketException e){
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) socket.close();
        }
    }
}