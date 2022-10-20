package party.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import party.dto.Party;
import util.PrPaging;

public interface PartyModifyService {
	
	/**
	 * 파티방 전체 조회
	 * 
	 * @return List<Party> - 파티방 전체 조회 목록
	 */
	public List<Party> getPrList();

	/**
	 * 파티방 페이징 목록 조회
	 * 
	 * @param paging - 페이징 정보 객체
	 * @return List<Board> - 파티방 전체 조회 목록
	 */
	public List<Party> getPrList(PrPaging paging);
	
	
	/**
	 * 파티목록 페이징 객체 생성
	 * 
	 * @param req - 요청 정보 객체
	 * @return Paging - 페이징 계산이 완료된 객체
	 */
	public PrPaging getPrPaging(HttpServletRequest req);




}
