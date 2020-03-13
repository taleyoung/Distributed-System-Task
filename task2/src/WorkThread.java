import java.net.*;
import java.util.concurrent.BlockingQueue;

public class WorkThread extends Thread{
    DatagramSocket socket = null;
    DatagramPacket packet = null;
    BlockingQueue<DatagramPacket> sendQueue = null;
    byte[] data = null;

    public WorkThread( DatagramSocket socket, BlockingQueue<DatagramPacket> receiveQueue, BlockingQueue<DatagramPacket> sendQueue) {
        this.socket = socket;
        this.packet = receiveQueue.poll();
        interrupt();
        this.data = null;
        this.sendQueue = sendQueue;
    }
    public void run(){
        System.out.println("工作线程启动");
        int res = compute();
        data = String.valueOf(res).getBytes();
        InetAddress address = packet.getAddress();
        int port = packet.getPort();
        DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
        sendQueue.add(packet);
        System.out.println("WorkThread: sendQueue的size为" + sendQueue.size());
    }
    public synchronized int compute(){
//        String info = new String(data);
        String info = new String(packet.getData(),0,packet.getLength());
        String source[] = info.split(" ");
        System.out.println("服务端收到客戶端的信息："+source[1] + source[0] + source[2]);
        int res = 0;
        int num1 = Integer.parseInt(source[1]), num2 = Integer.parseInt(source[2]);
        switch (source[0]){
            case "+":
                res = num1 + num2;
                Server.addCount++;
                System.out.println("正在处理第"+Server.addCount+"个加法运算");
                break;
            case "-":
                res = num1-num2;
                Server.subCount++;
                System.out.println("正在处理第" + Server.subCount + "个减法运算");
                break;
            case "*":
                res = num1 * num2;
                Server.mulCount++;
                System.out.println("正在处理第" + Server.mulCount + "个乘法运算");
                break;
            case "/":
                res = num1 / num2;
                Server.divCount++;
                System.out.println("正在处理第" + Server.divCount + "个除法运算");
                break;
        }
        return res;
    }
}