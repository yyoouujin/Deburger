package com.deburger.app.shop.productSale.service;

import java.util.List;

import lombok.Data;

@Data
public class StoreSaleListVO {
	private List<StoreSaleVO>  storeSaleList;
	private StoreSaleVO storeSale;
}
