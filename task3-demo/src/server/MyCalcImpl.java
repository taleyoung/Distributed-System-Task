package server;

import java.rmi.RemoteException;
import types.MyCalc;

public class MyCalcImpl implements MyCalc {

    @Override
    public int add(int a, int b) throws RemoteException {
	System.out.println("Someone is calling me. a=" + a + "   b=" + b);
        return (a + b);
    }
}
