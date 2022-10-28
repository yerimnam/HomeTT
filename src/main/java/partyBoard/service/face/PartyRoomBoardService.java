package partyBoard.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import party.dto.Party;
import party.dto.PartyRoom;
import partyBoard.dto.PartyBoard;
import util.PbPaging;

public interface PartyRoomBoardService {

	/** 
	 * 게시글 전체 조회
	 * 
	 * @return List<PartyBoard> - 게시글 전체 조회 목록
	 */
	public List<PartyBoard> getBrList();

	/**
	 * 파티게시판 페이징 목록 조회
	 * 
	 * @param paging - 페이징 정보 객체
	 * @return List<PartyBoard> - 파티방 전체 조회 목록
	 */
	public List<PartyBoard> getBrList(PbPaging paging);
	
	
	
	/**
	 * 파티게시판 페이징 객체 생성
	 * 
	 * @param req - 요청 정보 객체
	 * @return Paging - 페이징 계산이 완료된 객체
	 */
	public PbPaging getBrPaging(HttpServletRequest req);
	
	
	/**
	 *  전달된 요청 정보 객체를 이용하여
	 * 전달 파라미터 partyBoardNo, partyBoardWriter, partyBoardTitle을 추출한다
	 * 
	 * 추출한 데이터는 partyBoard DTO객체로 반환한다
	 * 
	 * @param req - 요청 정보 객체
	 * @return 전달 파라미터를 partyBoard객체로 한꺼번에 담아서 반환한다
	 */
	public PartyBoard getParam(HttpServletRequest req);


	public PartyBoard write(HttpServletRequest req);

//	public List<PartyBoard> getBrList(String searchCondition, String searchKeyword, PbPaging paging);



	/**
	 * 전달 파라미터 getpartyBoardno를 partyBoard DTO로 저장해서 반환
	 * 
	 * @param req - 요청 정보 객체
	 * @return - 전달파라미터 getpartyBoardno를 저장한 DTO객체
	 */
	public PartyBoard getpartyBoardno(HttpServletRequest req);
	
	
	
	/**
	 * 게시글 삭제
	 * 
	 * @param partyBoard - 삭제할 게시글 번호 객체
	 */
	public void delete(PartyBoard getpartyBoard);

	
	
	public List<PartyBoard> getPartySearchList(String searchType, String keyword);

	
	
	/**
	 * 전달파라미터 getPartyRoomNo를 party DTO로 저장해서 반환
	 * @param req-요청 정보 객체
	 * @return- 전달파라미터 getpartyRoomNo를 저장한 DTO객체
	 */
	public Party getPartyRoomNo(HttpServletRequest req);

	/**
	 * 파티방 탈퇴
	 * 
	 * @param partyRoom - 삭제할 파티방 번호 객체
	 */
	public void dropParty(PartyRoom partyRoom);





























	

}
