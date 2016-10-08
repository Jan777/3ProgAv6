package worldwar;

public class Elfo extends Personaje {
	
	int ataquesRecibidos;
	
	
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
	protected void despuesDeAtacar() {
		salud++;
	}
	
	@Override
	protected int calcularPuntosDeAtaque() {
		return getFuerza()+ataquesRecibidos;
		
	}

	@Override
	protected boolean puedeAtacar() {
		return energia >= calcularPuntosDeAtaque();
	}

	@Override
	public void serAtacado(int daño) {
		super.serAtacado(daño);
		this.ataquesRecibidos++;
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
