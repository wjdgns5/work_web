package com.tenco.filters;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

/*
 * 1. Filter 구현 
 * 2. URL 패턴 설정 (web.xml 파일에서 설정할 예정)
 */

public class IPBlockFilter implements Filter {
	
	// 192.168.0.144 <-- 내 아이피
	
	// 차단할 IP 대역의 접두사
	private static final String BLOCKED_IP_PREFIX = "192.168.0.25";
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("IPBlockFilter 초기화 ");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		// 전처리 - 요청자에 IP를 확인
	String remoteIP	= request.getRemoteAddr();
	System.out.println("Request from IP : " + remoteIP);
	
	// 차단 시킬 코드 작성
	if(remoteIP.startsWith(BLOCKED_IP_PREFIX)) {
		System.out.println("필터 적용 확인 ...");
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println("Access Denied !!");
		response.getWriter().println("너는 못 지나간다.");
		return;
	}
	
	chain.doFilter(request, response);
		
	}
}
