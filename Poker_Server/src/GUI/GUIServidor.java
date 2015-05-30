package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.rmi.RemoteException;

import javax.swing.JLabel;

import Logica.Servidor;

public class GUIServidor extends JFrame {

	private JPanel contentPane;
	Servidor servidor;
	JButton btnIniciar;

	/**
	 * 
	 * inicia la aplicacion Servidor
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIServidor frame = new GUIServidor();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * crea la interfaz GUIServidos con sus componentes
	 */
	public GUIServidor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnIniciar = new JButton("INICIAR");
		btnIniciar.addActionListener(new ActionListener() {
			/**
			 * inicia el servidor
			 */
			public void actionPerformed(ActionEvent e) {
				Servidor.main(null);
				btnIniciar.setEnabled(false);
			}
		});
		btnIniciar.setBounds(98, 289, 107, 49);
		contentPane.add(btnIniciar);

		JButton btnDetener = new JButton("DETENER");
		btnDetener.addActionListener(new ActionListener() {
			/**
			 * cierra el servidor
			 */
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnDetener.setBounds(285, 289, 107, 49);
		contentPane.add(btnDetener);

		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon("guiAzul.png"));
		fondo.setBounds(0, 0, 584, 362);
		contentPane.add(fondo);

	}

}
