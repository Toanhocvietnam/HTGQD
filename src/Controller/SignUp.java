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

import DAO.TacGiaDAO;
import DB.DBConnection;;

@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SignUp() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("View/Login.jsp");
		rd.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String hoten = request.getParameter("hoten");
		String sdt =  request.getParameter("sdt");
		
		Connection conn = DBConnection.CreateConnect();
	
		boolean isValid = TacGiaDAO.kiemTraDangKi(conn, email);
		if(isValid) {
			TacGiaDAO.insertTacGia(conn,hoten, sdt, email, password);
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("email", email);
			RequestDispatcher rd = request.getRequestDispatcher("View/Home.jsp");
			rd.forward(request,response);
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("View/Login.jsp");
			rd.forward(request,response);
		}
		
	}

}
