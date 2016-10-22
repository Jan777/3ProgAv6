package xp;

public class XP {

	private int experiencia = 0;
	private int nivel = 0;
	
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
			resetearExperiencia();
		}
	}
	
	public void resetearExperiencia(){
		this.experiencia -= 100;
	}
	
	public void puntosHabilidades(){
		
	}
	
	private void aumentarNivel(){
		this.nivel++;
	}
	
	public int getNivel(){
		return this.nivel;
	}
	
	
}
