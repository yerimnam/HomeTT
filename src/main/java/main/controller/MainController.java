package main.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.service.face.MainServcie;
import main.service.impl.MainServiceImpl;
import party.dto.Party;


@WebServlet("/homett/main")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MainServcie mainService = new MainServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("homett/main [GET]");
	
		
		
		//메인페이지에 현재 열린 파티방 목록 보여주기 ->party DTO 불러오기
		List<Party> mainlist = mainService.getList();
		
		
		System.out.println("mainlist : " + mainlist);
		//모텔달 view로 전달
		req.setAttribute("mainlist", mainlist);
		
		
		
		
		req.getRequestDispatcher("/WEB-INF/main/main.jsp").forward(req, resp);
	}
}
