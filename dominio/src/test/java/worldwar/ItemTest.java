package worldwar;

import org.junit.Assert;
import org.junit.Test;
 
public class ItemTest {
   
    /*
     * Especificación de Items
     * ~~~~~~~~~~~~~~~~~~~~~~~
     * ConEspada: Esta espada aumenta en 5 pts el ataque
     * ConEscudoS: Este escudo otorga 10 pts de defensa
     * ConAnillo: Este anillo multiplica el ataque x2
     */
 

    @Test
    public void quePuedoAgregarItemDeAtaque() {
 
    	Casta mago = new Mago();
        Personaje sigmund = new Humano(mago);
        Assert.assertEquals(6, sigmund.obtenerPuntosDeInteligencia());
 
        // agrego item de ataque
        sigmund = new ConEspada(sigmund);
        Assert.assertEquals(6, sigmund.obtenerPuntosDeAtaque());
    }
 
        
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
	
	
}
