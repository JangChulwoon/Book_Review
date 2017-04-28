package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import dao.MemoDao;

/**
 * Servlet implementation class MemoController
 */
@WebServlet("/MemoController")
public class MemoController extends HttpServlet {
	// Json 방식으로 값을 줌
	static Logger logger = Logger.getLogger(MemoController.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		int num = Integer.parseInt(request.getParameter("num"));
		String id = (String)session.getAttribute("id");
		MemoDao dao = new MemoDao();
		List<Map<String, String>> list = dao.selectList(id, num);
		
		JSONArray jsonArray = new JSONArray();
		for( Map<String, String> map : list ) {
			jsonArray.add( getJsonStringFromMap( map ) );
		}
		
		request.setAttribute("value", jsonArray);
		response.setCharacterEncoding("UTF-8");
	    response.setContentType("application/json");
	    
	    PrintWriter out = response.getWriter();
	    out.write(jsonArray.toString());
		logger.info(" :: "+jsonArray.toString());
		out.flush();
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public static JSONObject getJsonStringFromMap( Map<String, String> map ) {

		JSONObject json = new JSONObject();
		for( Map.Entry<String, String> entry : map.entrySet() ) {
			String key = entry.getKey();
			Object value = entry.getValue();
			json.put(key, value);
		}
		
		return json;
	}
	
}
