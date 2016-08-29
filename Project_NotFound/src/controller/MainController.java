package controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import bean.Board;
import bean.Reple;
import dao.BoarderDao;
import db.DB_inp;

/**
 * Servlet implementation class MainController
 */
@WebServlet("/MainController")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger(MainController.class);

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
		String action = request.getParameter("main_action");
		BoarderDao boarderDao = new BoarderDao();
		
		// �̷��� �����ص� �Ǵ°ǰ� ...
		if ("write".equals(action)) {
			Board board = new Board(request.getParameter("subject"), request.getParameter("id"),
					request.getParameter("contents").replaceAll("\r\n", "<br>"), request.getParameter("bookname"),
					request.getParameter("author"), request.getParameter("publisher"),
					request.getParameter("publication_date"), request.getParameter("book_img"),
					request.getParameter("description"));
			boarderDao.boarder_insert(board);
			response.sendRedirect("/NotFound/main.do");
		} else if ("detail".equals(action)) {
			// ���⼭�� ���� ������ �Խ��� ���� �ΰ��� �����ͼ� �ѷ��ִ� �۾��� ������Ѵ� ...
			String num = request.getParameter("num");
			List<Map<String, String>> list = boarderDao.boarder_detail(num);
			List<Map<String, String>> replelist = boarderDao.reple_selectAll(num);
			request.setAttribute("reple", replelist);
			request.setAttribute("board", list);
			Dispatcher(request, response, "/view/result.jsp");
		} else if ("reply".equals(action)) {
			String id = request.getParameter("id");
			String contents = request.getParameter("context").replaceAll("\r\n", "<br>");
			String num = request.getParameter("num");
			Reple reple = new Reple(Integer.parseInt(num), id, contents);
			boarderDao.Reple_insert(reple);
			Dispatcher(request, response, "/main.do?main_action=detail");
		} else if ("board_update".equals(action)) {
			Board board = new Board(request.getParameter("subject"), request.getParameter("id"),
					request.getParameter("contents"), request.getParameter("bookname"), request.getParameter("author"),
					request.getParameter("publisher"), request.getParameter("publication_date"),
					request.getParameter("book_img"), request.getParameter("description"));
			boarderDao.Board_Update(board, request.getParameter("num"));
			response.sendRedirect("/NotFound/main.do");
		} else if ("board_delete".equals(action)) {
			boarderDao.Board_Delete(request.getParameter("num"));
			boarderDao.Reple_Delete(request.getParameter("num"));
			response.sendRedirect("/NotFound/main.do");
		} else if ("search".equals(action)) {
			String keyword = request.getParameter("search_value");
			String key = request.getParameter("search_key");
			String current_page = request.getParameter("current_page");
			List<Map<String, String>> count_list = boarderDao.getBoardCount_search(keyword, key);
			int board_count = Integer.parseInt(count_list.get(0).get("size"));
			int current_pageInt = (current_page == null) ? 1 : Integer.parseInt(current_page);
			int page_count = (board_count != 0 && board_count % 10 == 0) ? (board_count / 10) : (board_count / 10) + 1;
			int first_page = ((current_pageInt - 1) * 10);
			List<Map<String, String>> list = boarderDao.boarder_SearchDB(keyword, key, first_page);
			request.setAttribute("page", current_pageInt);
			request.setAttribute("size", page_count);
			request.setAttribute("board", list);
			Dispatcher(request, response, "/view/main.jsp");
		} else {
			String current_page = request.getParameter("current_page");
			List<Map<String, String>> count_list = boarderDao.boarder_count();
			int board_count = Integer.parseInt(count_list.get(0).get("size"));
			// board count get
			int current_pageInt = (current_page == null) ? 1 : Integer.parseInt(current_page);
			// ����ڰ� ������ �������� �ٲ���
			int page_count = (board_count != 0 && board_count % 10 == 0) ? (board_count / 10) : (board_count / 10) + 1;
			// ���࿡ 10�� �� �������� ������ / 10 �̰� �ƴϸ� +1�� ���ٲ���
			int first_page = ((current_pageInt - 1) * 10);
			List<Map<String, String>> board_list = boarderDao.boarder_List(first_page);
			request.setAttribute("page", current_pageInt);
			request.setAttribute("size", page_count);
			request.setAttribute("board", board_list);
			Dispatcher(request, response, "/view/main.jsp");
		}

	}

	public void Dispatcher(HttpServletRequest request, HttpServletResponse response, String path)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
