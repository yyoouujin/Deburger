package com.deburger.app.shop.storein.service;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ListVO {
	
	List<StoreInVO> StoreInList;
}
