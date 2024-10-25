package edu.kh.toyProject.controller;

import java.io.IOException;

import edu.kh.toyProject.dto.ToyProject;
import edu.kh.toyProject.service.ToyProjectService;
import edu.kh.toyProject.service.ToyProjectServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/student/detail")
public class DetailServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			int no = Integer.parseInt(req.getParameter("no"));
			
			ToyProjectService service = new ToyProjectServiceImpl();
			
			ToyProject student = service.toyProjectDetailView(no);
			
			if(student == null) {
				
				HttpSession session = req.getSession();
				session.setAttribute("message", "학생이 존재하지 않습니다.");
				
				resp.sendRedirect("/");
				return;
				
			}
			
			
			req.setAttribute("student", student);
			
			String path = "/WEB-INF/views/detail.jsp";
			
			req.getRequestDispatcher(path).forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	

}
