import java.net.*;
import java.io.*;
import java.util.concurrent.BlockingQueue;

public class ReceiveThread extends Thread{
    DatagramSocket socket = null;
    BlockingQueue<DatagramPacket> receiveQueue = null;

    public ReceiveThread(DatagramSocket socket, BlockingQueue<DatagramPacket> receiveQueue) {
        this.socket = socket;
        this.receiveQueue = receiveQueue;
    }
    public void run(){
        byte[] buffer = new byte[10];
        System.out.println("接收线程开启");
        while(true){
            try {
                DatagramPacket request = new DatagramPacket(buffer, buffer.length);
                socket.receive(request);
                receiveQueue.put(request);
            } catch (IOException e) {
                e.printStackTrace();
            }catch (InterruptedException e){
            }
            finally{
            }
        }

    }
}