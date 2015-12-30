package filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// 占쏙옙占쏙옙 占쏙옙占싶부븝옙占쏙옙 占쏙옙占쏙옙 占실억옙占쏙옙占쏙옙 占쏙옙占쏙옙
/**
 * Servlet Filter implementation class LoginCheck
 */
@WebFilter("/LoginCheck")
public class LoginCheck implements Filter {

	/**
	 * Default constructor.
	 */
	public LoginCheck() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession(false);
		boolean login = false;
		String path = ((HttpServletRequest) request).getRequestURI();
		System.out.println("�뱾�뼱�삩 寃쎈줈 :" + path);
		if (session != null) {
			if (session.getAttribute("logincheck") != null) {
				login = true; // 占쏙옙占실븝옙占쏙옙占쏙옙 null占쏙옙 占싣닐곤옙占� true占쏙옙 占쏙옙占쏙옙.
			}
		}
		if (login) {
			if (path.equals("/NotFound/view/index.jsp") || path.equals("/NotFound/view/main.jsp")) {
				((HttpServletResponse) response).sendRedirect("/NotFound/main.do");
			}
			chain.doFilter(request, response);
		} else {
			if (path.equals("/NotFound/index.do")) {
				chain.doFilter(request, response);
			} else if (path.equals("/NotFound/idcheck.do")) {
				chain.doFilter(request, response);
			} else if (path.equals("/NotFound/view/check/booksearch.jsp")||path.equals("/NotFound/view/check/bookresult.jsp")) {
				chain.doFilter(request, response);
			} else if (path.equals("/NotFound/view/index.jsp")) {
				chain.doFilter(request, response);
			} else if (path.equals("/NotFound/view/check/Join_idcheck.jsp")) {
				chain.doFilter(request, response);
			} else {
				((HttpServletResponse) response).sendRedirect("/NotFound/view/index.jsp");
			}

		}
		// pass the request along the filter chain

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}