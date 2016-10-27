package alianza;

import java.util.HashMap;
import java.util.Map;

import personaje.Personaje;

public class Alianza {
	
	public Map <Integer, Aliados> alianza = new HashMap <Integer, Aliados> ();
	
	public Aliados crearAlianza () {
		alianza.put(alianza.size() + 1, new Aliados(alianza.size() + 1));
		return alianza.get(alianza.size());
	}
	
	public void agregarAliado(int numero, Personaje p) {
		alianza.get(numero).agregarPersonaje(p);
	}
	
}
