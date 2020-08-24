package com.example.demo.member.controller;


import java.util.List;

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
import com.example.demo.member.response.MemberResponse;
import com.example.demo.member.service.MemberService;
import com.example.demo.sample.BootstrapSampleController;

@Controller
public class MemberController {
	
	@Autowired
    private MemberService memberService;
	
	private static final Logger logger = LoggerFactory.getLogger(BootstrapSampleController.class);

	@RequestMapping(value="/memberJoinForm")
	public String memberJoinForm(Model model) throws Exception{
		logger.info("===== memberJoinForm START =====");
		
		return "login/memberJoin";
	}
	
	/**
	 * 회원가입
	 */
	@RequestMapping(value="/memberJoin", method = RequestMethod.POST)
	@ResponseBody
	public BaseBean memberJoin(HttpServletRequest request, HttpServletResponse response, Model model) {
		
		logger.info("===== memberJoin =====");
		BaseBean baseBean = new BaseBean();
		
		String memberId = request.getParameter("memberId");
		String memberPasswd = request.getParameter("memberPasswd");
		String memberName = request.getParameter("memberName");
		String email = request.getParameter("email");
		String memberPhone = request.getParameter("memberPhone");
		String birthDt = request.getParameter("birthDt");
		
		logger.info("memberId ===> "+memberId);
		logger.info("memberPasswd ===> "+memberPasswd);
		logger.info("memberName ===> "+memberName);
		logger.info("email ===> "+email);
		logger.info("memberPhone ===> "+memberPhone);
		logger.info("birthDt ===> "+birthDt);
		
		MemberResponse paramVO = new MemberResponse();
		paramVO.setMemberId(memberId);
		paramVO.setMemberPasswd(memberPasswd);
		paramVO.setMemberName(memberName);
		paramVO.setEmail(email);
		paramVO.setMemberPhone(memberPhone);
		paramVO.setBirthDt(birthDt);
		
		int chk = 0; 
		
		int idChk = memberService.getMemberIdCheck(paramVO);
		
		if(idChk == 0) {
				chk = memberService.insertMember(paramVO);
				
				if(chk == 1) {
					baseBean.setAttrVal1("회원가입이 완료되었습니다. ");
				}else {
					baseBean.setAttrVal1("회원가입 중 오류가 발생하였습니다.");
				}
		}else {
			baseBean.setAttrVal1("중복된 아이디가 존재합니다. ");
		}
		
		return baseBean;
	}
	
	@RequestMapping(value="/memberList", method = RequestMethod.GET)
	public String getMemberList(Model model) throws Exception{
		logger.info("===== getMemberList START =====");
		
		List<MemberResponse> list = memberService.getMemberList();
		model.addAttribute("memberList", list);
		
		for(int i=0;i<list.size();i++) {
			logger.info("==== list.memberID"+list.toString());
		}
		
		return "member/memberList";
	}
	
	/**
	 * 아이디 중복확인
	 */
	@RequestMapping(value="/getMemberIdCheck", method = RequestMethod.POST)
	@ResponseBody
	public BaseBean getMemberIdCheck(HttpServletRequest request, HttpServletResponse response, Model model) {
		
		logger.info("===== getMemberIdCheck =====");
		BaseBean baseBean = new BaseBean();
		
		String memberId = request.getParameter("memberId");
		
		logger.info("memberId ===> "+memberId);
		
		MemberResponse paramVO = new MemberResponse();
		paramVO.setMemberId(memberId);
		
		int chkVal = 0;
		
		chkVal = memberService.getMemberIdCheck(paramVO);
		
		if(chkVal == 0) {
			baseBean.setAttrVal1("사용 가능한 아이디입니다.");
		}else {
			baseBean.setAttrVal1("중복된 아이디입니다. 다른 아이디를 사용해주세요.");
		}
		
		return baseBean;
	}
	
	

}
