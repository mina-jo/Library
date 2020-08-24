package com.example.demo.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.login.dao.LoginDAO;
import com.example.demo.login.response.LoginResponse;

@Service
public class LoginService {
	
	@Autowired
	private LoginDAO loginDAO;
	
	public LoginResponse getLoginCheck(LoginResponse paramVO) {
    	return loginDAO.getLoginCheck(paramVO);
    }
	
	public LoginResponse getMemberIdFind(LoginResponse paramVO) {
    	return loginDAO.getMemberIdFind(paramVO);
    }
	
	public LoginResponse getMembePasswdFind(LoginResponse paramVO) {
    	return loginDAO.getMembePasswdFind(paramVO);
    }

}
