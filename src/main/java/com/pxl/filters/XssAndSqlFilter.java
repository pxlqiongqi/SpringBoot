package com.pxl.filters;
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
@WebFilter(filterName="xssAndSqlFilter",urlPatterns="/*")
public class XssAndSqlFilter implements Filter {
    @Override
    public void destroy() {
        // TODO Auto-generated method stub  
    }

    @Override  
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {  
        XssAndSqlHttpServletRequestWrapper xssRequest = new XssAndSqlHttpServletRequestWrapper((HttpServletRequest) request);  
        chain.doFilter(xssRequest, response);  
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {  
        // TODO Auto-generated method stub  
    }

} 