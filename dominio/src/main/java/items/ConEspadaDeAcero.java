package items;

import personaje.Personaje;
import personaje.PersonajeEquipado;

public class ConEspadaDeAcero extends PersonajeEquipado {
	
	public ConEspadaDeAcero(Personaje personajeConEspada) {
		super (personajeConEspada);
	}
	
	@Override
	public int obtenerPuntosDeAtaque() {
		return super.obtenerPuntosDeAtaque()+3;
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
