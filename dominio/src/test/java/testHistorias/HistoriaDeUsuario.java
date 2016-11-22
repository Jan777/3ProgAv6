package testHistorias;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import batalla.Batalla;
import batalla.BatallaVSNPC;
import casta.Casta;
import casta.Explorador;
import casta.Guerrero;
import casta.Mago;
import items.ConEscudoDeAcero;
import items.ConEscudoDeKevlar;
import items.ConEscudoDeMadera;
import items.ConEspadaDeAcero;
import items.ConEspadaDeHierro;
import items.ConEspadaDeMadera;
import items.ConPapiroDeGandalf;
import items.ConPapiroDeOz;
import items.ConPapiroDePotter;
import personaje.Elfo;
import personaje.Enemigo1;
import personaje.Humano;
import personaje.NPC;
import personaje.Orco;
import personaje.Personaje;
import ubicacion.Ubicacion;

public class HistoriaDeUsuario {
	
		/*
		 * Historia 1:
		 * ~~~~~~~~~~~~~~~~~~~~~~~
		 * Asignar a mi personaje raza y casta
		 */
		
		@Test
	    public void Historia1() {
			Casta guerrero = new Guerrero();
			Casta mago = new Mago();
			Casta explorador = new Explorador();
			
			//Casta en humanos
			Personaje humanoGuerrero= new Humano(guerrero);
	        Assert.assertEquals(2, humanoGuerrero.obtenerPuntosDeAtaque());
	        Assert.assertEquals(1, humanoGuerrero.obtenerPuntosDeDefensa());
	        Assert.assertEquals(1, humanoGuerrero.obtenerPuntosDeInteligencia());
	        
	        Personaje humanoMago= new Humano(mago);
	        Assert.assertEquals(1, humanoMago.obtenerPuntosDeAtaque());
	        Assert.assertEquals(1, humanoMago.obtenerPuntosDeDefensa());
	        Assert.assertEquals(2, humanoMago.obtenerPuntosDeInteligencia());
	        
	        Personaje humanoExplorador= new Humano(explorador);
	        Assert.assertEquals(1, humanoExplorador.obtenerPuntosDeAtaque());
	        Assert.assertEquals(2, humanoExplorador.obtenerPuntosDeDefensa());
	        Assert.assertEquals(1, humanoExplorador.obtenerPuntosDeInteligencia());
	        
	        //Casta en Elfos
	        Personaje elfoGuerrero= new Elfo(guerrero);
	        Assert.assertEquals(2, elfoGuerrero.obtenerPuntosDeAtaque());
	        Assert.assertEquals(1, elfoGuerrero.obtenerPuntosDeDefensa());
	        Assert.assertEquals(1, elfoGuerrero.obtenerPuntosDeInteligencia());
	        
	        Personaje elfoMago= new Elfo(mago);
	        Assert.assertEquals(1, elfoMago.obtenerPuntosDeAtaque());
	        Assert.assertEquals(1, elfoMago.obtenerPuntosDeDefensa());
	        Assert.assertEquals(2, elfoMago.obtenerPuntosDeInteligencia());
	        
	        Personaje elfoExplorador= new Elfo(explorador);
	        Assert.assertEquals(1, elfoExplorador.obtenerPuntosDeAtaque());
	        Assert.assertEquals(2, elfoExplorador.obtenerPuntosDeDefensa());
	        Assert.assertEquals(1, elfoExplorador.obtenerPuntosDeInteligencia());
	        
	        //Casta en Orcos
	        Personaje orcoGuerrero= new Orco(guerrero);
	        Assert.assertEquals(2, orcoGuerrero.obtenerPuntosDeAtaque());
	        Assert.assertEquals(1, orcoGuerrero.obtenerPuntosDeDefensa());
	        Assert.assertEquals(1, orcoGuerrero.obtenerPuntosDeInteligencia());
	        
	        Personaje orcoMago= new Orco(mago);
	        Assert.assertEquals(1, orcoMago.obtenerPuntosDeAtaque());
	        Assert.assertEquals(1, orcoMago.obtenerPuntosDeDefensa());
	        Assert.assertEquals(2, orcoMago.obtenerPuntosDeInteligencia());
	        
	        Personaje orcoExplorador= new Orco(explorador);
	        Assert.assertEquals(1, orcoExplorador.obtenerPuntosDeAtaque());
	        Assert.assertEquals(2, orcoExplorador.obtenerPuntosDeDefensa());
	        Assert.assertEquals(1, orcoExplorador.obtenerPuntosDeInteligencia());

		}
		
