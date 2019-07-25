package com.lti.filter;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class AuditFilter
 */
@WebFilter(dispatcherTypes =
{
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD, 
				DispatcherType.INCLUDE, 
				DispatcherType.ERROR
		}
					, urlPatterns = { "/AccountServlet" })
public class AuditFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuditFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("AUDIT FILTER IS DESTROYED");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("-------------------------------------------------------------------");
		System.out.println("Audit Filter==>doFilter");
		HttpServletRequest req=(HttpServletRequest) request;
		String url=req.getRequestURL().toString();
		System.out.println("URL Intercepted==>"+url);
		
		//start time
		long start=System.currentTimeMillis();
		
;		// pass the request along the filter chain
		chain.doFilter(request, response);
		
		long end=System.currentTimeMillis();
		
		System.out.println("==URL "+url+"took time "+(end-start)+"ms");
		System.out.println("-------------------------------------------------------------");
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("AUDIT FILTER IS INITIALIZED");
	}

}
