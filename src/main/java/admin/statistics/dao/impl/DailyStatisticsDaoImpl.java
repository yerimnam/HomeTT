package admin.statistics.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import admin.statistics.dao.face.DailyStatisticsDao;
import common.JDBCTemplate;

public class DailyStatisticsDaoImpl implements DailyStatisticsDao {
	
	private PreparedStatement ps; // SQL수행 객체
	private ResultSet rs; //SQL조회 결과 객체
	
	@Override
	public int selectCntNetflix(Connection conn) {
		String sql = "";
		sql += "SELECT count(*) cnt FROM party";
		sql += " WHERE party_kind ='넷플릭스' AND TO_CHAR(party_creDate, 'YY/MM/DD') = TO_CHAR(SYSDATE, 'YY/MM/DD')";
		
		//넷플릭스 파티방 수
		int count = 0;
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			rs = ps.executeQuery(); //SQL 수행 및 결과 집합 저장
			
			while( rs.next() ) {
				count = rs.getInt("cnt");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		System.out.println("selectCntNetflix() 수행 결과 : " + count);
		return count;
	}
	
	@Override
	public int updateCntNetflix(Connection conn, int netflix) {
		
		String sql = "";
		sql += "UPDATE dailypartystatistics";
		sql += " SET daily_partycnt = ?";
		sql += " WHERE daily_partykind IN ('넷플릭스')";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, netflix);
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		System.out.println("updateCntNetflix() 수행 결과 : " + res);
		return res;
	}
	
	@Override
	public int selectCntDisney(Connection conn) {
		String sql = "";
		sql += "SELECT count(*) cnt FROM party";
		sql += " WHERE party_kind='디즈니플러스' AND TO_CHAR(party_creDate, 'YY/MM/DD') = TO_CHAR(SYSDATE, 'YY/MM/DD')";
		
		//디즈니플러스 파티방 수
		int count = 0;
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			rs = ps.executeQuery(); //SQL 수행 및 결과 집합 저장
			
			while( rs.next() ) {
				count = rs.getInt("cnt");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		System.out.println("selectCntDisney() 수행 결과 : " + count);
		return count;
	}
	
	@Override
	public int updateCntDisney(Connection conn, int disney) {
		
		String sql = "";
		sql += "UPDATE dailypartystatistics";
		sql += " SET daily_partycnt = ?";
		sql += " WHERE daily_partykind = '디즈니플러스'";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, disney);
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		System.out.println("updateCntDisney() 수행 결과 : " + res);
		return res;
	}
	
	@Override
	public int selectCntTving(Connection conn) {
		String sql = "";
		sql += "SELECT count(*) cnt FROM party";
		sql += " WHERE party_kind='티빙' AND TO_CHAR(party_creDate, 'YY/MM/DD') = TO_CHAR(SYSDATE, 'YY/MM/DD')";
		
		//티빙 파티방 수
		int count = 0;
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			rs = ps.executeQuery(); //SQL 수행 및 결과 집합 저장
			
			while( rs.next() ) {
				count = rs.getInt("cnt");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		System.out.println("selectCntTving() 수행 결과 : " + count);
		return count;
	}
	
	@Override
	public int updateCntTving(Connection conn, int tving) {
		
		String sql = "";
		sql += "UPDATE dailypartystatistics";
		sql += " SET daily_partycnt = ?";
		sql += " WHERE daily_partykind = '티빙'";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, tving);
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		System.out.println("updateCntTving() 수행 결과 : " + res);
		return res;
	}
	
	@Override
	public int selectCntApple(Connection conn) {
		String sql = "";
		sql += "SELECT count(*) cnt FROM party";
		sql += " WHERE party_kind='애플' AND TO_CHAR(party_creDate, 'YY/MM/DD') = TO_CHAR(SYSDATE, 'YY/MM/DD')";
		
		//애플 파티방 수
		int count = 0;
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			rs = ps.executeQuery(); //SQL 수행 및 결과 집합 저장
			
			while( rs.next() ) {
				count = rs.getInt("cnt");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		System.out.println("selectCntApple() 수행 결과 : " + count);
		return count;
	}
	
	@Override
	public int updateCntApple(Connection conn, int apple) {
		
		String sql = "";
		sql += "UPDATE dailypartystatistics";
		sql += " SET daily_partycnt = ?";
		sql += " WHERE daily_partykind = '애플'";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, apple);
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		System.out.println("updateCntApple() 수행 결과 : " + res);
		return res;
	}
	
	@Override
	public int selectCntWave(Connection conn) {
		String sql = "";
		sql += "SELECT count(*) cnt FROM party";
		sql += " WHERE party_kind='웨이브' AND TO_CHAR(party_creDate, 'YY/MM/DD') = TO_CHAR(SYSDATE, 'YY/MM/DD')";
		
		//웨이브 파티방 수
		int count = 0;
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			rs = ps.executeQuery(); //SQL 수행 및 결과 집합 저장
			
			while( rs.next() ) {
				count = rs.getInt("cnt");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		System.out.println("selectCntWave() 수행 결과 : " + count);
		return count;
	}
	
	@Override
	public int updateCntWave(Connection conn, int wave) {
		
		String sql = "";
		sql += "UPDATE dailypartystatistics";
		sql += " SET daily_partycnt = ?";
		sql += " WHERE daily_partykind = '웨이브'";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, wave);
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		System.out.println("updateCntWave() 수행 결과 : " + res);
		return res;
	}
	
