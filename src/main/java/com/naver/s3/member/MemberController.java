package com.naver.s3.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/member/*")
public class MemberController {

	@Autowired
	MemberService memberService;
	
	@RequestMapping("memberLogin")
	public void memberLogin(MemberDTO memberDTO)throws Exception{
		
		memberDTO=memberService.memberLogin(memberDTO);
		
		
	
		}
	

	
}
