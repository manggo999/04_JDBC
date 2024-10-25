package edu.kh.toyProject.service;

import java.util.List;

import edu.kh.toyProject.dto.ToyProject;

public interface ToyProjectService {

	List<ToyProject> toyProjectFullView() throws Exception;

	ToyProject toyProjectDetailView(int no);

}
