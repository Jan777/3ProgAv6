package login;

public class Pers {
	private String nombrepers;
	private String casta;
	private String personaje;
	
	public String getNombrepers() {
		return nombrepers;
	}
	public void setNombrepers(String nombrepers) {
		this.nombrepers = nombrepers;
	}
	public String getCasta() {
		return casta;
	}
	public void setCasta(String casta) {
		this.casta = casta;
	}
	public String getPersonaje() {
		return personaje;
	}
	public void setPersonaje(String personaje) {
		this.personaje = personaje;
	}
	
	public Pers(String nombrepers)
	{
		this.nombrepers = nombrepers;
		this.casta=null;
		this.personaje=null;
		
	}
	
}
