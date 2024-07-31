package com.tenco.filters;

import jakarta.servlet.DispatcherType;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;
// DispatcherType.REQUEST : 서블릿은 고객이 요청한 것인지 서버가 내부에서 오류페이지를 요청한것이지 구분 
@WebFilter(urlPatterns = "/*", dispatcherTypes = {DispatcherType.REQUEST})
public class SimpleFilter implements Filter {
       
    public SimpleFilter() {
        super();
    }
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    	System.out.println("Simple/Filter 초기화 ");
    	
    }

    public void destroy() {
    	System.out.println("종료될 때 호출되는 메서드");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("SimpleFilter doFilter() 메서드 호출 됨. ");
		
		// 다음 필터로 또는 서블릿으로 요청, 응답 객체를 전달한다.
		chain.doFilter(request, response);
	}


}
