package comunicacionServidor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

import org.json.JSONException;
import org.json.JSONObject;

public class ConsultasSQL extends JFrame {
	
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
			pstmt.setString(1, mail);
			pstmt.setString(2, nombre);
			pstmt.setString(3, nickname);
			pstmt.setString(4, password);
			pstmt.setInt(5, 0);
			pstmt.execute();
			AtencionAlCliente at=new AtencionAlCliente(socket); 
			at.enviarRespuestaRegistro(socket);
		} catch (SQLException e1) {
			AtencionAlCliente at=new AtencionAlCliente(socket); 
			at.enviarRespuestaRegistroError(socket);
		}finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				System.err.println("Conexion SQL fallida");
			}
		}
	}
	
	public void validarUsuario(JSONObject json, Socket socket) throws JSONException {
		String password = json.getString("password");
		String nickname = json.getString("nickname");
		PreparedStatement pstmt = null;
		try {
			pstmt = SQLConnection.getConnection().prepareStatement("Select * from Usuario Where nickname=?");
			pstmt.setString(1, nickname);
			ResultSet rs  = pstmt.executeQuery();
			System.out.println();
			if(rs.next()){
				if(rs.getString("password").equals(password)){
					if(rs.getInt("isConnect") == 0){
						PreparedStatement pstmt1 = SQLConnection.getConnection().prepareStatement("UPDATE Usuario SET isConnect = '1' WHERE nickname = ?");
						pstmt1.setString(1, nickname);
						pstmt1.executeUpdate();
						AtencionAlCliente at=new AtencionAlCliente(socket); 
						at.enviarRespuestaCorrecto(socket, rs.getString("nickname"));
					}else {
						AtencionAlCliente at=new AtencionAlCliente(socket); 
						at.enviarRespuestaLogueado(socket);
					}
				}else {
					AtencionAlCliente at=new AtencionAlCliente(socket); 
					at.enviarRespuestaLoginIncorrecta(socket);
				}
			}
		
		}catch (SQLException sqle1) {
			AtencionAlCliente at=new AtencionAlCliente(socket); 
			at.enviarRespuestaLoginIncorrecta(socket);
		}finally {
			try {
				pstmt.close();
				AtencionAlCliente at=new AtencionAlCliente(socket); 
				at.enviarRespuestaLoginIncorrecta(socket);
			} catch (SQLException e) {
				System.err.println("Conexion SQL fallida");
			}
		}
	}
	
	public void crearPersonaje(JSONObject json, Socket clienteSocket) throws JSONException{
		String nickname = json.getString("nickname");
		String casta = json.getString("casta");
		String tipoPers = json.getString("tipopers");
		String nombre = json.getString("nombre");
		//crear usuario y grabarlo en la base de datos
	
		
	}
		
}
