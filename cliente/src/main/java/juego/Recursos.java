package juego;


import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class Recursos {

	private static int ANCHO; // Ancho del frame a obtener
	private static int ALTO; // Alto del frame a obtener
	
	// Inicio Personajes
	public static LinkedList<BufferedImage[]> humano = new LinkedList<>();
	private static BufferedImage[] humanoN;
	private static BufferedImage[] humanoNO; 
	private static BufferedImage[] humanoO;
	private static BufferedImage[] humanoSO;
	private static BufferedImage[] humanoS;
	private static BufferedImage[] humanoSE;
	private static BufferedImage[] humanoE;
	private static BufferedImage[] humanoNE;
	 
	
	public static LinkedList<BufferedImage[]> orco = new LinkedList<>();
	private static BufferedImage[] orcoN;
	private static BufferedImage[] orcoNO;
	private static BufferedImage[] orcoO;
	private static BufferedImage[] orcoSO;
	private static BufferedImage[] orcoS;
	private static BufferedImage[] orcoSE;
	private static BufferedImage[] orcoE;
	private static BufferedImage[] orcoNE; 

	public static LinkedList<BufferedImage[]> elfo = new LinkedList<>();
	private static BufferedImage[] elfoN;
	private static BufferedImage[] elfoNO;
	private static BufferedImage[] elfoO;
	private static BufferedImage[] elfoSO;
	private static BufferedImage[] elfoS;
	private static BufferedImage[] elfoSE;
	private static BufferedImage[] elfoE;
	private static BufferedImage[] elfoNE; 

	
	// Entorno
	public static BufferedImage cesped;
	public static BufferedImage fuego;
	public static BufferedImage background;
	//public static BufferedImage pared1;
	//public static BufferedImage pared2;
	
	
	public static BufferedImage nieve;
	// Fin Entorno
	
	// Cargo todos los recursos una sola vez para no tener que hacerlo en cada actualizacion
	
	public static void cargar() {
		ANCHO = 256;
		ALTO = 256;
			
		HojaDeSprites spriteHumano = new HojaDeSprites(CargadorImagen.cargarImagen("/humano.png"));		
			
		humanoN = new BufferedImage[10];
		humanoNO = new BufferedImage[10];
		humanoO = new BufferedImage[10];
		humanoSO= new BufferedImage[10];
		humanoS = new BufferedImage[10];
		humanoSE = new BufferedImage[10];
		humanoE = new BufferedImage[10];
		humanoNE = new BufferedImage[10];
		int k=0;
		for(int i = 0; i < 690; i+=69) {
			humanoN[k] = spriteHumano.getTile(i, 0, 69, 84);
			k++;
		}
		k=0;
		for(int i = 0; i < 690; i+=69) {
			humanoNO[k] = spriteHumano.getTile(i, 86, 69, 84);
			k++;
		}
		k=0;
		for(int i = 0; i < 690; i+=69) {
			humanoO[k] = spriteHumano.getTile(i, 172, 69, 84);
			k++;
		}
		k=0;
		for(int i = 0; i < 690; i+=69) {
			humanoSO[k] = spriteHumano.getTile(i, 258, 69, 84);
			k++;
		}
		k=0;
		for(int i = 0; i < 690; i+=69) {
			humanoS[k] = spriteHumano.getTile(i, 344, 69, 84);
			k++;
		}
		k=0;
		for(int i = 0; i < 690; i+=69) {
			humanoSE[k] = spriteHumano.getTile(i, 430, 69, 84);
			k++;
		}
		k=0;
		for(int i = 0; i < 690; i+=69) {
			humanoE[k] = spriteHumano.getTile(i, 516, 69, 84);
			k++;
		}
		k=0;
		for(int i = 0; i < 690; i+=69) {
			humanoNE[k] = spriteHumano.getTile(i, 602, 69, 84);
			k++;
		}
		
		humano.add(humanoN);
		humano.add(humanoNO);
		humano.add(humanoO);
		humano.add(humanoSO);
		humano.add(humanoS);
		humano.add(humanoSE);
		humano.add(humanoE);
		humano.add(humanoNE);
		
		HojaDeSprites spriteElfo = new HojaDeSprites(CargadorImagen.cargarImagen("/elfo.png"));		
		
		elfoN = new BufferedImage[10];
		elfoNO = new BufferedImage[10];
		elfoO = new BufferedImage[10];
		elfoSO= new BufferedImage[10];
		elfoS = new BufferedImage[10];
		elfoSE = new BufferedImage[10];
		elfoE = new BufferedImage[10];
		elfoNE = new BufferedImage[10];
		k=0;
		for(int i = 0; i < 710; i+=71) {
			elfoN[k] = spriteElfo.getTile(i, 0, 71, 90);
			k++;
		}
		k=0;
		for(int i = 0; i < 710; i+=71) {
			elfoNO[k] = spriteElfo.getTile(i, 92, 71, 90);
			k++;
		}
		k=0;
		for(int i = 0; i < 710; i+=71) {
			elfoO[k] = spriteElfo.getTile(i, 184, 71, 90);
			k++;
		}
		k=0;
		for(int i = 0; i < 710; i+=71) {
			elfoSO[k] = spriteElfo.getTile(i, 276, 71, 90);
			k++;
		}
		k=0;
		for(int i = 0; i < 710; i+=71) {
			elfoS[k] = spriteElfo.getTile(i, 368, 71, 90);
			k++;
		}
		k=0;
		for(int i = 0; i < 710; i+=71) {
			elfoSE[k] = spriteElfo.getTile(i, 460, 71, 90);
			k++;
		}
		k=0;
		for(int i = 0; i < 710; i+=71) {
			elfoE[k] = spriteElfo.getTile(i, 552, 71, 90);
			k++;
		}
		k=0;
		for(int i = 0; i < 710; i+=71) {
			elfoNE[k] = spriteElfo.getTile(i, 644, 71, 90);
			k++;
		}
		
		elfo.add(elfoN);
		elfo.add(elfoNO);
		elfo.add(elfoO);
		elfo.add(elfoSO);
		elfo.add(elfoS);
		elfo.add(elfoSE);
		elfo.add(elfoE);
		elfo.add(elfoNE);
		
		HojaDeSprites spriteOrco = new HojaDeSprites(CargadorImagen.cargarImagen("/orco.png"));		
		
		orcoN = new BufferedImage[10];
		orcoNO = new BufferedImage[10];
		orcoO = new BufferedImage[10];
		orcoSO= new BufferedImage[10];
		orcoS = new BufferedImage[10];
		orcoSE = new BufferedImage[10];
		orcoE = new BufferedImage[10];
		orcoNE = new BufferedImage[10];
		k=0;
		for(int i = 0; i < 650; i+=65) {
			orcoN[k] = spriteOrco.getTile(i, 0, 65, 94);
			k++;
		}
		k=0;
		for(int i = 0; i < 650; i+=65) {
			orcoNO[k] = spriteOrco.getTile(i, 96, 65, 94);
			k++;
		}
		k=0;
		for(int i = 0; i < 650; i+=65) {
			orcoO[k] = spriteOrco.getTile(i, 192, 65, 94);
			k++;
		}
		k=0;
		for(int i = 0; i < 650; i+=65) {
			orcoSO[k] = spriteOrco.getTile(i, 288, 65, 94);
			k++;
		}
		k=0;
		for(int i = 0; i < 650; i+=65) {
			orcoS[k] = spriteOrco.getTile(i, 384, 65, 94);
			k++;
		}
		k=0;
		for(int i = 0; i < 650; i+=65) {
			orcoSE[k] = spriteOrco.getTile(i, 480, 65, 94);
			k++;
		}
		k=0;
		for(int i = 0; i < 650; i+=65) {
			orcoE[k] = spriteOrco.getTile(i, 576, 65, 94);
			k++;
		}
		k=0;
		for(int i = 0; i < 650; i+=65) {
			orcoNE[k] = spriteOrco.getTile(i, 672, 65, 94);
			k++;
		}
		
		orco.add(orcoN);
		orco.add(orcoNO);
		orco.add(orcoO);
		orco.add(orcoSO);
		orco.add(orcoS);
		orco.add(orcoSE);
		orco.add(orcoE);
		orco.add(orcoNE);
		
		
		
		// Fin Ogro		
		
		// Inicio Entorno
		//cesped = CargadorImagen.cargarImagen("/cretebrick970.png");
		cesped = CargadorImagen.cargarImagen("/Cesped.png");
		//fuego = CargadorImagen.cargarImagen("/brickpavers2.png");
		fuego = CargadorImagen.cargarImagen("/rock.png");
		nieve = CargadorImagen.cargarImagen("/snow.png");
		background = CargadorImagen.cargarImagen("/background.jpg");
		//pared1 = CargadorImagen.cargarImagen("/bordeFrontal.png");
		//pared2 = CargadorImagen.cargarImagen("/bordeCostado.png");
		// Fin Entorno
	}
}
