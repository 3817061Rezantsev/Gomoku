package gomoku.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientIF extends Remote {
	void retrieveMessage(String message) throws RemoteException;

	void setTurn(boolean turn) throws RemoteException;

	boolean isMyTurn() throws RemoteException;
}
