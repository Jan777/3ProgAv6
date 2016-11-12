package batalla;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import alianza.Alianza;
import items.ConEspadaDeAcero;
import items.ConEspadaDeMadera;
import personaje.Atacable;
import personaje.Humano;
import personaje.Personaje;

public class Batalla  {

	public Batallon prepararBatallon(Personaje pepe) {
		Batallon batallon = new Batallon();
		Alianza aliados = pepe.getAliados();
		if (aliados != null) {
			Iterator<Personaje> iter = aliados.getAliados().iterator();
			while (iter.hasNext()) {
				Personaje p = iter.next();
				if (p.getUbicacion().intersectaCon(pepe.getUbicacion()))
					batallon.agregar(p);
			}
		}
		else
			batallon.agregar(pepe);
		return batallon;
	}


	
	public void batalla (Personaje p1 , Personaje p2 ) {
		Batallon batallon1 = prepararBatallon(p1);
		Batallon batallon2 = prepararBatallon(p2);
		
		while (!batallon1.estaVacio() && !batallon2.estaVacio()){
			
			batallon1.atacar(batallon2);
			
			if (batallon2.estaVacio()){
				System.out.println("Gana Batallon1");
				batallon1.batallaGanada();
				
			}
			else{
				batallon2.atacar(batallon1);
				
			}
			if (batallon1.estaVacio()){
				System.out.println("gana Batallon2");
				batallon2.batallaGanada();
			}
		
		}
		
	}
	
/*	public void escaparBatalla(Personaje pers){
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
	}*/
	
}