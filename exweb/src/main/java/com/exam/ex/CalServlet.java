package com.exam.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/clac.do")
public class CalServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("CalServlet 실행!!!!");
		
		req.setCharacterEncoding("UTF-8");
		String xval = req.getParameter("x");
		String yval = req.getParameter("y");
		String opp = req.getParameter("op");
		/* 숫자타입클래스명.parse숫자타입명("숫자문자열") */
		/*파라미터 값은 항상 문자열이므로 숫자로 변환해주는 명령문을 써야한다*/
		
		double num1 = Double.parseDouble(xval);
		double num2 = Double.parseDouble(yval);

		//op 파라미터값에 따라서 맞는 사칙연산을 수행
		//문자열 값을 동등비교하는 경우, == 연산자가 아닌 .equals() 메서드 사용
		// "문자열1" == "문자열2" (x)
		// "문자열1".equals("문자열2") (o)
		
		double result=0;
		String operator = "";
	
		switch(opp) {
			case "plu":
				result = num1+num2;
				operator="+";
				break;
			case "min":
				result = num1-num2;
				operator="-";
				break;
			case "mul":
				result = num1*num2;
				operator="*";
				break;
			case "div":
				result = num1/num2;
				operator="/";
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
		out.println("<h1>" + xval + operator + yval + " = " + result + "</h1>");
		
/*		if(opp.equals("plu")) {
			result=num1+num2;
			out.println("<h1>" + xval + "+" + yval + " = " + result + "</h1>");
			}else if(opp.equals("min")){
				result=num1-num2;
				out.println("<h1>" + xval + "-" + yval + " = " + result + "</h1>");
			}else if(opp.equals("mul")) {
				result=num1*num2;
				out.println("<h1>" + xval + "*" + yval + " = " + result + "</h1>");
			}else if(opp.equals("div")) {
				result=num1/num2;
				out.println("<h1>" + xval + "/" + yval + " = " + result + "</h1>");
			} */
		
		out.println("</body>                ");
		out.println("</html>                ");                                                      

	}                                                           

}
