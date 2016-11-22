package batalla;

import java.util.LinkedList;

import java.util.Iterator;
import personaje.Personaje;

import personaje.Atacable;

public class Batallon {
	
private LinkedList <Personaje> batallon = new LinkedList <Personaje> ();
	
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
		    	bajaEnBatalla(p);
		    }
		    	
		}
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

