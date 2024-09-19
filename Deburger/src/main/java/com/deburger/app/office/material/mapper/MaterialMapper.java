package com.deburger.app.office.material.mapper;

import java.util.List;

import com.deburger.app.office.material.service.MaterialVO;

public interface MaterialMapper {

	// 전체 조회
	public List<MaterialVO> selectAllList(MaterialVO materialVO);

	// 단건 조회
	public List<MaterialVO> selectMaterial(MaterialVO materialVO);

	// 등록
	public int insertMaterial(MaterialVO materialVO);

	// 수정
	public int updateMaterialInfo(MaterialVO materialVO);

	// 삭제
	public int deleteMaterial(MaterialVO materialVO);

	// Material 총 갯수
	public int countMaterial();

}
