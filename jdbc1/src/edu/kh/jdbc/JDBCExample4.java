package edu.kh.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCExample4 {

	public static void main(String[] args) {
		
		// 부서명을 입력받아
		// 해당 부서에 근무하는 사원의 
		// 사번, 이름, 부서명, 직급명을
		// 직급코드 오름차순으로 조회
		
		// hint : SQL에서 문자열 양쪽에 ''(홑따옴표) 필요
		
		// 1. JDBC 객체 참조용 변수 선언
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		
		
		try {
			
			// 2. Connection 객체 생성

			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String type = "jdbc:oracle:thin:@"; // 드라이버 종류
			
			String host = "localhost"; // DB 서버 컴퓨터의 IP 또는 도메인 주소
			                           // localhost == 현재 컴퓨터
			
			String port = ":1521"; // 프로그램 연결을 위한 port 번호
			
			String dbName = ":XE"; // DBMS 이름(XE == eXpress Edition)
			
			//jdbc:oracle:thin:@localhost:1521:XE
			
			String userName = "kh_gmk"; // 사용자 계정명
			
			String password = "kh1234"; // 계정 비밀번호
			
			
			// DB 연결 정보와 DriverManager를 이용해서 Connection 객체 생성
			conn = DriverManager.getConnection(type + host + port + dbName, 
					                           userName, 
					                           password);
			
             Scanner sc = new Scanner(System.in);
			
			  System.out.println("부서명 입력 : ");
			  String input = sc.nextLine();
			
			
			// 3. SQL 작성
			String sql = """
					       SELECT 
					           EMP_ID, 
                               EMP_NAME, 
                               DEPT_TITLE, 
                               JOB_NAME
					        FROM EMPLOYEE
					        JOIN JOB USING(JOB_CODE)
					        JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
					        WHERE DEPT_TITLE = '""" + input + "' ORDER BY JOB_CODE";
			
			// 4. Statement 객체 생성 
			stmt = conn.createStatement();
			
			// 5. Statement 객체를 이용해서 SQL 수행 후 결과 반환 받기
			rs = stmt.executeQuery(sql);
			
			// 6, 조회
			while(rs.next()) {
				
				String empId = rs.getString("EMP_ID");
			    String empName = rs.getString("EMP_NAME");
			    String deptTitle= rs.getString("DEPT_TITLE");
			    String jobName= rs.getString("JOB_NAME");
			   
			    System.out.printf(
						"사번 : %s / 이름 : %s / 부서명 : %s / 직급명 : %s \n",
						  empId, empName, deptTitle, jobName);
				
			}
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null ) conn.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
