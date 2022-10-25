package inquiry.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//1:1 문의 작성
@WebServlet("/homett/inquirycreate")
public class InquiryCreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("1:1 문의 작성하기 시작");
		//한글 인코딩
		req.setCharacterEncoding("UTF-8");

	
		
		
		System.out.println("1:1 문의 작성하기 끝");
		req.getRequestDispatcher("/WEB-INF/cs/inquiry/inquiryCreate.jsp").forward(req, resp);
	}
}
