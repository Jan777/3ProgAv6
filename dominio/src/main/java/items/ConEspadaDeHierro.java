package items;

public class ConEspadaDeHierro extends Item {
	
	public ConEspadaDeHierro (){
		this.prioridad = 2;
	}
	public int obtenerPuntosDeAtaque(){
		if (this.equipamiento == null)
			return 10;
		return equipamiento.obtenerPuntosDeAtaque() + 10;
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