package personaje;

public class Enemigo1 extends Personaje {
	
	public Enemigo1 () {
		this.salud=20;
		this.energia=20;
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
