package com.deburger.app.office.logistic.mapper;

import java.util.List;

import com.deburger.app.office.logistic.service.Criteria;
import com.deburger.app.office.logistic.service.LogisticVO;

public interface LogisticMapper {
	
		//물류창고 전체조회페이징
		public List<LogisticVO> selectLogisticAll(Criteria criteria);
		//물류창고 전체데이터(페이징)
		public int getTotal();
		//물류창고 상세조회
		public List<LogisticVO> selectLogisticInfo(LogisticVO logisticVO);
		//물류창고 상세데이터 (페이징)
		public int getMatTotal();
		
		//물류창고 필요재고
		public List<LogisticVO> requireStock(LogisticVO logisticVO);
		//물류창고 충분재고
		public List<LogisticVO> enoughStock(LogisticVO logisticVO);
		
		//물류창고 물품조회
		public List<LogisticVO> selectLogisticMaterialInfo(LogisticVO logisticVO);
		//물류창고 등록
		public int insertLogisticInfo(LogisticVO logisticVO);
		//물류창고 담당자 선택
		public List<LogisticVO> selectLogisticPersonId(LogisticVO logisticVO);
		
		//물류창고 정보 단건조회
		public List<LogisticVO> selectLogisticDetailInfo(LogisticVO logisticVO);
		//물류창고 수정
		public int updateLogisticInfo(LogisticVO logisticVO);
		//물류창고 삭제
		public int deleteLogisticInfo(String logisticsId);
		
		

}
