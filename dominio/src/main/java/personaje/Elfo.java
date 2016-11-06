package personaje;

import casta.Casta;

public class Elfo extends Personaje {
	
	int ataquesRecibidos;
	
	public Elfo(Casta casta) {
		super(casta);
	}
	
	@Override
	public int obtenerPuntosDeAtaque() {
		return getFuerza() + casta.getAtaque() + obtenerPuntosDeAtaqueItem() + ataquesRecibidos;
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
		salud++;
	}
	
	@Override
	public void serAtacado(int danio) {
		super.serAtacado(danio);
		this.ataquesRecibidos++;
	}
	
}
