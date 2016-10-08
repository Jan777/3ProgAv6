package worldwar;

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
			throw new RuntimeException("El batallón está vacío");
		}
		return batallon.get(0);
	}
}
