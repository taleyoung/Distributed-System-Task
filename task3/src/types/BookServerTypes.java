package types;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import model.Book;

public interface BookServerTypes extends Remote{
    Book add(Book b) throws RemoteException;
    Book queryById(int bookId) throws RemoteException;
    Book queryByName(String name) throws  RemoteException;
    List<Book> queryAll() throws RemoteException;
    boolean delete(int bookId) throws RemoteException;
}
