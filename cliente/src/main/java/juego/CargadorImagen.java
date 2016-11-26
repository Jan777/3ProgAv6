package juego;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class CargadorImagen {

	public static BufferedImage cargarImagen(String path) {
		try {
			return ImageIO.read(CargadorImagen.class.getResource(path));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Ocurri� un error con la parte gr�fica del juego, por favor intente m�s tarde.");
			System.exit(1);
		}
		return null;
	}
	
	
}
