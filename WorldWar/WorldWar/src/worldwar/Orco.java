package worldwar;

public class Orco extends Personaje {

	int cantidadDeAtaques;	
	
	@Override
	protected int calcularPuntosDeDefensa() {
		return getDestreza();
	}
	
	@Override
	public int obtenerPuntosDeInteligencia() {
		return getInteligencia();
	}

	@Override
	public int obtenerPuntosDeAtaque() {
		return calcularPuntosDeAtaque();
	}
	
	@Override
	public int obtenerPuntosDeDefensa() {
		return calcularPuntosDeDefensa();
	}
	
	@Override
	protected int calcularPuntosDeAtaque() {
		return getFuerza()+cantidadDeAtaques;
	}
	
	@Override
	protected void despuesDeAtacar() {
		cantidadDeAtaques++;
	}
	
	@Override
	protected boolean puedeAtacar() {
		return energia >= calcularPuntosDeAtaque();
	}

	@Override
	protected int calcularPuntosDeMagia() {
		return 0;
	}

	@Override
	protected int calcularPuntosDeInteligencia() {
		return 0;
	}

	@Override
	public int obtenerPuntosDeMagia() {
		return 0;
	}
}
