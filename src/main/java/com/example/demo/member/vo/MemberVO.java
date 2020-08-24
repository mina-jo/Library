package com.example.demo.member.vo;


import org.springframework.boot.autoconfigure.domain.EntityScan;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@EntityScan
@Table(name = "tb_member")
@Data
@EqualsAndHashCode(of = "memberSeq")
@NoArgsConstructor
public class MemberVO implements Serializable{
	
	private static final long serialVersionUID = 1L;

    public MemberVO(long memberSeq){
        this.memberSeq = memberSeq;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "memberSeq")
    private long memberSeq;

    @Column(name = "member_id")
    private String memberId;

    @Column(name = "member_name")
    private String memberName;

    @Column(name = "member_passwd")
    private String memberPasswd;

    @Type(type = "yes_no")
    @Column(name = "admin_yn")
    private boolean adminYn = false;

    @Type(type = "yes_no")
    @Column(name = "use_yn")
    private boolean useYn = true;
    
    private LocalDateTime birthDt = LocalDateTime.now();

    @Column(name = "email")
    private String email;
    
    @Column(name = "member_phone")
    private String member_phone;

    private LocalDateTime createDate = LocalDateTime.now();

    private LocalDateTime updateDate;

}