		/*
		 * Historia 2:
		 * ~~~~~~~~~~~~~~~~~~~~~~~
		 * ingresar a un mundo con un personaje
		 */
		
		@Test
		@Ignore
	    public void Historia2() {
		}
		
		/*
		 * Historia 3:
		 * ~~~~~~~~~~~~~~~~~~~~~~~
		 * Obtener un item al ganar una batalla
		 * No se reflejan los cambios que se realizan dentro de la clase Batalla al agregar y quitar Items
		 */
		
		@Test
		@Ignore
	    public void Historia3() {
		}
		
		/*
		 * Historia 4:
		 * ~~~~~~~~~~~~~~~~~~~~~~~
		 * Aumento de experiencia al atacar enemigos
		 */
		
		@Test
	    public void Historia4() {
			Enemigo1 enemigo1 = new Enemigo1();
			
			Personaje humano = new Humano(new Guerrero());		
			Assert.assertEquals(0, humano.obtenerPuntosDeExperiencia());
			humano.atacar(enemigo1);
			Assert.assertEquals(1, humano.obtenerPuntosDeExperiencia());
			
			Personaje orco = new Orco(new Explorador());
			Assert.assertEquals(0, orco.obtenerPuntosDeExperiencia());
			orco.atacar(enemigo1);
			Assert.assertEquals(1, orco.obtenerPuntosDeExperiencia());
			
			Personaje elfo = new Elfo(new Mago());		
			Assert.assertEquals(0, elfo.obtenerPuntosDeExperiencia());
			elfo.atacar(enemigo1);
			Assert.assertEquals(1, elfo.obtenerPuntosDeExperiencia());
			
		}
		
		/*
		 * Historia 5:
		 * ~~~~~~~~~~~~~~~~~~~~~~~
		 * Cambiar de nivel al aumentar mi experiencia 
		 */
		
		@Test
	    public void Historia5() {
			/*Elijo una casta y se la asigno a un Humano*/
			Casta explorador = new Explorador();
			Personaje humano= new Humano(explorador);
			
	        Casta guerrero = new Guerrero();
			Personaje humano2 = new Humano(guerrero);
	        
			/*Nivel inicial y puntos ganados iniciales*/
			Assert.assertEquals(0, humano.obtenerNivel());
			Assert.assertEquals(0, humano.obtenerPuntosDeExperiencia());
        	
			/*Ataco 100 veces hasta aumentar el nivel (curo y energizo para poder hacer el testeo)*/
	        for(int i = 0; i < 100 ; i++){
	        	Assert.assertEquals(i, humano.obtenerPuntosDeExperiencia());
	        	humano.atacar(humano2);
	        	humano2.serCurado();
	        	humano.serEnergizado();
	        }
	        
	        Assert.assertEquals(1, humano.obtenerNivel());
			Assert.assertEquals(0, humano.obtenerPuntosDeExperiencia());

		}
		
		/*
		 * Historia 6:
		 * ~~~~~~~~~~~~~~~~~~~~~~~
		 * Al subir de nivel aumento mis habilidades
		 */
		
