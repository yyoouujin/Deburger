package com.deburger.app.office.container.service;

import java.util.List;

public interface ContainerService {

	// 전체 조회
	public List<ContainerVO> containerAllList();

	// 단건 조회
	public ContainerVO containerInfo(ContainerVO containerVO);

	// 등록
}
