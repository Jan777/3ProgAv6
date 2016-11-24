package batalla;

import java.util.LinkedList;

import items.ConEscudoDeAcero;
import items.ConEscudoDeKevlar;
import items.ConEscudoDeMadera;
import items.ConEspadaDeAcero;
import items.ConEspadaDeHierro;
import items.ConEspadaDeMadera;
import items.ConPapiroDeGandalf;
import items.ConPapiroDeOz;
import items.ConPapiroDePotter;
import items.Item;

import java.util.Iterator;
import personaje.Personaje;

import personaje.Atacable;

public class Batallon {
	
private LinkedList <Personaje> batallon = new LinkedList <Personaje> ();

public LinkedList<Personaje> getBatallon() {
	return batallon;
}

public LinkedList<Class> itemsPerdidos = new LinkedList<Class>();
public LinkedList<Item> itemsTotal = new LinkedList<Item>();
	
	public void atacar(Batallon otro){
		Iterator<Personaje> it = batallon.iterator();
		Personaje atacante;
		
		while(it.hasNext()){
			atacante = it.next();
			otro.depurarBatallon();
			if(!otro.estaVacio()){
				atacante.atacar(otro.obtenerProximaVictima());
			}
		}
		
		
		/*for (Personaje atacante : batallon) {
			if(batallon.isEmpty()){
				
			}else
				atacante.atacar(otro.obtenerProximaVictima());
		}*/
	}
	

	public  Atacable obtenerProximaVictima(){
		 //depurarBatallon();
		 
		 return batallon.get(0);
		
	}
	public int getSize(){
		return batallon.size();
	}
	
	public boolean estaVacio(){
		return batallon.isEmpty();
	}
	public void agregar(Personaje p){
		batallon.add(p);
	}
	
	public final void depurarBatallon() {
		Iterator<Personaje> iter =  batallon.iterator();
		
		while(iter.hasNext()){
			Personaje p = iter.next();
		    if(!p.estaVivo()){
		    	itemsPerdidos.add(p.desequiparMejorItem());
		    	bajaEnBatalla(p);
		    }
		    	
		}
	}
	
	public void asignarItemsGanados(LinkedList<Class> itemsPerdidos){
		cargarItems();
		for (Personaje luchador : batallon){
			if(luchador.puedeEquipar()){
				Item item = buscarItem(itemsPerdidos.getLast());
				itemsPerdidos.removeLast();
				luchador.agregarItem(item);
			}
		}
	}
	
	public void cargarItems(){
		this.itemsTotal.add(new ConEscudoDeAcero());
		this.itemsTotal.add(new ConEscudoDeKevlar());
		this.itemsTotal.add(new ConEscudoDeMadera());
		this.itemsTotal.add(new ConEspadaDeAcero());
		this.itemsTotal.add(new ConEspadaDeHierro());
		this.itemsTotal.add(new ConEspadaDeMadera());
		this.itemsTotal.add(new ConPapiroDeGandalf());
		this.itemsTotal.add(new ConPapiroDeOz());
		this.itemsTotal.add(new ConPapiroDePotter());
	}
	
	public Item buscarItem(Class itemBuscado){
		for(Item item : this.itemsTotal){
			if(item.getClass() == itemBuscado){
				return item;
			}
		}
		return null;
	}
	
	public void batallaGanada(){
		for (Personaje luchador : batallon){
			luchador.getExperiencia().aumentarExperiencia(100);
		}
	}
	
	public void bajaEnBatalla(Personaje p){
		batallon.remove(p);
		p.desequiparMejorItem();
	}

}

