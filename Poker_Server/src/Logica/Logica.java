package Logica;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import Conexion.RMI;


public class Logica extends UnicastRemoteObject implements RMI{
	static Mesa mesa;
protected Logica() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
 
	public static void main(String[] args) {
		
		mesa=new Mesa();
		mesa.llenarMazo();
		try{
			Registry reg=LocateRegistry.createRegistry(1099);
			reg.rebind("Servidor", (Remote) new Logica());
			System.out.println("Inicio!");
		}catch(Exception e){
			System.out.println(e);
		}

	}
	@Override
	public String getPath() throws RemoteException {
		return mesa.getPath();
	}


}
