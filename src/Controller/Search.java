package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.TacGiaDAO;
import DB.DBConnection;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String keyword = request.getParameter("search");
		keyword = keyword.trim();
		Connection conn = DBConnection.CreateConnect();
		ArrayList<String> searchResult = TacGiaDAO.getTacGiaByKeyword(conn, keyword);

		request.setAttribute("searchResult", searchResult);
		RequestDispatcher rd = request.getRequestDispatcher("View/SearchResult.jsp");
		rd.forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String email = request.getParameter("email");
		System.out.println("123");
		System.out.println(email);
		HttpSession httpSession = request.getSession();
		if(httpSession.getAttribute("emails") == null) {
			ArrayList<String> emails = new ArrayList<String>();
			emails.add(email);
			httpSession.setAttribute("emails",emails);
		}
		else {
			ArrayList<String> emails = (ArrayList<String>)httpSession.getAttribute("emails");
			emails.add(email);
			httpSession.setAttribute("emails",emails);
			
		}
		RequestDispatcher rd = request.getRequestDispatcher("View/Added.jsp");
		rd.forward(request, response);
	}

}
