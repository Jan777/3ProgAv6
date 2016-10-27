/*package batalla;

import personaje.Atacable;
import personaje.Humano;
import personaje.Personaje;

public class BatallaDeHumanos extends Batalla {

	@Override
	public void atacar(Batalla otro) {
		Atacable victima = otro.obtenerProximaVictima();
		for (Personaje atacante : batallon) {
			atacante.atacar(victima);
		}
	}

	public boolean agregar(Humano personaje) {
		return batallon.add(personaje);
	}

	@Override
	public Atacable obtenerProximaVictima() {
		depurarBatallon();
		if(batallon.isEmpty()) {
			throw new RuntimeException("El batall�n est� vac�o");
		}
		return batallon.get(0);
	}
}
*/