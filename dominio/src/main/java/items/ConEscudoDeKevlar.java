package items;

import personaje.Personaje;
import personaje.PersonajeEquipado;

public class ConEscudoDeKevlar extends PersonajeEquipado{
	 
	public ConEscudoDeKevlar (Personaje personajeConEscudoDeMimbre) {
		super (personajeConEscudoDeMimbre);
	}
		
	@Override
	public int obtenerPuntosDeAtaque() {
		return super.obtenerPuntosDeAtaque();
	}
	
	@Override
	public int obtenerPuntosDeDefensa() {
		return super.obtenerPuntosDeDefensa()+2;
	}
	
	@Override
	public int obtenerPuntosDeInteligencia() {
		return super.obtenerPuntosDeInteligencia();
	}
}
