package items;

public class ConArmadura extends Item {
	
	public ConArmadura () {
		super ();
	}
	
	public int obtenerPuntosDeAtaque(){
		if (this.equipamiento == null)
			return 8;
		return equipamiento.obtenerPuntosDeAtaque() + 8;
	}

}
