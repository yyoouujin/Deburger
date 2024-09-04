package com.deburger.app.office.logistic.mapper;

import java.util.List;

import com.deburger.app.office.logistic.service.LogisticVO;

public interface LogisticMapper {
		
		//물류창고 전체조회
		public List<LogisticVO> selectLogisticAll();
		//물류창고 상세조회
		public List<LogisticVO> selectLogisticInfo(LogisticVO logisticVO);
		//물류창고 물품조회
		public List<LogisticVO> selectLogisticMaterialInfo(LogisticVO logisticVO);
		//물류창고 등록
		public int insertLogisticInfo(LogisticVO logisticVO);
		//물류창고 수정
		public int updateLogisticInfo(LogisticVO logisticVO);
		//물류창고 삭제
		public int deleteLogisticInfo(String logisticsId);
		

}
