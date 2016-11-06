package servidor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ServidorSQL extends JFrame {
	public ServidorSQL() {
	}
	
	private Connection conn;

		
	public void agregarUsuario(String mail, String nombre, String nickname, String password) {
		PreparedStatement pstmt = null;
		try {
			pstmt = SQLConnection.getConnection().prepareStatement("Insert into Usuario VALUES (?,?,?,?,?)");
			pstmt.setString(1, mail);
			pstmt.setString(2, nombre);
			pstmt.setString(3, nickname);
			pstmt.setString(4, password);
			pstmt.setString(5, "true");
			pstmt.execute();
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
