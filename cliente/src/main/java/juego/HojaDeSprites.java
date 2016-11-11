package juego;

import java.awt.image.BufferedImage;

public class HojaDeSprites {

	private BufferedImage sprite;
	
	public HojaDeSprites(BufferedImage sprite) {
		this.sprite = sprite;
	}
	
	public BufferedImage getTile(int x, int y, int ancho, int alto) {
		return sprite.getSubimage(x, y, ancho, alto);
	}
}
