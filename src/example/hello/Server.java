package example.hello;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server implements ClientMethods {

    public Server() {
    }

    public static void main(String args[]) {

        try {
            Server obj = new Server();
            ClientMethods stub = (ClientMethods) UnicastRemoteObject.exportObject(obj, 0);

            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            registry.bind("Hello2", stub);

            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }

    @Override
    public String send(Message message) throws RemoteException {
        return null;
    }

    @Override
    public String store(Message message) throws RemoteException {
        return null;
    }

    @Override
    public String deliver(Message message) throws RemoteException {
        return null;
    }
}
