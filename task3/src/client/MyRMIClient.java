package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MyRMIClient {
    public static void main(String args[]) {

        try {
            String name = "Calculator";
            String serverIP = "127.0.0.1";  
            int serverPort = 1099;
			Registry registry = LocateRegistry.getRegistry(serverIP, serverPort);
			MyCalc mycalc = (MyCalc) registry.lookup(name);
            int result = mycalc.add(5, 3);
            System.out.println("Result:" + result);
        } catch (Exception e) {
            System.err.println("??? exception:");
            e.printStackTrace();
        }
    }
}