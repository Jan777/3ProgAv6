package xp;

public class XP {

	private int experiencia = 0;
	private int nivel = 0;
	private int puntosGanados = 0;
	
	public void aumentarExperiencia(){
		this.experiencia+=1;
		controlarExperiencia();
	}
	
	public int getPuntoDeExperiencia(){
		return this.experiencia;
	}
	
	public void controlarExperiencia(){
		if(this.experiencia >= 100){
			aumentarNivel();
			incrementarPuntosGanados();
			resetearExperiencia();
		}
	}
	
	public void resetearExperiencia(){
		this.experiencia -= 100;
	}
	
	public void incrementarPuntosGanados(){
		this.puntosGanados += (this.nivel + 3);
	}
	
	public void decrementarPuntosGanados(){
		this.puntosGanados--;
	}
	
	public void puntosHabilidades(){
		
	}
	
	private void aumentarNivel(){
		this.nivel++;
	}
	
	public int getNivel(){
		return this.nivel;
	}
	
	public int getPuntosGanados(){
		return this.puntosGanados;
	}

	public void aumentarExperiencia(int i) {
		this.experiencia += i;
	}
	
}
