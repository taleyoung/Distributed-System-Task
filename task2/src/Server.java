import java.net.*;
import java.util.concurrent.LinkedBlockingQueue;

public class Server{
    static int count=0;//访问数量
    static int addCount=0;
    static int subCount=0;
    static int mulCount=0;
    static int divCount=0;
    public static void main(String args[]){
        DatagramSocket socket = null;
        int serverPort = 6789;
        try{
            socket = new DatagramSocket(serverPort);
            LinkedBlockingQueue receiveQueue = new LinkedBlockingQueue();
            LinkedBlockingQueue sendQueue = new LinkedBlockingQueue();

            ReceiveThread receiveThread = new ReceiveThread(socket, receiveQueue);
            receiveThread.start();

            SendThread sendThread = new SendThread(socket, sendQueue);
            sendThread.start();

            while(true){
                    for(int i = 0; i < 3; i++){
                        if(receiveQueue.size() > 0){
                            WorkThread workThread = new WorkThread( socket, receiveQueue, sendQueue);
                            workThread.start();
                        }
                    }
            }
        } catch (SocketException e){
            System.out.println("Socket: " + e.getMessage());
        } finally {
            if (socket != null){
                socket.close();
            }
        }
    }
}