import java.net.*;
import java.io.*;
import java.util.concurrent.BlockingQueue;

public class SendThread extends Thread{
    DatagramSocket socket = null;
    DatagramPacket packet = null;
    BlockingQueue<DatagramPacket> queue = null;

    public SendThread(DatagramSocket socket, BlockingQueue<DatagramPacket> queue) {
        this.socket = socket;
        this.queue = queue;
    }
    public void run(){
        while(true){
            try {
                if(queue.size() > 0){
                    packet = queue.poll();
                    System.out.println("SendThread: sendQueue的size为"+queue.size());
                    socket.send(packet);
                    System.out.println("服务器端数据发送完毕");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally{
            }
        }

    }
}