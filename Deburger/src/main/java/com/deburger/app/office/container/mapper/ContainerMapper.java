package com.deburger.app.office.container.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

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

	// 입고 조회
	public List<ContainerVO> selectAllInList();

	// 물류 창고 폐기 처리
	public int containerOutInsert(ContainerVO containerVO);

	public int containerInupdate(@Param("lot") String lot, @Param("container") ContainerVO containerVO);
}
