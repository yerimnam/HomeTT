package payment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/homett/payamount")
public class PaymentAmountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
		//결제 창
	//파티 가입하기 누르면 나오는 창 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/homett/payamount - 결제 창");
	
		
		
		req.getRequestDispatcher("/WEB-INF/party/pay.jsp").forward(req, resp);
	}
	
}
