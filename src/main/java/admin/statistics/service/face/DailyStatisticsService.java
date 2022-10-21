package admin.statistics.service.face;

public interface DailyStatisticsService {
	
	/**
	 * 당일 개설된 넷플릭스 파티의 수를 구한다.
	 * 
	 * @return 당일 개설된 넷플릭스 파티 수
	 */
	public int getCntNetflix();
	
	/**
	 * 당일 개설된 디즈니플러스 파티의 수를 구한다.
	 * 
	 * @return 당일 개설된 디즈니플러스 파티 수
	 */
	public int getCntDisney();
	
	/**
	 * 당일 개설된 티빙 파티의 수를 구한다.
	 * 
	 * @return 당일 개설된 티빙 파티 수
	 */
	public int getCntTving();
	
	/**
	 * 당일 개설된 애플 파티의 수를 구한다.
	 * 
	 * @return 당일 개설된 애플 파티 수
	 */
	public int getCntApple();
	
	/**
	 * 당일 개설된 웨이브 파티의 수를 구한다.
	 * 
	 * @return 당일 개설된 웨이브 파티 수
	 */
	public int getCntWave();
	
	/**
	 * 당일 개설된 왓챠 파티의 수를 구한다.
	 * 
	 * @return 당일 개설된 왓챠 파티 수
	 */
	public int getCntWatcha();
	
	/**
	 * 당일 개설된 라프텔 파티의 수를 구한다.
	 * 
	 * @return 당일 개설된 라프텔 파티 수
	 */
	public int getCntLaftel();

	/**
	 * 당일 신규 가입한 회원 수를 구한다. 
	 * 
	 * @return 당일 신규 가입 회원 수
	 */
	public int getCntDNuser();

	/**
	 * 당일 탈퇴한 회원 수를 구한다. 
	 * 
	 * @return 당일 탈퇴 회원 수
	 */
	public int getCntDDuser();

	/**
	 * 당일 생성된 파티 수를 구한다. 
	 * 
	 * @return 당일 생성된 파티 수
	 */
	public int getCntDPartyCre();

	/**
	 * 당일 종료된 파티 수를 구한다. 
	 * 
	 * @return 당일 종료된 파티 수
	 */
	public int getCntDPartyEnd();

}
