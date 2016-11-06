package personaje;

import casta.Casta;

public class Orco extends Personaje {

	int cantidadDeAtaques;	
	
	public Orco(Casta casta) {
		super(casta);
	}
	
	@Override
	public int obtenerPuntosDeAtaque() {
		return getFuerza() + casta.getAtaque() + obtenerPuntosDeAtaqueItem() + cantidadDeAtaques;
	}
	
	@Override
	public int obtenerPuntosDeDefensa() {
		return getDestreza() +  casta.getDefensa() + obtenerPuntosDeDefensaItem();
	}
	
	@Override
	public int obtenerPuntosDeInteligencia() {
		return getInteligencia() + casta.getInteligencia() + obtenerPuntosDeInteligenciaItem();
	}
	
	@Override
	protected void despuesDeAtacar() {
		cantidadDeAtaques++;
	}

}
