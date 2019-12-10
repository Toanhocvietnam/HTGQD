package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BEAN.*;
import DAO.*;
import DB.DBConnection;
/**
 * Servlet implementation class GoiY
 */
@WebServlet("/GoiY")
public class GoiY extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoiY() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("View/GoiY.jsp");
		rd.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	    response.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=UTF-8");
	    
		String[] linhVucs = request.getParameterValues("LinhVuc");
		HttpSession session = request.getSession();
		String nguoiVietBai=(String)session.getAttribute("username");
		
		int maxSoBanBeChung = 0;
		int maxSoBaiVietChung=0;
		int maxSoBaiCungLinhVuc=0;
		float[] phuongAnLyTuongTot = {0,0,0};
		float[] phuongAnLyTuongXau = {1,1,1};
		Connection conn = DBConnection.CreateConnect();
		ArrayList<TacGia> tgList = TacGiaDAO.getUngCuVien(conn,nguoiVietBai);
		for( TacGia tg: tgList ) {
			tg.setSoBanBeChung(GoiYDAO.timSoBanBeChung(conn, nguoiVietBai, tg.getEmail()));
			tg.setSoBaiBaoVietChung(GoiYDAO.soBaiBaoVietChung(conn, nguoiVietBai, tg.getEmail()));
			int tongSoBaiBaoVeLinhVuc = GoiYDAO.soBaiBaoVeLinhVuc(conn, tg.getEmail(), linhVucs);
			tg.setSoBaiBaoVeLinhVuc(tongSoBaiBaoVeLinhVuc);
			if(tg.getSoBanBeChung()>maxSoBanBeChung) {
				maxSoBanBeChung = tg.getSoBanBeChung();
			}
			if(tg.getSoBaiBaoVietChung()>maxSoBaiVietChung) {
				maxSoBaiVietChung = tg.getSoBaiBaoVietChung();
			}
			if(tg.getSoBaiBaoVeLinhVuc() > maxSoBaiCungLinhVuc) {
				maxSoBaiCungLinhVuc =tg.getSoBaiBaoVeLinhVuc();
			}
		}
		for(TacGia tg:tgList) {
			tg.chuanHoa(maxSoBanBeChung, maxSoBaiVietChung, maxSoBaiCungLinhVuc);
			if(tg.getSoBanBeChungCH() > phuongAnLyTuongTot[0]) {
				phuongAnLyTuongTot[0] = tg.getSoBanBeChungCH();
			}
			if(tg.getSoBanBeChungCH() < phuongAnLyTuongXau[0]) {
				phuongAnLyTuongXau[0] = tg.getSoBanBeChungCH();
			}
			if(tg.getSoBaiBaoVietChungCH() > phuongAnLyTuongTot[1]) {
				phuongAnLyTuongTot[1] = tg.getSoBaiBaoVeLinhVucCH();
			}
			if(tg.getSoBaiBaoVietChungCH() < phuongAnLyTuongXau[1]) {
				phuongAnLyTuongXau[1] = tg.getSoBaiBaoVietChungCH();
			}
			if(tg.getSoBaiBaoVeLinhVucCH() > phuongAnLyTuongTot[2]) {
				phuongAnLyTuongTot[2] = tg.getSoBaiBaoVeLinhVucCH();
			}
			if(tg.getSoBaiBaoVeLinhVucCH() < phuongAnLyTuongXau[2]) {
				phuongAnLyTuongXau[2] = tg.getSoBaiBaoVeLinhVucCH();
			}
		}
		for(TacGia tg:tgList) {
			tg.tinhKcLyTuongTot(phuongAnLyTuongTot[0], phuongAnLyTuongTot[1],phuongAnLyTuongTot[2]);
			tg.tinhKcLyTuongXau(phuongAnLyTuongXau[0], phuongAnLyTuongXau[1],phuongAnLyTuongXau[2]);
			tg.tinhDoDoTuongTuGiaiPhapLT();
			
		}
		request.setAttribute("tgList", tgList);
		
		RequestDispatcher rd = request.getRequestDispatcher("View/KQGoiY.jsp");
		rd.forward(request,response);
		
	}

}
