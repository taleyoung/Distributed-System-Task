package server;

import model.Book;
import types.BookServerTypes;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class BookServerImpl implements BookServerTypes {
    public List<Book> bookList = new ArrayList<>();

    @Override
    public Book add(Book b) throws RemoteException {
        bookList.add(b);
        System.out.println("当前的bookList" + bookList);
        return b;
    }

    @Override
    public Book queryById(int bookId) throws RemoteException {
        for(Book b : bookList){
            if(b.id == bookId){
                return b;
            }
        }
        return null;
    }

    @Override
    public Book queryByName(String name) throws RemoteException {
        for(Book b : bookList){
            if(b.name == name){
                return b;
            }
        }
        return null;
    }

    @Override
    public boolean delete(int bookId) throws RemoteException {
        for(int i = 0; i < bookList.size(); i++){
            if(bookList.get(i).id == bookId){
                bookList.remove(i);
            }
        }
        return false;
    }

    @Override
    public List<Book> queryAll() throws RemoteException{
        return bookList;
    }
}
