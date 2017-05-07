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
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import bean.Clip;
import bean.Memo;
import dao.ClipDao;
import dao.MemoDao;
import db.DB_inp;

/**
 * Servlet implementation class MainController
 */
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
		
		HttpSession session = request.getSession();
		ClipDao dao = new ClipDao();
		String id = (String)session.getAttribute("id");
		List<Map<String, String>> list = dao.selectList(id);
		request.setAttribute("clip", list);
		logger.info(list.toString());
		Dispatcher(request, response, "/view/mainPage.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		ClipDao dao = new ClipDao();
		MemoDao memodao = new MemoDao();
		Clip clip  = null;
		Memo memo = null;
		int idx ;
		String id = (String)session.getAttribute("id");
		String action = request.getParameter("action");
		String memo_text;
		ClipDao boarderDao = new ClipDao();
		logger.info("login"+id);
		
		if ("record".equals(action)) {
			clip = new Clip(request.getParameter("book_title"),request.getParameter("state"));
			dao.insert(clip, id);
			response.sendRedirect("/NotFound/main.do");
		} else if ("memo".equals(action)) {
			memo_text = request.getParameter("memo");
			logger.info("idxs" +request.getParameter("index"));
			idx = Integer.parseInt(request.getParameter("index"));
			logger.info("idx :: "+ idx);
			memo = new Memo(idx, id, memo_text);
			memodao.insert(memo);
			response.sendRedirect("/NotFound/main.do");
		} else if ("board_update".equals(action)) {
			response.sendRedirect("/NotFound/main.do");
		}  else if ("search".equals(action)) {
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
			Dispatcher(request, response, "/view/mainPage.jsp");
		} else {
			List<Map<String, String>> list = dao.selectList(id);
	
			request.setAttribute("clip", list);
			Dispatcher(request, response, "/view/mainPage.jsp");
		}
	}

	public void Dispatcher(HttpServletRequest request, HttpServletResponse response, String path)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
