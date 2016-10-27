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
		return (int) (super.obtenerPuntosDeDefensa()*1.3);
	}
	
	@Override
	public int obtenerPuntosDeInteligencia() {
		return super.obtenerPuntosDeInteligencia();
	}
}
