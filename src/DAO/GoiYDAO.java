package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import BEAN.*;

public class GoiYDAO {
	public static int timSoBanBeChung (Connection conn, TacGia tg1, TacGia tg2) {
		
		String sql ="select count(TGID) as Ban_be_chung\r\n" + 
				"		from \r\n" + 
				"		(select TGID\r\n" + 
				"		from	TACGIA_BAIBAO as TG_BB1, (select BBID\r\n" + 
				"				from TACGIA_BAIBAO\r\n" + 
				"				where TGID = '"+tg1.getId()+"') as TG_BB2\r\n" + 
				"		where	TG_BB1.BBID = TG_BB2.BBID\r\n" + 
				"			and TGID !='"+tg1.getId()+"'\r\n" + 
				"\r\n" + 
				"		intersect \r\n" + 
				"\r\n" + 
				"		select TGID\r\n" + 
				"		from	TACGIA_BAIBAO as TG_BB1, (select BBID\r\n" + 
				"				from TACGIA_BAIBAO\r\n" + 
				"				where TGID = '"+tg1.getId()+"') as TG_BB2\r\n" + 
				"		where	TG_BB1.BBID = TG_BB2.BBID\r\n" + 
				"			and TGID != '"+tg2.getId()+"'\r\n" + 
				"		) as cc";
		int soBanBeChung = 0;
		try 
		{
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			ResultSet rs = ptmt.executeQuery();
			
			if(rs.next()) {
			soBanBeChung = rs.getInt("Ban_be_chung");
			}
				
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
			
		
		return soBanBeChung;
	}
	
	public static int soBaiBaoVietChung(Connection conn, TacGia tg1, TacGia tg2) {
		String sql = "select count(TG_BB1.BBID) as Bai_bao_chung\r\n" + 
				"from TACGIA_BAIBAO as TG_BB1,(select BBID\r\n" + 
				"								from TACGIA_BAIBAO\r\n" + 
				"								where TGID = '"+tg1.getId()+"') as TG_BB2\r\n" + 
				"where TG_BB1.BBID = TG_BB2.BBID\r\n" + 
				"	and TGID = '"+tg2.getId()+"'";
		int soBaiBaoVietChung = 0;
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			if(rs.next()) {
				soBaiBaoVietChung = rs.getInt("Bai_bao_chung");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return soBaiBaoVietChung;
	}
}
