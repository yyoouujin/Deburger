package com.deburger.app.office.container.service;

import java.util.List;

public interface ContainerService {

	// 전체 조회
	public List<ContainerVO> containerAllList(ContainerVO containerVO);

	// 전체 조회 페이징 처리
	public int containerAllCount(ContainerVO containerVO);

	// 상세 조회
	public List<ContainerVO> containerInfo(ContainerVO containerVO);

	// 등록
	public int containerInsert(ContainerVO containerVO);

	// 물류 창고 입고 조회
	public List<ContainerVO> containerAllInList(ContainerVO containerVO);

	// 물류 창고 입고 처리 조회
	public List<ContainerVO> containerInInfo(ContainerVO containerVO);

	// 물류 창고 입고 처리
	public int containerInTreatment(List<ContainerVO> list);

	// 물류 창고 폐기 조회
	public List<ContainerVO> containerDtInfo(ContainerVO containerVO);

	// 물류 창고 폐기 처리
	public int disposeItem(ContainerVO containerVO);

	// 물류 창고 출고 조회
	public List<ContainerVO> containerOutAll(ContainerVO containerVO);

	// 물류 창고 출고 count
	public int containerOutAllCount(ContainerVO containerVO);

	// 물류 창고 출고 처리 조회
	public List<ContainerVO> containerOutAllList(ContainerVO containerVO);

	// 물류 창고 출고 처리 상세 조회
	public List<ContainerVO> containerOutInfo(ContainerVO containerVO);

	// 물류 창고 프로시저
	public void containerOutpD(List<ContainerVO> list);

	// 모달
	public List<ContainerVO> containerOutModalInfo(ContainerVO containerVO);

	public ContainerVO loginService(ContainerVO containerVO);
	
	// 물류 창고 입고 카운트(희창)
	public List<ContainerVO> countInsertList(ContainerVO containerVO);

}
