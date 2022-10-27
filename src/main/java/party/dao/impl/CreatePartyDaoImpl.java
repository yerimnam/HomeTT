package party.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import common.JDBCTemplate;
import party.dao.face.CreatePartyDao;
import party.dto.Party;
import user.dto.Member;

public class CreatePartyDaoImpl implements CreatePartyDao {
	
	private PreparedStatement ps;	//sql 수행할 객체
	private ResultSet rs;	//조회 결과 객체

	
	//시퀀스 설정하기
	@Override
	public int selectNextPartyno(Connection conn) {
		
		String sql = "SELECT party_seq.nextval FROM dual";
		
		//시퀀스 nextval 저장할 변수
		int nextpartyno = 0;
		
		try {
			ps = conn.prepareStatement(sql);	
			
			rs = ps.executeQuery();
			
			rs.next();
			
//			nextpartyno = rs.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
	
		return nextpartyno;
	}
	
	@Override
	public Member selectUserinfo(Connection conn, int userno) {
		System.out.println("CreatePartyDaoImpl selectUser() - 시작");
		
		String sql ="";
		sql +="SELECT";
		sql +=" user_no, user_id, user_name";
		sql +=" FROM member";
		sql +=" WHERE user_no =?";
		
		//조회 결과 저장 객체  
		Member userinfo = new Member();
		try {
			
			//sql수행 객체 생성
			 ps = conn.prepareStatement(sql);
			 ps.setInt(1, userno);
			 //수행 결과 저장
			 rs = ps.executeQuery();
			 
			 //조회 결과 처리 
			 while(rs.next()) {
				 userinfo.setUserNo(rs.getInt("user_no"));
				 userinfo.setUserId(rs.getString("user_id"));
				 userinfo.setUserName(rs.getString("user_name"));
			 }
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
			
		}
		
		System.out.println("CreatePartyDaoImpl selectUser() - 끝");
		return  userinfo;
	}
	
	
	@Override
	public int insert(Connection conn, Party party) {
		System.out.println("CreatePartyDaoImpl insert() - 시작");
		
		
		//작성할 값 전부 적어야 함
		String sql ="";
		sql += "INSERT INTO party";
		sql	+= " ( party_no, party_name, user_no, party_kind, party_leader, party_rule, party_member, paymentamount, party_enddate )";
		sql += " VALUES ( party_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ? )";
		
		int result = 0;
		
		try {
			
			//sql 수행 객체 생성
			ps= conn.prepareStatement(sql);
			
			ps.setString(1, party.getPartyName());
			ps.setInt(2, party.getUserNo());
			ps.setString(3, party.getPartyKind());
			ps.setString(4, party.getPartyLeader());
			ps.setString(5, party.getPartyRule());
			ps.setInt(6, party.getPartyMember());
			ps.setInt(7, party.getPaymentAmount());
			ps.setDate(8, new java.sql.Date(party.getPartyEndDate().getTime()));
			

			//수행 결과 저장
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
