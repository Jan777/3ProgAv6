package worldwar;

public class Guerrero extends Casta {
	
	public Guerrero () {
		super();
	}
	
	public int getInteligencia() {
		return super.getInteligencia();
	}

	public int getAtaque() {
		return super.getAtaque() + 5;
	}

	public int getDefensa() {
		return super.getDefensa();
	}
}
