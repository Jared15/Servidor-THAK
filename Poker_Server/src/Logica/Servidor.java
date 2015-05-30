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
	Set<Integer> aposto = new HashSet<Integer>();
	private int bote = 0;
	private boolean iniciada = false;

	private static final long serialVersionUID = 1L;

	/**
	 * inicia el servidor
	 * 
	 * @param args
	 *            no es usado
	 */
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

	/**
	 * obtiene la ruta de una catra
	 * 
	 * @param carta
	 *            id de la carta a buscar la ruta
	 * @throws RemoteException
	 *             exepcion de conexion con el cliente
	 */
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

	/**
	 * observador
	 * 
	 * @author JACOJ
	 *
	 */
	private class WrappedObserver implements Observer, Serializable {

		private static final long serialVersionUID = 1L;

		private RemoteObserver remoteObserver = null;

		/**
		 * Crea una instancia de WrappedObserver
		 * 
		 * @param remoteObserver
		 */
		public WrappedObserver(RemoteObserver remoteObserver) {
			this.remoteObserver = remoteObserver;
		}

		/**
		 * @Override
		 * notifica cambios a los observadores
		 * @param observable 
		 * @param mensaje 
		 */
		public void update(Observable observable, Object mensaje) {
			try {
				remoteObserver.update(observable.toString(), mensaje);
			} catch (RemoteException e) {
				System.out
						.println("Remote exception removing observer:" + this);
				observable.deleteObserver(this);
			}
		}
	}

	/**
	 * @Override
	 * añade el obserbador 
	 * @param o el observador a agregar
	 */
	public void addObserver(RemoteObserver o) throws RemoteException {
		WrappedObserver mo = new WrappedObserver(o);
		addObserver(mo);
		System.out.println("Added observer:" + mo);
	}
/**
 * elimina un observador
 * @param o el observador a eliminar
 */
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
/**
 * inicia el hilo de la conexion
 */
	public void RmiServer() {
		thread.start();
	}
/**
 *  envia el mensaje de crear jugador a la base de datos
 * @param nombre nombre del jugador
 * @param pass contraseña del jugador
 * @param PathAvatar direccion del avatar del jugador
 */
	@Override
	public void crearJugador(String nombre, String pass, String PathAvatar)
			throws RemoteException {
		sqlite.agregarJugador(nombre, pass, PathAvatar);

	}
	/**
	 *  envia el mensaje de actualizar jugador a la base de datos
	 * @param nombre nombre del jugador
	 * @param pass contraseña del jugador
	 * @param PathAvatar direccion del avatar del jugador
	 */	
	@Override
	public void actualizarJugador(String nombre, String pass, String PathAvatar)
			throws RemoteException {
		sqlite.actualizarJugador(nombre, pass, PathAvatar);

	}

	/**
	 * envia la solicitud de verificar un jugador a la base de datos
	 * @param nombre nombre del jugador
	 * @param pass contraseña del jugador
	 * @return si el usuario esta autorizado para acceder al sistema
	 */
	public boolean verificarJugador(String nombre, String pass)
			throws RemoteException {
		return sqlite.verificarUsuario(nombre, pass);

	}
	/**
	 * añade un jugador al servidor
	 * @param nombreJugador jugador a ser agregado
	 */
	@Override
	public void addJugador(String nombreJugador) throws RemoteException {

		System.out.println("--------------------Entro (" + nombreJugador
				+ ") a la sala---------------------");
		mesa.getJuego().getJugadores().add(sqlite.getJugador(nombreJugador));

	}
/**
 * elimina a un jugador del servidor
 * @param nombreJugador jugador a ser eliminado
 */
	public void sacarJugador(String nombreJugador) {
		mesa.getJuego().getJugadores()
				.remove((sqlite.getJugador(nombreJugador)));
	}
/**
 * inicia los valores iniciales de las variables
 * @throws RemoteException exepcion de conexion con el cliente
 */
	public void iniciar() throws RemoteException {
		ronda = 0;
		turno = 0;
		rondaApuesta = 0;
		bote = 0;
		llenarParticipantes();
	}
/**
 * obtiene las cartas del juego y notifica a los observadores
 * @throws RemoteException exepcion de conexion con el cliente
 */
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
		apostar(jugadorInicial, 50);
		apostar(jugadorInicial + 1, 100);
		aposto.clear();

	}
/**
 * llena la lista de jugadores participantes en la mano
 */
	private void llenarParticipantes() {
		for (int i = 0; i < mesa.getJuego().getNoJugadores(); i++) {
			participando.add(new Integer(i + 1));
			a.put(i + 1, 0);
		}

	}
