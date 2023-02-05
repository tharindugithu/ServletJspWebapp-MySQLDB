package com.tharindu.web.filters;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;


public class IdFilter extends HttpServlet implements Filter {
       
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		PrintWriter out = response.getWriter();
		HttpServletRequest req = (HttpServletRequest) request;
		int pid = Integer.parseInt(request.getParameter("pid"));
        
		// pass the request along the filter chain
		if(pid > 0) {
			chain.doFilter(request, response);
		}else {
			out.print("<h1 style='color:red'>Id is not valid</h1>");
		}
	}

}
