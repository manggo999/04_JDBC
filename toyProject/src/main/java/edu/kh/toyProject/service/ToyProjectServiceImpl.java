package edu.kh.toyProject.service;

import static edu.kh.toyProject.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import edu.kh.toyProject.common.JDBCTemplate;
import edu.kh.toyProject.dao.ToyProjectDAO;
import edu.kh.toyProject.dao.ToyProjectDAOImpl;
import edu.kh.toyProject.dto.ToyProject;

// 추상메서드 구현
public class ToyProjectServiceImpl implements ToyProjectService{

	private ToyProjectDAO dao = new ToyProjectDAOImpl();

	@Override
	public List<ToyProject> toyProjectFullView() throws Exception {
		
		// 커넥션 생성
		Connection conn = getConnection();
		
		// 학생 목록 얻어오기
		List<ToyProject> student = dao.toyProjectFullView(conn);
		
		close(conn);
		
		
		
		
		return null;
	}

	@Override
	public ToyProject toyProjectDetailView(int no) {
		Connection conn = getConnection();
		
		ToyProject student = dao.
		return null;
	}
	
	
}
