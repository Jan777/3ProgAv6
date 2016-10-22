package items;

import personaje.Personaje;
import personaje.PersonajeEquipado;

public class ConPapiro extends PersonajeEquipado {
	
	public ConPapiro(Personaje personajeConPapiro) {
		super (personajeConPapiro);
	}
	
	@Override
	public int obtenerPuntosDeAtaque() {
		return super.obtenerPuntosDeAtaque();
	}
	
	@Override
	public int obtenerPuntosDeDefensa() {
		return super.obtenerPuntosDeDefensa();
	}
	
	@Override
	public int obtenerPuntosDeInteligencia() {
		return super.obtenerPuntosDeInteligencia()+1;
	}
	
}
