package types;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BookTypes extends Remote{
    int add2(int a, int b) throws RemoteException;
}
