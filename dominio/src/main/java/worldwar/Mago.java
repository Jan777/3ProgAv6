package worldwar;

public class Mago extends Casta {
	
	public Mago () {
		super();
	}

	public int getInteligencia() {
		return super.getInteligencia()+5;
	}

	public int getAtaque() {
		return super.getAtaque();
	}

	public int getDefensa() {
		return super.getDefensa();
	}
}
