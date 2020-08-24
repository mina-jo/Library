package com.example.demo.member.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.member.response.MemberResponse;

@Mapper
public interface MemberDAO {
	
	List<MemberResponse> getMemberList();
	
	MemberResponse getMember(MemberResponse paramVO);
	
	int getMemberIdCheck(MemberResponse paramVO);
	
	int insertMember(MemberResponse paramVO);


}
