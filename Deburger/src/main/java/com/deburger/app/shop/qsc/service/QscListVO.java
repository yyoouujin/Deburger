package com.deburger.app.shop.qsc.service;

import java.util.List;

import lombok.Data;

@Data
public class QscListVO {
	 private List<QscResultVO> qscDataList;
	 private QscResultVO scores;
}
