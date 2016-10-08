package worldwar;

import org.junit.Assert;
import org.junit.Test;

public class PersonajeTest {
	
	/*
	 * Especificación de Personajes
	 * ~~~~~~~~~~~~~~~~~~~~~~~
	 * Humano (Fuerza=1,Destreza=1,Inteligencia=1)
	 * Asigno una casta (suma 5 a la Inteligencia)
	 * Asigno una espada (suma 5 a la fuerza)
	 */
	
	@Test
    public void creoPersonajeHumano() {
		
		//Creo un personaje
		Personaje humano= new Humano();
        Assert.assertEquals(1, humano.obtenerPuntosDeAtaque());
        Assert.assertEquals(1, humano.obtenerPuntosDeDefensa());
        Assert.assertEquals(1, humano.obtenerPuntosDeInteligencia());
 
        //Elijo la casta
        humano = new Mago(humano);
        Assert.assertEquals(1, humano.obtenerPuntosDeAtaque());
        Assert.assertEquals(1, humano.obtenerPuntosDeDefensa());
        Assert.assertEquals(6, humano.obtenerPuntosDeInteligencia());
    
        //Asigno una espada al personaje
        humano = new ConEspada(humano);
        Assert.assertEquals(6, humano.obtenerPuntosDeAtaque());
        Assert.assertEquals(1, humano.obtenerPuntosDeDefensa());
        Assert.assertEquals(6, humano.obtenerPuntosDeInteligencia());
    }
	
	/*
	 * Especificación de Personajes
	 * ~~~~~~~~~~~~~~~~~~~~~~~
	 * Orco (Fuerza=1,Destreza=1,Inteligencia=1)
	 * Asigno una casta (suma 5 a la Inteligencia)
	 * Asigno una espada (suma 5 a la fuerza)
	 */

	@Test
    public void creoPersonajeOrco() {
		
		//Creo un personaje
		Personaje orco= new Orco();
        Assert.assertEquals(1, orco.obtenerPuntosDeAtaque());
        Assert.assertEquals(1, orco.obtenerPuntosDeDefensa());
        Assert.assertEquals(1, orco.obtenerPuntosDeInteligencia());
 
        //Elijo la casta
        orco = new Explorador(orco);
        Assert.assertEquals(1, orco.obtenerPuntosDeAtaque());
        Assert.assertEquals(6, orco.obtenerPuntosDeDefensa());
        Assert.assertEquals(1, orco.obtenerPuntosDeInteligencia());
    
        //Asigno un escudo al personaje
        orco = new ConEscudo(orco);
        Assert.assertEquals(1, orco.obtenerPuntosDeAtaque());
        Assert.assertEquals(11, orco.obtenerPuntosDeDefensa());
        Assert.assertEquals(1, orco.obtenerPuntosDeInteligencia());
    }
	
	/*
	 * Especificación de Personajes
	 * ~~~~~~~~~~~~~~~~~~~~~~~
	 * Elfo (Fuerza=1,Destreza=1,Inteligencia=1)
	 * Asigno una casta Guerrero (suma 5 a Ataque)
	 * Asigno una espada (suma 5 a la fuerza)
	 */

	@Test
    public void creoPersonajeElfo() {
		
		//Creo un personaje
		Personaje elfo = new Elfo();
		Assert.assertEquals(1, elfo.obtenerPuntosDeAtaque());
        Assert.assertEquals(1, elfo.obtenerPuntosDeDefensa());
        Assert.assertEquals(1, elfo.obtenerPuntosDeInteligencia());
 
        //Elijo la casta
		elfo = new Guerrero(elfo);
        Assert.assertEquals(6, elfo.obtenerPuntosDeAtaque());
        Assert.assertEquals(1, elfo.obtenerPuntosDeDefensa());
        Assert.assertEquals(1, elfo.obtenerPuntosDeInteligencia());
    
        //Asigno un papiro al personaje
        elfo = new ConPapiro(elfo);
        Assert.assertEquals(6, elfo.obtenerPuntosDeAtaque());
        Assert.assertEquals(1, elfo.obtenerPuntosDeDefensa());
        Assert.assertEquals(6, elfo.obtenerPuntosDeInteligencia());
        
        //Asigno un escudo al personaje
        elfo = new ConEscudo(elfo);
        Assert.assertEquals(6, elfo.obtenerPuntosDeAtaque());
        Assert.assertEquals(6, elfo.obtenerPuntosDeDefensa());
        Assert.assertEquals(6, elfo.obtenerPuntosDeInteligencia());
        
    }
}
