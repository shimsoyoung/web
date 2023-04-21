package com.exam.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dollar2")
public class Convsevlet2 extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
System.out.println("ConvServlet 실행!!!!");
		
		req.setCharacterEncoding("UTF-8");
		String money = req.getParameter("num");
		String unitt = req.getParameter("unit");
		
		
		double don = Double.parseDouble(money);

		
		double result=0;

	
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
		if (unitt.equals("won")) {
			result = don/1287;
			out.println("<h1>" + money + "원" + " = " + result + "달러" + "</h1>"); }
		else if (unitt.equals("dol")) {
			result = don*1287;
			out.println("<h1>" + money + "달러" + " = " + result + "원" + "</h1>"); }
		out.println("</body>                ");
		out.println("</html>                ");                                                      

	}                                                           

}