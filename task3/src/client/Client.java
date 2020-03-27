package client;

import types.BookServerTypes;
import model.Book;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class Client{
    public static void main(String[] args) {
      try {
          String name = "BookService";
          String host = "127.0.0.1";
          int serverPort = 1099;
          Registry registry = LocateRegistry.getRegistry(host,serverPort);
          BookServerTypes bookService = (BookServerTypes)registry.lookup(name);
          Book book1 = new Book(1,"No1","author1");
          Book book2 = new Book(2,"No2","author2");
          Book book3 = new Book(3,"No3","author3");

          Book res = bookService.add(book1);
          bookService.add(book2);
          bookService.add(book3);

          Book book = bookService.queryById(1);
          System.out.println("查询bookId为1：" + book);

          List<Book> bookList = bookService.queryAll();
          System.out.println("所有book" + bookList);

          bookService.delete(3);
          System.out.println("删除bookId=3之后" + bookList);

      }catch (Exception e){
          e.printStackTrace();
      }
    }
}
