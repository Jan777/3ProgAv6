package personaje;

import casta.Casta;
import items.Item;
import xp.XP;
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
	//ubicacion
	protected int saludTope;
	protected int energiTope;
	protected int cantItem = 0;
	protected Item equipamiento = null;
	
	
	/*
	 *  Constructores 
	 */
	//Constructor est�ndar
	public Personaje(Casta casta) {
		this.casta = casta;
		this.experiencia = new XP();
	}
	//Constructor para Enemigos
	public Personaje() {
	}
	//Contructor para?
	public Personaje(Personaje pers){
		this.casta = pers.casta;
		this.experiencia = pers.experiencia;
	}
	
	/*
	 * Getters y Setters
	 */
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
	public Alianza getAliados() {
		return aliados;
	}
	public void setAliados(Alianza aliados) {
		this.aliados = aliados;
	}
	public int getCantItem() {
		return cantItem;
	}
	

	/*
	 * Definici�n de m�todos abstractos
	 */
	public abstract int obtenerPuntosDeAtaque();
	public abstract int obtenerPuntosDeDefensa();
	public abstract int obtenerPuntosDeInteligencia();
	
	/*f
	 * Asignaci�n de puntos a habilidades
	 */
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
	
	/*
	 * Atacar y Ser Atacado
	 */
	public final void atacar(Atacable atacado) {
		if (puedeAtacar()) {
			atacado.serAtacado(obtenerPuntosDeAtaque());
			energia -= obtenerPuntosDeAtaque();
			experiencia.aumentarExperiencia();
			despuesDeAtacar();
		}
	}
	
	protected void despuesDeAtacar() { 
	}
	
	public void serAtacado(int danio) {
		if(danio > this.obtenerPuntosDeDefensa())
			this.salud -= (danio-this.obtenerPuntosDeDefensa());
		else
			this.salud--;
		
		if (this.salud<=0){
			this.morir();
		}
	}
	
	protected boolean puedeAtacar() {
		return energia >= obtenerPuntosDeAtaque();
	}
	
	/*
	 * Calculo de Puntos por Items
	 */
	public int obtenerPuntosDeAtaqueItem(){		
		if (this.equipamiento == null){
			return 0;
		}else{
			return this.equipamiento.obtenerPuntosDeAtaque();
		}
	}
	
	public int obtenerPuntosDeDefensaItem(){
		if (this.equipamiento == null){
			return 0;
		}else{
			return this.equipamiento.obtenerPuntosDeDefensa();
		}
	}
	
	public int obtenerPuntosDeInteligenciaItem(){
		if (this.equipamiento == null){
			return 0;
		}else{
			return this.equipamiento.obtenerPuntosDeInteligencia();
		}
	}
	
	/*
	 * M�todos para Alianzas
	 */
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
	
	/*
	 * Otras varias...
	 */
	public boolean estaVivo() {
		return this.salud > 0;
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
	
	/*
	 * M�todos para manejo de items
	 */
	public boolean tiene(Class decorado) {
		return this.equipamiento.tiene(decorado);
	}
	
	public void agregarItem (Item i){
		if(this.equipamiento == null)
			this.equipamiento = i;
		else{
			this.equipamiento.agregarItem(i);
		}
		incrementarCantidadDeItemsEquipados();
	}
	
	public Personaje desequipar(Class decorado){
		if(this.equipamiento == null  ||  !this.tiene(decorado) ){
			return this;
		}
		if(this.equipamiento.getClass() == decorado)
			this.equipamiento = this.equipamiento.equipamiento;
		else {
			this.equipamiento.desequipar(decorado,this.equipamiento);			
		}
		decrementarCantidadDeItemsEquipados();
		return this;
	}
	
	public Personaje desequipar2(int decorado){
		if(this.equipamiento.getPrioridad() == decorado)
			this.equipamiento = this.equipamiento.equipamiento;
		else {
			this.equipamiento.desequipar2(decorado,this.equipamiento);			
		}
		decrementarCantidadDeItemsEquipados();
		return this;
	}
	
	public Personaje desequiparMejorItem() {
		if(this.equipamiento == null ){
			return this;
		}
		int mejor = equipamiento.buscarMayorPrioridad(this.equipamiento.getPrioridad());
		return desequipar2(mejor);
	}

	public boolean puedeEquipar(){
		return this.cantItem<3;
	}
	
	private void incrementarCantidadDeItemsEquipados(){
		this.cantItem++;
	}
	
	private void decrementarCantidadDeItemsEquipados() {
		this.cantItem--;
	}
	
	public int obtenerNivel() {
		return experiencia.getNivel();
	}
	
	public int obtenerPuntosDeExperiencia (){
		return this.experiencia.getPuntoDeExperiencia();
	}
	

		
}