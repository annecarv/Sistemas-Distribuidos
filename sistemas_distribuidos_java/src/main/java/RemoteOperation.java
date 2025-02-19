package sd_project.sistemas_distribuidos_java.src.main.java;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteOperation extends Remote {
    byte[] doOperation(RemoteObjectRef o, int methodId, byte[] arguments) throws RemoteException;
    byte[] getRequest() throws RemoteException;
    void sendReply(byte[] reply, String clientHost, int clientPort) throws RemoteException;
}

