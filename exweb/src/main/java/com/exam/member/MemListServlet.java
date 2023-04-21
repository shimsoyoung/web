package com.exam.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/list.do")
public class MemListServlet extends HttpServlet {
	private MemberDao memberDao = new MemberDaoBatis();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<MemberVo> list = memberDao.selectMemberList();
				
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<!DOCTYPE html>        ");
		out.println("<html>                 ");
		out.println("<head>                 ");
		out.println("<meta charset=\"UTF-8\"> ");
		out.println("<title>회원관리</title>   ");
		out.println("</head>                ");
		out.println("<body>                 ");
		out.println("<h1>회원목록</h1>");
		out.println("<a href='" + req.getContextPath() + "/member/addform.do'>회원추가</a>");
		
		
		for (MemberVo vo : list) {
			out.println("<p>" + vo.getMemId() + ":" +vo.getMemPass() + ":" + vo.getMemName() + ":" + vo.getMemPoint());
			out.print("<button><a href='" + req.getContextPath() + "/member/del.do?memId=" + vo.getMemId() + "'><butten type='button'>회원삭제</button></a>");
			out.print("<form action='" + req.getContextPath() + "/member/del.do' method='get'>");
			out.print("<input type='hidden' name='memId' value='" + vo.getMemId() + "'/>");
			out.print("<input type='submit' value='삭제'/>");
			out.print("</p>");
			//			System.out.println(memId + ":" + memPass + ":" + memName + ":" + memPoint);
		}
		
		out.print("</form>				");
		out.println("</body>                ");
		out.println("</html>                ");   
	}

	
	
}
