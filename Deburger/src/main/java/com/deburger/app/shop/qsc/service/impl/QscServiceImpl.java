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
	public int insertQscDetails(List<QscResultVO>  qscResultVOList, QscResultVO qscResultVO) {
		int cnt = 0;
		String shopNo = "FRC0000001" ;
		qscResultVO.setStoreNumber(shopNo);
		System.out.println(qscResultVO);
		qscMapper.insertQscDetails(qscResultVO);				
		
		for(QscResultVO qscResultVOs : qscResultVOList) {
			qscResultVOs.setChecklistNumber(qscResultVO.getChecklistNumber());
			System.out.println(qscResultVOs);
			qscMapper.insertQscResultDetails(qscResultVOs);
		cnt++;
		};
		
		return cnt;
	}

	@Override
	public List<QscResultVO> selectQscListShop(QscResultVO qscResultVO) {
		return qscMapper.selectQscListShop(qscResultVO);
	}

	@Override
	public List<QscResultVO> selectQscInfoDetail(QscResultVO qscResultVO) {
		return qscMapper.selectQscInfoDetail(qscResultVO);
	}

	

}
