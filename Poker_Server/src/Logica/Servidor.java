package Logica;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import Conexion.RMI;
import Connection.RemoteObserver;
import DB.SQLite;
import Manos.Carta;


public class Servidor extends Observable implements RMI{
	static Mesa mesa;
	static List<Jugador> jugadoresDataBase;
	static SQLite sqlite;
	List<Object> o;
	
protected Servidor() throws RemoteException {
		super();
	}
private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		
		mesa=new Mesa();
		sqlite= new SQLite();
		sqlite.crearDB();
		   try {
	            Registry rmiRegistry = LocateRegistry.createRegistry(9999);
	            RMI rmiService = (RMI) UnicastRemoteObject.exportObject(new Servidor(), 9999);
	            rmiRegistry.bind("RmiService", rmiService);
	            System.out.println("Servidor iniciado");
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }

	}
	@Override
	public String getPath(int carta) throws RemoteException {
		Carta c= mesa.getCartas().get(carta);
		switch(c.getValorPalo()){
		case "DIAMANTE":
			return ("d"+c.getValor());
		case "TREBOL":
			return ("t"+c.getValor());
		case "CORAZON":
			return ("c"+c.getValor());
		case "PICA":
			return ("p"+c.getValor());
			
		}
		return null;
	}
	
    private class WrappedObserver implements Observer, Serializable {

        private static final long serialVersionUID = 1L;

        private RemoteObserver ro = null;

        public WrappedObserver(RemoteObserver ro) {
            this.ro = ro;
        }

        @Override
        public void update(Observable o, Object arg) {
            try {
                ro.update(o.toString(), arg);
            } catch (RemoteException e) {
                System.out
                        .println("Remote exception removing observer:" + this);
                o.deleteObserver(this);
            }
        }
    }

    @Override
    public void addObserver(RemoteObserver o) throws RemoteException {
        WrappedObserver mo = new WrappedObserver(o);
        addObserver(mo);
        System.out.println("Added observer:" + mo);
    }

    Thread thread = new Thread() {
        @Override
        public void run() {
            while (true) {
            }
        };
    };

    public void RmiServer() {
        thread.start();
    }
	@Override
	public void notificarActualizacion(String path) throws RemoteException {

	}
	@Override
	public void crearJugador(String nombre, String pass,String PathAvatar) throws RemoteException {
		sqlite.agregarJugador(nombre,pass,PathAvatar);
		
	}
	@Override
	public void actualizarJugador(String nombre, String pass,String PathAvatar) throws RemoteException {
		sqlite.actualizarJugador(nombre,pass,PathAvatar);
		
	}
	
	public boolean verificarJugador(String nombre, String pass) throws RemoteException {
		return sqlite.verificarUsuario(nombre, pass);
		
	}
	@Override
	public void addJugador(String nombreJugador) throws RemoteException {
		
		System.out.println("--------------------Entro ("+nombreJugador+") a la sala---------------------");
		mesa.getJuego().getJugadores().add(sqlite.getJugador(nombreJugador));
		
	}
	public void getListaCartasMesa() throws RemoteException {
		mesa.llenardealer(0);
		mesa.llenarJugadores();
		o= new ArrayList<Object>();
		List<String> ls= new ArrayList<String>();
		for(Carta j:mesa.getCartas()){
			ls.add(j.getPath());
		}
		for(Jugador j1: mesa.getJuego().getJugadores()){
			for(Carta c: j1.getMano()){
				ls.add(c.getPath());
				
			}
		}
		o.add(0);
		o.add(ls);
		setChanged();
		notifyObservers(o);
	}
	@Override
	public List<String> traerAvatar(String nombreUsuarioSesion) throws RemoteException {
		return sqlite.traerPathAvatar(nombreUsuarioSesion);
		
	}
	@Override
	public void eliminarJugador(String nombreJugador) throws RemoteException {
		sqlite.eliminarJugador(nombreJugador);
		
	}
	public List<List<String>> getListaJugadores(){
		List<List<String>> r=new ArrayList<List<String>>();
		List<Jugador> lj =mesa.getJuego().getJugadores();
		for(Jugador j1:lj){
			List<String> a= new ArrayList<String>();
			a.add(j1.getNombre());
			a.add(j1.getPuntos()+"");
			a.add("0");//TODO HACER METODO PARA TRAER LAS PARTIDAS GANADAS DE LA BD 
			a.add(sqlite.getPathJugador(j1.getNombre()));
			
			r.add(a);
		}
		return r;
	}
	public void llenarMazo(int estilo) throws RemoteException {
			mesa.llenarMazo();
	}
	public void mostrarPrimeras3() throws RemoteException{
		o.set(0,1);
		setChanged();
		notifyObservers(o);
	}
	public void mostrarCuarta() throws RemoteException{
		o.set(0,2);
		setChanged();
		notifyObservers(o);
	}
	public void mostrarQuinta() throws RemoteException{
		o.set(0,3);
		setChanged();
		notifyObservers(o);
	}



}
