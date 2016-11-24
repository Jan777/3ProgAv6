package batalla;

import java.util.Iterator;

import alianza.Alianza;
import personaje.Personaje;

public class Batalla  {

	public Batallon prepararBatallon(Personaje pepe) {
		Batallon batallon = new Batallon();
		Alianza aliados = pepe.getAliados();
		
		if (aliados != null) {
			Iterator<Personaje> iter = aliados.getAliados().iterator();
			while (iter.hasNext()) {
				Personaje p = iter.next();
				if (p.getUbicacion().intersectaCon(pepe.getUbicacion())){
					batallon.agregar(p);
				}
			}
		}
		batallon.agregar(pepe);
		return batallon;
	}


	
	public void batalla (Personaje p1 , Personaje p2 ) {
		Batallon batallon1 = prepararBatallon(p1);
		Batallon batallon2 = prepararBatallon(p2);
		
		while (!batallon1.estaVacio() && !batallon2.estaVacio()){
			
			batallon1.atacar(batallon2);
			
			if (batallon2.estaVacio()){
				batallon1.batallaGanada();
				batallon1.asignarItemsGanados(batallon2.itemsPerdidos);
			}
			else{
				batallon2.atacar(batallon1);
			}
			if (batallon1.estaVacio()){
				batallon2.batallaGanada();
				batallon2.asignarItemsGanados(batallon1.itemsPerdidos);
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