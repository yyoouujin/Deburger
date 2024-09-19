package com.deburger.app.shop.storein.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deburger.app.main.login.config.SecurityUtil;
import com.deburger.app.shop.stock.service.StockVO;
import com.deburger.app.shop.storein.mapper.StoreInMapper;
import com.deburger.app.shop.storein.service.ListVO;
import com.deburger.app.shop.storein.service.StoreInService;
import com.deburger.app.shop.storein.service.StoreInVO;

@Service
public class StoreInServiceImpl implements StoreInService {

	private StoreInMapper storeInMapper;
	
	@Autowired
	StoreInServiceImpl(StoreInMapper storeInMapper){
		this.storeInMapper = storeInMapper;
	}
	
	//입고 승인 전체 조회
	@Override
	public List<StoreInVO> StoreInList(StoreInVO storeInVO) {
		// TODO Auto-generated method stub
		String mcode = SecurityUtil.memberCode();
		storeInVO.setStoreNumber(mcode);
		return storeInMapper.StoreInList(storeInVO);
	}
	
	@Override
	public int shopincoun() {
		// TODO Auto-generated method stub
		return storeInMapper.shopincoun();
	}
	
	//입고 재고 상세 조회
	@Override
	public List<StoreInVO> StoreIninfoList(StoreInVO storeInVO) {
		// TODO Auto-generated method stub
		return storeInMapper.StoreIninfoList(storeInVO);
	}
	
	//입고 저장
	@Override
	@Transactional
	public int insertStoreInList(ListVO listVO) {
		// TODO Auto-generated method stub
		//리스트를 하나식 뽑아서 반복하여 다시 넣음.

		for(StoreInVO storein:  listVO.getStoreInList()) {
			System.err.println(storein);
			
			storeInMapper.insertStoreInList(storein);
	
			storeInMapper.storeStock(storein);
		}
		
		return 1;
	}
	
}
