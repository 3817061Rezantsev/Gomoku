package gomoku.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerIF extends Remote {
	void registerClient(ClientIF client) throws RemoteException;

	void broadcastMessage(String message) throws RemoteException;
}
