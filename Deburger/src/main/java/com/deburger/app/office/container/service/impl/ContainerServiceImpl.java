package com.deburger.app.office.container.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deburger.app.office.container.mapper.ContainerMapper;
import com.deburger.app.office.container.service.ContainerService;
import com.deburger.app.office.container.service.ContainerVO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ContainerServiceImpl implements ContainerService {

	public ContainerMapper containerMapper;

	// 물류 창고 전체 조회
	@Override
	// @Transactional
	public List<ContainerVO> containerAllList(ContainerVO containerVO) {
		// TODO Auto-generated method stub
		return containerMapper.selectAllList(containerVO);
	}

	// 물류 창고 페이징
	@Override
	public int containerAllCount(ContainerVO containerVO) {
		// TODO Auto-generated method stub
		return containerMapper.selectAllListcount(containerVO);
	}

	// 물류 창고 상세 조회
	@Override
	public List<ContainerVO> containerInfo(ContainerVO containerVO) {
		// TODO Auto-generated method stub
		return containerMapper.selectContainerInfo(containerVO);
	}

	// ?
	@Override
	public int containerInsert(ContainerVO containerVO) {
		// TODO Auto-generated method stub
		int result = containerMapper.insertContainerInfo(containerVO);
		return result == 1 ? Integer.parseInt(containerVO.getMaterialNumber()) : -1;
	}

	// 물류 창고 발주 승인건 미입고 list
	@Override
	public List<ContainerVO> containerAllInList(ContainerVO containerVO) {
		// TODO Auto-generated method stub
		return containerMapper.selectAllInList(containerVO);
	}

	// 물류 창고 입고 상세 조회
	@Override
	public List<ContainerVO> containerInInfo(ContainerVO containerVO) {
		// TODO Auto-generated method stub
		return containerMapper.selectInInfoList(containerVO);
	}

	// 물류 창고 입고 list 처리
	@Override
	@Transactional
	public int containerInTreatment(List<ContainerVO> list) {

		for (ContainerVO vo : list) {
			containerMapper.containerInInsert(vo);
			containerMapper.containerInUpdate(vo);
			containerMapper.logisticsStockin(vo);
		}

		return 1;
	}

	// 물류 창고 폐기 조회
	@Override
	public List<ContainerVO> containerDtInfo(ContainerVO containerVO) {
		// TODO Auto-generated method stub
		return containerMapper.ContainerDeleteInfo(containerVO);
	}

	// 물류 창고 폐기 처리
	@Override
	@Transactional
	public int disposeItem(ContainerVO containerVO) {
		containerMapper.stockDelete(containerVO);
		containerMapper.containerInupdate(containerVO);
		return containerMapper.containerOutInsert(containerVO);
	}

	// 물류창고 출고 조회
	@Override
	public List<ContainerVO> containerOutAll(ContainerVO containerVO) {
		// TODO Auto-generated method stub
		return containerMapper.containerOuts(containerVO);
	}

	// 물류창고 출고 count
	@Override
	public int containerOutAllCount(ContainerVO containerVO) {
		// TODO Auto-generated method stub
		return containerMapper.containerOutsCount(containerVO);
	}

	// 물류 창고 처리 조회 list (메인페이지 같이씀)
	@Override
	public List<ContainerVO> containerOutAllList(ContainerVO containerVO) {
		// TODO Auto-generated method stub
		return containerMapper.containerOutList(containerVO);
	}

	@Override
	public List<ContainerVO> containerOutInfo(ContainerVO containerVO) {
		// TODO Auto-generated method stub
		return containerMapper.containerOutListInfo(containerVO);
	}

	@Override
	public List<ContainerVO> containerOutModalInfo(ContainerVO containerVO) {
		// TODO Auto-generated method stub
		return containerMapper.containerOutModal(containerVO);
	}

	// 프로시저 처리
	@Override
	public void containerOutpD(List<ContainerVO> list) {
		for (ContainerVO vo : list) {
			containerMapper.containerOutprocedure(vo);
			return;
		}
	}

	@Override
	public ContainerVO loginService(ContainerVO containerVO) {
		// TODO Auto-generated method stub
		return containerMapper.loginSession(containerVO);
	}
	
	
	// 메인페이지 입고 알람개수
	@Override
	public List<ContainerVO> countInsertList(ContainerVO containerVO) {
		// TODO Auto-generated method stub
		return containerMapper.countInsertList(containerVO);
	}

}