		@Test
	    public void Historia6() {
			/*Elijo una casta y se la asigno a un Humano*/
			Casta explorador = new Explorador();
			Personaje humano= new Humano(explorador);
			
			Personaje humano2 = new Humano(explorador);
	        
			/*Nivel inicial y puntos ganados iniciales*/
			Assert.assertEquals(0, humano.obtenerNivel());
			Assert.assertEquals(0, humano.obtenerPuntosGanados());
        	
			/*Ataco 100 veces hasta aumentar el nivel (curo y energizo para poder hacer el testeo)*/
	        for(int i = 0; i<100 ; i++){
	        	humano.atacar(humano2);
	        	humano2.serCurado();
	        	humano.serEnergizado();
	        }
	        
	        Assert.assertEquals(1, humano.obtenerNivel());
			Assert.assertEquals(4, humano.obtenerPuntosGanados());
			
			/*Asigo algunos de los puntos ganados (no todos)*/
			humano.incrementarDestreza();
			humano.incrementarFuerza();
			humano.incrementarFuerza();
			
	        Assert.assertEquals(3, humano.obtenerPuntosDeAtaque());
	        Assert.assertEquals(3, humano.obtenerPuntosDeDefensa());
	        Assert.assertEquals(1, humano.obtenerPuntosDeInteligencia());
			
	        /*Vuelvo a atacar 100 veces*/
	        for(int i = 0; i<100 ; i++){
	        	humano.atacar(humano2);
	        	humano2.serCurado();
	        	humano.serEnergizado();
	        }
	        
	        Assert.assertEquals(2, humano.obtenerNivel());
			Assert.assertEquals(6, humano.obtenerPuntosGanados());
			
			/* Asigno todos los puntos ganados que tengo */
			humano.incrementarDestreza();
			humano.incrementarDestreza();
			humano.incrementarFuerza();
			humano.incrementarFuerza();
			humano.incrementarInteligencia();
			humano.incrementarInteligencia();
			
	        Assert.assertEquals(5, humano.obtenerPuntosDeAtaque());
	        Assert.assertEquals(5, humano.obtenerPuntosDeDefensa());
	        Assert.assertEquals(3, humano.obtenerPuntosDeInteligencia());
	        
		}
		
		/*
		 * Historia 7:
		 * ~~~~~~~~~~~~~~~~~~~~~~~
		 * Equipar un personaje con una espada, potencia mi ataque
		 */
		
		@Test
	    public void Historia7() {
			//Equipo con espada de acero (aumenta 20 a la ataque) a un elfo explorador
			Personaje elfo = new Elfo(new Explorador());
			Assert.assertEquals(1, elfo.obtenerPuntosDeAtaque());
			elfo.agregarItem(new ConEspadaDeAcero());
			Assert.assertEquals(21, elfo.obtenerPuntosDeAtaque());
			//Equipo con espada de hierro (aumenta 10 a la ataque)
			elfo.agregarItem(new ConEspadaDeHierro());
			Assert.assertEquals(31, elfo.obtenerPuntosDeAtaque());
			//Equipo con espada de madera (aumenta 5 a la ataque)
			elfo.agregarItem(new ConEspadaDeMadera());
			Assert.assertEquals(36, elfo.obtenerPuntosDeAtaque());
			
			//Equipo con espada de hierro (aumenta 10 a la ataque) a un orco mago
			Personaje orco = new Orco(new Mago());
			Assert.assertEquals(1, orco.obtenerPuntosDeAtaque());
			orco.agregarItem(new ConEspadaDeHierro());
			Assert.assertEquals(11, orco.obtenerPuntosDeAtaque());
	        
			//Equipo con espada de madera (aumenta 5 a la ataque) a un humano guerrero
			Personaje humano = new Humano(new Guerrero());
			Assert.assertEquals(2, humano.obtenerPuntosDeAtaque());
			humano.agregarItem(new ConEspadaDeMadera());
			Assert.assertEquals(7, humano.obtenerPuntosDeAtaque());
		}
		
		/*
		 * Historia 8:
		 * ~~~~~~~~~~~~~~~~~~~~~~~
		 * Equipar un personaje con un escudo, potencia mi defensa
		 */
		
