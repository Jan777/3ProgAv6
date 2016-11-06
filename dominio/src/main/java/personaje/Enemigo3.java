package personaje;

public class Enemigo3 extends Personaje {

	public Enemigo3() {
		this.fuerza=2;
	}

	@Override
	public int obtenerPuntosDeAtaque() {
		return getFuerza() + casta.getAtaque() + obtenerPuntosDeAtaqueItem();
	}
	
	@Override
	public int obtenerPuntosDeDefensa() {
		return getDestreza() +  casta.getDefensa() + obtenerPuntosDeDefensaItem();
	}
	
	@Override
	public int obtenerPuntosDeInteligencia() {
		return getInteligencia() + casta.getInteligencia() + obtenerPuntosDeInteligenciaItem();
	}
	
}
