package items;

import personaje.Personaje;
import personaje.PersonajeEquipado;

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
		return super.obtenerPuntosDeDefensa()+1;
	}
	
	@Override
	public int obtenerPuntosDeInteligencia() {
		return super.obtenerPuntosDeInteligencia();
	}
}