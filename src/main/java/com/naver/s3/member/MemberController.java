package com.naver.s3.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

	@Autowired
	MemberService memberService;
	
}
