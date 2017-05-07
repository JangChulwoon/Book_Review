package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import bean.Memo;
import dao.ClipDao;
import dao.MemoDao;

/**
 * Servlet implementation class MemoController
 */
public class MemoController extends HttpServlet {
	// Json 방식으로 값을 줌
	static Logger log = Logger.getLogger(MemoController.class);
	private static final long serialVersionUID = 1L;
    private static final MemoDao MEMODAO = new MemoDao();
    private static final ClipDao CLIPDAO = new ClipDao();
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
		int num;
		String id = (String)session.getAttribute("id");
		String action  = request.getParameter("action");
	
		// character set 설정 및 writer 초기화
		response.setCharacterEncoding("UTF-8");
	    response.setContentType("application/json");
	    PrintWriter out = response.getWriter();
		if("select".equals(action)){
			 num = Integer.parseInt(request.getParameter("num"));
			List<Map<String, String>> list = MEMODAO.selectList(id, num);
			
			JSONArray jsonArray = new JSONArray();
			for( Map<String, String> map : list ) {
				jsonArray.add( getJsonStringFromMap( map ) );
			}
		    log.info(jsonArray.toString());
		    out.write(jsonArray.toString());
		}else if("delete".equals(action)){
			int idx = Integer.parseInt(request.getParameter("index"));
			// clip 과 memo 부분을 삭제하는 로직
			if(CLIPDAO.delete(idx,id) && MEMODAO.delete(idx)){
				out.write("{ \"data\" : \"ok\" }");
			}else{
				out.write("{ \"data\" : \"false\" }");
			}
		}
		out.flush();
		out.close();
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		String action  = request.getParameter("action");
		String memo_text ;
		int idx;
		Memo memo = null;
		response.setCharacterEncoding("UTF-8");
	    response.setContentType("application/json");
	    
	    PrintWriter out = null;
	    if("insert".equals(action)){
			// insert 부분 작성해야함. 
	    	memo_text = request.getParameter("memo");
			idx = Integer.parseInt(request.getParameter("index"));
			memo = new Memo(idx, id, memo_text);
			out = response.getWriter();
			if(MEMODAO.insert(memo)){
				log.info("ok");
				out.write("{ \"data\" : \"ok\" }");
			}else{
				out.write("{ \"data\" : \"false\" }");
			}
		}
	    log.info("flush");
	    out.flush();
 		out.close();
	   
		
	    
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
