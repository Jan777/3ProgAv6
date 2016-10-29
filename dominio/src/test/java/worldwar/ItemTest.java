package worldwar;

import org.junit.Assert;
import org.junit.Test;

import casta.Casta;
import casta.Mago;
import items.ConEscudoDeKevlar;
import items.ConEscudoDeMadera;
import items.ConEspadaDeAcero;
import items.ConEspadaDeHierro;
import items.ConEspadaDeMadera;
import items.ConPapiroDeGandalf;
import personaje.Humano;
import personaje.Personaje;
import personaje.PersonajeEquipado;
 
public class ItemTest {
   
    /*
     * Especificación de Items
     * ~~~~~~~~~~~~~~~~~~~~~~~
     * ConEspada: Esta espada aumenta en 5 pts el ataque
     * ConEscudoS: Este escudo otorga 10 pts de defensa
     * ConAnillo: Este anillo multiplica el ataque x2
     */
 

    /*@Test
    public void quePuedoAgregarItemDeAtaque() {
 
    	Casta mago = new Mago();
        Personaje sigmund = new Humano(mago);
        Assert.assertEquals(6, sigmund.obtenerPuntosDeInteligencia());
 
        // agrego item de ataque
        sigmund = new ConEspadaDeMadera(sigmund);
        Assert.assertEquals(6, sigmund.obtenerPuntosDeAtaque());
    }
 
     */   
    /*@Test
    public void quePuedoAgregarAmbosItems() {
 
        Personaje sigmund = new Humano();
        Assert.assertEquals(1, sigmund.obtenerPuntosDeAtaque());
 
        // agrego item de ataque
        sigmund = new ConEspada(sigmund);
        Assert.assertEquals(5 + 1, sigmund.obtenerPuntosDeAtaque());
 
        Assert.assertEquals(0, sigmund.obtenerPuntosDeDefensa());
        sigmund = new ConEscudo(sigmund);
        // agrego defensa
        Assert.assertEquals(10 + 0, sigmund.obtenerPuntosDeDefensa());
        // y no pierdo ataque
        Assert.assertEquals(5 + 1, sigmund.obtenerPuntosDeAtaque());
    }*/
    
    
    /*@Test
    public void quePuedoAgregarDosTiposDeItem() {
        Personaje sigmund = new Humano();
        Assert.assertEquals(1, sigmund.obtenerPuntosDeAtaque());
 
        // agrego item de ataque
        sigmund = new ConEspada(sigmund);
        Assert.assertEquals(5 + 1, sigmund.obtenerPuntosDeAtaque());
 
        // agrego anillo multiplicador (x2)
        sigmund = new ConPapiro(sigmund);
        Assert.assertEquals((5 + 1) * 2, sigmund.obtenerPuntosDeAtaque());
    }*/
	
    @Test
	public void quePuedoQuitarUnItem() {
    	Casta mago = new Mago();
		Personaje sigmund = new Humano(mago);
		
		
		sigmund = new ConEspadaDeHierro(sigmund);
		/*sigmund = new ConEspadaDeAcero(sigmund);
		sigmund = new ConEscudoDeMadera(sigmund);
		sigmund = new ConEscudoDeKevlar(sigmund);
		sigmund = new ConPapiroDeGandalf(sigmund);
		System.out.println(sigmund.getCantItem());*/
		//Assert.assertEquals(2,sigmund.getCantItem());
		
		Assert.assertTrue(sigmund.tiene(ConEspadaDeHierro.class));
		//Assert.assertTrue(sigmund.tiene(ConEspadaDeAcero.class));
		//Assert.assertTrue(sigmund.tiene(ConEscudoDeMadera.class));
		sigmund = sigmund.desequipar(ConEspadaDeHierro.class, (PersonajeEquipado)sigmund, (PersonajeEquipado)sigmund);
		Assert.assertFalse(sigmund.tiene(ConEspadaDeHierro.class));
		//Assert.assertFalse(sigmund.tiene(ConEspadaDeAcero.class));
		//Assert.assertTrue(sigmund.tiene(ConEscudoDeMadera.class));
		//Assert.assertTrue(sigmund.tiene(ConEscudoDeKevlar.class));
		//Assert.assertTrue(sigmund.tiene(ConPapiroDeGandalf.class));
		//Assert.assertTrue(sigmund.tiene(ConEspadaDeHierro.class));
		/*Assert.assertTrue(sigmund.tiene(ConEspadaSkofnung.class));
		sigmund = sigmund.desequipar(ConEspadaSkofnung.class);
		Assert.assertFalse(sigmund.tiene(ConEspadaSkofnung.class));
		*/
	}
	
}
