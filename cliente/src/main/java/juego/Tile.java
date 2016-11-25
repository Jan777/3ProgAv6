package juego;


import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	
	public static Tile[] tiles = new Tile[256];
	public static Tile cesped = new TileCesped(0); //id 0 para cesped
	public static Tile fuego = new TileFuego(1); //id 1 para fueog
	public static Tile nieve = new TileNieve(2); //id 2 para nieve
	//public static Tile bordeFrontal = new TilePared1(3);
	//public static Tile bordeLateral = new TilePared2(4);
	
	public static final int ANCHO = 64;
	public static final int ALTO = 32;
	
	protected BufferedImage textura;
	protected final int id;
	
	public Tile(BufferedImage textura, int id) {
		this.textura = textura;
		this.id = id;
		
		tiles[id] = this;
	}
	
	public void actualizar() {
		
	}
	
	public void graficar(Graphics g, int x, int y) {
		g.drawImage(textura, x, y, ANCHO, ALTO, null);
	}
	
	public boolean esSolido() {
		return false;
	}
	
	public int getId() {
		return id;
	}
}
