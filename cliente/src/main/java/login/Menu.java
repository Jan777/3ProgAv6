package login;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class Menu extends JFrame {

	private JPanel contentPane;
	private MensajeJSON mensajeJSON;
	Socket socket;
	
	
	public Menu() {
			setTitle("WorldWar");
			setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			setBounds(100, 100, 319, 251);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(new BorderLayout(0, 0));
			setContentPane(contentPane);

			JButton btnIniciarJuego = new JButton("Iniciar Juego");
			/*btnIniciarJuego.addActionListener(new ActionListener() {
				@SuppressWarnings("deprecation")
				public void actionPerformed(ActionEvent arg0) {
					instanciarPR();
					pantallaRegistro.show();
				}
			});*/
			contentPane.add(btnIniciarJuego, BorderLayout.SOUTH);

			JPanel panel = new JPanel();
			contentPane.add(panel, BorderLayout.CENTER);

			JButton btnSalir = new JButton("Salir");
			btnSalir.addActionListener(new ActionListener() {
				@SuppressWarnings("deprecation")
				public void actionPerformed(ActionEvent e) {
					try {
						socket.close();
						dispose();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			});
			btnSalir.setBounds(27, 124, 231, 20);
			panel.setLayout(null);
			panel.add(btnSalir);
			
			JButton btnCrearPersonaje = new JButton("Crear Personaje");
			btnCrearPersonaje.setBounds(27, 16, 231, 23);
			panel.add(btnCrearPersonaje);
			
			JButton btnMapa = new JButton("Seleccionar Mapa");
			/*btnMapa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});*/
			btnMapa.setBounds(28, 67, 222, 23);
			panel.add(btnMapa);
		}

}