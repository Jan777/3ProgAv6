package batalla;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import items.ConEspadaDeAcero;
import items.ConEspadaDeMadera;
import personaje.Atacable;
import personaje.Humano;
import personaje.Personaje;
import personaje.PersonajeEquipado;

public class Batalla  {

	protected List<Personaje> batallon1 = new LinkedList<Personaje>();
	protected List<Personaje> batallon2 = new LinkedList<Personaje>();
	
	public void agregarb1 (Personaje pers){
		batallon1.add(pers);
	}
	
	public void agregarb2 (Personaje pers){
		batallon2.add(pers);
	}
	
	public int consultaBatallon1(){
		return batallon1.size();
	}
	
	public int consultaBatallon2(){
		return batallon2.size();
	}
	
	public void batalla () {
		Iterator<Personaje> iter1;
		Iterator<Personaje> iter2;
		while (!batallon1.isEmpty() && !batallon2.isEmpty()){
			iter1 = batallon1.iterator();
			iter2 = batallon2.iterator();
			while (iter1.hasNext() && iter2.hasNext()){
				Personaje pers1 = iter1.next();
				Personaje pers2 = iter2.next();
				pers1.atacar(pers2);
				//Falta definir la prioridad del Item perdido
				if (pers2.getSalud()<=0){
					pers2=pers2.desequipar(ConEspadaDeMadera.class, (PersonajeEquipado)pers2, (PersonajeEquipado)pers2);
					pers1=new ConEspadaDeMadera(pers1);
					iter2.remove();
				}
				pers2.atacar(pers1);
				if (pers1.getSalud()<=0){
					pers1=pers1.desequipar(ConEspadaDeAcero.class, (PersonajeEquipado)pers2, (PersonajeEquipado)pers2);
					pers2=new ConEspadaDeAcero(pers2);
					iter1.remove();
				}
			}
		
		}
		
	}
	
	public void escaparBatalla(Personaje pers){
		Iterator<Personaje> iter1 = batallon1.iterator();
		Iterator<Personaje> iter2 = batallon2.iterator(); 
		while (iter1.hasNext()){
			if (pers==iter1.next()){
				iter1.remove();
				//desequipar Item
			}
		}
		while (iter2.hasNext()){
			if (pers==iter2.next()){
				iter2.remove();
				//desequipar Item
			}
		}	
	}
	
}