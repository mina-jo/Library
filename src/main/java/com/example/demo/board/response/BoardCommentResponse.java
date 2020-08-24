package com.example.demo.board.response;

import java.time.LocalDateTime;


import org.apache.ibatis.type.Alias;

import com.example.demo.common.search.SearchCondition;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Alias("boardCommentResponse")
public class BoardCommentResponse extends SearchCondition{
	
    private long boardCommSeq;
	
    private String boardSeq;
	
    private String memberSeq;
    
	private String boardComment;
	
    private LocalDateTime createDate = LocalDateTime.now();
	
    private LocalDateTime updateDate;
    
    private String memberName;
    
    

}
