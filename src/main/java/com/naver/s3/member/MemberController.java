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
	private MemberService memberService;
	
	@RequestMapping("memberLogin")
	public void memberLogin()throws Exception{
	//폼으로 이동하는거
		
		
	}
	@RequestMapping(value="memberLogin" ,method = RequestMethod.POST)
	public String memberLogin(MemberDTO memberDTO)throws Exception{
		//받아온 파라미터를 서비스로 넘기는거
		memberDTO=memberService.memberLogin(memberDTO);
		
		return "redirect:../"; //루트로 올라감 인덱스페이지 현재는 member폴더안
	}
	
	@RequestMapping("memberJoin")
	public void memberJoin()throws Exception{
	
	
	}
	
	@RequestMapping(value="memberJoin" ,method = RequestMethod.POST)
	public String memberJoin(MemberDTO memberDTO)throws Exception{
		
		int result = memberService.memberJoin(memberDTO);
		
		return "redirect:../";
		
	}	
	
		}
	


