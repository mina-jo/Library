package com.example.demo.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.member.dao.MemberDAO;
import com.example.demo.member.response.MemberResponse;

@Service
public class MemberService {
	
	@Autowired
    private MemberDAO memberDAO;


    public List<MemberResponse> getMemberList() {
        return memberDAO.getMemberList();
    }
    
    public MemberResponse getMember(MemberResponse paramVO) {
    	return memberDAO.getMember(paramVO);
    }
    
    public int getMemberIdCheck(MemberResponse paramVO) {
    	return memberDAO.getMemberIdCheck(paramVO);
    }
    
    public int insertMember(MemberResponse paramVO) {
    	return memberDAO.insertMember(paramVO);
    }

}
