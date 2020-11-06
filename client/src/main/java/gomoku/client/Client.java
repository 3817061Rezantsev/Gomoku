package gomoku.client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

import gomoku.common.ClientIF;
import gomoku.common.ServerIF;

public class Client extends UnicastRemoteObject implements ClientIF, Runnable {

	private static final long serialVersionUID = 1L;
	private ServerIF server;
	private String name = null;
	private boolean myTurn = false;

	protected Client(String name, ServerIF server) throws RemoteException {
		this.server = server;
		this.name = name;
		server.registerClient(this);
		if (name.equals("White")) {
			myTurn = true;
		}
	}

	@Override
	public void retrieveMessage(String message) throws RemoteException {
		System.out.println(message);
	}

	@Override
	public void run() {
		Scanner scanner = new Scanner(System.in);
		String message;
		while (true) {
			if (myTurn) {
				System.out.println("turn of" + name);
				message = scanner.nextLine();
				try {
					server.broadcastMessage(name + ":" + message);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				myTurn = false;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void setTurn(boolean turn) throws RemoteException {
		myTurn = turn;
	}

	@Override
	public boolean isMyTurn() throws RemoteException {
		return myTurn;
	}
}
