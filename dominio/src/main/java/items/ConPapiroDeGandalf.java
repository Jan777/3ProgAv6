package items;

public class ConPapiroDeGandalf extends Item {
	
	public ConPapiroDeGandalf(){
		this.prioridad = 3;
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
			return 20;
		return equipamiento.obtenerPuntosDeInteligencia() + 20 ;
	}
	
}