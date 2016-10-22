package personaje;

import casta.Casta;

public class Orco extends Personaje {

	int cantidadDeAtaques;	
	
	public Orco(Casta casta) {
		super(casta);
	}
	
	@Override
	protected int calcularPuntosDeAtaque() {
		return getFuerza()+cantidadDeAtaques;
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
