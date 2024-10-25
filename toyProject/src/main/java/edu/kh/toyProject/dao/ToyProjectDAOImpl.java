package edu.kh.toyProject.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static edu.kh.toyProject.common.JDBCTemplate.*;
import edu.kh.toyProject.dto.ToyProject;

public class ToyProjectDAOImpl implements ToyProjectDAO{
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public ToyProjectDAOImpl() {
		
		try {
			
			String filePath = ToyProjectDAOImpl.class
					.getResource("/xml/sql.xml").getPath();
			
			prop = new Properties();
			prop.loadFromXML(new FileInputStream(filePath));
			
		} catch (Exception e) {
			System.out.println("sql.xml 로드 중 예외발생");
			e.printStackTrace();
		}
		
		
	}

	@Override
	public List<ToyProject> toyProjectFullView(Connection conn) throws Exception {
		List<ToyProject> student = new ArrayList<ToyProject>();
		
		try {
			
			String sql = prop.getProperty("toyProjectFullView");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
			ToyProject toyproject = ToyProject.builder()
									.no(rs.getInt("STD_NO"))
									.name(rs.getString("STD_NAME"))
									.age(rs.getInt("STD_AGE"))
									.gender(rs.getString("STD_GENDER"))
									.score(rs.getString("STD_SCORE"))
									.build();
									
									
				student.add(toyproject);
				
				
			}
			
			
		} finally {
			
			close(rs);
			close(stmt);
			
		}
		
		return student;
	}

	

	@Override
	public int getCompleteCount(Connection conn) throws Exception {
		int completeCount = 0;
		
		try {
			
			String sql = prop.getProperty("getcompleteCount");
			
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				completeCount = rs.getInt(1);
				
			}
			
		} finally {
			close(rs);
			close(stmt);
			
		}
		
		
		
		
		return completeCount;
	}

}
