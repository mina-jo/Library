package com.example.demo.login.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.login.response.LoginResponse;

@Mapper
public interface LoginDAO {
	
	LoginResponse getLoginCheck(LoginResponse paramVO);
	
	LoginResponse getMemberIdFind(LoginResponse paramVO);
	
	LoginResponse getMembePasswdFind(LoginResponse paramVO);

}
