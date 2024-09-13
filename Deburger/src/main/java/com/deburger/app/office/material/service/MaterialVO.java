package com.deburger.app.office.material.service;

import lombok.Data;

@Data
public class MaterialVO {

	public String materialNumber;
	public String materialName;
	public String unit;
	public int saleUnitprice;
	public String materialItem;
	public int buyUnitprice;
	public String image;
	public String materialClassification;
	public int logisticsSafetyStock;
	public int cost;

}
