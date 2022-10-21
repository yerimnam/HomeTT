package party.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import party.dao.face.CreatePartyDao;
import party.dto.Party;

public class CreatePartyDaoImpl implements CreatePartyDao {
	
	private PreparedStatement ps;
	private ResultSet rs;

	@Override
	public int selectNextPartyno(Connection conn) {
		
		String sql = "SELECT party_seq.nextval FROM dual";
		
		//시퀀스 nextval 저장할 변수
		int nextpartyno = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			rs.next();
			
			nextpartyno = rs.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
	
		return nextpartyno;
	}
	
	@Override
	public int insert(Connection conn, Party party) {
		System.out.println("CreatePartyDaoImpl insert() - 시작");
		
		
		//insert 쿼리 작성하기
		
		//작성할 값 전부 적어야 함
		String sql ="";
		sql += "INSERT INTO party ( PARTY_NO, PARTY_NAME, PARTY_RULE , PARTY_MEMBER)";
		sql += " VALUES (?, ?, ?, ?)";
		
		int result = 0;
		
		try {
			
			ps= conn.prepareStatement(sql);
			
			ps.setInt(1, party.getPartyNo());
			ps.setString(2, party.getPartyName());
			ps.setString(3, party.getPartyKind());
			ps.setString(4, party.getPartyRule());
			ps.setInt(5, party.getPartyMember());

			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		System.out.println("CreatePartyDaoImpl insert() - 끝");
		return result;
	}


}
