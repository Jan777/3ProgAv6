package worldwar;

public class Humano extends Personaje {
	
	@Override
	protected int calcularPuntosDeAtaque() {
		return getFuerza();
	}
	
	@Override
	protected int calcularPuntosDeDefensa() {
		return getDestreza();
	}
	
	@Override
	public int obtenerPuntosDeInteligencia() {
		return getInteligencia();
	}
	
	@Override
	public int obtenerPuntosDeAtaque() {
		return calcularPuntosDeAtaque();
	}
	
	@Override
	public int obtenerPuntosDeDefensa() {
		return calcularPuntosDeDefensa();
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
	protected int calcularPuntosDeInteligencia() {
		return 0;
	}

	@Override
	public int obtenerPuntosDeMagia() {
		return 0;
	}

	
	/*public void aplicarHechizoEn(String nombre, Personaje p){
		Iterator <String> it = m.keySet().iterator();
		
	}*/
	
	
		
	
}
