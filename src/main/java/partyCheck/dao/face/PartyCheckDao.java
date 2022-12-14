package partyCheck.dao.face;

import java.sql.Connection;
import java.util.List;

import partyCheck.dto.MypageMember;
import partyCheck.dto.PartyCheck;
import user.dto.Member;
import util.Paging5;

public interface PartyCheckDao {
	
	/**
	 * 파티 테이블 전체 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @return List<PartyCheck> - 테이블 전체 조회 목록
	 */
	public List<PartyCheck> selectAll(Connection conn);
	
	/**
	 * 파티 테이블 페이징 목록 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @param paging -  페이징 정보 객체
	 * @return List<PartyCheck> - 테이블 페이징 조회 결과
	 */
	public List<PartyCheck> selectAll(Connection conn, Paging5 paging);

	/**
	 * 총 파티 수 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @return int - 테이블의 전체 행수 
	 */
	public int selectCntAll(Connection conn);
	
	/**
	 * 파티방 나가기(DB삭제)
	 * 
	 * @param conn - DB연결 객체
	 * @param partyCheck - 나갈 파티방 번호
	 * @return delete 수행 결과
	 */
	public int delete(Connection conn, PartyCheck partyCheck);

	
	/**
	 * 파티 테이블 파티장 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @return List<PartyCheck> - 테이블 전체 조회 목록
	 */
	public List<PartyCheck> selectOwner(Connection conn);

	
	/**
	 * userid를 이용해 회원정보 조회하기
	 * 
	 * @param conn - DB연결 객체
	 * @param member - 조회할 userid를 가진 객체
	 * @return Member - 조회된 회원 정보
	 */
	public Member selectMemberInfo(Connection conn, MypageMember mypageMember);



}
