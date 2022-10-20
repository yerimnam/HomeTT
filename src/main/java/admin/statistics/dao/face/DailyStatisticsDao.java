package admin.statistics.dao.face;

import java.sql.Connection;

public interface DailyStatisticsDao {
	
	/**
	 * 당일 개설된 넷플릭스 파티 방 수 조회
	 * 
	 * @param connection - DB 연결 객체
	 * @return 당일 개설된 넷플릭스 파티 방 수 
	 */
	public int selectCntNetflix(Connection connection);
	
	/**
	 * 당일 개설된 넷플릭스 파티 방 수 DB에 저장
	 * 
	 * @param connection - DB 연결 객체
	 * @param netflix 당일 개설된 넷플릭스 파티 방 수
	 * @return update쿼리 수행 결과
	 */
	public int updateCntNetflix(Connection conn, int netflix);
	
	/**
	 * 당일 개설된 디즈니플러스 파티 방 수 조회
	 * 
	 * @param connection - DB 연결 객체
	 * @return 당일 개설된 디즈니플러스 파티 방 수 
	 */
	public int selectCntDisney(Connection connection);
	
	/**
	 * 당일 개설된 디즈니플러스 파티 방 수 DB에 저장
	 * 
	 * @param connection - DB 연결 객체
	 * @param disney 당일 개설된 디즈니플러스 파티 방 수
	 * @return update쿼리 수행 결과
	 */
	public int updateCntDisney(Connection conn, int disney);
	
	/**
	 * 당일 개설된 티빙 파티 방 수 조회
	 * 
	 * @param connection - DB 연결 객체
	 * @return 당일 개설된 티빙 파티 방 수 
	 */
	public int selectCntTving(Connection connection);
	
	/**
	 * 당일 개설된 티빙 파티 방 수 DB에 저장
	 * 
	 * @param connection - DB 연결 객체
	 * @param tving 당일 개설된 티빙 파티 방 수
	 * @return update쿼리 수행 결과
	 */
	public int updateCntTving(Connection conn, int tving);
	
	/**
	 * 당일 개설된 애플 파티 방 수 조회
	 * 
	 * @param connection - DB 연결 객체
	 * @return 당일 개설된 애플 파티 방 수 
	 */
	public int selectCntApple(Connection connection);
	
	/**
	 * 당일 개설된 애플 파티 방 수 DB에 저장
	 * 
	 * @param connection - DB 연결 객체
	 * @param apple 당일 개설된 애플 파티 방 수
	 * @return update쿼리 수행 결과
	 */
	public int updateCntApple(Connection conn, int apple);
	
	/**
	 * 당일 개설된 웨이브 파티 방 수 조회
	 * 
	 * @param connection - DB 연결 객체
	 * @return 당일 개설된 웨이브 파티 방 수 
	 */
	public int selectCntWave(Connection connection);
	
	/**
	 * 당일 개설된 웨이브 파티 방 수 DB에 저장
	 * 
	 * @param connection - DB 연결 객체
	 * @param wave 당일 개설된 웨이브 파티 방 수
	 * @return update쿼리 수행 결과
	 */
	public int updateCntWave(Connection conn, int wave);
	
	/**
	 * 당일 개설된 왓챠 파티 방 수 조회
	 * 
	 * @param connection - DB 연결 객체
	 * @return 당일 개설된 왓챠 파티 방 수 
	 */
	public int selectCntWatcha(Connection connection);
	
	/**
	 * 당일 개설된 왓챠 파티 방 수 DB에 저장
	 * 
	 * @param connection - DB 연결 객체
	 * @param Watcha 당일 개설된 왓챠 파티 방 수
	 * @return update쿼리 수행 결과
	 */
	public int updateCntWatcha(Connection conn, int watcha);
	
	/**
	 * 당일 개설된 라프텔 파티 방 수 조회
	 * 
	 * @param connection - DB 연결 객체
	 * @return 당일 개설된 라프텔 파티 방 수 
	 */
	public int selectCntLaftel(Connection connection);
	
	/**
	 * 당일 개설된 라프텔 파티 방 수 DB에 저장
	 * 
	 * @param connection - DB 연결 객체
	 * @param Laftel 당일 개설된 라프텔 파티 방 수
	 * @return update쿼리 수행 결과
	 */
	public int updateCntLaftel(Connection conn, int laftel);

	/**
	 * 당일 가입한 회원 수 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @return 당일 가입한 회원 수
	 */
	public int selectCntNuser(Connection conn);

	/**
	 * 당일 가입한 회원 수 DB에 저장
	 * 
	 * @param conn - DB 연결 객체
	 * @param nuser - 당일 가입한 회원 수
	 * @return update쿼리 수행 결과
	 */
	public int updateCntNuser(Connection conn, int nuser);

	/**
	 * 당일 탈퇴한 회원 수 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @return 당일 탈퇴한 회원 수
	 */
	public int selectCntDuser(Connection conn);

	/**
	 * 당일 탈퇴한 회원 수 DB에 저장
	 * 
	 * @param conn - DB 연결 객체
	 * @param nuser - 당일 탈퇴한 회원 수
	 * @return update쿼리 수행 결과
	 */
	public int updateCntDuser(Connection conn, int duser);

	/**
	 * 당일 생성된 파티 수 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @return 당일 생성된 파티 수
	 */
	public int selectCntPartyCre(Connection conn);

	/**
	 * 당일 생성된 파티 수 DB에 저장
	 * 
	 * @param conn - DB 연결 객체
	 * @param nuser - 당일 생성된 파티 수
	 * @return update쿼리 수행 결과
	 */
	public int updateCntPartyCre(Connection conn, int partyCre);

	/**
	 * 당일 종료된 파티 수 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @return 당일 종료된 파티 수
	 */
	public int selectCntPartyEnd(Connection conn);

	/**
	 * 당일 종료된 파티 수 DB에 저장
	 * 
	 * @param conn - DB 연결 객체
	 * @param nuser - 당일 종료된 파티 수
	 * @return update쿼리 수행 결과
	 */
	public int updateCntPartyEnd(Connection conn, int partyEnd);
	
}
