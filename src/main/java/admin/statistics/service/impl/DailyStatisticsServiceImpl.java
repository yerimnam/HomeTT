package admin.statistics.service.impl;

import java.sql.Connection;

import admin.statistics.dao.face.DailyStatisticsDao;
import admin.statistics.dao.impl.DailyStatisticsDaoImpl;
import admin.statistics.service.face.DailyStatisticsService;
import common.JDBCTemplate;

public class DailyStatisticsServiceImpl implements DailyStatisticsService {
	
	private DailyStatisticsDao dailyStatisticsDao = new DailyStatisticsDaoImpl(); 
	
	@Override
	public int getCntNetflix() {
		System.out.println("getCntnetflix() - 시작");
		//DB연결 객체
		Connection conn = JDBCTemplate.getConnection();
		
		//개설된 넷플릭스 파티방 조회
		int netflix = dailyStatisticsDao.selectCntNetflix(conn);
		
		//DB에 조회된 파티 방 저장
		if( dailyStatisticsDao.updateCntNetflix(conn, netflix) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		System.out.println("getCntnetflix() - 종료");
		//조회된 넷플릭스 파티방 수 리턴
		return netflix;
		
	}
	
	@Override
	public int getCntDisney() {
		
		//DB연결 객체
		Connection conn = JDBCTemplate.getConnection();
		
		//개설된 디즈니플러스 파티방 조회
		int disney = dailyStatisticsDao.selectCntDisney(conn);
		
		//DB에 조회된 파티 방 저장
		if( dailyStatisticsDao.updateCntDisney(conn, disney) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		//조회된 디즈니플러스 파티방 수 리턴
		return disney;
		
	}
	
	@Override
	public int getCntTving() {
		
		//DB연결 객체
		Connection conn = JDBCTemplate.getConnection();
		
		//개설된 티빙 파티방 조회
		int tving = dailyStatisticsDao.selectCntTving(conn);
		
		//DB에 조회된 파티 방 저장
		if( dailyStatisticsDao.updateCntTving(conn, tving) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		//조회된 티빙 파티방 수 리턴
		return tving;
		
	}
	
	@Override
	public int getCntApple() {
		
		//DB연결 객체
		Connection conn = JDBCTemplate.getConnection();
		
		//개설된 애플 파티방 조회
		int apple = dailyStatisticsDao.selectCntApple(conn);
		
		//DB에 조회된 파티 방 저장
		if( dailyStatisticsDao.updateCntApple(conn, apple) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		//조회된 애플 파티방 수 리턴
		return apple;
		
	}
	
	@Override
	public int getCntWave() {
		
		//DB연결 객체
		Connection conn = JDBCTemplate.getConnection();
		
		//개설된 웨이브 파티방 조회
		int wave = dailyStatisticsDao.selectCntWave(conn);
		
		//DB에 조회된 파티 방 저장
		if( dailyStatisticsDao.updateCntWave(conn, wave) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		//조회된 웨이브 파티방 수 리턴
		return wave;
		
	}
	
	@Override
	public int getCntWatcha() {
		
		//DB연결 객체
		Connection conn = JDBCTemplate.getConnection();
		
		//개설된 왓챠 파티방 조회
		int watcha = dailyStatisticsDao.selectCntWatcha(conn);
		
		//DB에 조회된 파티 방 저장
		if( dailyStatisticsDao.updateCntWatcha(conn, watcha) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		//조회된 왓챠 파티방 수 리턴
		return watcha;
		
	}
	
	@Override
	public int getCntLaftel() {
		
		//DB연결 객체
		Connection conn = JDBCTemplate.getConnection();
		
		//개설된 라프텔 파티방 조회
		int laftel = dailyStatisticsDao.selectCntLaftel(conn);
		
		//DB에 조회된 파티 방 저장
		if( dailyStatisticsDao.updateCntLaftel(conn, laftel) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		//조회된 라프텔 파티방 수 리턴
		return laftel;
		
	}

	@Override
	public int getCntDNuser() {
		//DB연결 객체
		Connection conn = JDBCTemplate.getConnection();
		
		//당일 가입한 회원 조회
		int nuser = dailyStatisticsDao.selectCntNuser(conn);
		
		//DB에 당일 가입한 회원 수 저장 
		if( dailyStatisticsDao.updateCntNuser(conn, nuser) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		//조회된 당일 가입한 회원 수 리턴
		return nuser;
	}
	
	@Override
	public int getCntDDuser() {
		//DB연결 객체
		Connection conn = JDBCTemplate.getConnection();
		
		//당일 탈퇴한 회원 조회
		int duser = dailyStatisticsDao.selectCntDuser(conn);
		
		//DB에 당일 탈퇴한 회원 수 저장 
		if( dailyStatisticsDao.updateCntDuser(conn, duser) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		//조회된 당일 탈퇴한 회원 수 리턴
		return duser;
	}
	
	@Override
	public int getCntDPartyCre() {
		//DB연결 객체
		Connection conn = JDBCTemplate.getConnection();
		
		//당일 생성된 파티 조회
		int partyCre = dailyStatisticsDao.selectCntPartyCre(conn);
		
		//DB에 당일 생성된 파티 수 저장 
		if( dailyStatisticsDao.updateCntPartyCre(conn, partyCre) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		//조회된 당일 생성된 파티 수 리턴
		return partyCre;
	}
	
	@Override
	public int getCntDPartyEnd() {
		//DB연결 객체
		Connection conn = JDBCTemplate.getConnection();
		
		//당일 종료된 파티 조회
		int partyEnd = dailyStatisticsDao.selectCntPartyEnd(conn);
		
		//DB에 당일 종료된 파티 수 저장 
		if( dailyStatisticsDao.updateCntPartyEnd(conn, partyEnd) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		//조회된 당일 종료된 파티 수 리턴
		return partyEnd;
	}
	
}