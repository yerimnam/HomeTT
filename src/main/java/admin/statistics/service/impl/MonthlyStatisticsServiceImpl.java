package admin.statistics.service.impl;

import java.sql.Connection;

import admin.statistics.dao.face.MonthlyStatisticsDao;
import admin.statistics.dao.impl.MonthlyStatisticsDaoImpl;
import admin.statistics.service.face.MonthlyStatisticsService;
import common.JDBCTemplate;

public class MonthlyStatisticsServiceImpl implements MonthlyStatisticsService {
	
private MonthlyStatisticsDao monthlyStatisticsDao = new MonthlyStatisticsDaoImpl(); 
	
	@Override
	public int getCntNetflix() {
		System.out.println("getCntnetflix() - 시작");
		//DB연결 객체
		Connection conn = JDBCTemplate.getConnection();
		
		//개설된 넷플릭스 파티방 조회
		int netflix = monthlyStatisticsDao.selectCntNetflix(conn);
		
		//DB에 조회된 파티 방 저장
		if( monthlyStatisticsDao.updateCntNetflix(conn, netflix) > 0 ) {
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
		int disney = monthlyStatisticsDao.selectCntDisney(conn);
		
		//DB에 조회된 파티 방 저장
		if( monthlyStatisticsDao.updateCntDisney(conn, disney) > 0 ) {
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
		int tving = monthlyStatisticsDao.selectCntTving(conn);
		
		//DB에 조회된 파티 방 저장
		if( monthlyStatisticsDao.updateCntTving(conn, tving) > 0 ) {
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
		int apple = monthlyStatisticsDao.selectCntApple(conn);
		
		//DB에 조회된 파티 방 저장
		if( monthlyStatisticsDao.updateCntApple(conn, apple) > 0 ) {
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
		int wave = monthlyStatisticsDao.selectCntWave(conn);
		
		//DB에 조회된 파티 방 저장
		if( monthlyStatisticsDao.updateCntWave(conn, wave) > 0 ) {
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
		int watcha = monthlyStatisticsDao.selectCntWatcha(conn);
		
		//DB에 조회된 파티 방 저장
		if( monthlyStatisticsDao.updateCntWatcha(conn, watcha) > 0 ) {
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
		int laftel = monthlyStatisticsDao.selectCntLaftel(conn);
		
		//DB에 조회된 파티 방 저장
		if( monthlyStatisticsDao.updateCntLaftel(conn, laftel) > 0 ) {
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
		int nuser = monthlyStatisticsDao.selectCntNuser(conn);
		
		//DB에 당일 가입한 회원 수 저장 
		if( monthlyStatisticsDao.updateCntNuser(conn, nuser) > 0 ) {
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
		int duser = monthlyStatisticsDao.selectCntDuser(conn);
		
		//DB에 당일 탈퇴한 회원 수 저장 
		if( monthlyStatisticsDao.updateCntDuser(conn, duser) > 0 ) {
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
		int partyCre = monthlyStatisticsDao.selectCntPartyCre(conn);
		
		//DB에 당일 생성된 파티 수 저장 
		if( monthlyStatisticsDao.updateCntPartyCre(conn, partyCre) > 0 ) {
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
		int partyEnd = monthlyStatisticsDao.selectCntPartyEnd(conn);
		
		//DB에 당일 종료된 파티 수 저장 
		if( monthlyStatisticsDao.updateCntPartyEnd(conn, partyEnd) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		//조회된 당일 종료된 파티 수 리턴
		return partyEnd;
	}
	
}
