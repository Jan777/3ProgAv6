package personaje;

public class Enemigo2 extends Personaje {
	
	public Enemigo2() {
		this.salud=50;
		this.energia=50;
	}

	@Override
	public int obtenerPuntosDeAtaque() {
		return getFuerza() + obtenerPuntosDeAtaqueItem();
	}
	
	@Override
	public int obtenerPuntosDeDefensa() {
		return getDestreza() + obtenerPuntosDeDefensaItem();
	}
	
	@Override
	public int obtenerPuntosDeInteligencia() {
		return getInteligencia() + obtenerPuntosDeInteligenciaItem();
	}

}
