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
	public int selectNextUserno(Connection conn) {
		
		String sql = "SELECT party_seq.nextval FROM dual";
		
		//시퀀스 nextval 저장할 변수
		int nextval = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			rs.next();
			
			nextval = rs.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
	
		return nextval;
	}
	
	@Override
	public int insert(Connection conn, Party party) {
		System.out.println("CreatePartyDaoImpl insert() - 시작");
		
		
		//insert 쿼리 작성하기 
		String sql ="";
		sql += "INSERT INTO party ( party_no, paty_name, party_kind, party_rule)";
		sql += " VALUES (?, ?, ?, ?)";
		
		int res = 0;
		
		try {
			
			ps= conn.prepareStatement(sql);
			
			ps.setInt(1, party.getPartyNo());
			ps.setString(2, party.getPartyName());
			ps.setString(3, party.getPartyKind());
			ps.setString(4, party.getPartyRule());

			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		System.out.println("CreatePartyDaoImpl insert() - 끝");
		return res;
	}







	

}
