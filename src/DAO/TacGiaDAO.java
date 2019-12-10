package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	public static ArrayList<TacGia> getUngCuVien(Connection conn, String user){
		String sql = "SELECT * \r\n" + 
				"FROM TacGia\r\n" + 
				"WHERE email != '"+user+"'";
		ArrayList<TacGia> tgList = new ArrayList<TacGia>();
		try 
		{
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			ResultSet rs = ptmt.executeQuery();
			
			while(rs.next()){
				String email = rs.getString("email");
				TacGia tg = new TacGia(email);
				tgList.add(tg);
			}
			
				
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		return tgList;
	}
}
