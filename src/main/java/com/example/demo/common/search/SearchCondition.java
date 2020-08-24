	package com.example.demo.common.search;

import com.example.demo.common.pagination.PaginationInfo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchCondition{

	    private String searchKeyword;
	    
	    private String searchCondition;

	    // 날짜 시작
	    private  String searchStartDate;

	    // 날짜 종료
	    private  String searchEndDate;


	    /** 현재페이지 */
	    private int pageIndex = 1;

	    /** 한 페이지에 출력될 컨텐츠 개수 */
	    private int pageUnit = 10;

	    /** 페이징 영역에 보여질 페이지 개수(사이즈) */
	    private int pageSize = 5;

	    /** firstIndex */
	    private int firstIndex = 1;

	    /** lastIndex */
	    private int lastIndex = 1;

	    /** recordCountPerPage */
	    private int recordCountPerPage = 10;

}
