package casta;

public class Mago extends Casta {
	
	public Mago () {
		super();
	}

	public int getInteligencia() {
		return super.getInteligencia()+1;
	}

	public int getAtaque() {
		return super.getAtaque();
	}

	public int getDefensa() {
		return super.getDefensa();
	}
}
