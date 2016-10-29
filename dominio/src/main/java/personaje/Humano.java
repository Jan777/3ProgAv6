package personaje;

import casta.Casta;

public class Humano extends Personaje {
	
	int cantItems;
	
	public Humano(Casta casta) {
		super(casta);
	}
	
	@Override
	protected int calcularPuntosDeAtaque() {
		return getFuerza();
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
	protected boolean puedeAtacar() {
		return energia >= 10;
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
		return 1;
	}
	
	/*public void aplicarHechizoEn(String nombre, Personaje p){
		Iterator <String> it = m.keySet().iterator();
		
	}*/
	
	
		
	
}
