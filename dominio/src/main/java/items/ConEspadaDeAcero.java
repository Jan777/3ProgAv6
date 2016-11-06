package items;

import personaje.Personaje;

public class ConEspadaDeAcero extends Item {
	
	public ConEspadaDeAcero (){
		this.prioridad = 3;
	}
	
	public int obtenerPuntosDeAtaque(){
		if (this.equipamiento == null)
			return 20;
		return equipamiento.obtenerPuntosDeAtaque() + 20;
	}
	
	public int obtenerPuntosDeDefensa(){
		if (this.equipamiento == null)
			return 0;
		return equipamiento.obtenerPuntosDeDefensa() + 0;
	}
	
	public int obtenerPuntosDeInteligencia(){
		if (this.equipamiento == null)
			return 0;
		return equipamiento.obtenerPuntosDeInteligencia() + 0;
	}
}
