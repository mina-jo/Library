package com.example.demo.board.response;

import java.time.LocalDateTime;


import org.apache.ibatis.type.Alias;

import com.example.demo.common.search.SearchCondition;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Alias("boardResponse")
public class BoardResponse extends SearchCondition{
	
    private long boardSeq;
	
    private String boardTitle;
	
    private String memberSeq;
    
	private String boardContent;
	
    private String useYn;
	
    private String views;
	
    private LocalDateTime createDate = LocalDateTime.now();
	
    private LocalDateTime updateDate;
    
    private String memberName;
    
    

}
