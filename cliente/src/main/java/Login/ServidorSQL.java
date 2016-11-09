package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.json.JSONObject;
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ServidorSQL extends JFrame {
	public ServidorSQL() {
	}
	
	private Connection conn;

		
	public void agregarUsuario(String mail, String nombre, String nickname, String password) throws JSONException {
		
		JSONObject obj = new JSONObject();
		obj.put("name", "registro");
		obj.put("email",  mail);
		obj.put("nombre", nombre);
		obj.put("nickname",  nickname);
		obj.put("password",  password);
		obj.put("isConect",  true);
		
		
		
		
		/*PreparedStatement pstmt = null;
		try {
			pstmt = SQLConnection.getConnection().prepareStatement("Insert into Usuario VALUES (?,?,?,?,?)");
			pstmt.setString(1, mail);
			pstmt.setString(2, nombre);
			pstmt.setString(3, nickname);
			pstmt.setString(4, password);
			pstmt.setBoolean(5, true);
			pstmt.execute();
		} catch (SQLException sqle) {
			System.err.println(sqle);
		}finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				System.err.println("Conexion SQL fallida");
			}
		}*/
	}
	
	
	public void validarUsuario(Usuario u) {
		PreparedStatement pstmt = null;
		try {
			pstmt = SQLConnection.getConnection().prepareStatement("Select password from Usuario Where nickname=?");
			pstmt.setString(1, u.getNickname());
			ResultSet rs  = pstmt.executeQuery();
			if(rs.next()){
				if(rs.getString("password").equals(u.getPassword())){
					//Login correcto
				}else
					contrasenaIncorrecta();				
			}
			else
				usuarioInexistente();
		} catch (SQLException sqle) {
			System.err.println(sqle);
		}finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				System.err.println("Conexion SQL fallida");
			}
		}
	}
	
	public void contrasenaIncorrecta() {
		JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "Error",
                JOptionPane.ERROR_MESSAGE);
	}
	
	public void usuarioInexistente() {
		JOptionPane.showMessageDialog(null, "Usuario inexistente", "Error",
                JOptionPane.ERROR_MESSAGE);
	}

	
}
