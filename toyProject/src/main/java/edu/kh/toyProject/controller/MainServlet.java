package edu.kh.toyProject.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import edu.kh.toyProject.dto.ToyProject;
import edu.kh.toyProject.service.ToyProjectService;
import edu.kh.toyProject.service.ToyProjectServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/main")
public class MainServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			// Service 객체 생성
			ToyProjectService service = new ToyProjectServiceImpl();
			
			List<ToyProject> studentList = service.toyProjectFullView();
			
			
			
			req.setAttribute("studentList", studentList);
			
			
			// 메인페이지 응답을 담당하는 jsp에 요청위임
			String path = "/WEB-INF/views/main.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
