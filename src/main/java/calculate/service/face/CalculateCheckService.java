package calculate.service.face;

import java.util.List;

import calculate.dto.Calculate;

public interface CalculateCheckService {

	/**
	 * 정산 목록 전체 조회
	 * 
	 * @return - 정산 전체 조회 목록
	 */
	public List<Calculate> getList();

}
