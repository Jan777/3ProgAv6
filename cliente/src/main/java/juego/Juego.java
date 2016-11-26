package juego;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JOptionPane;

public class Juego implements Runnable {

	private Ventana pantalla;
	private final String NOMBRE;
	private final int ANCHO;
	private final int ALTO;
	private String nickname;
	private String raza;
	
	private Thread hilo;
	
	public Thread getHilo() {
		return hilo;
	}

	private boolean enFuncionamiento;

	private BufferStrategy bs; 
	private Graphics g;

	// Estados
	private Estado estadoJuego;

	// HandlerMouse
	private ControlMouse controlarMouse;
	
	// Camara
	private VistaCamara camara;

	public Juego(final String nombre, final int ancho, final int alto, String nickname, String raza) {
		this.NOMBRE = nombre;
		this.ALTO = alto;
		this.ANCHO = ancho;
		this.nickname = nickname;
		controlarMouse = new ControlMouse();
		this.raza = raza;
	}

	public void iniciar() { // Carga lo necesario para iniciar el juego
		pantalla = new Ventana(NOMBRE, ANCHO, ALTO, nickname);
		pantalla.getCanvas().addMouseListener(controlarMouse);
		Recursos.cargar();

		estadoJuego = new EstadoDelJuego(this, raza);
		Estado.setEstado(estadoJuego);
		
		camara = new VistaCamara(this, 0, 0);
	}

	private void actualizar() { // Actualiza los objetos y sus posiciones
		controlarMouse.actualizar();

		if (Estado.getEstado() != null) {
			Estado.getEstado().actualizar();
		}
	}

	private void graficar() { // Grafica los objetos y sus posiciones
		bs = pantalla.getCanvas().getBufferStrategy();
		if (bs == null) { // Seteo una estrategia para el canvas en caso de que no tenga una
			pantalla.getCanvas().createBufferStrategy(3);
			return;
		}

		g = bs.getDrawGraphics();

		g.clearRect(0, 0, ANCHO, ALTO); // Limpieza de pantalla

		// Graficado de imagenes
		
		if (Estado.getEstado() != null) {
			estadoJuego.graficar(g);
	 	}

		// Fin de graficado de imagenes

		bs.show(); // Pone visible el siguiente buffer disponible
		g.dispose();
	}

	@Override
	public void run() { // Hilo principal del juego
		iniciar();

		int fps = 60; // Cantidad de actualizaciones por segundo que se desean
		double tiempoPorActualizacion = 1000000000 / fps; // Cantidad de nanosegundos en FPS deseados
		double delta = 0;
		long ahora;
		long ultimoTiempo = System.nanoTime();
		long timer = 0; // Timer para mostrar fps cada un segundo
		int actualizaciones = 0; // Cantidad de actualizaciones que se realizan realmente

		while (enFuncionamiento) {
			ahora = System.nanoTime();
			delta += (ahora - ultimoTiempo) / tiempoPorActualizacion; // Calculo  para determinar cuando realizar la actualizacion y el graficado
			timer += ahora - ultimoTiempo; // Sumo el tiempo transcurrido hasta que se acumule 1 segundo y mostrar los FPS
			ultimoTiempo = ahora; // Para las proximas corridas del bucle

			if (delta >= 1) {
				actualizar();
				graficar();
				actualizaciones++;
				delta--;
			}

			if (timer >= 1000000000) { // Si paso 1 segundo muestro los FPS
				pantalla.getFrame().setTitle(NOMBRE + " | " + "FPS: " + fps);
				actualizaciones = 0;
				timer = 0;
			}
		}

		stop();
	}

	public synchronized void start() { // Inicia el juego
		if (enFuncionamiento)
			return;
		enFuncionamiento = true;
		hilo = new Thread(this);
		hilo.start();
	}

	public synchronized void stop() { // Detiene el juego
		if (!enFuncionamiento)
			return;
		try {
			enFuncionamiento = false;
			hilo.join();
		} catch (InterruptedException e) {
			JOptionPane.showMessageDialog(null, "Fallo al intentar detener el juego.");
		}
	}

	public int getAncho() {
		return ANCHO;
	}

	public int getAlto() {
		return ALTO;
	}

	public ControlMouse getHandlerMouse() {
		return controlarMouse;
	}
	
	public VistaCamara getCamara() {
		return camara;
	}
	
	public EstadoDelJuego getEstadoJuego() {
		return (EstadoDelJuego) estadoJuego;
	}

}

