package com.exam.comm;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//리스너 : 특정 사건이 발생했을때 자동으로 실행되는 객체
//-감지하고 싶은 사건의 종류에 따라서 그에 맞는 리스너인터페이스를 구현

//-web.xml 파일에 <listener>를 사용하여 등록하거나, @WebListener를 클래스에 적용


public class DriverListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//서블릿컨텍스트객체가 처음 생성된 시점(서버(톰캣)시작시점)에 실행되는 메서드
		System.out.println("DrivetListener contextInitialized() 실행");
		
		ServletContext context = sce.getServletContext(); //생성된 서블릿 컨텍스트 객체 가져오기
		//"driver"라는 이름으로 저장되어 있는 컨텍스트파라미터 값 읽기
		String cname = context.getInitParameter("driver");
		
		//애플리케이션에 JDBC 사용 전에 최초 1번은 jDBC 드라이버 클래스를 메모리에 로드 필요
				try {
					Class.forName(cname);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		//서블릿컨텍스트객체가 소멸되기 직전(서버(톰캣)종료시점)에 실행되는 메서드
		System.out.println("DrivetListener contextDestroyed() 실행");
	}
	
}
