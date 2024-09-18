package com.deburger.app.office.product.service;

import lombok.Data;

@Data
public class ProductVO {

	public String productNumber;
	public String productName;
	public int saleUnitprice;
	public String image;
	public String RecipePdf;
	public int Price;
	public String category;
	public String kind;
	public String registrationDay;
	public String Note;
	
    private String id;
    
    

}
