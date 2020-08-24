package com.example.demo.common.vo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BaseBean {
	
	/** 세션 KEY. */
	private String sessionKey = null; 
	
	/** 결과코드. */
	private String resultCode = "200000200";
	
	/** 결과 메세지. */
	private String resultMsg = "정상처리 되었습니다";
	
	/** 페이지수. */
	private Integer pageCount = null;
	
	/** 페이지번호. */
	private Integer pageNum = null; 
	
	/** 페이징처리 시작번호. */
	private Integer startIndex = null;
	
	/** 페이징 처리 끝번호. */
	private Integer endIndex = null;
	
	
	/** 결과 값. */
	private String attrVal1 = null;
	
	/** 결과 값. */
	private String attrVal2 = null;
	
	/** 결과 값. */
	private String attrVal3 = null;

}