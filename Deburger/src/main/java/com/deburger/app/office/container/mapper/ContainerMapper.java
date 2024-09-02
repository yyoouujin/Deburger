package com.deburger.app.office.container.mapper;

import java.util.List;

import com.deburger.app.office.container.service.ContainerVO;

public interface ContainerMapper {

	// 전체 조회
	public List<ContainerVO> selectAllList();

	// 단건 조회
	public ContainerVO selectContainerInfo(ContainerVO containerVO);

	// 등록
	public int insertContainerInfo(ContainerVO containerVO);
	// 수정

	// 삭제
}
