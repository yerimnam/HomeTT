package party.service.face;

import javax.servlet.http.HttpServletRequest;

import party.dto.Comments;

public interface CommentService {

	
	
	/**
	 * 전달 파라미터 commentsno를 Comments DTO로 저장해서 반환
	 * 
	 * @param req - 요청 정보 객체
	 * @return - 전달파라미터 commentsno를 저장한 DTO객체
	 */
	public Comments getCommentsno(HttpServletRequest req);
	
	
	
	/**
	 * 게시글 삭제
	 * 
	 * @param comments - 삭제할 게시글 번호 객체
	 */
	public void delete(Comments comments);
	

}
