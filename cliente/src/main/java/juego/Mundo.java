package juego;


import java.awt.Graphics;

import juego.Juego;

public class Mundo {
	private Juego juego;
	private int ancho;
	private int alto;
	private int spawnX;
	private int spawnY;
	private int xOffset;
	private int yOffset;
	
	private float[] iso = new float[2];
	private int[][] tiles;

	private int xMinimo;
	private int xMaximo;
	private int yMinimo;
	private int yMaximo;

	public Mundo(Juego juego, String path) {
		this.juego = juego;
		cargarMundo(path);
	}

	public void actualizar() {

	}

	public void graficar(Graphics g) {
		xOffset = juego.getEstadoJuego().getPersonaje().getxOffset();
		yOffset = juego.getEstadoJuego().getPersonaje().getYOffset();

		xMinimo = (int) (juego.getCamara().getxOffset() - xOffset - 30);
		xMaximo = xMinimo + juego.getAncho() + xOffset + 30;
		yMinimo = (int) juego.getCamara().getyOffset() - yOffset + 5;
		yMaximo = yMinimo + juego.getAlto() + yOffset - 5; 

		for (int i = 0; i < alto; i++) {
			for (int j = 0; j < ancho; j++) {

				//grafico isometrico
				iso[0] = (i - j) * (Tile.ANCHO / 2);
				iso[1] = (i + j) * (Tile.ALTO / 2);
				
				if ((iso[0] >= xMinimo && iso[0] <= xMaximo) && (iso[1] >= yMinimo && iso[1] <= yMaximo)) {
					getTile(j, i).graficar(g, (int) (iso[0] - juego.getCamara().getxOffset()),
							(int) (iso[1] - juego.getCamara().getyOffset()));
				}
			}
		}
	}

	public Tile getTile(int x, int y) {
		Tile t = Tile.tiles[tiles[x][y]];
		if (t == null) {
			return Tile.cesped;
		}
		return t;
	}

	private void cargarMundo(String path) {
		
		//en este método podríamos poner la eleccion del mundo con un case.
		
		//ejemplo de un mapa
		BosqueConNieve mundo1 = new BosqueConNieve();
		ancho = mundo1.getAncho();
		alto = mundo1.getAlto();
		spawnX = mundo1.getSpawnX();
		spawnY = mundo1.getSpawnY();		
		tiles = mundo1.getTiles();
		
	}

	public static float[] isoA2D(float x, float y) {
		float[] dosD = new float[2];

		dosD[0] = (x / (Tile.ANCHO / 2) + y / (Tile.ALTO / 2)) / 2;
		dosD[1] = (y / (Tile.ALTO / 2) - (x / (Tile.ANCHO / 2))) / 2;

		return dosD;
	}

	/*public static float[] dosDaIso(float x, float y) {
		float[] iso = new float[2];

		iso[0] = (x - y) * (Tile.ANCHO / 2);
		iso[1] = (x + y) * (Tile.ALTO / 2);

		return iso;
	}*/

	public static int[] mouseATile(float x, float y) {
		int tile[] = new int[2];

		tile[0] = (int) Math.floor((y / Tile.ALTO) + (x / Tile.ANCHO)) + 1;
		tile[1] = (int) Math.floor((-x / Tile.ANCHO) + (y / Tile.ALTO)) + 1;

		return tile;
	}
}
