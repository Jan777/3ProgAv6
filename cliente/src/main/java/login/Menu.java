package login;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.Socket;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.json.JSONException;

import juego.Juego;

import javax.swing.JComboBox;

public class Menu extends JFrame {

	private JPanel contentPane;
	private MensajeJSON mensajeJSON;
	Socket socket;
	private PantallaPersonaje pantallaPersonaje = null;
	private PantallaMapa pantallaMapa = null;
	String mapa;
	
	
	public Menu(String nickname, String raza) {
			setTitle("WorldWar");
			setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			setBounds(100, 100, 319, 251);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(new BorderLayout(0, 0));
			setContentPane(contentPane);
			
			JPanel panel = new JPanel();
			contentPane.add(panel, BorderLayout.CENTER);
			setLocationRelativeTo(null);
			
			/*BOTON CREAR EL PERSONAJE*/
			JButton btnCrearPersonaje = new JButton("Crear Personaje");
			btnCrearPersonaje .addActionListener(new ActionListener() {
				@SuppressWarnings("deprecation")
				public void actionPerformed(ActionEvent arg0) {
					if (raza.equals("sinPersonaje")){
					instanciarCP(nickname);
					pantallaPersonaje.show();
					dispose ();
					}else{
					personajeCreado();
					}
				}
			});
			//contentPane.add(btnCrearPersonaje, BorderLayout.SOUTH);
			btnCrearPersonaje.setBounds(27, 15, 230, 23);
			panel.add(btnCrearPersonaje);
			
			
			/*BOTON ELEGIR EL MAPA*/
			JButton btnMapa = new JButton("Seleccionar Mapa");
			btnMapa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					instanciarMapa();
					pantallaMapa.show();
				}
			});
			btnMapa.setBounds(27, 65, 230, 23);
			panel.add(btnMapa);
			
			/*BOTON INICIAR EL JUEGO*/
			JButton btnIniciarJuego = new JButton("Iniciar Juego");
			btnIniciarJuego.addActionListener(new ActionListener() {
				@SuppressWarnings("deprecation")
				public void actionPerformed(ActionEvent arg0) {
					
					Juego worldwar = new Juego("World War", 800, 600, nickname, raza);
					worldwar.start();
				}
			});
			contentPane.add(btnIniciarJuego, BorderLayout.SOUTH);
			btnIniciarJuego.setBounds(27, 115, 230, 23);
			panel.add(btnIniciarJuego);
			
			
			/*BOTON SALIR*/
			JButton btnSalir = new JButton("Salir");
			btnSalir.addActionListener(new ActionListener() {
				@SuppressWarnings("deprecation")
				public void actionPerformed(ActionEvent e) {
					MensajeJSON mensajeJSON=new MensajeJSON();
					try {
						mensajeJSON.cerrarSesion(nickname);
					} catch (JSONException e1) {
						JOptionPane.showMessageDialog(null, "No se pudo cerrar sesión del usuario " + nickname);
					}
					dispose();
				}
			});
			btnSalir.setBounds(77, 165, 130, 23);
			panel.setLayout(null);
			panel.add(btnSalir);

	}
	
	public void instanciarCP(String nickname) {
		this.pantallaPersonaje = new PantallaPersonaje(this, nickname);
	}
	
	public void instanciarMapa() {
		this.pantallaMapa = new PantallaMapa(this);
	}
	
	public void personajeCreado (){
		JOptionPane.showMessageDialog(null, "Ya posee creado un personaje");
	}
	
}