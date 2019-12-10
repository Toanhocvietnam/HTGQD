package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import BEAN.*;

public class GoiYDAO {
	public static int timSoBanBeChung (Connection conn, String tg1, String tg2) {
		
		String sql ="select count(email) as Ban_be_chung\r\n" + 
				"		from \r\n" + 
				"		(select email\r\n" + 
				"		from	TACGIA_BAIBAO as TG_BB1, (select BBID\r\n" + 
				"				from TACGIA_BAIBAO\r\n" + 
				"				where email = '"+tg1+"') as TG_BB2\r\n" + 
				"		where	TG_BB1.BBID = TG_BB2.BBID\r\n" + 
				"			and email !='"+tg1+"'\r\n" + 
				"\r\n" + 
				"		intersect \r\n" + 
				"\r\n" + 
				"		select email\r\n" + 
				"		from	TACGIA_BAIBAO as TG_BB1, (select BBID\r\n" + 
				"				from TACGIA_BAIBAO\r\n" + 
				"				where email = '"+tg2+"') as TG_BB2\r\n" + 
				"		where	TG_BB1.BBID = TG_BB2.BBID\r\n" + 
				"			and email != '"+tg2+"'\r\n" + 
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
	
	public static int soBaiBaoVietChung(Connection conn, String tg1, String tg2) {
		String sql = "select count(TG_BB1.BBID) as Bai_bao_chung\r\n" + 
				"from TACGIA_BAIBAO as TG_BB1,(select BBID\r\n" + 
				"								from TACGIA_BAIBAO\r\n" + 
				"								where email = '"+tg1+"') as TG_BB2\r\n" + 
				"where TG_BB1.BBID = TG_BB2.BBID\r\n" + 
				"	and email = '"+tg2+"'";
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
	public static int soBaiBaoVeLinhVuc(Connection conn, String tg,String[] linhVuc) {
		String linhVucs = "";
		for(int i=0;i<linhVuc.length-1;i++) {
			linhVucs =linhVucs+"N'"+ linhVuc[i]+ "',";
		}
		linhVucs += "N'"+linhVuc[linhVuc.length-1] + "'";
		String sql = "SELECT COUNT(TACGIA_BAIBAO.BBID) as soBaiBaoVeLinhVuc\r\n" + 
				"FROM TACGIA, TACGIA_BAIBAO, BAIBAO_LINHVUC,LINHVUC\r\n" + 
				"WHERE TACGIA.email = TACGIA_BAIBAO.email\r\n" + 
				"AND TACGIA_BAIBAO.BBID = BAIBAO_LINHVUC.BBID\r\n" + 
				"AND BAIBAO_LINHVUC.LVID = LINHVUC.LVID\r\n" + 
				"AND TACGIA_BAIBAO.email ='"+tg+"'\r\n" + 
				"AND TenLv In ("+linhVucs+")";
		int soBaiBaoVeLinhVuc = 0;
		System.out.println(sql);
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			if(rs.next()) {
				soBaiBaoVeLinhVuc = rs.getInt("soBaiBaoVeLinhVuc");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return soBaiBaoVeLinhVuc;
	}
}
