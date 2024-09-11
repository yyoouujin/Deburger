package com.deburger.app.office.container.mapper;

import java.util.List;

import com.deburger.app.office.container.service.ContainerVO;

public interface ContainerMapper {

	// 물류 재고 전체 조회
	public List<ContainerVO> selectAllList();

	// 상세 조회
	public List<ContainerVO> selectContainerInfo(ContainerVO containerVO);

	// 등록
	public int insertContainerInfo(ContainerVO containerVO);
	// 수정

	// 삭제

	// 물류 창고 입고 조회
	public List<ContainerVO> selectAllInList();

	// 물류 창고 입고 조회 list
	public List<ContainerVO> selectInInfoList(ContainerVO containerVO);

	// 물류 창고 입고 조회 처리
	public int containerInInsert(ContainerVO vo);

	public int containerInUpdate(ContainerVO vo);

	// 물류 창고 폐기 조회
	public List<ContainerVO> ContainerDeleteInfo(ContainerVO containerVO);

	// 물류 창고 폐기 처리
	public int containerOutInsert(ContainerVO containerVO);

	public int containerInupdate(ContainerVO containerVO);

	// 물류 창고 출고 리스트
	public List<ContainerVO> containerOutList();

	// 물류 창고 출고 상세 조회
	public List<ContainerVO> containerOutListInfo(ContainerVO containerVO);

	// 모달
	public List<ContainerVO> containerOutModal(ContainerVO containerVO);

	// 모달 처리

}
