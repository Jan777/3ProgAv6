package personaje;

import xp.XP;

public class PersonajeEquipado extends Personaje {
	
	private Personaje personajeEq;
	protected int prioridad;
	
	public PersonajeEquipado(Personaje personaje) {
		//super(personaje);
		this.personajeEq = personaje;
	}
	
	@Override
	protected boolean puedeAtacar() {
		return this.personajeEq.puedeAtacar();
	}
	
	@Override
	protected int calcularPuntosDeAtaque(){
		return this.personajeEq.calcularPuntosDeAtaque();
	}
	
	@Override
	public int obtenerPuntosDeAtaque(){
		return this.personajeEq.obtenerPuntosDeAtaque();
	}
	
	@Override
	protected int calcularPuntosDeDefensa(){
		return this.personajeEq.calcularPuntosDeDefensa();
	}
	
	@Override
	public int obtenerPuntosDeDefensa(){
		return this.personajeEq.obtenerPuntosDeDefensa();
	}

	@Override
	protected int calcularPuntosDeInteligencia() {
		return this.personajeEq.calcularPuntosDeInteligencia();
	}
	
	@Override
	public int obtenerPuntosDeInteligencia() {
		return this.personajeEq.obtenerPuntosDeInteligencia();
	}

	@Override
	protected int calcularPuntosDeMagia() {
		return this.personajeEq.calcularPuntosDeMagia();
	}
	
	@Override
	public int obtenerPuntosDeMagia() {
		return this.personajeEq.obtenerPuntosDeMagia();
	}
	
	@Override
	public int obtenerPuntosDeExperiencia() {
		return experiencia.getPuntoDeExperiencia();
	}

	@Override
	public int obtenerNivel() {
		return personajeEq.experiencia.getNivel();
	}

	protected int calcularQuiteDeEnergia() {
		return this.personajeEq.calcularQuiteDeEnergia();
	}
	
	public int obtenerQuiteDeEnergia(){
		return this.personajeEq.obtenerQuiteDeEnergia();
	}
	
	@Override
	public boolean tiene(Class decorado) {
		return this.getClass() == decorado || this.personajeEq.tiene(decorado);
	}

	@Override
	public Personaje desequipar(Class decorado, PersonajeEquipado persEq, PersonajeEquipado persOri) {
		return this.desequiparEste(decorado, persEq, persOri);
	}

	private Personaje desequiparEste(Class decorado, PersonajeEquipado persEq, PersonajeEquipado persOri) {
		if (decorado==persEq.getClass()){
			return this.personajeEq;
		}else if (this.getClass() == decorado){
			persEq.personajeEq=this.personajeEq;
			return persOri; 
		} else
		return this.personajeEq.desequipar(decorado, this, persOri);
	}
	
}