package batalla;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import personaje.Atacable;
import personaje.Humano;
import personaje.Personaje;

public abstract class Batalla {

	protected List<Personaje> batallon = new LinkedList<Personaje>();
		
	public abstract void atacar(Batalla otro);
	public abstract Atacable obtenerProximaVictima();
	
	public final void depurarBatallon() {
		Iterator<Personaje> iter = batallon.iterator();
		while(iter.hasNext()){
		    if(!iter.next().estaVivo()) iter.remove();
		}
	}
	
	public void comenzar(){
	}

	public void finalizar(){
	}

	public void escapar(){
	}
	
}