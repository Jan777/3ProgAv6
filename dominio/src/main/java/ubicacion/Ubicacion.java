package ubicacion;

public class Ubicacion {
	private int x;
	private int y;
	int radio;
public Ubicacion(int x, int y) {
	this.x = x;
	this.y = y;
	this.radio = 100;
	

}

public double  distanciaCon(Ubicacion personaje){
	 
		return Math.sqrt( Math.pow(this.x - personaje.x, 2)
				+ Math.pow(this.y - personaje.y, 2));
	}

public boolean intersectaCon(Ubicacion personaje) {
	return this.distanciaCon(personaje) <=
			this.radio + personaje.radio;
}


}
