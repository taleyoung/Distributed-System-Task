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
            BlockingQueue<DatagramPacket> receiveQueue = new LinkedBlockingQueue();
            BlockingQueue<DatagramPacket> sendQueue = new LinkedBlockingQueue();

            SendThread sendThread = new SendThread(socket, sendQueue);
            sendThread.start();

            while(true){
                DatagramPacket request = new DatagramPacket(buffer, buffer.length);
                socket.receive(request);
                receiveQueue.put(request);


                if(receiveQueue.size() > 0){
                    for(int i = 0; i < 3; i++){
                        WorkThread workThread = new WorkThread(buffer, socket, receiveQueue, sendQueue);
                        workThread.start();
                    }

                }
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