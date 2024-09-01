package com.deburger.app.office.supplier.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class SupplierVO {

		private String clientId;					//공급업체 아이디
		private String clientName;					//공급업체 이름
		private int postal;							//공급업체 우편주소
		private String address;						//공급업체 기본주소
		private String addresssec;					//공급업체 상세주소
		private String note;						//공급업체 참고주소
		private String email;						//공급업체 이메일
		private String phone;						//공급업체 전화번호
		private String businessnum;					//사업자 번호
		private String representativeName;			//대표자 이름
		private String businessType;				//업태
		@DateTimeFormat(pattern="yyyy-MM-dd")
		private Date contractDay;					//계약일
		private String contractPdf;					//계약서

		private String personName;					//담당자 이름
		private String personPhone;					//담당자 전화번호
		private String personEmail;					//담당자 이메일
	
	
}


/*
SELECT client_id							//공급업체 아이디
      , client_name						//공급업체 이름
      , postal								//공급업체 우편번호
      , address								//공급업체 기본주소
      , addresssec						//공급업체 상세주소
      , email									//공급업체 이메일
      , phone									//공급업체 전화번호
      , businessnum						//사업자 번호
      , representative_name		//대표자 이름
      , businesstype					//업태
      , contract_day					//계약일
      , contract_pdf					//계약서
      , note									//비고
      , person_name						//담당자 이름
      , person_phone					//담당자 전화번호
      , person_email					//담당자 이메일
FROM supplier;
 
*/
