package coupon.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CouponController
 */
//@WebServlet("/homett/mypage")
public class CouponController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		 System.out.println("test");
		 System.out.println("test");//추가했다용
	 }

}
