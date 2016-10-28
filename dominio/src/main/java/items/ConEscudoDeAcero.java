package items;

import personaje.Personaje;
import personaje.PersonajeEquipado;

public class ConEscudoDeAcero extends PersonajeEquipado {
	
	public ConEscudoDeAcero (Personaje personajeConEscudoDeAcero) {
		super (personajeConEscudoDeAcero);
		//this.prioridad = 1;
	}
		
	@Override
	public int obtenerPuntosDeAtaque() {
		return super.obtenerPuntosDeAtaque();
	}
	
	@Override
	public int obtenerPuntosDeDefensa() {
		return super.obtenerPuntosDeDefensa()+3;
	}
	
	@Override
	public int obtenerPuntosDeInteligencia() {
		return super.obtenerPuntosDeInteligencia();
	}

}