/**
 * retorna la lista de avatares de los jugadores
 * @param nombreUsuarioSesion nombre del usuario * 
 * @return lista con las rutas de los avatares de los jugadores
 * @throws RemoteException exepcion de conexion con el cliente
 */
	@Override
	public List<String> traerAvatar(String nombreUsuarioSesion)
			throws RemoteException {
		return sqlite.traerPathAvatar(nombreUsuarioSesion);

	}
/**
 * envia la solicitud de eliminar un usuario a la base de datos
 * @param nombreJugador nombre del jugador a eliminar
 * @throws RemoteException exepcion de conexion con el cliente
 */
	@Override
	public void eliminarJugador(String nombreJugador) throws RemoteException {
		sqlite.eliminarJugador(nombreJugador);

	}
/**
 * devuelve la informacion de los jugadores 
 * @return un conjunto con los datos de todos los jugadores
 */
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
/**
 * llena el mazo de la mesa con el estilo de carta seleccionado
 * @param estilo estilo de carta eligido
 * @throws RemoteException exepcion de conexion con el cliente
 */
	
	public void llenarMazo(int estilo) throws RemoteException {
		mesa.llenarMazo();
	}
	/**
	 * notifica a los observadores para mostrar las primeras tres cartas
	 * @throws RemoteException exepcion de conexion con el cliente
	 */
	public void mostrarPrimeras3() throws RemoteException {
		o.set(0, 0);
		o.set(1, 1);
		setChanged();
		notifyObservers(o);
	}
	/**
	 * notifica a los observadores para mostrar la cuarta carta
	 * @throws RemoteException exepcion de conexion con el cliente
	 */
	public void mostrarCuarta() throws RemoteException {
		o.set(1, 2);
		o.set(0, 0);
		setChanged();
		notifyObservers(o);
	}
	/**
	 * notifica a los observadores para mostrar la quinta carta
	 * @throws RemoteException exepcion de conexion con el cliente
	 */
	public void mostrarQuinta() throws RemoteException {
		o.set(0, 0);
		o.set(1, 3);
		setChanged();
		notifyObservers(o);
	}
	/**
	 * hace el cambio de ronda y lo notifica a los observadores
	 * @throws RemoteException exepcion de conexion con el cliente
	 */
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
	/**
	 * cambia el jugador en tueno y lo notifica a los observadores
	 * @throws RemoteException exepcion de conexion con el cliente
	 */
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
/**
 * agrega una apuesta a las apuestas y modifica la apuesta de la ronda
 * @throws RemoteException exepcion de conexion con el cliente
 */
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
	/**
	 * verifica si es momento de cambiar de ronda
	 * @throws RemoteException exepcion de conexion con el cliente
	 */
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
	/**
	 * recibe la apuesta de un jugador, la guarda en el servidor y notifica a los observadores
	 * @param jugador id del jugador que hace la apuesta
	 * @param cantidad dinero que reprensenta la apuesta del jugador
	 * @throws RemoteException exepcion de conexion con el cliente
	 */
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
		if (aposto.contains(jugador)) {
			verificarApuestasRonda();
		} else {
			aposto.add(jugador);
			if (aposto.size() == participando.size()) {
				verificarApuestasRonda();
			}
		}
		actualizarDinero(jugador, cantidad);
		bote += cantidad;

	}
	/**
	 * retira al jugador de la mano actual
	 * @param jugador id del jugador a retirarse
	 * @throws RemoteException exepcion de conexion con el cliente
	 */
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
/**
 * notifica el jugador ganador a alos observadores
 * @param jugador
 */
	private void ganador(Integer jugador) {

		o.set(0, -1);
		o.set(1, jugador);
		if (participando.size() != 1) {
			o.set(2, participando);
		}
		setChanged();
		notifyObservers(o);
		actualizarDinero(jugador, -bote);
		sqlite.registrarGanador(mesa.getJuego().getJugadores().get(jugador - 1)
				.getNombre());

	}
	/**
	 * envia la peticion de agregar una nota a la base de datos
	 * @param nota nota a agregar
	 * @param usuario jugador que creo la nota
	 * @throws RemoteException exepcion de conexion con el cliente
	 */
	@Override
	public void agregarNota(String nota, String usuario) throws RemoteException {
		sqlite.agregarNota(nota, usuario);

	}
	/**
	 * envia la solicitud de verificar si un usuario es administrador a la base de datos
	 * @param usuario usuario a verificar
	 * @return confirmacion si el usuario es un administrador
	 * @throws RemoteException exepcion de conexion con el cliente
	 */
	@Override
	public boolean esAdministrador(String usuario) throws RemoteException {
		return sqlite.verificarAdministrador(usuario);

	}
	/**
	 * obtiene la informacion de todos los jugadores para mostrarsela a un administrador
	 * @return informacion de todos los usuarios de la base de datos
	 * @throws RemoteException exepcion de conexion con el cliente
	 */
	@Override
	public List<List<String>> listaAdmin() throws RemoteException {

		return sqlite.listaUsuarios();
	}
	/**
	 * notifica a todos los abservadores el inicio de una partida
	 * @throws RemoteException exepcion de conexion con el cliente
	 */
	@Override
	public void iniciarPartida() throws RemoteException {
		iniciada = true;
		o = new ArrayList<Object>();
		o.add(-2);
		o.add(0);
		setChanged();
		notifyObservers(o);

	}
	/**
	 * notifica a los obserbadores la actualizacion de la lista de participantes en la mesa
	 * @throws RemoteException exepcion de conexion con el cliente
	 */
	@Override
	public void actualizarLista() throws RemoteException {
		o = new ArrayList<Object>();
		o.add(-3);
		o.add(0);
		setChanged();
		notifyObservers(o);

	}
	/**
	 * envia la peticion de registrar denuncio a la base de datos
	 * @param jugador jugador que hace el denuncio
	 * @param motivo motivo del denuncio
	 * @param descripcion descripcion del denuncio
	 * @throws RemoteException exepcion de conexion con el cliente
	 */
	@Override
	public void registrarDenuncio(String jugador, String motivo,
			String descripcion) throws RemoteException {
		sqlite.registrarDenuncio(jugador, motivo, descripcion);

	}
	/**
	 * envia la solicitud de bloquear un usuario a la base de datos
	 * @param nombre jugador a ser bloqueado
	 * @throws RemoteException exepcion de conexion con el cliente
	 */
	@Override
	public void bloquearJugador(String nombre) throws RemoteException {
		sqlite.bloquearUsuario(nombre);

	}
