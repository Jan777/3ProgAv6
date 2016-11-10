package comunicacionServidor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class db {

	public static void main(String[] args) throws SQLException {
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		pstmt = SQLConnection.getConnection().prepareStatement("Select * from Usuario Where nickname= 'a'");
		ResultSet rs  = pstmt.executeQuery();
		System.out.println(rs.getString("isConnect"));
		pstmt1 = SQLConnection.getConnection().prepareStatement("Update Usuario SET isConnect = '0' WHERE nickname = 'a'");
		pstmt1.executeUpdate();
		
	}

}
