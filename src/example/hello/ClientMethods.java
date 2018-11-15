package example.hello;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientMethods extends Remote {
    String send(Message message) throws RemoteException;
    String store(Message message) throws RemoteException;
    String deliver(Message message) throws RemoteException;
}