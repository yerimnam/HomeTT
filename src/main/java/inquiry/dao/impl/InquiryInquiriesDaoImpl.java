package inquiry.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import inquiry.dao.face.InquiryInquiriesDao;
import inquiry.dto.InquiryBoard;
import util.Paging;

public class InquiryInquiriesDaoImpl implements InquiryInquiriesDao {
	
		private PreparedStatement ps;
		private ResultSet rs;
		
		
		
		@Override
		public int selectCntAll(Connection conn,int userNo) {

			System.out.println("selectCntAll -Start");
			String sql  ="";
			sql += "SELECT count(*) cnt FROM cs_inquiry";
			sql +=" WHERE user_no =?";
			
			//총 게시글 변수 
			
			int count =0;
			
			try {
				ps = conn.prepareStatement(sql);
				ps.setInt(1,userNo);
				rs=ps.executeQuery();
				
				while(rs.next()) {
					
					count = rs.getInt("cnt");
					
				}
			
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				
				JDBCTemplate.close(rs);
				JDBCTemplate.close(ps);
			}
			
			//최종 결과 반환
			System.out.println("selectCntAll -end");
			return count;
		}
	@Override
	public List<InquiryBoard> selectAll(Connection conn,Paging paging, int userNo) {
		System.out.println("inquiryBoard select 시작");
		String sql ="";
		sql +=" SELECT * FROM(";
		sql +="   SELECT rownum rnum, Q.* FROM(";
		sql +="       SELECT I.*,m.user_nick from cs_inquiry I";
		sql +=" 		inner join member m";
		sql +=" 		on m.user_no = I.user_no";
		sql +=" 		where I.user_no = ?";
		sql +="  		)Q		";		
		sql +="      )INQUIRY";
		sql +="   WHERE rnum BETWEEN ? AND ? ";
		
		//반환데이터 
		List<InquiryBoard> inquiryList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			//?에 unserno삽입
			ps.setInt(1, userNo);
			
			ps.setInt(2, paging.getStartNo());
			ps.setInt(3, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				InquiryBoard inquiryBaord = new InquiryBoard();
				
				
				

				inquiryBaord.setInquiryArticleNumber(rs.getInt("inquiry_articlenumber"));
				inquiryBaord.setUserNo(rs.getInt("user_no"));
				inquiryBaord.setAdminNo(rs.getInt("admin_no"));
				inquiryBaord.setBoardCode(rs.getInt("board_code"));
				inquiryBaord.setInquiryArticleTitle(rs.getString("inquiry_articletitle"));
				inquiryBaord.setInquiryContent(rs.getString("inquiry_content"));
				inquiryBaord.setInquiryWriter(rs.getString("inquiry_writer"));
				inquiryBaord.setInquiryDate(rs.getDate("inquiry_date"));
				inquiryBaord.setAnswerWriter(rs.getString("answer_writer"));
				inquiryBaord.setAnswercontent(rs.getString("answer_content"));
				inquiryBaord.setAnswerdate(rs.getDate("answer_date"));
				inquiryBaord.setUserNick(rs.getString("user_nick"));
			
			inquiryList.add(inquiryBaord);
			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		System.out.println("inquiryBoard select 끝");
		return inquiryList;
	}
	
	
	@Override
	public InquiryBoard selectDetail(Connection conn, int userNo,InquiryBoard inquiryTitle) {

		System.out.println("selectDetail-start");
		
		String sql ="";
		sql +=" SELECT I.*";
		sql +=" ,m.user_nick";
		sql +=" FROM cs_inquiry I";
		sql +=" inner join member m";
		sql +=" on m.user_no = I.user_no";
		sql +=" where I.user_no = ? and I.inquiry_articletitle=?" ;
		
		InquiryBoard inquiryDetail = null;
		try {

			ps = conn.prepareStatement(sql);
			ps.setInt(1, userNo);
			ps.setString(2,inquiryTitle.getInquiryArticleTitle());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				inquiryDetail = new InquiryBoard();
				inquiryDetail.setInquiryArticleNumber(rs.getInt("inquiry_articlenumber"));
				inquiryDetail.setUserNo(rs.getInt("user_no"));
				inquiryDetail.setAdminNo(rs.getInt("admin_no"));
				inquiryDetail.setBoardCode(rs.getInt("board_code"));
				inquiryDetail.setInquiryArticleTitle(rs.getString("inquiry_articletitle"));
				inquiryDetail.setInquiryContent(rs.getString("inquiry_content"));
				inquiryDetail.setInquiryWriter(rs.getString("inquiry_writer"));
				inquiryDetail.setInquiryDate(rs.getDate("inquiry_date"));
				inquiryDetail.setAnswerWriter(rs.getString("answer_writer"));
				inquiryDetail.setAnswercontent(rs.getString("answer_content"));
				inquiryDetail.setAnswerdate(rs.getDate("answer_date"));
				inquiryDetail.setUserNick(rs.getString("user_nick"));
				
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
			
		}
		
		
		System.out.println("selectDetail-detail");
		return inquiryDetail;
	}
	
	
	@Override
	public int insertinQuiry(Connection conn, InquiryBoard param, int userNo) {
		System.out.println("insertinQuiry시작");
		String sql ="";
		sql +="INSERT INTO cs_inquiry (inquiry_articlenumber,user_no,inquiry_articletitle,inquiry_content,inquiry_date)";
		sql +=" VALUES(cs_inquiry_seq.nextval, ?,?,?,sysdate)";
		
		
		int result = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, userNo);
			ps.setString(2, param.getInquiryArticleTitle());
			ps.setString(3, param.getInquiryContent());
			
		 result = ps.executeUpdate();
		 
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(ps);
		}
		System.out.println("inquiryinsert_end");
		return result;
	}
	
	@Override
	public InquiryBoard selectcontent(Connection conn, InquiryBoard inquiryNo) {
	
		System.out.println("selectcontent -start");
		
		String sql ="";
		sql +="SELECT * FROM cs_inquiry";
		sql +=" WHERE inquiry_articlenumber =?";
		
		InquiryBoard updateContent = null;
		try {
			ps =conn.prepareStatement(sql);

			ps.setInt(1, inquiryNo.getInquiryArticleNumber());
			
			rs= ps.executeQuery();
			
			while(rs.next()) {
				
				updateContent = new InquiryBoard();
				updateContent.setInquiryArticleNumber(rs.getInt("inquiry_articlenumber"));
				updateContent.setInquiryArticleTitle(rs.getString("inquiry_articletitle"));
				updateContent.setUserNo(rs.getInt("user_no"));
				updateContent.setInquiryContent(rs.getString("inquiry_content"));
				updateContent.setInquiryDate(rs.getDate("inquiry_date"));;
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
			
		}
		
		
		return updateContent ;
	}
	
	
	@Override
	public int updateDo(Connection conn, InquiryBoard inquiryNum) {
		System.out.println("updateDo 시작");
		
		String sql ="";
		sql +="UPDATE cs_inquiry";
		sql +=" SET inquiry_articletitle =?,inquiry_content=?";
		sql +=" WHERE inquiry_articlenumber =?";
		
		System.out.println(inquiryNum);
		
		int result =0;
		try {
			ps =conn.prepareStatement(sql);
			
			ps.setString(1, inquiryNum.getInquiryArticleTitle());
			ps.setString(2, inquiryNum.getInquiryContent());
			ps.setInt(3, inquiryNum.getInquiryArticleNumber());
			
			result = ps.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			JDBCTemplate.close(ps);
		}
		System.out.println("updateDo end");
	return result;
	}
	
	@Override
	public int deleteDo(Connection conn, InquiryBoard inquiryNo) {

		System.out.println("deleteDo 시작");
		
		String sql ="";
		sql +="DELETE cs_inquiry";
		sql +=" WHERE inquiry_articlenumber =? ";
		
		int deleteresult  =0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, inquiryNo.getInquiryArticleNumber());
			
			deleteresult = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			JDBCTemplate.close(ps);
		}
		
		
		System.out.println("deleteDo 끝");
		return deleteresult;
	}

}
