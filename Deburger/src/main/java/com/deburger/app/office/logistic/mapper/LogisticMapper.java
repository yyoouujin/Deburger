package com.deburger.app.office.logistic.mapper;

import java.util.List;

import com.deburger.app.office.logistic.service.LogisticVO;

public interface LogisticMapper {
		
		//물류창고 전체조회
		public List<LogisticVO> selectLogisticAll();
		//물류창고 상세조회
		public LogisticVO selectLogisticInfo(LogisticVO logisticVO);

}