		@Test
	    public void Historia8() {
			//Equipo con escudo de acero (aumenta 20 a la defensa) a un elfo explorador
			Personaje elfo = new Elfo(new Explorador());
			Assert.assertEquals(2, elfo.obtenerPuntosDeDefensa());
			elfo.agregarItem(new ConEscudoDeAcero());
			Assert.assertEquals(22, elfo.obtenerPuntosDeDefensa());
			//Equipo con escudo de kevlar (aumenta 10 a la defensa)
			elfo.agregarItem(new ConEscudoDeKevlar());
			Assert.assertEquals(32, elfo.obtenerPuntosDeDefensa());
			//Equipo con escudo de madera (aumenta 5 a la defensa)
			elfo.agregarItem(new ConEscudoDeMadera());
			Assert.assertEquals(37, elfo.obtenerPuntosDeDefensa());
	        
			//Equipo con escudo de kevlar (aumenta 10 a la defensa) a un orco mago
			Personaje orco = new Orco(new Mago());
			Assert.assertEquals(1, orco.obtenerPuntosDeDefensa());
			orco.agregarItem(new ConEscudoDeKevlar());
			Assert.assertEquals(11, orco.obtenerPuntosDeDefensa());
	        
			//Equipo con escudo de madera (aumenta 5 a la defensa) a un humano guerrero
			Personaje humano = new Humano(new Guerrero());
			Assert.assertEquals(1, humano.obtenerPuntosDeDefensa());
			humano.agregarItem(new ConEscudoDeMadera());
			Assert.assertEquals(6, humano.obtenerPuntosDeDefensa());
		}
		
		/*
		 * Historia 9:
		 * ~~~~~~~~~~~~~~~~~~~~~~~
		 * Equipar un personaje con un papiro, potencia mi inteligencia
		 */
		
		@Test
	    public void Historia9() {
			//Equipo con papiro de gandalf (aumenta 20 a la inteligencia) a un elfo mago
			Personaje elfo = new Elfo(new Mago());
			Assert.assertEquals(2, elfo.obtenerPuntosDeInteligencia());
			elfo.agregarItem(new ConPapiroDeGandalf());
			Assert.assertEquals(22, elfo.obtenerPuntosDeInteligencia());
			//Equipo con papiro de Oz (aumenta 10 a la inteligencia)
			elfo.agregarItem(new ConPapiroDeOz());
			Assert.assertEquals(32, elfo.obtenerPuntosDeInteligencia());
			//Equipo con papiro de potter (aumenta 5 a la inteligencia)
			elfo.agregarItem(new ConPapiroDePotter());
			Assert.assertEquals(37, elfo.obtenerPuntosDeInteligencia());
	        
			//Equipo con papiro de Oz (aumenta 10 a la inteligencia) a un orco guerrero
			Personaje orco = new Orco(new Guerrero());
			Assert.assertEquals(1, orco.obtenerPuntosDeInteligencia());
			orco.agregarItem(new ConPapiroDeOz());
			Assert.assertEquals(11, orco.obtenerPuntosDeInteligencia());
	        
			//Equipo con papiro de potter (aumenta 5 a la inteligencia) a un humano explorador
			Personaje humano = new Humano(new Explorador());
			Assert.assertEquals(1, humano.obtenerPuntosDeInteligencia());
			humano.agregarItem(new ConPapiroDePotter());
			Assert.assertEquals(6, humano.obtenerPuntosDeInteligencia());
		}
		
		/*
		 * Historia 10:
		 * ~~~~~~~~~~~~~~~~~~~~~~~
		 * Aliarme a otro personaje y combatir a su lado
		 */
		
		@Test
		
