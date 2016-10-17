package worldwar;

public class Explorador extends Casta {
	
	public Explorador () {
		super();
	}
	
	public int getInteligencia() {
		return super.getInteligencia();
	}

	public int getAtaque() {
		return super.getAtaque();
	}

	public int getDefensa() {
		return super.getDefensa()+5;
	}
}