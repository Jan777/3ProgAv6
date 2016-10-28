package personaje;

import casta.Casta;
import ubicacion.Ubicacion;
import xp.XP;
import alianza.Aliados;
import alianza.Alianza;


public abstract class Personaje implements Atacable {

	public int idPersonaje;
	protected int energia = 100;
	protected int salud = 100;
	protected int fuerza = 1;
	protected int destreza = 1;
	protected int inteligencia = 1;
	protected Casta casta;
	protected XP experiencia;
	protected Alianza aliados = null;
	private Ubicacion ubicacion;
	protected int saludTope;
	protected int energiTope;
		
	public Personaje(Casta casta) {
		this.casta = casta;
		this.experiencia = new XP();
	}
	
	public Personaje() {
		this.experiencia = new XP();
	}
	
	public Personaje(Personaje pers){
		this.casta = pers.casta;
		this.experiencia = pers.experiencia;
	}
	
	public int getEnergia() {
		return energia;
	}

	public void setEnergia(int energia) {
		this.energia = energia;
	}

	public int getSalud() {
		return salud;
	}

	public void setSalud(int salud) {
		this.salud = salud;
	}

	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}

	public int getDestreza() {
		return this.destreza;
	}

	public void setDestreza(int destreza) {
		this.destreza = destreza;
	}

	public int getInteligencia() {
		return inteligencia;
	}

	
	public XP getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(XP experiencia) {
		this.experiencia = experiencia;
	}

	public void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
	}

	public void incrementarInteligencia(){
		if(validaPuntos()){
			this.inteligencia++;
			this.experiencia.decrementarPuntosGanados();
		}
	}
	
	public void incrementarFuerza(){
		if(validaPuntos()){
			this.fuerza++;
			this.experiencia.decrementarPuntosGanados();
		}
	}

	public void incrementarDestreza(){
		if(validaPuntos()){
			this.destreza++;
			this.experiencia.decrementarPuntosGanados();
		}
	}
	
	public boolean validaPuntos(){
		return obtenerPuntosGanados() >= 1;
	}

	
	public int obtenerPuntosGanados(){
		return this.experiencia.getPuntosGanados();
	}
	
	public final void atacar(Atacable atacado) {
		if (puedeAtacar()) {
			atacado.serAtacado(obtenerPuntosDeAtaque());
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

	public void serAtacado(int danio) {
		if(danio > this.obtenerPuntosDeDefensa())
			this.salud -= (danio-this.obtenerPuntosDeDefensa());
		else
			this.salud--;
		
		if (this.salud<=0){
			this.morir();
		}
	}
	
	public void serCurado() {
		this.salud = 100;
	}

	public void serEnergizado() {
		this.energia = 100;
	}
	
	public Alianza getAliados() {
		return aliados;
	}

	public void setAliados(Alianza aliados) {
		this.aliados = aliados;
	}
	
	public void aliarse(Personaje otr) {
		if (this.aliados == null) {
			if (otr.aliados == null) {
				Alianza alianza = new Alianza();
				alianza.agregarAliado(otr);
				alianza.agregarAliado(this);
				this.aliados = alianza;
				otr.aliados = alianza;
			} else {

				otr.aliados.agregarAliado(this);
				this.aliados = otr.aliados;
			}
		} else {
			if(otr.aliados == null){
				this.aliados.agregarAliado(this);
				otr.aliados = this.aliados;
			}
			else 
				System.out.println("el jugador ya tiene alianza");

		}

	}

	public void salirDeAlianza() {
		this.aliados.removerAliado(this);
		this.aliados = null;
	}

	protected void aparecer(){
		//aparece el personaje en una posicion del mapa
	}

	protected void morir(){
		//hacer desaparecer el personaje
		aparecer();
	}
	
}