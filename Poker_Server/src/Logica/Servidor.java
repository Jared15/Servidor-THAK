package Logica;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.SortedSet;

import Conexion.RMI;
import Connection.RemoteObserver;
import DB.SQLite;
import Manos.Carta;

public class Servidor extends Observable implements RMI {
	static Mesa mesa;
	static List<Jugador> jugadoresDataBase;
	static SQLite sqlite;
	List<Object> o;
	private int ronda = 0;
	private int turno = 0;
	private int rondaApuesta = 0;
	private int jugadorInicial = 1;
	private static List<Integer> participando;
	private int minApuesta;
	private int apuestaRonda = 0;
	private Map a = new HashMap<Integer, Integer>();
	Set<Integer> aposto=new   HashSet<Integer>() ;
	private int bote=0;
	private boolean iniciada=false;
	 

	public Servidor(){
		super();
		participando = new ArrayList<Integer>();
	}

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		participando = new ArrayList<Integer>();
		mesa = new Mesa();
		sqlite = new SQLite();
		sqlite.crearDB();
		try {
			Registry rmiRegistry = LocateRegistry.createRegistry(9999);
			RMI rmiService = (RMI) UnicastRemoteObject.exportObject(
					new Servidor(), 9999);
			rmiRegistry.bind("RmiService", rmiService);
			System.out.println("Servidor iniciado");
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public String getPath(int carta) throws RemoteException {
		Carta c = mesa.getCartas().get(carta);
		switch (c.getValorPalo()) {
		case "DIAMANTE":
			return ("d" + c.getValor());
		case "TREBOL":
			return ("t" + c.getValor());
		case "CORAZON":
			return ("c" + c.getValor());
		case "PICA":
			return ("p" + c.getValor());

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

	public void deleteObserver(RemoteObserver o) {
		int n = countObservers();
		System.out.println(n);
		WrappedObserver mo = new WrappedObserver(o);
		deleteObserver(mo);
		n = countObservers();
		System.out.println(n);
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
	public void crearJugador(String nombre, String pass, String PathAvatar)
			throws RemoteException {
		sqlite.agregarJugador(nombre, pass, PathAvatar);

	}

	@Override
	public void actualizarJugador(String nombre, String pass, String PathAvatar)
			throws RemoteException {
		sqlite.actualizarJugador(nombre, pass, PathAvatar);

	}

	public boolean verificarJugador(String nombre, String pass)
			throws RemoteException {
		return sqlite.verificarUsuario(nombre, pass);

	}

	@Override
	public void addJugador(String nombreJugador) throws RemoteException {

		System.out.println("--------------------Entro (" + nombreJugador
				+ ") a la sala---------------------");
		mesa.getJuego().getJugadores().add(sqlite.getJugador(nombreJugador));

	}

	public void sacarJugador(String nombreJugador) {
		mesa.getJuego().getJugadores()
				.remove((sqlite.getJugador(nombreJugador)));
	}

	public void iniciar()throws RemoteException {
		ronda = 0;
		turno = 0;
		rondaApuesta = 0;
		bote=0;
		llenarParticipantes();		
	}

	public void getListaCartasMesa() throws RemoteException {
		iniciar();
		mesa.nuevaMano();
		mesa.llenardealer(0);
		mesa.llenarJugadores();

		o = new ArrayList<Object>();
		List<String> ls = new ArrayList<String>();
		for (Carta j : mesa.getCartas()) {
			ls.add(j.getPath());
		}
		for (Jugador j1 : mesa.getJuego().getJugadores()) {
			for (Carta c : j1.getMano().getCartas()) {
				ls.add(c.getPath());

			}
		}
		o.add(0);
		o.add(0);
		o.add(0);
		o.add(ls);
		o.add(0);
		setChanged();
		notifyObservers(o);	
		apostar(jugadorInicial,50);		
		apostar(jugadorInicial+1,100);
		aposto.clear();
		
	}

	private void llenarParticipantes() {
		for (int i = 0; i < mesa.getJuego().getNoJugadores(); i++) {
			participando.add(new Integer(i + 1));
			a.put(i + 1, 0);
		}
		

	}

	@Override
	public List<String> traerAvatar(String nombreUsuarioSesion)
			throws RemoteException {
		return sqlite.traerPathAvatar(nombreUsuarioSesion);

	}

	@Override
	public void eliminarJugador(String nombreJugador) throws RemoteException {
		sqlite.eliminarJugador(nombreJugador);

	}

	public List<List<String>> getListaJugadores() {
		List<List<String>> r = new ArrayList<List<String>>();
		List<Jugador> lj = mesa.getJuego().getJugadores();
		for (Jugador j1 : lj) {
			List<String> a = new ArrayList<String>();
			a.add(j1.getNombre());
			a.add(j1.getPuntos() + "");
			a.add("0");// TODO HACER METODO PARA TRAER LAS PARTIDAS GANADAS DE
						// LA BD
			a.add(sqlite.getPathJugador(j1.getNombre()));

			r.add(a);
		}
		return r;
	}

	public void llenarMazo(int estilo) throws RemoteException {
		mesa.llenarMazo();
	}

	public void mostrarPrimeras3() throws RemoteException {
		o.set(0, 0);
		o.set(1, 1);
		setChanged();
		notifyObservers(o);
	}

	public void mostrarCuarta() throws RemoteException {
		o.set(1, 2);
		o.set(0, 0);
		setChanged();
		notifyObservers(o);
	}

	public void mostrarQuinta() throws RemoteException {
		o.set(0, 0);
		o.set(1, 3);
		setChanged();
		notifyObservers(o);
	}

	@Override
	public void siguienteRonda() throws RemoteException {
		ronda++;
		aposto.clear();
		if (ronda < 4) {
			o.set(0, 0);
			o.set(1, ronda);
			o.set(2, jugadorInicial);
			setChanged();
			notifyObservers(o);
		} else {
			llenarMazo(1);
			getListaCartasMesa();
			int ganador = mesa.encontrarGanador(participando);
			ganador(ganador);
			jugadorInicial++;
		}

	}

	@Override
	public void pasarTurno() throws RemoteException {
		rondaApuesta++;
		System.out.println("------" + (int) rondaApuesta / participando.size());
		turno++;
		turno = turno % participando.size();
		o.set(0, 1);
		o.set(1, 0);
		o.set(2, participando.get(turno));
		o.set(3, apuestaRonda);
		setChanged();
		notifyObservers(o);

	}

	public void agregarApuesta(int jugador, int cantidad)
			throws RemoteException {
		int anterior;
		if (a.get(jugador) != null) {
			anterior = (int) a.get(jugador);
		} else {
			anterior = 0;
		}
		a.put(jugador, cantidad + anterior);
		if (apuestaRonda < cantidad + anterior) {
			apuestaRonda = cantidad + anterior;
		}		

	}

	public void verificarApuestasRonda() throws RemoteException {
		System.out.println("Apuesta Ronda:" + apuestaRonda);

		for (int jugador : participando) {
			if ((int) a.get(jugador) != apuestaRonda) {
				return;
			}
		}
		siguienteRonda();
		for (Object jugador : a.keySet()) {
			a.put(jugador, 0);
		}
		apuestaRonda = 0;

	}

	@Override
	public void apostar(int jugador, int cantidad) throws RemoteException {
		agregarApuesta(jugador, cantidad);
		turno++;
		rondaApuesta++;

		turno = turno % participando.size();
		o.set(0, jugador);
		o.set(1, cantidad);
		o.set(2, participando.get(turno));
		o.set(3, apuestaRonda);
		o.set(4, (int) rondaApuesta / participando.size());
		setChanged();
		notifyObservers(o);
		if(aposto.contains(jugador)){
			verificarApuestasRonda();
		}else{
			aposto.add(jugador);
			if(aposto.size()==participando.size()){
				verificarApuestasRonda();
			}
		}
		actualizarDinero(jugador,cantidad);
		bote+=cantidad;

	}

	@Override
	public void retirarse(int jugador) throws RemoteException {
		for (int i = 0; i < participando.size(); i++) {
			if (participando.get(i) == jugador) {
				participando.remove(i);
				a.remove(jugador);
			}
		}
		aposto.remove(jugador);
		a.remove(jugador);
		if (participando.size() == 1) {
			ganador(participando.get(0));
		}
		turno--;
		pasarTurno();
	}

	private void ganador(Integer jugador) {
		
		o.set(0, -1);
		o.set(1, jugador);
		if(participando.size() != 1) {
			o.set(2, participando);
		}
		setChanged();
		notifyObservers(o);
		actualizarDinero(jugador, -bote);
		sqlite.registrarGanador(mesa.getJuego().getJugadores().get(jugador-1).getNombre());
		
	}

	@Override
	public void agregarNota(String nota,String usuario) throws RemoteException {
		sqlite.agregarNota(nota,usuario);

	}

	@Override
	public boolean esAdministrador(String usuario) throws RemoteException {
		return sqlite.verificarAdministrador(usuario);

	}

	@Override
	public List<List<String>> listaAdmin() throws RemoteException {

		return sqlite.listaUsuarios();
	}

	@Override
	public void iniciarPartida() throws RemoteException {
		iniciada=true;
		o=new ArrayList<Object>();
		o.add(-2);
		o.add(0);
		setChanged();
		notifyObservers(o);
	
	}

	@Override
	public void actualizarLista() throws RemoteException {
		o=new ArrayList<Object>();
		o.add(-3);
		o.add(0);
		setChanged();
		notifyObservers(o);
		
	}

	@Override
	public void registrarDenuncio(String jugador,String motivo, String descripcion)throws RemoteException {
		sqlite.registrarDenuncio(jugador,motivo,descripcion);
		
	}

	@Override
	public void bloquearJugador(String nombre) throws RemoteException {
		sqlite.bloquearUsuario(nombre);
		
	}
	 public void actualizarDinero(int jugador, int cantidad){	
			 String nombre=mesa.getJuego().getJugadores().get(jugador-1).getNombre();
			 System.out.println("nombre "+nombre+" dinero "+cantidad);
			 sqlite.actualizarDinero(nombre,cantidad);
		 
	 }

	@Override
	public String getPass(String arg0) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isIniciada() throws RemoteException {
		return iniciada;
		
	}

	@Override
	public void guardarColores(String fondo, int carta, String mesa,String usuario)
			throws RemoteException {
		sqlite.guardarColores(fondo,carta,mesa,usuario);
		
	}

	@Override
	public double promedioGanadas() throws RemoteException {
		return sqlite.promedioGanadas();
	}

	@Override
	public List<List<String>> getReportes() throws RemoteException {
		return sqlite.getReportes();
	}
}
