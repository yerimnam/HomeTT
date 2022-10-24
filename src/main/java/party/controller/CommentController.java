package party.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import party.dto.Comments;
import party.service.face.CommentService;
import party.service.impl.CommentServiceImpl;

/**
 * Servlet implementation class CommentController
 */
@WebServlet("/homett/comment")
public class CommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//서비스 객체 가져오기
	private CommentService commentService = new CommentServiceImpl();

	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/homett/comment GET()");
		
	
		Comments comments = commentService.getCommentsno(req);
		
		commentService.delete(comments);
		
		resp.sendRedirect("/homett/roomboard");
		
		
		
		}
	
	

}
