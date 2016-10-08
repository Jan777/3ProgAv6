package worldwar;

public class ConEscudo extends PersonajeEquipado{
	 
	public ConEscudo (Personaje personajeConEscudo) {
		super (personajeConEscudo);
	}
		
	@Override
	public int obtenerPuntosDeAtaque() {
		return super.obtenerPuntosDeAtaque();
	}
	
	@Override
	public int obtenerPuntosDeDefensa() {
		return super.obtenerPuntosDeDefensa()+5;
	}
	
	@Override
	public int obtenerPuntosDeInteligencia() {
		return super.obtenerPuntosDeInteligencia();
	}
}