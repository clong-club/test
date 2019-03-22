package com.boot.demo.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.springframework.core.annotation.Order;

@Order(1)
//重点
@WebFilter(filterName = "testFilter1", urlPatterns = "/*")
public class TestFilterFirst implements Filter {
@Override
public void init(FilterConfig filterConfig) throws ServletException {

}

@Override
public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
    throws IOException, ServletException {
  System.out.println("TestFilter1");
  NewRequestWrapper requestWrapper;
try {
	requestWrapper = new NewRequestWrapper((HttpServletRequest)servletRequest);
	filterChain.doFilter(requestWrapper, servletResponse);
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}

@Override
public void destroy() {

}
}