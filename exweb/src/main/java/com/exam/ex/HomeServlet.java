package com.exam.ex;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		resp.setCharacterEncoding("UTF-8");//응답내용을 쓸 때 사용할 문자인코딩 방식 지정
		resp.setContentType("text/html");//응답내용의 데이터타입을 설정(웹브라우저에게 정보제공)
//		resp.setContentType("text/html; charset=UTF-8");//문자인코딩과 데이터타입을 한 번에 설정 가능
		PrintWriter out = resp.getWriter();//응답객체에 내용을 쓸 수 있는 Writer 가져오기
		//out.println("Hello SERVLET"); //응답객체에 문자열을 출력
		//응답객체에 출력한 내용은 클라이언트(브라우저)로 전송된다
		out.println("<!DOCTYPE html>        ");
		out.println("<html>                 ");
		out.println("<head>                 ");
		out.println("<meta charset='UTF-8'> ");
		out.println("<title>HOME</title>   ");
		out.println("</head>                ");
		out.println("<body>                 ");
		out.println("<h1>HOME</h1>         ");
		
		//SaveServlet에서 저장한 데이터를 읽어서 출력
		HttpSession session = req.getSession();
		String nickName = (String)session.getAttribute("nick"); //세션객체에 "nick"이라는 이름으로 저장된 데이터 읽기
		out.println("세션에 저장된 닉네임: " + nickName + "<br>");
		
		
		ServletContext context = getServletContext();
		String contextNick = (String)context.getAttribute("nick"); //서블릿컨텍스트객체에 "nick"이라는 이름으로 저장된 데이터 읽기
		out.println("서블릿컨텍스트에 저장된 닉네임: " + contextNick + "<br>");
		
		Cookie[] cookies = req.getCookies();
		for (Cookie c : cookies) {
			if ( "nick".equals(c.getName()) ) { //쿠키이름이 nick인 경우
				
				String v = URLDecoder.decode(c.getValue(), "UTF-8");
				out.println("쿠키에 저장된 닉네임: " + v + "<br>");
			}
		}
		
		out.println("</body>                ");
		out.println("</html>                ");
	}                                      

}
