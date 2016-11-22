package alianza;

import java.util.LinkedList;

import personaje.Personaje;

public class Alianza {
	
	LinkedList <Personaje> aliados= new LinkedList<Personaje>();
	
	public void agregarAliado( Personaje p) {
		this.aliados.add(p);
	}
	
	public LinkedList<Personaje> getAliados() {
		return aliados;
	}

	public void setAliados(LinkedList<Personaje> aliados) {
		this.aliados = aliados;
	}

	public void removerAliado(Personaje p){
		this.aliados.remove(p);
	}
	
	public int getTamanio(){
		return aliados == null?0:this.aliados.size();
	}
	
}