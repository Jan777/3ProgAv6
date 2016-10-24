package items;

import personaje.Personaje;
import personaje.PersonajeEquipado;

public class ConEspadaDeHierro extends PersonajeEquipado {
	
	public ConEspadaDeHierro(Personaje personajeConEspada) {
		super (personajeConEspada);
	}
	
	@Override
	public int obtenerPuntosDeAtaque() {
		return super.obtenerPuntosDeAtaque()+2;
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