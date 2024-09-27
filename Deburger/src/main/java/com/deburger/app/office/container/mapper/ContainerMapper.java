package com.deburger.app.office.container.mapper;

import java.util.List;

import com.deburger.app.office.container.service.ContainerVO;

public interface ContainerMapper {

	// 물류 재고 전체 조회
	public List<ContainerVO> selectAllList(ContainerVO containerVO);

	// 물류 재고 페이징
	public int selectAllListcount(ContainerVO containerVO);

	// 상세 조회
	public List<ContainerVO> selectContainerInfo(ContainerVO containerVO);

	// 등록 ??
	public int insertContainerInfo(ContainerVO containerVO);

	// 물류 창고 입고 조회
	public List<ContainerVO> selectAllInList(ContainerVO containerVO);

	// 물류 창고 입고 조회 list
	public List<ContainerVO> selectInInfoList(ContainerVO containerVO);

	
	// 물류 창고 입고 카운트(희창)
	public List<ContainerVO> countInsertList(ContainerVO containerVO);


	// 물류 창고 입고 조회 처리
	public int containerInInsert(ContainerVO vo);

	public int containerInUpdate(ContainerVO vo);

	public int logisticsStockin(ContainerVO vo);

	// 물류 창고 폐기 조회
	public List<ContainerVO> ContainerDeleteInfo(ContainerVO containerVO);

	// 물류 창고 폐기 처리
	public int containerOutInsert(ContainerVO containerVO);

	public int containerInupdate(ContainerVO containerVO);

	public int stockDelete(ContainerVO containerVO);

	// 물류 창고 출고 리스트
	public List<ContainerVO> containerOuts(ContainerVO containerVO);

	// 물류 창고 출고 조회 count
	public int containerOutsCount(ContainerVO containerVO);

	// 물류 창고 출고 처리 리스트
	public List<ContainerVO> containerOutList(ContainerVO containerVO);

	// 물류 창고 출고 처리 상세 조회
	public List<ContainerVO> containerOutListInfo(ContainerVO containerVO);

	// 물류 창고 출고 처리 프로시저
	public void containerOutprocedure(ContainerVO vo);

	// 모달
	public List<ContainerVO> containerOutModal(ContainerVO containerVO);

	// 로그인 세션
	public ContainerVO loginSession(ContainerVO containerVO);
}
