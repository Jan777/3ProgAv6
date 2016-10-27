/*package batalla;

import personaje.Atacable;
import personaje.Orco;
import personaje.Personaje;

public class BatallaDeOrcos extends Batalla {

	private int ultimoIndice = -1;
	
	@Override
	public void atacar(Batalla otro) {
		Atacable victima = otro.obtenerProximaVictima();
		for (Personaje atacante : batallon) {
			atacante.atacar(victima);
		}
	}

	public boolean agregar(Orco personaje) {
		return batallon.add(personaje);
	}
	
	@Override
	public Atacable obtenerProximaVictima() {
		depurarBatallon();
		if(batallon.isEmpty()) {
			throw new RuntimeException("El batallón está vacío");
		}
		this.ultimoIndice  = (this.ultimoIndice + 1) % this.batallon.size();
		return batallon.get(this.ultimoIndice);
	}

}
*/