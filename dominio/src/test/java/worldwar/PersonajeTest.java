package worldwar;

import org.junit.Assert;
import org.junit.Test;

import alianza.Aliados;
import alianza.Alianza;
import casta.Casta;
import casta.Explorador;
import casta.Guerrero;
import casta.Mago;
import items.ConEscudoDeMadera;
import items.ConEscudoDeAcero;
import items.ConEscudoDeKevlar;
import items.ConEspadaDeMadera;
import items.ConPapiroDeOz;
import personaje.Elfo;
import personaje.Enemigo1;
import personaje.Enemigo2;
import personaje.Enemigo3;
import personaje.Humano;
import personaje.Orco;
import personaje.Personaje;

public class PersonajeTest {
	
	/*
	 * Especificaci�n de Personajes
	 * ~~~~~~~~~~~~~~~~~~~~~~~
	 * Humano (Fuerza=1,Destreza=1,Inteligencia=1)
	 * Asigno una casta Guerrero (suma 1 al Ataque)
	 * Asigno una espada (suma 1 al ataque)
	 */
	
	@Test
    public void creoPersonajeHumano() {
		
		//Elijo una casta y se la asigno a un Humano
		Casta guerrero = new Guerrero();
		Personaje humano= new Humano(guerrero);
        Assert.assertEquals(2, humano.obtenerPuntosDeAtaque());
        Assert.assertEquals(1, humano.obtenerPuntosDeDefensa());
        Assert.assertEquals(1, humano.obtenerPuntosDeInteligencia());

        //Asigno una espada al personaje
        humano = new ConEspadaDeMadera(humano);
        Assert.assertEquals(3, humano.obtenerPuntosDeAtaque());
        Assert.assertEquals(1, humano.obtenerPuntosDeDefensa());
        Assert.assertEquals(1, humano.obtenerPuntosDeInteligencia());
    }
	
	/*
	 * Especificaci�n de Personajes
	 * ~~~~~~~~~~~~~~~~~~~~~~~
	 * Orco (Fuerza=1,Destreza=1,Inteligencia=1)
	 * Asigno una casta Explorador (suma 1 a la defensa)
	 * Asigno un escudo de madera (suma 2 a la defensa)
	 */

	@Test
    public void creoPersonajeOrco() {
		
		//Elijo una casta y se la asigno a un orco
		Casta explorador = new Explorador();
		Personaje orco= new Orco(explorador);
        Assert.assertEquals(1, orco.obtenerPuntosDeAtaque());
        Assert.assertEquals(2, orco.obtenerPuntosDeDefensa());
        Assert.assertEquals(1, orco.obtenerPuntosDeInteligencia());

        //Asigno un escudo al personaje
        orco = new ConEscudoDeMadera(orco);
        Assert.assertEquals(1, orco.obtenerPuntosDeAtaque());
        Assert.assertEquals(3, orco.obtenerPuntosDeDefensa());
        Assert.assertEquals(1, orco.obtenerPuntosDeInteligencia());
    }
	
	/*
	 * Especificaci�n de Personajes
	 * ~~~~~~~~~~~~~~~~~~~~~~~
	 * Elfo (Fuerza=1,Destreza=1,Inteligencia=1)
	 * Asigno una casta Mago (suma 1 a inteligencia)
	 * Asigno un papiro (suma 1 a la inteligencia)
	 * Asigno un un escudo (suma 1 a la defensa)
	 */

	@Test
    public void creoPersonajeElfo() {
		
		//Elijo una casta y se la asigno a un Elfo
		Casta mago = new Mago();
		Personaje elfo = new Elfo(mago);
		Assert.assertEquals(1, elfo.obtenerPuntosDeAtaque());
        Assert.assertEquals(1, elfo.obtenerPuntosDeDefensa());
        Assert.assertEquals(2, elfo.obtenerPuntosDeInteligencia());
    
        //Asigno un papiro al personaje
        elfo = new ConPapiroDeOz(elfo);
        Assert.assertEquals(1, elfo.obtenerPuntosDeAtaque());
        Assert.assertEquals(1, elfo.obtenerPuntosDeDefensa());
        Assert.assertEquals(3, elfo.obtenerPuntosDeInteligencia());
        
        //Asigno un escudo al personaje
        elfo = new ConEscudoDeAcero(elfo);
        Assert.assertEquals(1, elfo.obtenerPuntosDeAtaque());
        Assert.assertEquals(4, elfo.obtenerPuntosDeDefensa());
        Assert.assertEquals(3, elfo.obtenerPuntosDeInteligencia());
        
    }

	/*
	 * Dos humanos con casta Mago atacan y van subiendo experiencia por cada ataque
	 * Al llegar a los 5 puntos (a modo de ejemplo, en realidad van a ser 100 pts) aumenta el nivel
	 */
	
	@Test
    public void aumentoNivelDeHumano() {
		
		//Elijo una casta y se la asigno a un Elfo
		Casta mago = new Mago();
		Personaje humano1 = new Humano(mago);
		Personaje humano2 = new Humano(mago);
	
		Assert.assertEquals(0, humano1.obtenerNivel());
		Assert.assertEquals(0, humano1.obtenerPuntosDeExperiencia());
		Assert.assertEquals(0, humano2.obtenerNivel());
		Assert.assertEquals(0, humano2.obtenerPuntosDeExperiencia());
		
		//Humano 1 ataca a humano 2
		for (int i =0; i<51; i++){
			humano1.atacar(humano2);
		}
		humano1.serEnergizado();
		for (int i =0; i<50; i++){
			humano1.atacar(humano2);
		}
		Assert.assertEquals(1, humano1.obtenerNivel());
		Assert.assertEquals(1, humano1.obtenerPuntosDeExperiencia());
		Assert.assertEquals(0, humano2.obtenerNivel());
		Assert.assertEquals(0, humano2.obtenerPuntosDeExperiencia());
		
		//Humano 2 ataca a humano 1
		
		humano2.atacar(humano1);
		humano2.atacar(humano1);
		humano2.atacar(humano1);
		humano2.atacar(humano1);
		humano2.atacar(humano1);
		Assert.assertEquals(1, humano1.obtenerNivel());
		Assert.assertEquals(1, humano1.obtenerPuntosDeExperiencia());
		Assert.assertEquals(0, humano2.obtenerNivel());
		Assert.assertEquals(5, humano2.obtenerPuntosDeExperiencia());		
    }
	
	/*
	@Test //Alianzas
	public void asignacionPersonajeAlianza (){

		Alianza alianza = new Alianza();
		
		Aliados aliados = alianza.crearAlianza();
		
		Casta casta1 = new Mago ();
		Personaje p1 = new Humano (casta1);
		p1.idPersonaje = 11;
		
		Casta casta2 = new Mago ();
		Personaje p2 = new Humano (casta2);
		p2.idPersonaje = 22;
		
		Aliados alianza = new Aliados ();
		alianza.agregarPersonaje(p1);
		p1.alianza = alianza;
		alianza.listarPersonajes();
		p1.alianza.listarPersonajes();
		p1.alianza.quitarPersonaje(p1);
		
		alianza.listarPersonajes();
		
	}
	
	*/
			
	
}
