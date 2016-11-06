package items;

import personaje.Personaje;

public class ConPapiroDeOz extends Item {
	
	public ConPapiroDeOz(){
		this.prioridad = 2;
	}
	
	public int obtenerPuntosDeAtaque(){
		if (this.equipamiento == null)
			return 0;
		return equipamiento.obtenerPuntosDeAtaque() +  0 ;
	}
	
	public int obtenerPuntosDeDefensa(){
		if (this.equipamiento == null)
			return 0;
		return equipamiento.obtenerPuntosDeDefensa() + 0;
	}
	
	public int obtenerPuntosDeInteligencia(){
		if (this.equipamiento == null)
			return 10;
		return equipamiento.obtenerPuntosDeInteligencia() + 10;
	}
}
