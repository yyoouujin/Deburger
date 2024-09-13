package com.deburger.app.shop.qna.service;

import java.util.Date;

import lombok.Data;

@Data
public class QnaVO {
     private Integer qnaNumber; //일련번호
     private String title;      //제목
     private String content;    //내용 
     private String storeNumber;//가맹점번호
     private Date writerDay;    //작성일자
     private String writer;     //문의상태
     
     private String storeName; //가맹점이름
     
     private Integer commentsNumber; //답변 번호
     private String comContent; //답변 내용
     private Date comWriterDay;//답변 일자
     
}
