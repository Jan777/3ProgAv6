package juego;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.json.JSONException;

import login.MensajeJSON;

public class Ventana {

	private JFrame pantalla;
	private Canvas canvas; // Objeto donde se grafica el juego

	public Ventana(final String NOMBRE, final int ANCHO, final int ALTO, String nickname) {
		pantalla = new JFrame(NOMBRE);
		pantalla.setSize(ANCHO, ALTO);
		pantalla.setResizable(false);
		pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pantalla.setLocationRelativeTo(null);
		pantalla.setVisible(true);

		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(ANCHO, ALTO));
		canvas.setMaximumSize(new Dimension(ANCHO, ALTO));
		canvas.setMinimumSize(new Dimension(ANCHO, ALTO));
		canvas.setFocusable(false);
		
		pantalla.add(canvas);
		pantalla.pack();
		
		pantalla.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				int res = JOptionPane.showConfirmDialog(pantalla, "¿Desea salir del juego?", "Salida", JOptionPane.YES_NO_OPTION);
				if (res == JOptionPane.YES_OPTION) {

						MensajeJSON mensajeJSON=new MensajeJSON();
						try {
							mensajeJSON.cerrarSesion(nickname);
						} catch (JSONException e1) {
							JOptionPane.showMessageDialog(null, "No se pudo cerrar sesión del usuario " + nickname);
						}
						pantalla.dispose();
					
				}
			}
		});
		
	}

	public Canvas getCanvas() {
		return canvas;
	}
	
	public JFrame getFrame() {
		return pantalla;
	}

}

