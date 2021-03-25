package com.naver.s3.member;

import javax.servlet.http.HttpSession;

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

	@RequestMapping("memberDelete")
	public String memberDelete(HttpSession session)throws Exception{
		MemberDTO memberDTO= (MemberDTO)session.getAttribute("member");
		int result =memberService.memberDelete(memberDTO);
		
		session.invalidate();
		return "redirect:../";

	}


	@RequestMapping("memberPage")
	public void memberPage()throws Exception{
		//다시 조회하거나, 세션에서 빼서 쓰거나

	}

	@RequestMapping("memberLogout")
	public String memberLogout(HttpSession session)throws Exception{
		//세션객체를 없애거나 세션안의 멤버디티오를 없애기
		session.invalidate();
		return "redirect:../";
	}


	@RequestMapping("memberLogin")
	public void memberLogin()throws Exception{
		//폼으로 이동하는거

	}
	@RequestMapping(value="memberLogin" ,method = RequestMethod.POST)
	public String memberLogin(MemberDTO memberDTO,HttpSession session)throws Exception{
		//받아온 파라미터를 서비스로 넘기는거
		memberDTO=memberService.memberLogin(memberDTO);
		System.out.println(memberDTO);
		session.setAttribute("member", memberDTO);
		//리퀘스트가 발생하더라도 일정시간동안 혹은 웹브라우저를 닫기 전까지 살아있음
		// 이 세션은 home.jsp에서 쓰기위해서 

		return "redirect:../"; //루트로 올라감 인덱스페이지 현재는 member폴더안
	}

	@RequestMapping("memberJoin")
	public void memberJoin()throws Exception{


	}

	@RequestMapping(value="memberJoin" ,method = RequestMethod.POST)
	public String memberJoin(MemberDTO memberDTO,HttpSession session)throws Exception{

		int result = memberService.memberJoin(memberDTO);
		
		if(result>0) {
			session.setAttribute("member", memberDTO);
		}
		return "redirect:../";

	}	

	@RequestMapping("memberUpdate")
	public void memberUpdate()throws Exception{
			
	}
	
	@RequestMapping(value="memberUpdate",method = RequestMethod.POST)
	public String memberUpdate(MemberDTO memberDTO)throws Exception{
		
		int result = memberService.memberUpdate(memberDTO);
		
		return "redirect:../";
	}


}