	    public void Historia10() {
			Personaje elfo = new Elfo(new Mago());
			Personaje humano = new Humano(new Guerrero());
			Personaje orco = new Orco (new Explorador());
			Personaje sigurd = new Humano(new Guerrero());
			
			sigurd.aliarse(humano);	
			elfo.aliarse(orco);
			
			//Si los aliados de cada uno se encuentran en el radio permitido, pelean
			humano.setUbicacion(new Ubicacion(10,10));
			orco.setUbicacion(new Ubicacion(10,10));
			sigurd.setUbicacion(new Ubicacion(10,10));
			elfo.setUbicacion(new Ubicacion(11,11));
			
			//Seteo la salud para que la batalla termine más rápido
			elfo.setSalud(10);
			orco.setSalud(10);
			
			new Batalla().batalla(sigurd, elfo);
			
			Assert.assertFalse(elfo.estaVivo());
			Assert.assertFalse(orco.estaVivo());
			
			Assert.assertTrue(sigurd.estaVivo());
			Assert.assertTrue(humano.estaVivo());

		}
		
		/*
		 * Historia 11:
		 * ~~~~~~~~~~~~~~~~~~~~~~~
		 * Romper una alianza para generar una nueva
		 */
		
		@Test
	    public void Historia11() {
			Personaje elfo = new Elfo(new Mago());
			Personaje humano = new Humano(new Guerrero());
			Personaje orco = new Orco (new Explorador());
			Personaje sigurd = new Humano(new Guerrero());
			
			sigurd.aliarse(humano);	
			elfo.aliarse(orco);

			Assert.assertEquals(1, elfo.getAliados().getTamanio());
			Assert.assertEquals(1, orco.getAliados().getTamanio());
			Assert.assertEquals(1, humano.getAliados().getTamanio());
			
			Assert.assertEquals(1, sigurd.getAliados().getTamanio());
			Assert.assertTrue(sigurd.tieneAlianza());
			sigurd.salirDeAlianza();
			Assert.assertFalse(sigurd.tieneAlianza());
			
			Personaje orcoMago = new Orco (new Mago());
			sigurd.aliarse(orcoMago);
			
			Assert.assertEquals(1, sigurd.getAliados().getTamanio());
			Assert.assertEquals(1, orcoMago.getAliados().getTamanio());
			
			
			//Se testea que un personaje no pueda aliarse con sigo mismo
			Personaje elfoGuerrero = new Elfo(new Guerrero());
			Assert.assertFalse(elfoGuerrero.tieneAlianza());
			elfoGuerrero.aliarse(elfoGuerrero);
			Assert.assertFalse(elfoGuerrero.tieneAlianza());
			
			//Se testea que no puedan aliarse dos personajes que ya poseen alianzas anteriormente
			Personaje elfoMago = new Elfo(new Mago());
			Personaje humanoGuerrero = new Humano(new Guerrero());
			Personaje orcoExplorador = new Orco (new Explorador());
			Personaje sigurdGuerrero = new Humano(new Guerrero());
			
			elfoMago.aliarse(humanoGuerrero);
			orcoExplorador.aliarse(sigurdGuerrero);
			
			Assert.assertEquals(1, elfoMago.getAliados().getTamanio());
			Assert.assertEquals(1, orcoExplorador.getAliados().getTamanio());
			Assert.assertEquals(1, humanoGuerrero.getAliados().getTamanio());
			Assert.assertEquals(1, sigurdGuerrero.getAliados().getTamanio());
			
			humanoGuerrero.aliarse(orcoExplorador);
			
			Assert.assertEquals(1, orcoExplorador.getAliados().getTamanio());
			Assert.assertEquals(1, humanoGuerrero.getAliados().getTamanio());
			
			
			//Se testea que si el personaje no tiene alianza, pero el personaje al cual
			//me quiero aliar si tiene, me alio a toda su alianza
			
			Personaje orcoGuerrero = new Orco(new Guerrero());
			
			Assert.assertFalse(orcoGuerrero.tieneAlianza());
			orcoGuerrero.aliarse(elfoMago);
			Assert.assertEquals(2, orcoGuerrero.getAliados().getTamanio());
			
			//Se testea que si el personaje tiene alianza, pero el personaje al cual
			//me quiero aliar no tiene, este se alia a toda la alianza del primero
			
			Personaje humanoMago = new Humano(new Mago());
			
			Assert.assertFalse(humanoMago.tieneAlianza());
			orcoGuerrero.aliarse(humanoMago);
			Assert.assertEquals(3, humanoMago.getAliados().getTamanio());
			
			elfo.salirDeAlianza();
			humano.salirDeAlianza();
			orco.salirDeAlianza();
			sigurd.salirDeAlianza();
			orcoMago.salirDeAlianza();
			elfoMago.salirDeAlianza();
			humanoGuerrero.salirDeAlianza();
			orcoExplorador.salirDeAlianza();
			sigurdGuerrero.salirDeAlianza();
			orcoGuerrero.salirDeAlianza();
			humanoMago.salirDeAlianza();
			
			Assert.assertFalse(elfo.tieneAlianza());
			Assert.assertFalse(humano.tieneAlianza());
			Assert.assertFalse(orco.tieneAlianza());
			Assert.assertFalse(sigurd.tieneAlianza());
			Assert.assertFalse(orcoMago.tieneAlianza());
			Assert.assertFalse(elfoMago.tieneAlianza());
			Assert.assertFalse(humanoGuerrero.tieneAlianza());
			Assert.assertFalse(orcoExplorador.tieneAlianza());
			Assert.assertFalse(sigurdGuerrero.tieneAlianza());
			Assert.assertFalse(orcoGuerrero.tieneAlianza());
			Assert.assertFalse(humanoMago.tieneAlianza());
			
		}
		
