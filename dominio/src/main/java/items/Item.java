package items;

public abstract class Item {

	public Item equipamiento;
	private int fuerza = 0;
	private int defensa = 0;
	private int inteligencia = 0;
	int prioridad = 0;

	public Item() {
		this.equipamiento = null;
	}
	
	public int getPrioridad(){
		return this.prioridad;
	}

	public int obtenerPuntosDeAtaque() {
		return this.equipamiento.obtenerPuntosDeAtaque();
	}

	public int obtenerPuntosDeDefensa() {
		return this.equipamiento.obtenerPuntosDeDefensa();
	}

	public int obtenerPuntosDeInteligencia() {
		return this.equipamiento.obtenerPuntosDeInteligencia();
	}

	public void agregarItem(Item i) {
		if (this.equipamiento == null)
			this.equipamiento = i;
		else {
			this.equipamiento.agregarItem(i);
		}
	}

	public boolean tiene (Class decorado) {
		return this.getClass() == decorado?true:(this.equipamiento == null?false:this.equipamiento.tiene(decorado));
	}

	public void desequiparPorClase(Class decorado, Item itemLlamador) {
		if (this.getClass() == decorado) { 
			itemLlamador.equipamiento = this.equipamiento;
		} else {
			this.equipamiento.desequiparPorClase(decorado, this);
		}
	}
	
	public int buscarMayorPrioridad(int mejor) {
		if(this.equipamiento == null){
			if(this.prioridad > mejor)
				return this.prioridad;
			return mejor;
		}else{
			if(this.prioridad > mejor)
				return this.equipamiento.buscarMayorPrioridad(this.prioridad);
			return this.equipamiento.buscarMayorPrioridad(mejor);
		}
	}
	
	public Class desequiparPorPrioridad(int decorado, Item itemLlamador) {
		if (this.getPrioridad() == decorado) { 
			itemLlamador.equipamiento = this.equipamiento;
			return this.getClass();
		} else {
			return this.equipamiento.desequiparPorPrioridad(decorado, this);
		}
	}

}
