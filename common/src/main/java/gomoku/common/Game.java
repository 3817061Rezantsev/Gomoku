package gomoku.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Game extends Remote {
	String sayHello() throws RemoteException;
}
