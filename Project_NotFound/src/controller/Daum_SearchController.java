package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import api_daum.SearchApi;

/**
 * Servlet implementation class Daum_SearchController
 */
@WebServlet("/Daum_SearchController")
public class Daum_SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Daum_SearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String booksearch =request.getParameter("booksearch");
		String value[][] = new String[6][6]; 
		SearchApi api = new SearchApi();
		value = api.Search(value, booksearch);
		request.setAttribute("value", value);
		if(value!=null){
			RequestDispatcher rd = request.getRequestDispatcher("/view/check/bookresult.jsp");
			rd.forward(request, response);
		}else{
			System.out.println("�߸��� ���� �̰ų� , �˻�� �߷� x ");
		}
	}

}