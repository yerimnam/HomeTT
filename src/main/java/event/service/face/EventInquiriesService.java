package event.service.face;

import java.util.List;

import event.dto.EventBoard;

public interface EventInquiriesService {
	
	/**
	 * 게시글 전체 조회
	 * @return List<board> - 게시글 전체 조회 목록
	 */
	public List<EventBoard> getList();
}
