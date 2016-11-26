package juego;

import java.awt.image.BufferedImage;

public class HojaDeSprites {

	private BufferedImage ss;
	
	public HojaDeSprites(BufferedImage sprite) {
		this.ss = sprite;
	}
	
	public BufferedImage getTile(int x, int y, int ancho, int alto) {
		BufferedImage sprite = ss.getSubimage(x, y, ancho, alto);
		return sprite;
	}
}
