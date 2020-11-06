package gomoku.server;

import java.rmi.server.UnicastRemoteObject;

import java.rmi.RemoteException;

import java.util.ArrayList;

import gomoku.common.ClientIF;
import gomoku.common.ServerIF;

public class Server extends UnicastRemoteObject implements ServerIF {

	private static final long serialVersionUID = 1L;
	private ArrayList<ClientIF> clients;

	protected Server() throws RemoteException {
		clients = new ArrayList<>();
	}

	@Override
	public synchronized void registerClient(ClientIF client) throws RemoteException {
		this.clients.add(client);
	}

	@Override
	public synchronized void broadcastMessage(String message) throws RemoteException {
		int i = 0;
		while (i < clients.size()) {
			if (clients.get(i).isMyTurn()) {
				clients.get(i++).retrieveMessage(message);
			} else {
				clients.get(i++).setTurn(true);
			}

		}

	}

}
