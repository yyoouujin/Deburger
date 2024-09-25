package com.deburger.app.office.material.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.deburger.app.office.material.mapper.MaterialMapper;
import com.deburger.app.office.material.service.MaterialService;
import com.deburger.app.office.material.service.MaterialVO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MaterialServiceImpl implements MaterialService {

	public MaterialMapper materialMapper;

	// 전체 조회
	@Override
	public List<MaterialVO> serviceAllList(MaterialVO materialVO) {
		return materialMapper.selectAllList(materialVO);
	}

	// 상세 조회
	@Override
	public List<MaterialVO> materialInfo(MaterialVO materialVO) {
		// TODO Auto-generated method stub
		return materialMapper.selectMaterial(materialVO);
	}

	// 등록
	@Override
	public int insertMaterialService(MaterialVO materialVO) {
		// TODO Auto-generated method stub	 
		//return materialMapper.insertMaterial(materialVO);
		 return materialMapper.insertMaterial(materialVO);
	}

	// 수정
	@Override
	public Map<String, Object> updateMaterial(MaterialVO materialVO) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		boolean isSuccessed = false;

		int result = materialMapper.updateMaterialInfo(materialVO);

		if (result == 1) {
			isSuccessed = true;
		}

		map.put("result", isSuccessed);
		map.put("target", materialVO);
		return map;
	}

	// 삭제
	@Override
	public int deleteMaterialService(MaterialVO materialVO) {
		// TODO Auto-generated method stub
		return materialMapper.deleteMaterial(materialVO);
	}

	// 페이징 처리
	@Override
	public int countMaterialService() {
		// TODO Auto-generated method stub
		return materialMapper.countMaterial();
	}

}
