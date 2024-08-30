package com.deburger.app.office.material.service.impl;

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

	@Override
	public List<MaterialVO> serviceAllList() {
		return materialMapper.selectAllList();
	}

	@Override
	public MaterialVO materialInfo(MaterialVO materialVO) {
		// TODO Auto-generated method stub
		return materialMapper.selectMaterial(materialVO);
	}

	@Override
	public int insertMaterial() {
		// TODO Auto-generated method stub
		return materialMapper.insertMaterialInfo();
	}

	@Override
	public Map<String, Object> updateMaterial() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> deleteMaterial() {
		// TODO Auto-generated method stub
		return null;
	}

}