/**
 * envia la solicitud de actualizar el dinero de un jugadore en la base de datos
 * @param jugador jugador al que se le actualiza el dinero
 * @param cantidad monto en el que se le actualiza el dinero del jugador
 */
	public void actualizarDinero(int jugador, int cantidad) {
		String nombre = mesa.getJuego().getJugadores().get(jugador - 1)
				.getNombre();
		System.out.println("nombre " + nombre + " dinero " + cantidad);
		sqlite.actualizarDinero(nombre, cantidad);

	}
	/**
	 * envia la solicitud de obtener la contraseña de la base de datos y returna la respuesta
	 * @param usuario jugador al que se le obtiene la contraseña
	 * @return contraseña del usuario
	 * @throws RemoteException exepcion de conexion con el cliente
	 */
	@Override
	public String getPass(String usuario) throws RemoteException {
		
		return sqlite.getPass(usuario);
	}
	/**
	 * retorna si la partida ya esta iniciada
	 * @return si la partida ya inicio
	 * @throws RemoteException exepcion de conexion con el cliente
	 */
	@Override
	public boolean isIniciada() throws RemoteException {
		return iniciada;

	}
	/**
	 * envia la solicitud de guardar las preferencias de colores de un usuario
	 * @param fondo preferencia de fondo del jugador
	 * @param carta preferencia de carta del jugador
	 * @param mesa preferencia de mesa del jugador
	 * @param usuario usuario al que se le van a agregar las preferencias
	 * @throws RemoteException exepcion de conexion con el cliente
	 */
	@Override
	public void guardarColores(String fondo, int carta, String mesa,
			String usuario) throws RemoteException {
		sqlite.guardarColores(fondo, carta, mesa, usuario);

	}
	/**
	 * envia la solicitud a la base de datos para obtener el promedio de partidas ganadas
	 * @return promedio de partidas ganadas de la base de datos
	 * @throws RemoteException exepcion de conexion con el cliente
	 */
	@Override
	public double promedioGanadas() throws RemoteException {
		return sqlite.promedioGanadas();
	}
	/**
	 * debuelbe un reporte con la informacion de los jugadores de la base de datos
	 * @return lista con el reporte de los jugadores
	 * @throws RemoteException exepcion de conexion con el cliente
	 */
	@Override
	public List<List<String>> getReportes() throws RemoteException {
		return sqlite.getReportes();
	}
	/**
	 * notifica a los observadores una actualizacion
	 * @throws RemoteException exepcion de conexion con el cliente
	 */
	@Override
	public void notificarActualizacion(String arg0) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
}
