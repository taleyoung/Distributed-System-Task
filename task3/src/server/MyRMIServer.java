package server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class MyRMIServer {
    public static void main(String[] args) throws Exception {

        try {
            String name = "Calculator";
            MyCalc engine = new MyCalcImpl();
            MyCalc skeleton = (MyCalc) UnicastRemoteObject.exportObject(engine, 0);
			Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
            System.out.println("Registering Calculator Object");
            registry.rebind(name, skeleton);
        } catch (Exception e) {
            System.err.println("Exception:" + e);
            e.printStackTrace();
        }
    }
}