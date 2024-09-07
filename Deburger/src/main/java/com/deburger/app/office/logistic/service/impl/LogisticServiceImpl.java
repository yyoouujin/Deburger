package com.deburger.app.office.logistic.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deburger.app.office.logistic.mapper.LogisticMapper;
import com.deburger.app.office.logistic.service.Criteria;
import com.deburger.app.office.logistic.service.LogisticService;
import com.deburger.app.office.logistic.service.LogisticVO;

@Service
public class LogisticServiceImpl implements LogisticService {

	
	private LogisticMapper logisticMapper;
	
	@Autowired
	public LogisticServiceImpl(LogisticMapper logisticMapper) {
			this.logisticMapper = logisticMapper;
	}
	
	/*
	@Override
	public List<LogisticVO> logisticList() {
			return logisticMapper.selectLogisticAll();
	}
	*/
	
	@Override
	public List<LogisticVO> logistiList(Criteria criteria) {
		return logisticMapper.selectLogisticAll(criteria);
	}
	
	@Override
	public int getTotal() {
		return logisticMapper.getTotal();
	}

	@Override
	public List<LogisticVO> logisticInfo(LogisticVO logisticVO) {
			return logisticMapper.selectLogisticInfo(logisticVO);
	}
	
	@Override
	public List<LogisticVO> logisticMaterialInfo(LogisticVO logisticVO) {
		return logisticMapper.selectLogisticMaterialInfo(logisticVO);
	}
	

	@Override
	public int insertLogistic(LogisticVO logisticVO) {
			int result = logisticMapper.insertLogisticInfo(logisticVO);
			return result == 1 ? Integer.parseInt(logisticVO.getLogisticsId().substring(3)) : -1;
	}
	
	@Override
	public List<LogisticVO> logisticPersonInfo(LogisticVO logisticVO) {
		return logisticMapper.selectLogisticPersonId(logisticVO);
	}
	
	@Override
	public int updateLogistic(LogisticVO logisticVO) {
		int result = logisticMapper.updateLogisticInfo(logisticVO);
		return result == 1 ? Integer.parseInt(logisticVO.getLogisticsId().substring(3)) : -1;
	}
	

	/*
	@Override
	public Map<String, Object> updateLogistic(LogisticVO logisticVO) {
		Map<String, Object> map = new HashMap<>();
			
		boolean isSuccessed = false;
		int result = logisticMapper.updateLogisticInfo(logisticVO);
			
		if (result == 1) {
			isSuccessed = true;
		}
			
		map.put("result", isSuccessed);
		map.put("target", logisticVO);
			
		return map;
	}
	*/
	
	

	@Override
	public int deleteLogistic(String logisticsId) {
		return logisticMapper.deleteLogisticInfo(logisticsId);
	}

}
