package alianza;

import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


import personaje.Personaje;

public class Aliados {
	
	public int idAlianza;
	private Map <Integer, Personaje> personajes = new HashMap <Integer, Personaje> ();
	//private List <Personaje> personajes = new LinkedList <Personaje> ();	
	
	public Aliados(int idAlianza) {
		this.idAlianza = idAlianza;
	}
	
	public void agregarPersonaje (Personaje p) {
		this.personajes.put(p.idPersonaje,p);
	}
	
	public void quitarPersonaje (Personaje p) {
		this.personajes.remove(p.idPersonaje);
	}
	
	public void listarPersonajes () {
		Iterator <Integer> it = personajes.keySet().iterator();
		while (it.hasNext()){
			System.out.println(it.next());
		}
			
	}

}
