package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import bean.User;
import dao.DB_set;
import dao.UserDao;

/**
 * Servlet implementation class IndexController
 */
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexController() {
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
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		UserDao userdao = new UserDao();
		PrintWriter out = response.getWriter(); 
		if(action==null||action.length()==0){
			//���⼭ �ڷ� ���°� �ƴ϶� ������������ ���� ���� �������� ������ ..
				out.println("<script>");
				out.println("alert('what ? nope!');");
				out.println("history.back();");
				out.println("</script>");
			
		}else if(action.equals("join")){
			// ���̵� �ߺ�üũ�� ���߿�
			String id = request.getParameter("joinid");
			String pass = request.getParameter("joinpass");
			String name = request.getParameter("joinname");
			System.out.println(name);
			User user = new User(id,pass,name);
			DB_set dbset = new DB_set();
			Connection conn = dbset.dbinit(); // ���  Ŀ�ؼ� ���� 
			userdao.insertDB(conn,user);
			session.setAttribute("logincheck", "login");
			session.setAttribute("name",name);
			session.setAttribute("id",id);
			dbset.disconn(conn); 
			response.sendRedirect("/NotFound/main.do");
		}else if(action.equals("login")){
			System.out.println("�α�");
			//���⼭ ��� �����ͼ� �˻縦 �ؾߴ� ...  
			DB_set dbset = new DB_set();
			Connection conn = dbset.dbinit();
			String id = request.getParameter("userid");
			User user = new User();
			user = userdao.loginDB(conn, id);
			String name =user.getUsername();
			String db_id = user.getUseremail();
			if(!(db_id.equals(""))&&(request.getParameter("userpd").equals(user.getUserpd()))){
				session.setAttribute("logincheck", "login");
				session.setAttribute("name",name);
				System.out.println(name);
				session.setAttribute("id",user.getUseremail());		
				response.sendRedirect("/NotFound/main.do");
			
			}else{
				out.println("<script>");
				out.println("alert('nope!');");
				out.println("history.back();");
				out.println("</script>");
			}
		}else if(action.equals("facebook")){
			session.setAttribute("logincheck", "facebook");
			session.setAttribute("id",request.getParameter("email"));
			session.setAttribute("name",request.getParameter("name"));
			response.sendRedirect("/NotFound/main.do");
			
		}else if("logout".equals(action)){
			session.invalidate();
			response.sendRedirect("/NotFound/view/index.jsp");
		}else{
			out.println("<script>");
			out.println("alert('what ? nope!');");
			out.println("history.back();");
			out.println("</script>");
		}
	}

}