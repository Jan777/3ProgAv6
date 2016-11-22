package items;

public class ConEscudoDeKevlar extends Item {

	public ConEscudoDeKevlar(){
		this.prioridad = 2;
	}
	
	public int obtenerPuntosDeAtaque() {
		if (this.equipamiento == null)
			return 0;
		return equipamiento.obtenerPuntosDeAtaque() + 0;
	}

	public int obtenerPuntosDeDefensa() {
		if (this.equipamiento == null)
			return 10;
		return equipamiento.obtenerPuntosDeDefensa() + 10;
	}

	public int obtenerPuntosDeInteligencia() {
		if (this.equipamiento == null)
			return 0;
		return equipamiento.obtenerPuntosDeInteligencia() + 0;
	}
}
