package com.youdo.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * 
 * @author shsun
 * 
 */
public class SetHttpServletRequestWithGetMethodCharacterEncodingFilter implements Filter {

	@SuppressWarnings("unused")
	private FilterConfig filterConfig = null;

	private String charset = "UTF-8";

	public void init( FilterConfig filterConfig ) throws ServletException {
		// TODO Auto-generated method stub
		this.filterConfig = filterConfig;
		String charset = filterConfig.getServletContext().getInitParameter("charset");
		if (charset != null && charset.trim().length() != 0) {
			this.charset = charset;
		}
	}

	public void doFilter( ServletRequest request, ServletResponse response, FilterChain chain ) throws IOException, ServletException {
		// TODO Auto-generated method stub

		//
		request.setCharacterEncoding(this.charset);
		response.setCharacterEncoding(this.charset);

		HttpServletRequest tmpRequest = (HttpServletRequest) request;
		if (tmpRequest.getMethod().equalsIgnoreCase("GET")) {
			tmpRequest = new Request(tmpRequest, this.charset);
		}

		chain.doFilter(tmpRequest, response);
	}

	public void destroy() {
		// TODO Auto-generated method stub
		charset = null;
		filterConfig = null;
	}

	/**
	 * 
	 * @author shsun
	 * 
	 */
	class Request extends HttpServletRequestWrapper {

		private String charset = "UTF-8";

		/**
		 * 
		 * @param request
		 *            the object which be wrapped
		 */
		public Request(HttpServletRequest request) {
			super(request);
		}

		/**
		 * @param request
		 *            the object which be wrapped
		 * @param charset
		 *            expected charset
		 */
		public Request(HttpServletRequest request, String charset) {
			super(request);
			this.charset = charset;
		}

		/**
		 * 
		 */
		@Override
		public String getParameter( String name ) {
			String value = super.getParameter(name);
			value = value == null ? null : convert(value);
			return value;
		}

		/**
		 * 
		 */
		@Override
		public String[] getParameterValues( String name ) {
			String values[] = ((HttpServletRequest) super.getRequest()).getParameterValues(name);
			if (values != null) {
				for (int i = 0; i < values.length; i++) {
					values[i] = convert(values[i]);
				}
			}
			return values;
		}

		private String convert( String target ) {
			String s = null;
			try {
				//s = java.net.URLDecoder.decode(target, this.charset);
				s = new String(target.trim().getBytes("ISO-8859-1"), this.charset);
			} catch (UnsupportedEncodingException e) {
				s = target;
			}
			return s;
		}
	}
}
