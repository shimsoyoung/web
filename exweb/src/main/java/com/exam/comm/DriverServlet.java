package com.exam.comm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;



public class DriverServlet extends HttpServlet{

	@Override
	public void init() throws ServletException {
		System.out.println("DriverServlet init() 실행!!!!!");
		
		String cname = getInitParameter("driver"); //현재 서블릿의 "driver" 초기화파라미터 값 읽기
		
		//애플리케이션에 JDBC 사용 전에 최초 1번은 jDBC 드라이버 클래스를 메모리에 로드 필요
		try {
			Class.forName(cname);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	
	}
}
