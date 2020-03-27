package server;

import types.BookTypes;

import java.rmi.RemoteException;

public class BookServerImpl implements BookTypes {

    @Override
    public int add2(int a, int b) throws RemoteException{
        return a+b;
    }
}
