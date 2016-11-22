package personaje;

public class Enemigo3 extends Personaje {

	public Enemigo3() {
		this.fuerza=2;
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
