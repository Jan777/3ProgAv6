package items;

import personaje.Personaje;
import personaje.PersonajeEquipado;

public class ConEscudoDeAcero extends PersonajeEquipado {
	
	public ConEscudoDeAcero (Personaje personajeConEscudoDeAcero) {
		super (personajeConEscudoDeAcero);
	}
		
	@Override
	public int obtenerPuntosDeAtaque() {
		return super.obtenerPuntosDeAtaque();
	}
	
	@Override
	public int obtenerPuntosDeDefensa() {
		return (int) (super.obtenerPuntosDeDefensa()*1.4);
	}
	
	@Override
	public int obtenerPuntosDeInteligencia() {
		return super.obtenerPuntosDeInteligencia();
	}

}
