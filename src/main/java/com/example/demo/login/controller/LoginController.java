package com.example.demo.login.controller;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.common.vo.BaseBean;
import com.example.demo.login.response.LoginResponse;
import com.example.demo.login.service.LoginService;
import com.example.demo.sample.BootstrapSampleController;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	private static final Logger logger = LoggerFactory.getLogger(BootstrapSampleController.class);
	
	@RequestMapping(value="/loginForm")
	public String loginForm() {
		logger.info("===== loginForm =====");
		return "login/login";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	@ResponseBody
	public BaseBean login(HttpServletRequest request, HttpServletResponse response, LoginResponse loginrResponse, Model model) {
		logger.info("===== login =====");
		
		BaseBean baseBean = new BaseBean();
		
		String memberId = request.getParameter("memberId");
		String memberPasswd = request.getParameter("memberPasswd");
		String idSave = request.getParameter("idSave");
		
		logger.info("memberId ===> "+memberId);
		logger.info("memberPasswd ===> "+memberPasswd);
		logger.info("idSave ===> "+idSave);
		
		
		LoginResponse paramVO = new LoginResponse();
		paramVO.setMemberId(memberId);
		paramVO.setMemberPasswd(memberPasswd);
		
		
		LoginResponse ressultVO = loginService.getLoginCheck(paramVO);
		
		if(ressultVO != null && (!"".equals(ressultVO.getMemberId())) && ("Y".equals(ressultVO.getUseYn()))) {
			
			//세션 생성
			//request.getSession().setAttribute("memberInfo", ressultVO);
			
			// 쿠키 생성
			if("on".equals(idSave)){
				Cookie cookie = new Cookie("memberId", ressultVO.getMemberId());
				cookie.setMaxAge(60*60*24*7);            // 쿠키 유지 기간(이부분이 없으면 브라우저 종료시 사라짐)
			    response.addCookie(cookie);                // 쿠키저장
			}else if("off".equals(idSave)){
				Cookie cookie = new Cookie("memberId", null);
				cookie.setMaxAge(0);            // 쿠키 유지 기간(이부분이 없으면 브라우저 종료시 사라짐)
			    response.addCookie(cookie);                // 쿠키저장
			}else {
				logger.info("idSave 값 이상한 값이 들어 옴 idSave --->"+idSave);
			}
			
			// 로그 일시 업데이트
			
			logger.info("success");
			
			
		}else if(ressultVO != null && (!"".equals(ressultVO.getMemberId())) && ("N".equals(ressultVO.getUseYn()))) {
			logger.info("FAIL");
			baseBean.setResultCode("10001");
		}else {
			logger.info("FAIL");
			baseBean.setResultCode("10002");
		}
		
		return baseBean;
	}
	

	/**
	 * 로그아웃 처리
	 * @param request
	 * @return
	 */
	@RequestMapping(value="logout", method=RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		
		//request.getSession().invalidate();
		//request.getSession().removeAttribute("memberInfo");
		return "redirect:/loginForm";
	}
	
	/**
	 * 아이디 찾기 화면
	 */
	@RequestMapping(value="/findIdForm", method=RequestMethod.GET)
	public String findIdForm() {
		logger.info("===== findIdForm =====");
		return "login/findIdForm";
	}
	
	/**
	 *  아이디 찾기
	 */
	@RequestMapping(value="/findId", method = RequestMethod.POST)
	@ResponseBody
	public BaseBean findId(HttpServletRequest request, HttpServletResponse response, Model model) {
		BaseBean baseBean = new BaseBean();
		
		String memberName = request.getParameter("memberName");
		String memberPhone = request.getParameter("memberPhone");
		
		logger.info("memberName ===> "+memberName);
		logger.info("memberPasswd ===> "+memberPhone);
		
		LoginResponse paramVO = new LoginResponse();
		paramVO.setMemberName(memberName);
		paramVO.setMemberPhone(memberPhone);
		
		LoginResponse resultVO = loginService.getMemberIdFind(paramVO);
		
		if(resultVO == null) {
			logger.info("FAIL");
			baseBean.setResultCode("10003");
			
		}else{
			logger.info("success");
			baseBean.setAttrVal1(resultVO.getMemberId());
		}
		
		return baseBean;
	}
	
	
	
	/**
	 * 비밀번호 찾기 화면
	 */
	@RequestMapping(value="/findPasswdForm", method=RequestMethod.GET)
	public String findPasswdForm() {
		logger.info("===== findPasswdForm =====");
		return "login/findPasswdForm";
	}
	
	/**
	 *  비밀번 찾기
	 */
	@RequestMapping(value="/findPasswd", method = RequestMethod.POST)
	@ResponseBody
	public BaseBean findPasswd(HttpServletRequest request, HttpServletResponse response, Model model) {
		BaseBean baseBean = new BaseBean();
		
		String memberId = request.getParameter("memberId");
		String memberName = request.getParameter("memberName");
		String memberPhone = request.getParameter("memberPhone");
		
		logger.info("memberId ===> "+memberId);
		logger.info("memberName ===> "+memberName);
		logger.info("memberPasswd ===> "+memberPhone);
		
		LoginResponse paramVO = new LoginResponse();
		paramVO.setMemberId(memberId);
		paramVO.setMemberName(memberName);
		paramVO.setMemberPhone(memberPhone);
		
		LoginResponse resultVO = loginService.getMembePasswdFind(paramVO);
		
		if(resultVO == null) {
			logger.info("FAIL");
			baseBean.setResultCode("10003");
			
		}
		
		return baseBean;
	}
	

}
