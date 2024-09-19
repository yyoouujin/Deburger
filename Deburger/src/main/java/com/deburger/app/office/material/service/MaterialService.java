package com.deburger.app.office.material.service;

import java.util.List;
import java.util.Map;

public interface MaterialService {

	// 전체 조회
	public List<MaterialVO> serviceAllList(MaterialVO materialVO);

	// 단건 조회
	public List<MaterialVO> materialInfo(MaterialVO materialVO);

	// 등록
	public int insertMaterialService(MaterialVO materialVO);

	// 수정
	public Map<String, Object> updateMaterial(MaterialVO materialVO);

	// 삭제
	public int deleteMaterialService(MaterialVO materialVO);

	// Material 총 갯수
	public int countMaterialService();

}
