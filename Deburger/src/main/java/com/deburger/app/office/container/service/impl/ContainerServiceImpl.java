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

	// 전체 조회
	@Override
	public List<ContainerVO> containerAllList() {
		// TODO Auto-generated method stub
		return containerMapper.selectAllList();
	}

	// 상세 조회
	@Override
	public List<ContainerVO> containerInfo(ContainerVO containerVO) {
		// TODO Auto-generated method stub
		return containerMapper.selectContainerInfo(containerVO);
	}

	//
	@Override
	public int containerInsert(ContainerVO containerVO) {
		// TODO Auto-generated method stub
		int result = containerMapper.insertContainerInfo(containerVO);
		return result == 1 ? Integer.parseInt(containerVO.getMaterialNumber()) : -1;
	}

	// 물류 창고 입고 list
	@Override
	public List<ContainerVO> containerAllInList() {
		// TODO Auto-generated method stub
		return containerMapper.selectAllInList();
	}

	// 물류 창고 입고 list 조회
	@Override
	public List<ContainerVO> containerInInfo(List<ContainerVO> list) {
		// TODO Auto-generated method stub
		return containerMapper.selectInInfoList(list);
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
		containerMapper.containerInupdate(containerVO);
		return containerMapper.containerOutInsert(containerVO);
	}

}
