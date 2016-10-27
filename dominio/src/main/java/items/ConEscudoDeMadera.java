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
		return (int) (super.obtenerPuntosDeDefensa()*1.2);
	}
	
	@Override
	public int obtenerPuntosDeInteligencia() {
		return super.obtenerPuntosDeInteligencia();
	}

}