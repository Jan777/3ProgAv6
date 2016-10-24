package items;

import personaje.Personaje;
import personaje.PersonajeEquipado;

public class ConEspadaDeMadera extends PersonajeEquipado {
	
	public ConEspadaDeMadera(Personaje personajeConEspada) {
		super (personajeConEspada);
	}
	
	@Override
	public int obtenerPuntosDeAtaque() {
		return super.obtenerPuntosDeAtaque()+1;
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