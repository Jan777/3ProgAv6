package personaje;

import casta.Casta;

public class Humano extends Personaje {
	
	public Humano(Casta casta) {
		super(casta);
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
