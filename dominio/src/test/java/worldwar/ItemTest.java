package worldwar;

import org.junit.Assert;

import casta.Casta;
import casta.Guerrero;
import items.ConArmadura;
import items.ConEscoba;
import items.ConEscudoDeAcero;
import items.ConEscudoDeKevlar;
import items.ConEscudoDeMadera;
import items.Item;
import personaje.Humano;
import personaje.Personaje;

public class ItemTest {
	
	public static void main (String [] args){
		
		Casta guerrero = new Guerrero();
		Personaje humano= new Humano(guerrero);
		System.out.println("1 " + humano.obtenerPuntosDeDefensa());
		
		humano.agregarItem(new ConEscudoDeKevlar());
        System.out.println("2 " + humano.obtenerPuntosDeDefensa());
        
        humano.agregarItem(new ConEscudoDeAcero());
        System.out.println("3 " + humano.obtenerPuntosDeDefensa());
        
        humano.agregarItem(new ConEscudoDeMadera());
        System.out.println("4 " + humano.obtenerPuntosDeDefensa());
        
        //humano.desequipar(ConEscudoDeAcero.class);
        //System.out.println("5 " + humano.obtenerPuntosDeDefensa());
        
        humano.desequiparMejorItem();
        System.out.println("5 " + humano.obtenerPuntosDeDefensa());        
        
	}

}
