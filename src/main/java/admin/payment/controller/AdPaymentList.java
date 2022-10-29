package admin.payment.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.login.dto.Admin;
import admin.login.service.face.AdminLoginService;
import admin.login.service.impl.AdminLoginServiceImpl;
import admin.payment.dto.Payment;
import admin.payment.service.face.AdPaymentListService;
import admin.payment.service.impl.AdPaymentListServiceImpl;
import util.Paging;

@WebServlet("/homett/adpaymentlist")
public class AdPaymentList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AdminLoginService adminLoginService = new AdminLoginServiceImpl();
	private AdPaymentListService adPaymentListService = new AdPaymentListServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//한글 인코딩 처리
		req.setCharacterEncoding("UTF-8");
		
		HttpSession session = req.getSession();
		
		Admin admin = new Admin();
		admin.setAdminId((String) session.getAttribute("adminId"));
		admin.setAdminPw((String) session.getAttribute("adminPw"));
		
		boolean loginSt = adminLoginService.login(admin);
		
		if ( loginSt ) {
		
			String searchType = req.getParameter("searchType");
			String keyword = req.getParameter("keyword");
			
			Paging paging;
			if ( searchType != null && keyword != null ) {
				paging = adPaymentListService.getSearchPaging(req, searchType, keyword);
			} else {
				paging = adPaymentListService.getPaging(req);
			}
			
			req.setAttribute("paging", paging);
			
			List<Payment> paymentList;
			if(searchType != null && keyword != null) {
				// 검색한 결과
				paymentList = adPaymentListService.getSearchList( paging, searchType, keyword );
//				System.out.println("검색한 paging 결과 : " + paging);
			} else {
				// 검색 안한 결과
				paymentList = adPaymentListService.getList( paging );
//				System.out.println("검색 안한 paging 결과 : " + paging);
			}
			
			req.setAttribute("paymentList", paymentList);
			req.getRequestDispatcher("/WEB-INF/admin/payment/adminpaymentlist.jsp").forward(req, resp);
			
		} else {
			resp.sendRedirect("./adminlogin");
		}
			
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
