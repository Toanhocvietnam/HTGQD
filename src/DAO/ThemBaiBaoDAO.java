package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ThemBaiBaoDAO {

	public static boolean themBaiBao(Connection conn,String BBID,String TenBB, String NoiDung) {
		String sql = "insert into BAIBAO values ('"+BBID+"',N'"+TenBB+"',N'"+NoiDung+"')";
		try 
		{			
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			return true;
		
		} 
		catch (SQLException e) 
		{	
			e.printStackTrace();
		}
		return false;
	}
	
	public static String layBBID(Connection conn) {
		String sql = "select top 1 * from BAIBAO order by BBID desc";
		try 
		{
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			ResultSet rs = ptmt.executeQuery();
			
			if(rs.next()){
				String BBID = rs.getString("BBID");
				return BBID;
			}
		
		} 
		catch (SQLException e) 
		{	
			e.printStackTrace();
		}
		return "BB70";
	}
}
