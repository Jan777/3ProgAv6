package comunicacionServidor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DesloguearTEST {

	public static void main(String[] args) {
		PreparedStatement pstmt = null;
		
		try {
			pstmt = SQLConnection.getConnection().prepareStatement("Select * from Usuario Where isConnect='1'");
			ResultSet rs  = pstmt.executeQuery();
			
			while(rs.next()){
				PreparedStatement pstmt1 = SQLConnection.getConnection().prepareStatement("UPDATE Usuario SET isConnect = '0'");
				pstmt1.executeUpdate();
			}
		
		}catch (SQLException sqle1) {
			System.out.println(sqle1);
		}
	}
}
