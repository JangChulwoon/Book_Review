package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

/**
 * Servlet Filter implementation class CommonEncodingFilter
 */
@WebFilter("/CommonEncodingFilter")
public class CommonEncodingFilter implements Filter {
	/**
	 * ���ڵ��� ������ ���ڵ� ĳ���� �� ����
	 */
	private String encoding = null;
	static Logger logger = Logger.getLogger(CommonEncodingFilter.class);

	/**
	 * ���� ���� ������
	 */
	protected FilterConfig filterConfig = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		this.encoding = this.filterConfig.getInitParameter("encoding");
	}

	public void destroy() {

		this.encoding = null;
		this.filterConfig = null;

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		if (request.getCharacterEncoding() == null) {
			if (encoding != null) {
				String path = ((HttpServletRequest) request).getRequestURI();
				logger.info("enco path ::  ::" + path);
				request.setCharacterEncoding(encoding);
			}
		}
		chain.doFilter(request, response);
	}

	public FilterConfig getFilterConfig() {
		return filterConfig;
	}

	public void setFilterConfig(FilterConfig cfg) {
		filterConfig = cfg;
	}
}