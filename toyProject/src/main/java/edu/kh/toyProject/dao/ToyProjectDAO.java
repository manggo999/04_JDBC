package edu.kh.toyProject.dao;

import java.sql.Connection;
import java.util.List;

import edu.kh.toyProject.dto.ToyProject;

public interface ToyProjectDAO {

	List<ToyProject> toyProjectFullView(Connection conn) throws Exception;

	int getCompleteCount(Connection conn) throws Exception;

}
