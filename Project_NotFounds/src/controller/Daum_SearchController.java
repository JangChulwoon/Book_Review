package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;

import api_daum.SearchApi;

/**
 * Servlet implementation class Daum_SearchController
 */
public class Daum_SearchController extends HttpServlet {
	static Logger logger = Logger.getLogger(Daum_SearchController.class);
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Daum_SearchController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String booksearch = request.getParameter("booksearch");
		SearchApi api = new SearchApi();
		JSONArray value = api.Search(booksearch);
		request.setAttribute("value", value);
		response.setCharacterEncoding("UTF-8");
	    response.setContentType("application/json");
	    
	    PrintWriter out = response.getWriter();
	    out.write(value.toString());
		logger.info(" :: "+value.toString());
		out.flush();
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
