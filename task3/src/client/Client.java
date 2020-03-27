package client;

import types.BookTypes;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) {
      try {
          String name = "BookService";
          String host = "127.0.0.1";
          int serverPort = 1099;
          Registry registry = LocateRegistry.getRegistry(host,serverPort);
          BookTypes bookService = (BookTypes)registry.lookup(name);
          int result = bookService.add2(5, 3);
          System.out.println("Result:" + result);
      }catch (Exception e){
          e.printStackTrace();
      }
    }
}
