package example.hello;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    private Buffer buffer;
    private Registry registry;
    private int clock;

    private Client() throws RemoteException {
        this.registry = LocateRegistry.getRegistry("localhost", 1099);
        try {
            this.registry.lookup("1");
        } catch (NotBoundException e) {
            e.printStackTrace();
        }

        this.buffer = new Buffer();
        this.clock = 0;
    }

    private void sendMessage(Message message) throws RemoteException, NotBoundException {
        ClientMethods stub = (ClientMethods) this.registry.lookup("Hello");

        String response = stub.send(message);
        this.receiveMessage(new Message(response));
    }

    private void receiveMessage(Message message) {

    }

    public static void main(String[] args) {

//        String host = (args.length < 1) ? null : args[0];
        try {
            Client client = new Client();
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
