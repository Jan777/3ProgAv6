package worldwar;

public class PersonajeEquipado extends Personaje {
	
	private Personaje personajeEq;
	
	public PersonajeEquipado(Personaje personaje) {
		this.personajeEq = personaje;
	}
	
	@Override
	protected boolean puedeAtacar() {
		return this.personajeEq.puedeAtacar();
	}
	
	@Override
	public int calcularPuntosDeAtaque(){
		return this.personajeEq.calcularPuntosDeAtaque();
	}
	
	@Override
	public int obtenerPuntosDeAtaque(){
		return this.personajeEq.obtenerPuntosDeAtaque();
	}
	
	@Override
	public int calcularPuntosDeDefensa(){
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

}