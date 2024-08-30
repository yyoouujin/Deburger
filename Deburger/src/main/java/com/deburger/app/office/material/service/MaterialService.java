package com.deburger.app.office.material.service;

import java.util.List;
import java.util.Map;

public interface MaterialService {

	// 전체 조회
	public List<MaterialVO> serviceAllList();

	// 단건 조회
	public MaterialVO materialInfo(MaterialVO materialVO);

	// 등록
	public int insertMaterial();

	// 수정
	public Map<String, Object> updateMaterial();

	// 삭제
	public Map<String, Object> deleteMaterial();

}
