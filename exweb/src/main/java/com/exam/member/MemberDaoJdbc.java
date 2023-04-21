package com.exam.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//Dao = Data Access Object
public class MemberDaoJdbc implements MemberDao {
	String url = "jdbc:oracle:thin:@localhost:1521:xe";		//데이터베이스 서버 주소
	String user = "web";									//데이터베이스 접속 아이디
	String password = "web01";								//데이터베이스 접속 비밀번호
	
	@Override
	public List<MemberVo> selectMemberList() {
		List<MemberVo> list = new ArrayList<MemberVo>();
		
		String sql = "select mem_id, mem_pass, mem_name, mem_point from member";
		
		//try () 내부에 선언된 변수의 값은
		//try-catch 블럭의 실행이 완료된 후 자동으로 close() 메서드 실행
		try (
				Connection conn = DriverManager.getConnection(url, user, password);	//지정한 데이터베이스에 접속(로그인)
				
				PreparedStatement pstmt = conn.prepareStatement(sql); 	//해당 연결을 통해 실행할 SQL문을 담은 명령문 객체 생성
				ResultSet rs = pstmt.executeQuery();							//SQL문 실행(SELECT 문 실행은 executeQuery()메서드 사용)
				//반환값은 조회 결과 레코드(row) 수
			) {
			
			//처음 ResultSet 객체는 첫 레코드(row) 이전을 가리키고 있음
			// .next() 메서드를 실행하면 다음 레코드를 가리키게 된다
			// 다음 레코드가 있으면 true를 반환하고 없으면 false를 반환한다.
			while(rs.next()) {
				MemberVo vo = new MemberVo();
				//컬럼값의 데이터타입에 따라서 get타입("컬럼명") 메서드를 사용하여 컬럼값 읽기
				vo.setMemId(rs.getString("mem_id")) ; //현재 가리키는 레코드(row)의 "mem_id"컬럼값 읽기
				vo.setMemPass(rs.getString("mem_pass")); //현재 가리키는 레코드(row)의 "mem_pass"컬럼값 읽기
				vo.setMemName(rs.getString("mem_name")); //현재 가리키는 레코드(row)의 "mem_name"컬럼값 읽기
				vo.setMemPoint(rs.getInt("mem_point")) ; //현재 가리키는 레코드(row)의 "mem_point"컬럼값 읽기
				list.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public int imsertMember(MemberVo vo) {
		String sql = "INSERT INTO member (mem_id, mem_pass, mem_name, mem_point) "
				+ "VALUES ( ?, ?, ?, ? )";
		int n = 0;
		//try () 내부에 선언된 변수의 값은
		//try-catch 블럭의 실행이 완료된 후 자동으로 close() 메서드 실행
		try (
				Connection conn = DriverManager.getConnection(url, user, password);	//지정한 데이터베이스에 접속(로그인)
				
				PreparedStatement pstmt = conn.prepareStatement(sql); 	//해당 연결을 통해 실행할 SQL문을 담은 명령문 객체 생성
			) {
			
			//pstmt 명령문 객체에 담겨있는 SQL문의 ?에 값을 채워넣기
			//채워넣는 값의 타입에 따라서 set타입면() 매서드 사용
			pstmt.setString(1, vo.getMemId()); //1번째 ?에 memId 값을 넣기
			pstmt.setString(2, vo.getMemPass()); //2번째 ?에 memId 값을 넣기
			pstmt.setString(3, vo.getMemName()); //3번째 ?에 memId 값을 넣기
			pstmt.setInt(4, vo.getMemPoint()); //4번째 ?에 memId 값을 넣기
			
			n = pstmt.executeUpdate();							//SQL문 실행(INSERT, UPDATE,DELETE 문 실행은 executeUpdate()메서드 사용)
																	//반환값은 SQL문 실행으로 영향받은 레코드(row) 수
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}
	
	@Override
	public int deleteMember(String memId) {
		String sql = "DELETE FROM member WHERE mem_id=?";
		int n = 0;
		//try () 내부에 선언된 변수의 값은
		//try-catch 블럭의 실행이 완료된 후 자동으로 close() 메서드 실행
		try (
				Connection conn = DriverManager.getConnection(url, user, password);	//지정한 데이터베이스에 접속(로그인)
				
				PreparedStatement pstmt = conn.prepareStatement(sql); 	//해당 연결을 통해 실행할 SQL문을 담은 명령문 객체 생성
			) {
			
			//pstmt 명령문 객체에 담겨있는 SQL문의 ?에 값을 채워넣기
			//채워넣는 값의 타입에 따라서 set타입면() 매서드 사용
			pstmt.setString(1, memId); //1번째 ?에 memId 값을 넣기
			n = pstmt.executeUpdate();							//SQL문 실행(INSERT, UPDATE,DELETE 문 실행은 executeUpdate()메서드 사용)
																	//반환값은 SQL문 실행으로 영향받은 레코드(row) 수
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}
}
