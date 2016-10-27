package personaje;

import casta.Casta;

public class Elfo extends Personaje {
	
	int ataquesRecibidos;
	
	public Elfo(Casta casta) {
		super(casta);
	}
	
	@Override
	protected int calcularPuntosDeAtaque() {
		return getFuerza()+ataquesRecibidos;
		
	}
	
	@Override
	protected int calcularPuntosDeDefensa() {
		return getDestreza();
	}
	
	@Override
	protected int calcularPuntosDeInteligencia() {
		return getInteligencia();
	}
	
	@Override
	public int obtenerPuntosDeInteligencia() {
		return calcularPuntosDeInteligencia() + casta.getInteligencia();
	}
	
	@Override
	public int obtenerPuntosDeAtaque() {
		return calcularPuntosDeAtaque() + casta.getAtaque();
	}
	
	@Override
	public int obtenerPuntosDeDefensa() {
		return calcularPuntosDeDefensa() + casta.getDefensa();
	}
	
	@Override
	protected void despuesDeAtacar() {
		salud++;
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
	public int obtenerPuntosDeMagia() {
		return 0;
	}
	
	@Override
	public int obtenerPuntosDeExperiencia() {
		return experiencia.getPuntoDeExperiencia();
	}

	@Override
	public int obtenerNivel() {
		return experiencia.getNivel();
	}
	
	public int obtenerQuiteDeEnergia(){
		return calcularQuiteDeEnergia();
	}
	
	protected int calcularQuiteDeEnergia(){
		return 5;
	}
	
}
