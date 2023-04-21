package com.exam.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dollar")
public class Convsevlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("ConvServlet 실행!!!!");
		
		req.setCharacterEncoding("UTF-8");
		String money = req.getParameter("num");
		String unitt = req.getParameter("unit");
		
		
		double don = Double.parseDouble(money);

		
		double result=0;
		String operator = "";
		String opp = "";
		
		switch(unitt) {
			case "won" :
				result = don/1287;
				operator = "원";
				opp = "달러";
			break;
			
			case "dol" :
				result = don*1287;
				operator = "달러";
				opp = "원";
			break;
		
		}
	
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
		out.println("<h1>" + money + operator + " = " + result + opp + "</h1>");
		out.println("</body>                ");
		out.println("</html>                ");                                                      

	}                                                           

}
