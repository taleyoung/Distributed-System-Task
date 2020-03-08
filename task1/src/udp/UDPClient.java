package udp;

import java.net.*;
import java.io.*;

public class UDPClient{
    public static void main(String args[]){
// args give message contents and server hostname
        DatagramSocket aSocket = null;
        try {
            InetAddress aHost = InetAddress.getByName("127.0.0.1");
            int serverPort = 6789;
            byte[] m = "from client m".getBytes();
            DatagramPacket request = new DatagramPacket(m, m.length, aHost, serverPort);
            aSocket = new DatagramSocket();
            aSocket.send(request);
            System.out.println("客户端正在发送数据给服务器");

            byte[] buffer = new byte[1000];
            DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
            aSocket.receive(reply);
            System.out.println("客户端开始接收数据");
            System.out.println("客戶端收到服务器的reply"+new String(reply.getData()));
        } catch (SocketException e){
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e){
            System.out.println("IO: " + e.getMessage());
        } finally {
            if(aSocket != null) aSocket.close();
        }
    }
}