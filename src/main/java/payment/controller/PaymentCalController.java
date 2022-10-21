package payment.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import coupon.dto.Coupon;
import party.dto.Party;
import payment.service.face.PaymentService;
import payment.service.impl.PaymentServiceImpl;
import user.dto.Member;

/**
 * Servlet implementation class PaymentCalController
 */
@WebServlet("/homett/paymodule")
public class PaymentCalController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//서비스 객체
	PaymentService paymentService = new PaymentServiceImpl()
;	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		  System.out.println("/homett/paymentcal [POST}");

//		  
		  
		  req.getRequestDispatcher("/WEB-INF/party/paymodule.jsp").forward(req, resp);
	}
}
