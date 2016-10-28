package worldwar;

import batalla.Batalla;
import casta.Casta;
import casta.Guerrero;
import items.ConEspadaDeAcero;
import items.ConEspadaDeMadera;
import personaje.Humano;
import personaje.Personaje;

public class pruebaBatallon {
	
	public static void main (String [] args) {
		Casta guerrero = new Guerrero();
		Personaje humano= new Humano(guerrero);
		humano = new ConEspadaDeAcero(humano);
		Casta guerrero1 = new Guerrero();
		Personaje humano1= new Humano(guerrero1);
		humano1 = new ConEspadaDeMadera(humano1);
		humano1.setSalud(10);
		Batalla batalla= new Batalla ();
		batalla.agregarb1(humano);
		batalla.agregarb2(humano1);
		batalla.batalla();
	}

}
