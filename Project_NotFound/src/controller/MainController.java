package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import dao.BoarderDao;
import dao.DB_set;
import dao.UserDao;
import bean.Board;
import bean.Reple;

import java.util.*;

/**
 * Servlet implementation class MainController
 */
@WebServlet("/MainController")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MainController() {
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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("main_action");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		BoarderDao boarderDao;
		// �̷��� �����ص� �Ǵ°ǰ� ...
		if ("write".equals(action)) {
			DB_set dbset = new DB_set();
			Connection conn = dbset.dbinit(); // ��� Ŀ�ؼ� ����
			Board board = new Board(request.getParameter("subject"), request.getParameter("id"),
					request.getParameter("contents").replaceAll("\r\n","<br>"), request.getParameter("bookname"), request.getParameter("author"),
					request.getParameter("publisher"), request.getParameter("publication_date"),
					request.getParameter("book_img"), request.getParameter("description"));
			System.out.println(request.getParameter("contents"));
			boarderDao = new BoarderDao();
			boarderDao.boarder_insertDB(conn, board);
			dbset.disconn(conn);
			response.sendRedirect("/NotFound/main.do");
		}  else if ("detail".equals(action)) {
			// ���⼭�� ���� ������ �Խ��� ���� �ΰ��� �����ͼ� �ѷ��ִ� �۾��� ������Ѵ� ...
			String num = request.getParameter("num");
			DB_set dbset = new DB_set();
			Connection conn = dbset.dbinit(); // ��� Ŀ�ؼ� ����
			boarderDao = new BoarderDao();
			List list = boarderDao.boarder_detailDB(conn, num);
			List replelist = boarderDao.Reple_listDB(conn, num);
			dbset.disconn(conn);
			request.setAttribute("reple", replelist);
			request.setAttribute("board", list);
			RequestDispatcher rd = request.getRequestDispatcher("/view/result.jsp");
			rd.forward(request, response);
		} else if ("reply".equals(action)) {
			String id = request.getParameter("id");
			String contents = request.getParameter("context").replaceAll("\r\n","<br>");
			String num = request.getParameter("num");
			Reple reple = new Reple(Integer.parseInt(num), id, contents);
			// ���� �̿��ؼ� ������ �����Ҳ���
			// ���� �����带 dao�� ���� ���� ���� ���� ...
			boarderDao = new BoarderDao();
			DB_set dbset = new DB_set();
			Connection conn = dbset.dbinit(); // ��� Ŀ�ؼ� ����
			boarderDao.Reple_insertDB(conn, reple);
			dbset.disconn(conn);
			// �Ϸ� �Ǹ� �翬�� result �� ....?
			RequestDispatcher rd = request.getRequestDispatcher("/main.do?main_action=detail");
			rd.forward(request, response);
		} else if ("board_update".equals(action)) {
			boarderDao = new BoarderDao();
			DB_set dbset = new DB_set();
			Connection conn = dbset.dbinit(); // ��� Ŀ�ؼ� ����
			Board board = new Board(request.getParameter("subject"), request.getParameter("id"),
					request.getParameter("contents"), request.getParameter("bookname"), request.getParameter("author"),
					request.getParameter("publisher"), request.getParameter("publication_date"),
					request.getParameter("book_img"), request.getParameter("description"));
			boarderDao.boarder_updatDB(conn, board,request.getParameter("num"));
			dbset.disconn(conn);
			response.sendRedirect("/NotFound/main.do");
		} else if ("board_delete".equals(action)) {
			boarderDao = new BoarderDao();
			DB_set dbset = new DB_set();
			Connection conn = dbset.dbinit(); // ��� Ŀ�ؼ� ����
			boarderDao.boarder_deletDB(conn, request.getParameter("num"));
			dbset.disconn(conn);
			response.sendRedirect("/NotFound/main.do");
		} else if ("search".equals(action)) {
			boarderDao = new BoarderDao(); 
			String keyword = request.getParameter("search_value");
			String key = request.getParameter("search_key");
			DB_set dbset = new DB_set();
			Connection conn = dbset.dbinit(); // ��� Ŀ�ؼ� ����
			String current_page = request.getParameter("current_page"); 
			// ���� �������� �����ٰǰ� ?
			int board_count = boarderDao.getBoardCount_search(conn,keyword, key);
			// ��ü ������ �����Ӿ� 
			int current_pageInt = (current_page == null) ? 1 : Integer.parseInt(current_page);
			// ����ڰ� ������ �������� �ٲ��� 
			int page_count = (board_count%10==0&&board_count!=0)?(board_count / 10):(board_count / 10)+1;
			// ���࿡ 10�� �� �������� ������ / 10 �̰� �ƴϸ� +1�� ���ٲ���
			int first_page = ((current_pageInt - 1)  * 10);
			// ������ ��ȣ ? 1 ~ / 11 ~ �̷��� 
			int last_page = first_page+10;
			List list = boarderDao.boarder_SearchDB(conn, keyword, key,first_page,last_page);
			dbset.disconn(conn);
			request.setAttribute("page", current_pageInt);
			request.setAttribute("size", page_count);
			request.setAttribute("board", list);
			RequestDispatcher rd = request.getRequestDispatcher("/view/main.jsp");
			rd.forward(request, response);
			// �̰����� �����ָ� �ǳ� ..?
		} else {
			boarderDao = new BoarderDao();
			DB_set dbset = new DB_set();
			Connection conn = dbset.dbinit(); // ��� Ŀ�ؼ� ����
			String current_page = request.getParameter("current_page"); 
			// ���� �������� �����ٰǰ� ?
			int board_count = boarderDao.getBoardCount(conn);
			// ��ü ������ �����Ӿ� 
			int current_pageInt = (current_page == null) ? 1 : Integer.parseInt(current_page);
			// ����ڰ� ������ �������� �ٲ��� 
			int page_count = (board_count%10==0)?(board_count / 10):(board_count / 10)+1;
			// ���࿡ 10�� �� �������� ������ / 10 �̰� �ƴϸ� +1�� ���ٲ���
			int first_page = ((current_pageInt - 1)  * 10);
			// ������ ��ȣ ? 1 ~ / 11 ~ �̷��� 
			int last_page = first_page+10;
			// 10 20 30 ....
			List list = boarderDao.boarder_selectDB(conn,first_page,last_page);
			dbset.disconn(conn);
			request.setAttribute("page", current_pageInt);
			request.setAttribute("size", page_count);
			request.setAttribute("board", list);
			RequestDispatcher rd = request.getRequestDispatcher("/view/main.jsp");
			rd.forward(request, response);
			// ���Ⱑ action�� ������ ���ų� , �ǵ����� ���� ������ ���°� ..
		}

	}

}