package batalla;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import personaje.Atacable;
import personaje.Humano;
import personaje.Personaje;

public abstract class Batalla {

	protected List<Personaje> batallon1 = new LinkedList<Personaje>();
	protected List<Personaje> batallon2 = new LinkedList<Personaje>();
		
	public abstract void atacar(Batalla otro);
	public abstract Atacable obtenerProximaVictima();
	
	public boolean agregarBatallon1(Personaje personaje) {
		return batallon1.add(personaje);
	}

	public boolean agregarBatallon2(Personaje personaje) {
		return batallon2.add(personaje);
	}

	public final void depurarBatallon1() {
		Iterator<Personaje> iter1 = batallon1.iterator();
		while(iter1.hasNext()){
		    if(!iter1.next().estaVivo()) iter1.remove();
		}
	}
	
	public final void depurarBatallon2() {
		Iterator<Personaje> iter2 = batallon2.iterator();
		while(iter2.hasNext()){
		    if(!iter2.next().estaVivo()) iter2.remove();
		}
	}
	
	public void comenzarBatalla(){
		Iterator<Personaje> iter1 = batallon1.iterator();
		Iterator<Personaje> iter2 = batallon2.iterator();
		while(batallon1.isEmpty() || batallon2.isEmpty()){
			iter1.hasNext().atacar(iter2.hasNext());	
		}
	}

	public void finalizar(){
	}

	public void escapar(){
	}
	
}