package com.deburger.app.shop.StoreMatCon.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deburger.app.main.login.config.SecurityUtil;
import com.deburger.app.shop.StoreMatCon.mapper.StoreMatConMapper;
import com.deburger.app.shop.StoreMatCon.service.StoreMatConService;
import com.deburger.app.shop.StoreMatCon.service.StoreMatConVO;

@Service
public class StoreMatConServiceImpl implements StoreMatConService {

	private StoreMatConMapper storeMatConMapper;
	
	@Autowired
	StoreMatConServiceImpl(StoreMatConMapper storeMatConMapper){
		this.storeMatConMapper = storeMatConMapper;
	}	
	
	@Override
	public List<StoreMatConVO> StoreMaterialList() {
		// TODO Auto-generated method stub
		
		return storeMatConMapper.StoreMaterialList();
	}
	
	@Override
	public List<StoreMatConVO> StoreMaterialoneList(StoreMatConVO storeMatConVO) {
		// TODO Auto-generated method stub
		
		String mcode = SecurityUtil.memberCode();
		storeMatConVO.setStoreNumber(mcode);
		return storeMatConMapper.StoreMaterialoneList(storeMatConVO);
	}
	
	@Override
	public List<StoreMatConVO> stockClassificationMa() {
		// TODO Auto-generated method stub
		
		return storeMatConMapper.stockClassificationMa();
	}
	
	@Override
	public List<StoreMatConVO> classificationListMa(StoreMatConVO storeMatConVO) {
		// TODO Auto-generated method stub
		
		String mcode = SecurityUtil.memberCode();
		storeMatConVO.setStoreNumber(mcode);
		return storeMatConMapper.classificationListMa(storeMatConVO);
	}
}
