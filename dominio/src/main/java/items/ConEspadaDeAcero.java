package items;

import personaje.Personaje;
import personaje.PersonajeEquipado;

public class ConEspadaDeAcero extends PersonajeEquipado {
	
	public ConEspadaDeAcero(Personaje personajeConEspada) {
		super (personajeConEspada);
		this.prioridad = 1;
	}
	
	@Override
	public int obtenerPuntosDeAtaque() {
		return super.obtenerPuntosDeAtaque()+5;
	}
	
	@Override
	public int obtenerPuntosDeDefensa() {
		return super.obtenerPuntosDeDefensa();
	}
	
	@Override
	public int obtenerPuntosDeInteligencia() {
		return super.obtenerPuntosDeInteligencia();
	}
	
}
