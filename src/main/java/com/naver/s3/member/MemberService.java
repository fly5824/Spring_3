package com.naver.s3.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

	@Autowired
	MemberDAO memberDAO;
	
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception{
		
		return memberDAO.memberLogIn(memberDTO);
	}
}