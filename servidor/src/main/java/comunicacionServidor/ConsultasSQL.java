package comunicacionServidor;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.net.Socket;

import org.json.JSONException;
import org.json.JSONObject;

import personaje.CrearPersonajes;
import personaje.Personaje;


public class ConsultasSQL extends JFrame {
	private Personaje personaje = null;
	private CrearPersonajes crear;
	private Socket socket;
	
	public ConsultasSQL() {
				
	}
	
	private Connection conn;
	
		
	public void grabarRegistro(JSONObject json, Socket socket) throws JSONException {
		
		String mail = json.getString("email");
		String password = json.getString("password");
		String nickname = json.getString("nickname");
		String nombre = json.getString("nombre");
		PreparedStatement pstmt = null;
		try {
			pstmt = SQLConnection.getConnection().prepareStatement("Insert into Usuario VALUES (?,?,?,?,?)");
			pstmt.setString(1, nickname);
			pstmt.setString(2, nombre);
			pstmt.setString(3, mail);
			pstmt.setString(4, password);
			pstmt.setInt(5, 0);
			pstmt.execute();
			pstmt.close();
			AtencionAlCliente at=new AtencionAlCliente(socket); 
			at.enviarRespuestaRegistro(socket, nickname);
		} catch (SQLException e1) {
			AtencionAlCliente at=new AtencionAlCliente(socket); 
			at.enviarRespuestaRegistroError(socket, nickname);
		}
	}
	
	public int validarUsuario(JSONObject json, Socket socket) throws JSONException {
		String password = json.getString("password");
		String nickname = json.getString("nickname");
		PreparedStatement pstmt = null;
		try {
			pstmt = SQLConnection.getConnection().prepareStatement("Select * from Usuario Where nickname=?");
			pstmt.setString(1, nickname);
			ResultSet rs  = pstmt.executeQuery();
			if(rs.next()){
				if(rs.getString("password").equals(password)){
					if(rs.getInt("isConnect") == 0){
						PreparedStatement pstmt1 = SQLConnection.getConnection().prepareStatement("UPDATE Usuario SET isConnect = '1' WHERE nickname = ?");
						pstmt1.setString(1, nickname);
						pstmt1.executeUpdate();
						return 1;
						//AtencionAlCliente at=new AtencionAlCliente(socket); 
						//at.enviarRespuestaCorrecto(socket, rs.getString("nickname"));
					}else {
						//AtencionAlCliente at=new AtencionAlCliente(socket); 
						//at.enviarRespuestaLogueado(socket, rs.getString("nickname"));
						return 0;
					}
				}else {
					//AtencionAlCliente at=new AtencionAlCliente(socket); 
					//at.enviarRespuestaLoginIncorrecta(socket, nickname);
					return -1;
				}
			}
			return 2;
		
		}catch (SQLException sqle1) {
			//AtencionAlCliente at=new AtencionAlCliente(socket); 
			//at.enviarRespuestaLoginIncorrecta(socket, nickname);
			return -1;
		}finally {
			try {
				pstmt.close();
				//AtencionAlCliente at=new AtencionAlCliente(socket); 
				//at.enviarRespuestaLoginIncorrecta(socket, nickname);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Fall� la conexi�n con la bases de datos.");
			}
		}
	}
	
	public int crearPers(JSONObject json, Socket clienteSocket) throws JSONException, SQLException{
		String nickname = json.getString("nickname");
		String casta = json.getString("casta");
		String tipoPers = json.getString("tipopers");
		String nombre = json.getString("nombre");
		CrearPersonajes crear = new CrearPersonajes();
		personaje=crear.crearPersonajes(casta, tipoPers);
		int energia = personaje.getEnergia();
		int idPersonaje = personaje.getIdPersonaje();
		int salud = personaje.getSalud();
		int fuerza = personaje.getFuerza();
		int destreza = personaje.getDestreza();
		int inteligencia = personaje.getInteligencia();
		int nivel=personaje.getExperiencia().getNivel();
		int experiencia=personaje.getExperiencia().getPuntoDeExperiencia();
		
		PreparedStatement pstmt = null;
		try {
			pstmt = SQLConnection.getConnection().prepareStatement("Insert into Personaje VALUES (?,?,?,?,?,?,?,?,?,?,?)");		
			pstmt.setString(1, nickname);
			pstmt.setString(2, nombre);
			pstmt.setInt(3, energia);
			pstmt.setInt(4, salud);
			pstmt.setInt(5, fuerza);
			pstmt.setInt(6, destreza);
			pstmt.setInt(7, inteligencia);
			pstmt.setInt(8, nivel);
			pstmt.setInt(9, experiencia);
			pstmt.setString(10, casta);
			pstmt.setString(11, tipoPers);
			//System.out.println("Llegue hasta aca 1");
			pstmt.execute();
			pstmt.close();
			//System.out.println("Llegue hasta aca 2");
			return 3;
		} catch (SQLException e) {
			return 4;
			//JOptionPane.showMessageDialog(null, "Ocurrio un error al crear el personaje.");
		}
	}
	public void cerrarSesion (JSONObject json, Socket clienteSocket) throws JSONException{
		String nickname = json.getString("nickname");
		try {
			PreparedStatement pstmt2 = SQLConnection.getConnection().prepareStatement("UPDATE Usuario SET isConnect = '0' WHERE nickname = ?");
			pstmt2.setString(1, nickname);
			pstmt2.executeUpdate();
		}catch (SQLException sqle1) {
			
		}
	}
	
	public String raza (String nickname){
		PreparedStatement pstmt = null;
		try {
			pstmt = SQLConnection.getConnection().prepareStatement("Select * from Personaje Where nickname=?");
			pstmt.setString(1, nickname);
			ResultSet rs  = pstmt.executeQuery();
			return rs.getString("raza");
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return "sinPersonaje";
		}		
	}
}
