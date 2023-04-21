package com.exam.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//2.웹브라우저에서 http://localhost:8000/exweb/foo/bar.do 로 접속하면
//웹브라우저 화면에 "Welcome" 이라고 출력되도록 HiServlet 클래스를 새로 추가하세요.


//서블릿 주소(경로) 지정 규칙
//-반드시 "/" 또는 "*." 으로 시작
//- "*"은 0개 이상의 모든 문자열과 일치, * 이렇게 할시 /foo/뒤에는 어떤 글자가와도 실행이됨
//즉 모든 문자열을 나타내고 싶을때 *을 쓴다
//"*.do"는 경로는 중요하지않고 .do 로 끝나는 명령어일때 실행이 됨

//@WebServlet("*.act")
@WebServlet("/hi.do")
public class HiServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("HiServlet 실행!");
		
		String userval = req.getParameter("user");
		
//		PrintWriter out = resp.getWriter();
//		out.println("Welcome");
		 
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		out.println("<!DOCTYPE html>       ");
		out.println("<html>                ");
		out.println("<head>                ");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>HELLO</title>  ");
		out.println("</head>               ");
		out.println("<body>                ");
		out.println("<h1>연습</h1>        ");
		out.println("<h2>" + userval + "님 환영합니다.</h2>        ");
		out.println("</body>               ");
		out.println("</html>               ");
		
		
		
	}

}

//"/hi.do?user=둘리"로 요청을 보내면, 화면에 "둘리님 환영합니다"라고 출력되고,
//"/hi.do?user=고길동"으로 요청을 보내면, 화면에 "고길동님 환영합니다"라고 출력되는
//HiServlet의 내용을 변경하세요.


//이클립스의 다이나믹웹프로젝트(톰캣)가 실행 중인 상태에서
// *.java 파일을 변경하면, 이클립스가 톰캣을 자동 재시작
//src/main/webapp 폴더의 정적 리소스(*.html, *.css…)파일들을 변경하면
//즉시 톰캣에 반영되므로 톰캣 재시작 없이 웹브라우저에서 새로고침만 하면 됨.
// web.xml 등 설정파일 변경시에, 수동으로 톰캣 재시작 필요




