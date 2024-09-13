package com.deburger.app.office.container.service;

import java.util.List;

public interface ContainerService {

	// 전체 조회
	public List<ContainerVO> containerAllList(ContainerVO containerVO);

	// 상세 조회
	public List<ContainerVO> containerInfo(ContainerVO containerVO);

	// 등록
	public int containerInsert(ContainerVO containerVO);

	// 물류 창고 입고 조회
	public List<ContainerVO> containerAllInList(ContainerVO containerVO);

	// 물류 창고 입고 처리 조회
	public List<ContainerVO> containerInInfo(ContainerVO containerVO);

	// 물류 창고 입고 처리
	public int containerInTreatment(List<ContainerVO> liSt);

	// 물류 창고 폐기 조회
	public List<ContainerVO> containerDtInfo(ContainerVO containerVO);

	// 물류 창고 폐기 처리
	public int disposeItem(ContainerVO containerVO);

	// 물류 창고 출고 조회
	public List<ContainerVO> containerOutAllList();

	// 물류 창고 출고 상세 조회
	public List<ContainerVO> containerOutInfo(ContainerVO containerVO);

	// 물류 창고 프로시저
	public List<ContainerVO> containerOutpD(ContainerVO containerVO);

	// 모달
	public List<ContainerVO> containerOutModalInfo(ContainerVO containerVO);

	public ContainerVO loginService(ContainerVO containerVO);
}
