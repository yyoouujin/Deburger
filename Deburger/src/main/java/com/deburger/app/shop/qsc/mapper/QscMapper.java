package com.deburger.app.shop.qsc.mapper;

import java.util.List;

import com.deburger.app.shop.qsc.service.QscResultVO;
import com.deburger.app.shop.qsc.service.QscVO;

public interface QscMapper {	
	
	public List<QscVO> selectQscListRecent();
	public int insertQscListRecent(QscVO qscVO);
	public int cntQscListRecent();
	public int insertQscDetails(QscResultVO qscResultVO);
	public int insertQscResultDetails(QscResultVO qscResultVO);
	public List<QscResultVO> selectQscListShop(QscResultVO qscResultVO);
	public List<QscResultVO> selectQscInfoDetail(QscResultVO qscResultVO);
	public List<QscResultVO> selectAllQscListShop();
}
