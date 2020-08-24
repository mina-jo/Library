package com.example.demo.member.response;

import java.time.LocalDateTime;


import org.apache.ibatis.type.Alias;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter @Setter
@Alias("memberResponse")
public class MemberResponse {
	
    private long memberSeq;
	
    private String memberId;
	
    private String memberName;
    
	private String memberPasswd;
	
	private String adminYn;
	
    private String useYn;
	
    private String birthDt;
	
    private String email;
	
    private String memberPhone;
	
    private LocalDateTime createDate = LocalDateTime.now();
	
    private LocalDateTime updateDate;
    
    

}
