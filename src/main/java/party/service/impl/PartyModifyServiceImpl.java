package party.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import party.dao.face.PartyModifyDao;
import party.dao.impl.PartyModifyDaoImpl;
import party.dto.Party;
import party.service.face.PartyModifyService;
import util.PrPaging;

public class PartyModifyServiceImpl implements PartyModifyService {

	// DAO객체
	private PartyModifyDao partyModifyDao = new PartyModifyDaoImpl();

	@Override
	public List<Party> getPrList() {
		System.out.println("PartyModifyService getPrList() - 시작");

		System.out.println("PartyModifyService getPrList() - 끝");

		// DB조회결과 반환
		return partyModifyDao.selectAllPr(JDBCTemplate.getConnection());
	}

	@Override
	public List<Party> getPrList(PrPaging paging) {
		return partyModifyDao.selectAllPr(JDBCTemplate.getConnection(), paging);
	}
	
	
	@Override
	public PrPaging getPrPaging(HttpServletRequest req) {

		// 총 게시글 수 조회하기
		int totalCount = partyModifyDao.selectPrAll(JDBCTemplate.getConnection());

		// 전달파라미터 curPage 추출하기
		String param = req.getParameter("curPage");
		int curPage = 0;
		if (param != null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		}

		// Paging객체 생성
		PrPaging paging = new PrPaging(totalCount, curPage);

		return paging;
	}


}
