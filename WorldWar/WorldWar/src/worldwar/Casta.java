package worldwar;

public class Casta extends Personaje {
	
	private Personaje personaje;
	
	public Casta(Personaje sigmund) {
		personaje = sigmund;
	}

	@Override
	protected boolean puedeAtacar() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected int calcularPuntosDeAtaque() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected int calcularPuntosDeDefensa() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int obtenerPuntosDeAtaque() {
		// TODO Auto-generated method stub
		return personaje.obtenerPuntosDeAtaque();
	}

	@Override
	public int obtenerPuntosDeDefensa() {
		// TODO Auto-generated method stub
		return personaje.obtenerPuntosDeDefensa();
	}

	public int obtenerPuntosDeInteligencia() {
		return personaje.obtenerPuntosDeInteligencia();
	}

	@Override
	protected int calcularPuntosDeMagia() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected int calcularPuntosDeInteligencia() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int obtenerPuntosDeMagia() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
