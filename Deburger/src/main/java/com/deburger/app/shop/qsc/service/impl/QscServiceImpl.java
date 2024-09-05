package com.deburger.app.shop.qsc.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deburger.app.shop.qsc.mapper.QscMapper;
import com.deburger.app.shop.qsc.service.QscResultVO;
import com.deburger.app.shop.qsc.service.QscService;
import com.deburger.app.shop.qsc.service.QscVO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class QscServiceImpl implements QscService{
	
	private QscMapper qscMapper;
	
	@Override
	public List<QscVO> selectQscListRecent() {		
		return qscMapper.selectQscListRecent();
	}

	@Override
	public int insertQscListRecent(QscVO qscVO) {
		return qscMapper.insertQscListRecent(qscVO);
	}

	@Override
	public int cntQscListRecent() {
		return qscMapper.cntQscListRecent();
	}

	@Override
	@Transactional
	public int insertQscDetails(List<QscResultVO>  qscResultVO) {
		for(QscResultVO qscResultVOs : qscResultVO) {
		qscMapper.insertQscResultDetails(qscResultVOs);
		qscMapper.insertQscDetails(qscResultVOs);
		}
		return 0;
	}

	

}
