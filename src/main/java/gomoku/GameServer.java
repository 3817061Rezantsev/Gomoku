package gomoku;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class GameServer implements Game {

	public GameServer() {
	}

	public String sayHello() {
		return "Hello, world!";
	}

	public static void main(String args[]) {

		try {
			GameServer obj = new GameServer();
			Game stub = (Game) UnicastRemoteObject.exportObject(obj, 0);

			// Bind the remote object's stub in the registry
			Registry registry = LocateRegistry.getRegistry();
			registry.rebind("Hello", stub);

			System.err.println("Server ready");
		} catch (Exception e) {
			System.err.println("Server exception: " + e.toString());
			e.printStackTrace();
		}
	}
}