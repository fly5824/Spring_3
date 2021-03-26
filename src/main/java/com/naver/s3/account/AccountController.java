package com.naver.s3.account;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.naver.s3.member.MemberDTO;

@RequestMapping("/account/*")
@Controller
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping("accountList")
	public void accountList(HttpSession session, Model model)throws Exception{
		
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setId(memberDTO.getId());
		List<AccountDTO> ar = accountService.getList(accountDTO);
		model.addAttribute("list",ar);
		
	}
	
	

}
