package juego;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class CargadorImagen {

	public static BufferedImage cargarImagen(String path) {
		try {
			return ImageIO.read(CargadorImagen.class.getResource(path));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Ocurrió un error con la parte gráfica del juego, por favor intente más tarde.");
			System.exit(1);
		}
		return null;
	}
}
