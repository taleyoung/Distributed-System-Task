package server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import types.*;

public class BookServer {
    public static void main(String[] args) throws Exception{
       try {
           String name = "BookService";
           BookServerTypes engine = new BookServerImpl();
           BookServerTypes skeleton = (BookServerTypes)UnicastRemoteObject.exportObject(engine, 0);
           LocateRegistry.createRegistry(1099);
           Registry registry = LocateRegistry.getRegistry("127.0.0.1",1099);
           registry.rebind(name, skeleton);
       }catch (Exception e){
           e.printStackTrace();
       }
    }
}
