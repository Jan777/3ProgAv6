package login;

public class Usuario {
	private String mail;
	private String nombre;
	private String nickname;
	private String password;
	
	
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public Usuario(String nickname)
	{
		this.mail=null;
		this.nombre=null;
		this.nickname=nickname;
		this.password=null;
	}
	
	public Usuario(String mail, String nombre, String apodo, String password)
	{
		this.mail=mail;
		this.nombre=nombre;
		this.nickname=apodo;
		this.password=password;
	}
	
}
