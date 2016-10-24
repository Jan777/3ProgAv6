package items;

import personaje.Personaje;
import personaje.PersonajeEquipado;

public class ConEscudoDeMadera extends PersonajeEquipado {
	
	public ConEscudoDeMadera (Personaje personajeConEscudoDeMadera) {
		super (personajeConEscudoDeMadera);
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