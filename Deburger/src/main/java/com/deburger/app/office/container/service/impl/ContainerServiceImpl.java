package com.deburger.app.office.container.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

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

	@Override
	public ContainerVO containerInfo(ContainerVO containerVO) {
		// TODO Auto-generated method stub
		return containerMapper.selectContainerInfo(containerVO);
	}

	@Override
	public int containerInsert(ContainerVO containerVO) {
		// TODO Auto-generated method stub
		int result = containerMapper.insertContainerInfo(containerVO);
		return result == 1 ? Integer.parseInt(containerVO.getNumber()) : -1;
	}

}
