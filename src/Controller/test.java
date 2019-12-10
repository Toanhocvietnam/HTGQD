package Controller;
import java.sql.Connection;
import BEAN.*;
import DAO.*;
import DB.DBConnection;
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double kcLyTuongXau = 0.0609;
		double kcLyTuongTot = 0.0463;
		float z = (float)4/9;
		double y=(double)Math.round((kcLyTuongXau/(kcLyTuongTot+kcLyTuongXau))*1000)/1000;
		System.out.println(y);
		
	}

}
