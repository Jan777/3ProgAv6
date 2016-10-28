package personaje;

public class NPC implements Atacable  {
	
	int salud = 5;
	
	public NPC() {
		this.salud = salud;
	}

	public int getSalud() {
		return salud;
	}

	public void setSalud(int salud) {
		this.salud = salud;
	}
	
	public void serAtacado(int danio) {
		this.salud-=danio;
	}
	
	public void morir() {
		this.salud = 0;
	}
	
	public int obtenerPuntosDeDefensa() {
		return 0;
	}
	
	
}