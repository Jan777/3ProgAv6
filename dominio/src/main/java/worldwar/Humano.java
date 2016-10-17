package worldwar;

public class Humano extends Personaje {
	
	public Humano(Casta casta) {
		super(casta);
	}
	
	@Override
	protected int calcularPuntosDeAtaque() {
		return getFuerza();
	}
	
	@Override
	protected int calcularPuntosDeDefensa() {
		return getDestreza();
	}
	
	@Override
	protected int calcularPuntosDeInteligencia() {
		return getInteligencia();
	}
	
	@Override
	public int obtenerPuntosDeInteligencia() {
		return calcularPuntosDeInteligencia() + casta.getInteligencia();
	}
	
	@Override
	public int obtenerPuntosDeAtaque() {
		return calcularPuntosDeAtaque() + casta.getAtaque();
	}
	
	@Override
	public int obtenerPuntosDeDefensa() {
		return calcularPuntosDeDefensa() + casta.getDefensa();
	}

	@Override
	protected boolean puedeAtacar() {
		return energia >= 10;
	}

	@Override
	protected int calcularPuntosDeMagia() {
		return 0;
	}

	@Override
	public int obtenerPuntosDeMagia() {
		return 0;
	}

	@Override
	public int obtenerPuntosDeExperiencia() {
		return experiencia.getPuntoDeExperiencia();
	}

	@Override
	public int obtenerNivel() {
		return nivel.getNivel();
	}
	
	/*public void aplicarHechizoEn(String nombre, Personaje p){
		Iterator <String> it = m.keySet().iterator();
		
	}*/
	
	
		
	
}
