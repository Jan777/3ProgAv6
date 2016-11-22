package items;

public class ConEscudoDeMadera extends Item {
	
	public ConEscudoDeMadera(){
		this.prioridad = 1;
	}

	public int obtenerPuntosDeAtaque(){
		if (this.equipamiento == null)
			return 0;
		return equipamiento.obtenerPuntosDeAtaque() + 0;
	}
	
	public int obtenerPuntosDeDefensa(){
		if (this.equipamiento == null)
			return 5;
		return equipamiento.obtenerPuntosDeDefensa() + 5;
	}
	
	public int obtenerPuntosDeInteligencia(){
		if (this.equipamiento == null)
			return 0;
		return equipamiento.obtenerPuntosDeInteligencia() + 0;
	}

}