package batalla;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import personaje.Atacable;
import personaje.Humano;
import personaje.Personaje;

public class Batalla  {

	protected List<Personaje> batallon1 = new LinkedList<Personaje>();
	protected List<Personaje> batallon2 = new LinkedList<Personaje>();
	
	public void agregarb1 (Personaje pers){
		batallon1.add(pers);
	}
	
	public void agregarb2 (Personaje pers){
		batallon2.add(pers);
	}
	
	public void removerb1 (Personaje pers){
		batallon1.remove(pers);
	}
	
	public void removerb2 (Personaje pers){
		batallon2.remove(pers);
	}
	
	public int consultaBatallon1(){
		return batallon1.size();
	}
	
	public int consultaBatallon2(){
		return batallon2.size();
	}
	
	public void batalla () {
		Iterator<Personaje> iter1 = batallon1.iterator();
		Iterator<Personaje> iter2 = batallon2.iterator();
		while (batallon1.isEmpty() || batallon2.isEmpty()){
			while (iter1.hasNext() && iter2.hasNext()){
				Personaje pers1 = iter1.next();
				Personaje pers2 = iter2.next();
				pers1.atacar(pers2);
				if (pers2.getSalud()==0){
					removerb2(pers2);
				}
				pers2.atacar(pers1);
				if (pers1.getSalud()==0){
					removerb1(pers1);
				}
			}
		}
		if (consultaBatallon1()==0){
			System.out.println("gano batallon 2");
		}else{
			System.out.println("gano batallon 1");
		}
	
	}
}