package com.deburger.app.office.container.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		containerMapper.containerInupdate(containerVO);
		return containerMapper.containerOutInsert(containerVO);
	}

	@Override
	public List<ContainerVO> containerOutAllList() {
		// TODO Auto-generated method stub
		return containerMapper.containerOutList();
	}

	@Override
	public List<ContainerVO> containerOutInfo(ContainerVO containerVO) {
		// TODO Auto-generated method stub
		return containerMapper.containerOutListInfo(containerVO);
	}

	@Override
	public Map<String, Object> containerOutModalInfo(List<ContainerVO> containerVO) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();

		List<String> list = new ArrayList<String>();
		for (ContainerVO vo : containerVO) {
			containerMapper.containerOutModal(vo);
			list.add(vo.lot);
		}

		map.put("result", list);
		return map;
	}

}
