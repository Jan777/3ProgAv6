package items;

public class ConEspadaDeMadera extends Item {
	
	public ConEspadaDeMadera(){
		this.prioridad = 1;
	}
	public int obtenerPuntosDeAtaque(){
		if (this.equipamiento == null)
			return 5;
		return equipamiento.obtenerPuntosDeAtaque() + 5;
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