import java.net.*;
import java.io.*;
import java.util.concurrent.BlockingQueue;

public class ServerThread extends Thread{
    DatagramSocket socket = null;
    DatagramPacket packet = null;
    byte[] data = null;

    public ServerThread(byte[] data, DatagramSocket socket, BlockingQueue<DatagramPacket> queue) {
        this.socket = socket;
        this.packet = queue.poll();
        interrupt();
        this.data = data;
    }
    public void run(){
        System.out.println("线程启动");
        int res = compute(data);
        data = String.valueOf(res).getBytes();
        InetAddress address = packet.getAddress();
        int port = packet.getPort();
        DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
        try {
            socket.send(packet);
            System.out.println("服务器端数据发送完毕");
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
        }
    }
    public synchronized int compute(byte[] data){
        String info = new String(data);
        String source[] = info.split(" ");
        System.out.println("服务端收到客戶端的信息："+source[1] + source[0] + source[2]);
        int res = 0;
        int num1 = Integer.parseInt(source[1]), num2 = Integer.parseInt(source[2]);
        switch (source[0]){
            case "+":
                res = num1 + num2;
                break;
            case "-":
                res = num1-num2;
                break;
            case "*":
                res = num1 * num2;
                break;
            case "/":
                res = num1 / num2;
                break;
        }
        return res;
    }
}