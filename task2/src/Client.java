import java.net.*;
import java.io.*;

public class Client{
    public static void main(String args[]){
        DatagramSocket socket = null;

        try {
            InetAddress host = InetAddress.getByName("127.0.0.1");
            int serverPort = 6789;

            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            String userInput = "";
            for(int i = 0; i < 3; i++){
                userInput = userInput.concat(stdIn.readLine()+" ");
            }
            byte[] m = userInput.getBytes();

            DatagramPacket request = new DatagramPacket(m, m.length, host, serverPort);
            socket = new DatagramSocket();
            socket.send(request);

            System.out.println("客户端正在发送数据给服务器");
            byte[] buffer = new byte[10];
            DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
            socket.receive(reply);
            System.out.println("客户端开始接收数据");
            System.out.println("客戶端收到服务器的reply："+new String(reply.getData()).trim());

        } catch (SocketException e){
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e){
            System.out.println("IO: " + e.getMessage());
        } finally {
            if(socket != null) socket.close();
        }
    }
}