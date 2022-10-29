package payment.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import party.dto.Party;
import party.dto.PartyRoom;
import payment.dao.face.PaymentDao;
import payment.dto.Payment;
import user.dto.Member;

public class PaymentDaoImpl implements PaymentDao {

	private PreparedStatement ps; // SQL 수행 객체
	private ResultSet rs; // SQL 결과

	@Override
	public Member selectUserInfo(Connection conn, int userno) {
		System.out.println("SelectuserInf- start"); 
		String sql = "";
		sql += "SELECT user_no,user_id,user_name,user_email,user_phone";
		sql += " FROM member";
		sql += " WHERE user_no =?";

		// 조회 결과 저장할 객체

		Member userinfo = new Member();
		try {
			// sql수행 객체 생성
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userno);
			// 수행 결과 저장
			rs = ps.executeQuery();

			// 조회 결과 처리
			while (rs.next()) {
				userinfo.setUserNo(rs.getInt("user_no"));
				userinfo.setUserId(rs.getString("user_id"));
				userinfo.setUserName(rs.getString("user_name"));
				userinfo.setUserEmail(rs.getString("user_email"));
				userinfo.setUserPhone(rs.getInt("user_phone"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);

		}

		System.out.println("SelectuserInf- end");
		return userinfo;
	}

	@Override
	public Party selectPartyInfo(Connection conn, int partyno) {
		System.out.println("selectPartyInfo-start");
		String sql = "";
		sql += "SELECT party_no,user_no,paymentAmount,party_name,party_leader";
		sql += " FROM party";
		sql += " WHERE party_no =?";

		Party party = new Party();

		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, partyno);

			rs = ps.executeQuery();

			while (rs.next()) { 

				party.setPartyNo(rs.getInt("party_no"));
				party.setUserNo(rs.getInt("user_no"));
				party.setPaymentAmount(rs.getInt("paymentAmount"));
				party.setPartyName(rs.getString("party_name"));
				party.setPartyLeader(rs.getString("party_leader"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);

		}

		System.out.println("selectPartyInfo-end");
		return party;
	}

	@Override
	public int insertPayment(Connection conn, Payment returnData) {

		System.out.println("insertPayment -start");
		System.out.println("returnData : " + returnData);
		String sql = "";
		sql += "INSERT INTO payment (pay_no, order_no, user_no, party_no, paymentmethod,user_cardcom, payment_amount,payment_date)";
		sql += " values(?,?,?,?,?,?,?,sysdate)";

		// insert 결과 변수
		int result = 0;

		try {
			ps = conn.prepareStatement(sql);

			ps.setString(1, returnData.getPayNo());
			ps.setString(2, returnData.getOrderNo());
			ps.setInt(3, returnData.getUserNo());
			ps.setInt(4, returnData.getPartyNo());
			ps.setString(5, returnData.getPaymentMethod());
//			ps.setInt(6, returnData.getUserCardno());
			ps.setString(6, returnData.getUserCardCom());
			ps.setInt(7, returnData.getPaymentAmount());

			//

			// 나중에 카드번호,.카드 유효기간 카드사 ,넣는 코드 작성하기
			result = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		System.out.println("insert-payment-end");
		System.out.println("result : " + result);
		return result;
	}

	@Override
	public Payment selectpayresult(Connection conn, Payment payinsert) {

		System.out.println("selectpay result -strat");
		String sql = "";
		
		sql +="SELECT p.party_no,a.party_name, p.payment_amount,p.user_cardcom,m.user_name,m.user_nick,m.user_email,p.payment_date ";
		sql +=" FROM member m";
		sql +=" inner join  payment p";
		sql +=" on  p.user_no = m.user_no";
		sql +="    inner join party a";
		sql +="     on  p.party_no = a.party_no ";
		sql +="  where p.party_no =?"  ;     
		  //-----------------------------------------------------------------------------------------   
//		sql += "SELECT p.party_no,p.payment_amount,p.user_cardcom,m.user_name,m.user_nick,m.user_email,p.payment_date FROM payment p";
//		sql += " INNER JOIN member m";
//		sql += " on p.user_no = m.user_no";
//		sql += " WHERE p.party_no =?";
//
//		//파티이름 조회하여 반환
//		String sql_two = "";
//		sql_two += "SELECT a.party_name FROM party a";
//		sql_two += " INNER JOIN payment p";
//		sql_two += " on p.party_no = a.party_no";
//		sql_two += " WHERE p.party_no =?";

		Payment payresult = new Payment();
		try {
			ps = conn.prepareStatement(sql);
		

			ps.setInt(1, payinsert.getPartyNo());
			

			rs = ps.executeQuery();
			while (rs.next()) {
				payresult.setPartyNo(rs.getInt("party_no"));
				payresult.setPaymentAmount(rs.getInt("payment_amount"));
				payresult.setUserCardCom(rs.getString("user_cardcom"));
				payresult.setUserName(rs.getString("user_name"));
				payresult.setUserNick(rs.getString("user_nick"));
				payresult.setUserEmail(rs.getString("user_email"));
				payresult.setPaymentDate(rs.getDate("payment_date"));
				payresult.setPartyName(rs.getString("party_name"));
			}

			
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}

		System.out.println("selectpay result -end");
		return payresult;
	}

	// @@@@@@@@파티부분@@@@@@@@
	@Override
	public int insertPartyM(Connection conn, Payment returnData) {
		String sql = "";
		sql += "INSERT INTO party_room(party_room_no, user_no, party_no)";
		sql += " values(? ,?, ?)";

		PartyRoom partyRoom = new PartyRoom();
		
		int result = 0;

		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, partyRoom.getParty_room_no());
			ps.setInt(2, returnData.getUserNo());
			ps.setInt(3, returnData.getPartyNo());

			result = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			JDBCTemplate.close(ps);

		}
		return result;

	}
}
