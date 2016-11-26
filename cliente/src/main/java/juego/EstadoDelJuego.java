package juego;

import java.awt.Color;
import java.awt.Graphics;


public class EstadoDelJuego extends Estado {

	private Entidad personaje;
	private Mundo mundo;
	private String raza;

	public EstadoDelJuego(Juego juego, String raza) {
		super(juego);
		mundo = new Mundo(juego, "recursos/mundo2.txt");
		if (raza.equals("Orco"))
			personaje = new Entidad(juego, mundo, 64, 64, 0, 0, Recursos.orco, 170, raza);
		else if (raza.equals("Humano"))
			personaje = new Entidad(juego, mundo, 64, 64, 0, 0, Recursos.humano, 170, raza);
		else if (raza.equals("Elfo"))
			personaje = new Entidad(juego, mundo, 64, 64, 0, 0, Recursos.elfo, 170, raza);
	}

	@Override
	public void actualizar() {
		mundo.actualizar();
		personaje.actualizar();
	}

	@Override
	public void graficar(Graphics g) {
		g.drawImage(Recursos.background, 0, 0, juego.getAncho(), juego.getAlto(), null);
		mundo.graficar(g);
		personaje.graficar(g);
		}
	
	public Entidad getPersonaje() {
		return personaje;
	}
}
