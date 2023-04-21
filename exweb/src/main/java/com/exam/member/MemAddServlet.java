package com.exam.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/member/add.do")
public class MemAddServlet extends HttpServlet {
	private MemberDao memberDao = new MemberDaoJdbc();
	
	{
		//애플리케이션에 JDBC 사용 전에 최초 1번은 jDBC 드라이버 클래스를 메모리에 로드 필요
		
				try {
					Class.forName("oracle.jdbc.OracleDriver");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		req.setCharacterEncoding("UTF-8"); //필터로 이동
		MemberVo vo = new MemberVo();
		vo.setMemId(req.getParameter("memId"));
		vo.setMemPass(req.getParameter("memPass"));
		vo.setMemName(req.getParameter("memName"));
		vo.setMemPoint(Integer.parseInt(req.getParameter("memPoint")));
		
		int n = memberDao.imsertMember(vo);
		
		System.out.println(n + "명의 회원 추가");
		
		//회원목록 출력
		//MemListServlet 실행!
		//forward : 요청객체와 응답객체를 전달하면서, 지정한 주소의 서블릿을 실행
		//		현재 서블릿에서는 더 이상 출력하지 않는다
//		req.getRequestDispatcher("/member/list.do").forward(req, resp);
		//include : 요청객체와 응답객체를 전달하면서, 지정한 주소의 서블릿을 실행
		//		현재 서블릿의 출력한 내용 중간에 지정한 서블릿의 출력할 내용을 끼워넣을 수 있다.
//		req.getRequestDispatcher("/member/list.do").include(req, resp);
		//redirect : 지정한 주소로 이동하라는 명령을 담은 응답을 웹브라우저에게 전송
		resp.sendRedirect(req.getContextPath() + "/member/list.do");
		
		/*
		 * resp.setCharacterEncoding("UTF-8"); resp.setContentType("text/html");
		 * 
		 * PrintWriter out = resp.getWriter();
		 * 
		 * out.println("<!DOCTYPE html>        ");
		 * out.println("<html>                 ");
		 * out.println("<head>                 ");
		 * out.println("<meta charset=\"UTF-8\"> ");
		 * out.println("<title>회원추가성공화면</title>   ");
		 * out.println("</head>                ");
		 * out.println("<body>                 "); out.println("<h1>" + n +
		 * "명의 회원 추가 성공</h1>"); out.println("<a href='" + req.getContextPath() +
		 * "/member/list.do'>회원목록</a>"); out.println("</body>                ");
		 * out.println("</html>                ");
		 */     
	}

	
	
}
