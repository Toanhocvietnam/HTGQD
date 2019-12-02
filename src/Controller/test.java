package Controller;
import java.sql.Connection;
import BEAN.*;
import DAO.*;
import DB.DBConnection;
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = DBConnection.CreateConnect();
		String name1 ="TG01";
		String name2="TG02";
		TacGia tg1 = new TacGia(name1);
		TacGia tg2 = new TacGia(name2);
		int count =GoiYDAO.timSoBanBeChung(conn, tg1, tg2);
		System.out.println(count);
		System.out.println(GoiYDAO.soBaiBaoVietChung(conn, tg1, tg2));
	}

}