	@Override
	public int selectCntWatcha(Connection conn) {
		String sql = "";
		sql += "SELECT count(*) cnt FROM party";
		sql += " WHERE party_kind='왓챠' AND TO_CHAR(party_creDate, 'YY/MM/DD') = TO_CHAR(SYSDATE, 'YY/MM/DD')";
		
		//왓챠 파티방 수
		int count = 0;
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			rs = ps.executeQuery(); //SQL 수행 및 결과 집합 저장
			
			while( rs.next() ) {
				count = rs.getInt("cnt");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		System.out.println("selectCntWatcha() 수행 결과 : " + count);
		return count;
	}
	
	@Override
	public int updateCntWatcha(Connection conn, int whtcha) {
		
		String sql = "";
		sql += "UPDATE dailypartystatistics";
		sql += " SET daily_partycnt = ?";
		sql += " WHERE daily_partykind = '왓챠'";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, whtcha);
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		System.out.println("updateCntWatcha() 수행 결과 : " + res);
		return res;
	}
	
	@Override
	public int selectCntLaftel(Connection conn) {
		String sql = "";
		sql += "SELECT count(*) cnt FROM party";
		sql += " WHERE party_kind='라프텔' AND TO_CHAR(party_creDate, 'YY/MM/DD') = TO_CHAR(SYSDATE, 'YY/MM/DD')";
		
		//라프텔 파티방 수
		int count = 0;
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			rs = ps.executeQuery(); //SQL 수행 및 결과 집합 저장
			
			while( rs.next() ) {
				count = rs.getInt("cnt");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		System.out.println("selectCntLaftel() 수행 결과 : " + count);
		return count;
	}
	
	@Override
	public int updateCntLaftel(Connection conn, int laftel) {
		
		String sql = "";
		sql += "UPDATE dailypartystatistics";
		sql += " SET daily_partycnt = ?";
		sql += " WHERE daily_partykind = '라프텔'";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, laftel);
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		System.out.println("updateCntLaftel() 수행 결과 : " + res);
		return res;
	}
	
	@Override
	public int selectCntNuser(Connection conn) {
		String sql = "";
		sql += "SELECT count(*) cnt FROM member";
		sql += " WHERE TO_CHAR(user_join, 'YY/MM/DD') = TO_CHAR(SYSDATE, 'YY/MM/DD')";
		
		//당일 가입한 회원 수
		int count = 0;
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			rs = ps.executeQuery(); //SQL 수행 및 결과 집합 저장
			
			while( rs.next() ) {
				count = rs.getInt("cnt");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		System.out.println("selectCntNuser() 수행 결과 : " + count);
		return count;
	}
	
	@Override
	public int updateCntNuser(Connection conn, int nuser) {
		String sql = "";
		sql += "UPDATE dailyetcstatistics";
		sql += " SET daily_joinuser = ?";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, nuser);
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		System.out.println("updateCntNuser() 수행 결과 : " + res);
		return res;
	}
	
	@Override
	public int selectCntDuser(Connection conn) {
		String sql = "";
		sql += "SELECT count(*) cnt FROM secede_member";
		sql += " WHERE TO_CHAR(Secede_date, 'YY/MM/DD') = TO_CHAR(SYSDATE, 'YY/MM/DD')";
		
		//당일 탈퇴한 회원 수
		int count = 0;
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			rs = ps.executeQuery(); //SQL 수행 및 결과 집합 저장
			
			while( rs.next() ) {
				count = rs.getInt("cnt");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		System.out.println("selectCntDuser() 수행 결과 : " + count);
		return count;
	}
	
	@Override
	public int updateCntDuser(Connection conn, int duser) {
		String sql = "";
		sql += "UPDATE dailyetcstatistics";
		sql += " SET daily_dorpuser = ?";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, duser);
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		System.out.println("updateCntDuser() 수행 결과 : " + res);
		return res;
	}
	
	@Override
	public int selectCntPartyCre(Connection conn) {
		String sql = "";
		sql += "SELECT count(*) cnt FROM party";
		sql += " WHERE TO_CHAR(party_creDate, 'YY/MM/DD') = TO_CHAR(SYSDATE, 'YY/MM/DD')";
		
		//당일 생성된 파티 수
		int count = 0;
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			rs = ps.executeQuery(); //SQL 수행 및 결과 집합 저장
			
			while( rs.next() ) {
				count = rs.getInt("cnt");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		System.out.println("selectCntPartyCre() 수행 결과 : " + count);
		return count;
	}
	
	@Override
	public int updateCntPartyCre(Connection conn, int partyCre) {
		String sql = "";
		sql += "UPDATE dailyetcstatistics";
		sql += " SET daily_newparty = ?";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, partyCre);
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		System.out.println("updateCntPartyCre() 수행 결과 : " + res);
		return res;
	}
	
	@Override
	public int selectCntPartyEnd(Connection conn) {
		String sql = "";
		sql += "SELECT count(*) cnt FROM party";
		sql += " WHERE TO_CHAR(party_endDate, 'YY/MM/DD') = TO_CHAR(SYSDATE, 'YY/MM/DD')";
		
		//당일 종료된 파티 수
		int count = 0;
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			rs = ps.executeQuery(); //SQL 수행 및 결과 집합 저장
			
			while( rs.next() ) {
				count = rs.getInt("cnt");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		System.out.println("selectCntPartyEnd() 수행 결과 : " + count);
		return count;
	}
	
	@Override
	public int updateCntPartyEnd(Connection conn, int partyEnd) {
		String sql = "";
		sql += "UPDATE dailyetcstatistics";
		sql += " SET daily_endparty = ?";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, partyEnd);
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		System.out.println("updateCntPartyEnd() 수행 결과 : " + res);
		return res;
	}
	
}
