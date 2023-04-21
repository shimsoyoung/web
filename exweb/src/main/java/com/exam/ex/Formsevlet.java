package com.exam.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form.do")
public class Formsevlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("ConvServlet 실행!!!!");
		
		req.setCharacterEncoding("UTF-8");
		String pval = req.getParameter("prod");
		String fval = req.getParameter("fruit");
		String[] dval = req.getParameterValues("drink");
		
		
	
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();	
		 
		out.println("<!DOCTYPE html>        ");
		out.println("<html>                 ");
		out.println("<head>                 ");
		out.println("<meta charset=\"UTF-8\"> ");
		out.println("<title>HELLO</title>   ");
		out.println("</head>                ");
		out.println("<body>                 ");
		out.println("<h1> 요청주소 : " + req.getRequestURL() + "</h1>");
		out.println("<h1> 요청주소 : " + req.getRequestURI() + "</h1>");
		out.println("<h1> 애플리케이션 고유경로 : " + req.getContextPath() + "</h1>");
		out.println("<h1> 요청방식 : " + req.getMethod() + "</h1>");
		out.println("<h1> 요청헤더 : " + req.getHeader("User-Agent") + "</h1>");
		out.println("<h1> 사용자 IP주소 : " + req.getRemoteAddr() + "</h1>");
		
		out.println("<h1> 상품 : " + pval + "</h1>");
		out.println("<img src='https://api.lorem.space/image/" + pval + "?w=150&h=150'>");
		out.println("<h1> 과일 : " + fval + "</h1>");
		out.println("<h1> 음료 : ");
		
		if (dval !=null) {	//파라미터가 전송되지 않은 경우 null
		for (int i = 0; i < dval.length; i++) {
			out.println("[" + dval[i] + "]");
			}
		}
		
		out.println("</h1>");
		
		out.println("</body>                ");
		out.println("</html>                ");                                                      

	}                                                           

}
