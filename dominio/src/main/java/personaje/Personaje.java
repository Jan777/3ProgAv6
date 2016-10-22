package personaje;

import casta.Casta;
import xp.XP;

public abstract class Personaje implements Atacable {

	protected int energia = 100;
	protected int salud = 100;
	protected int fuerza = 1;
	protected int destreza = 1;
	protected int inteligencia = 1;
	protected int radio = 100;
	protected Casta casta;
	protected XP experiencia;
		
	public Personaje(Casta casta) {
		this.casta = casta;
		this.experiencia = new XP();
	}
	
	public Personaje() {
		this.experiencia = new XP();
	}
	
	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}

	public int getDestreza() {
		return destreza;
	}

	public void setDestreza(int destreza) {
		this.destreza = destreza;
	}

	public int getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
	}

	public final void atacar(Atacable atacado) {
		if (puedeAtacar()) {
			atacado.serAtacado(calcularPuntosDeAtaque());
			energia -= calcularQuiteDeEnergia();
			experiencia.aumentarExperiencia();
			despuesDeAtacar();
		}
	}

	protected void despuesDeAtacar() { 
	}
	
	public boolean estaVivo() {
		return this.salud > 0;
	}
	
	protected abstract boolean puedeAtacar();
	protected abstract int calcularPuntosDeAtaque();
	protected abstract int calcularPuntosDeDefensa();
	protected abstract int calcularPuntosDeMagia();
	protected abstract int calcularPuntosDeInteligencia();
	protected abstract int calcularQuiteDeEnergia();
	public abstract int obtenerPuntosDeAtaque();
	public abstract int obtenerPuntosDeDefensa();
	public abstract int obtenerPuntosDeMagia();
	public abstract int obtenerPuntosDeInteligencia();
	public abstract int obtenerPuntosDeExperiencia();
	public abstract int obtenerNivel();
	public abstract int obtenerQuiteDeEnergia();
	//public abstract void aplicarHechizoEn(String nombre, Personaje p);

	public void serAtacado(int daño) {
		this.salud -= daño;
		if (this.salud<=0){
			morir();
		}
	}

	public void serCurado() {
		this.salud = 100;
	}

	public void serEnergizado() {
		this.energia = 100;
	}

	protected void aparecer(){
		//aparece el personaje en una posicion del mapa
	}

	protected void morir(){
		//hacer desaparecer el personaje
		aparecer();
	}
	
}