		/*
		 * Historia 12:
		 * ~~~~~~~~~~~~~~~~~~~~~~~
		 * Escapar de una batalla, siendo penalizado
		 * Falta realizar ajuste para desequipar un Item
		 */
		
		@Test
		@Ignore
		public void Historia12() {
					
		}
		/*
		 * Historia 13:
		 * ~~~~~~~~~~~~~~~~~~~~~~~
		 * Destrozar obstaculos
		 */
		
		@Test
		@Ignore
	    public void Historia13() {
		}
		
		/*
		 * Historia 14:
		 * ~~~~~~~~~~~~~~~~~~~~~~~
		 * Combatir NPC para aumentar experiencia
		 */
		
		@Test
	    public void Historia14() {
			Personaje humano = new Humano(new Guerrero());
			Assert.assertEquals(0, humano.obtenerPuntosDeExperiencia());
			
			new BatallaVSNPC().ataqueNPC(humano,new NPC());
			//Como la cantidad de veces que el personaje va a atacar al NPC,
			//va a depender de los puntos de ataque que disponga, testeo que sus puntos de experiencia
			//no sean los iniciales
			Assert.assertNotEquals(0, humano.obtenerPuntosDeExperiencia());
			
			//Testeo con un elfo mago
			Personaje elfo = new Elfo(new Mago());
			Assert.assertEquals(0, elfo.obtenerPuntosDeExperiencia());
			
			new BatallaVSNPC().ataqueNPC(elfo,new NPC());
			//Como la cantidad de veces que el personaje va a atacar al NPC,
			//va a depender de los puntos de ataque que disponga, testeo que sus puntos de experiencia
			//no sean los iniciales
			Assert.assertNotEquals(0, elfo.obtenerPuntosDeExperiencia());
			
			//Testeo con un orco explorador
			Personaje orco = new Orco(new Explorador());
			Assert.assertEquals(0, orco.obtenerPuntosDeExperiencia());
			
			new BatallaVSNPC().ataqueNPC(orco,new NPC());
			//Como la cantidad de veces que el personaje va a atacar al NPC,
			//va a depender de los puntos de ataque que disponga, testeo que sus puntos de experiencia
			//no sean los iniciales
			Assert.assertNotEquals(0, orco.obtenerPuntosDeExperiencia());
			
		}
}
