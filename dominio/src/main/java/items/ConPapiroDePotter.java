package items;

import personaje.Personaje;
import personaje.PersonajeEquipado;

public class ConPapiroDePotter extends PersonajeEquipado {
	
	public ConPapiroDePotter(Personaje personajeConPapiro) {
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
		return super.obtenerPuntosDeInteligencia()+2;
	}
	
}
