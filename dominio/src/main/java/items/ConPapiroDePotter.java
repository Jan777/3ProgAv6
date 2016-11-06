package items;

import personaje.Personaje;

public class ConPapiroDePotter extends Item {
	
	public ConPapiroDePotter(){
		this.prioridad = 1;
	}
	
	
	public int obtenerPuntosDeAtaque(){
		if (this.equipamiento == null)
			return 0;
		return equipamiento.obtenerPuntosDeAtaque() + 0;
	}
	
	public int obtenerPuntosDeDefensa(){
		if (this.equipamiento == null)
			return 0;
		return equipamiento.obtenerPuntosDeDefensa() + 0;
	}
	
	public int obtenerPuntosDeInteligencia(){
		if (this.equipamiento == null)
			return 5;
		return equipamiento.obtenerPuntosDeInteligencia() +  5 ;
	}
}
