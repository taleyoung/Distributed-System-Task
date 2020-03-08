package udp;

import java.net.*;
import java.io.*;

public class UdpThread extends Thread{
    DatagramSocket socket = null;
    DatagramPacket packet = null;
    byte[] data = null;

    public UdpThread(byte[] data,DatagramSocket socket,DatagramPacket packet) {
        this.socket = socket;
        this.packet = packet;
        interrupt();
        this.data = data;
    }
    //线程要执行的方法
    public void run(){
        System.out.println("线程启动");
        String info = new String(data);
        System.out.println("服務器收到客戶端的信息："+info);
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
}