package juego;

public class TileLimite extends Tile {
	
	public TileLimite(int id) {
		super(Recursos.limite, id);
	}
	
	@Override
	public boolean esSolido() {
		return true;
	}
}