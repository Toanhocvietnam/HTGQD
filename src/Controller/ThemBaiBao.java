package Controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ThemBaiBaoDAO;
import DB.DBConnection;;

@WebServlet("/ThemBaiBao")
public class ThemBaiBao extends HttpServlet {
	private static final long serialVersionUID = 2L;
       
    public ThemBaiBao() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("View/ThemBaiBao.jsp");
		rd.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String[] linhVucs = request.getParameterValues("LinhVuc");	
		String TenBB = request.getParameter("TenBB");
		String NoiDung = request.getParameter("NoiDung");
		
		//String tg1 = request.getParameter("tg1");
		//String tg2 = request.getParameter("tg2");
		//String tg3 = request.getParameter("tg3");
		//String tg4= request.getParameter("tg4");
		
		HttpSession session = request.getSession();
		String nguoiVietBai=(String)session.getAttribute("email");
		
		Connection conn = DBConnection.CreateConnect();
		String BBID = ThemBaiBaoDAO.layBBID(conn);
		char[] a = BBID.toCharArray();
		if(a[3]=='9') {a[2]++; a[3]='0';}
		else a[3]++;
		BBID = new String(a);
		
		ThemBaiBaoDAO.themBaiBao(conn, BBID, TenBB, NoiDung);
		//ThemBaiBaoDAO.themBaiBao_LinhVuc(conn,BBID, LVID);
		RequestDispatcher rd = request.getRequestDispatcher("View/ThemBaiBao.jsp");
		rd.forward(request,response);
	}

}
