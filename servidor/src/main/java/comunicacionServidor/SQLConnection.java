package comunicacionServidor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class SQLConnection {
	private static Connection conn=null;
	
	public static Connection dbConnector(){
		try{
			Class.forName("org.sqlite.JDBC");
			Connection conn=DriverManager.getConnection("jdbc:sqlite:../servidor/WorldWar.db");
			//JOptionPane.showMessageDialog(null, "Conexion Correcta");
			return conn;
		}catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
	
	public static Connection getConnection() {
		try {
			if(conn == null) {	
				String driver="org.sqlite.JDBC";
				String url="jdbc:sqlite:../servidor/WorldWar.db";
				String pwd="Progra2016";
				String usr="sa";
				Class.forName(driver);
				conn = DriverManager.getConnection(url,usr,pwd);
			}
		} catch (ClassNotFoundException cnfe) {
			System.err.println("No se encuentra el Driver.");
		} catch (SQLException sqle) {
			System.err.println("Error al intentar la conexion.");
		}	
		return conn;
	}
	
}
	  