package com.deburger.app.shop.qsc.service;

import java.util.List;

public interface QscService {
	public List<QscVO> selectQscListRecent();
	public int insertQscListRecent(QscVO qscVO);
	public int cntQscListRecent();
	public int insertQscDetails(List<QscResultVO>  qscResultVOs, QscResultVO QscResultVO);
	public List<QscResultVO> selectQscListShop(QscResultVO qscResultVO);
	public List<QscResultVO> selectQscInfoDetail(QscResultVO qscResultVO);
	public List<QscResultVO> selectAllQscListShop();
}
