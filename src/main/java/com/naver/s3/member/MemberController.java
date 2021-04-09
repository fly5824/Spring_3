package com.naver.s3.member;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value = "/member/*")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("memberIdCheck")
	public String memberIdCheck(MemberDTO memberDTO, Model model)throws Exception{
		memberDTO = memberService.memberIdCheck(memberDTO);
		String result = "0"; //0 사용불가 1: 사용가능
		if(memberDTO == null) {
			result ="1";
		}
		
		model.addAttribute("result", result);
		
		return "common/ajaxResult";
	}
	

	@RequestMapping("memberDelete")
	public String memberDelete(HttpSession session)throws Exception{
		MemberDTO memberDTO= (MemberDTO)session.getAttribute("member");
		int result =memberService.memberDelete(memberDTO,session);
		
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
	public String memberJoin(MemberDTO memberDTO, MultipartFile avatar, Model model, HttpSession session)throws Exception{

		int result = memberService.memberJoin(memberDTO,avatar,session);
		System.out.println(avatar.getName());
		System.out.println(avatar.getOriginalFilename());
		System.out.println(avatar.getSize());
		System.out.println(avatar.isEmpty());
		
//		Random random = new Random();
//		int result = random.nextInt(2);
		
		String message = "회원가입실패";
		String path="./memberJoin";
		
		if(result>0) {
			message = "회원가입성공";
			path="../";
		}
		model.addAttribute("msg",message);
		model.addAttribute("path", path);
		
		return "common/commonResult";
		//이 리턴의 주소는 jsp주소를 찾으러 가는거임(리다이렉트가 아님)
		//리다이렉트는 그 주소가 클라이언트한테 바로 나가는거라서 상대경로를 써주는거라서 리턴이랑 다르다!!!!
		//view의 jsp의 경로를 리턴해주는것
		// member/memberJoinResult가 뷰에 담겨있어서 이경로없앞에 prifix를 더해주는거임
		// 결국 /web-inf/views/member/memberJoinResult.jsp가 됨
	

	}	
	
	@RequestMapping("memberJoinCheck")
	public void memberJoinCheck()throws Exception{
		
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



