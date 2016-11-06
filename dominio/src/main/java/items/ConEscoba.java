package items;

import personaje.Personaje;

public class ConEscoba extends Item{
	
	
	
	public int obtenerPuntosDeAtaque(){
		if (this.equipamiento == null)
			return 5;
		return equipamiento.obtenerPuntosDeAtaque() + 5;
	}
	
	public int obtenerPuntosDeDefensa(){
		if (this.equipamiento == null)
			return 5;
		return equipamiento.obtenerPuntosDeDefensa() + 0;
	}
	
	public int obtenerPuntosDeInteligencia(){
		if (this.equipamiento == null)
			return 5;
		return equipamiento.obtenerPuntosDeInteligencia() + 0;
	}

}
