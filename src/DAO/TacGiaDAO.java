package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import BEAN.TacGia;;

public class TacGiaDAO {
	public static boolean validateUser(Connection conn,String username, String password) {
		String sql = "SELECT * \r\n" + 
				"FROM TacGia\r\n" + 
				"WHERE email = '"+username+"'";
		try 
		{
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			ResultSet rs = ptmt.executeQuery();
			
			if(rs.next()) {
			String pass = rs.getString("password");
			if(password.equals(pass)) {
				return true;
			}
			}
			
				
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		return false;
	}
}
