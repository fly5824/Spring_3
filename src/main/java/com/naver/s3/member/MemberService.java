package com.naver.s3.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDAO;
	
	public int memberDelete(MemberDTO memberDTO) throws Exception{
		
		return memberDAO.memberDelete(memberDTO);
		
	}
	
	
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception{
		
		return memberDAO.memberLogIn(memberDTO);
	}
	
	public int memberJoin(MemberDTO memberDTO) throws Exception{
		
		return memberDAO.memberJoin(memberDTO);
	}
	
	public int memberUpdate(MemberDTO memberDTO)throws Exception{
		
		return memberDAO.memberUpdate(memberDTO);
	}
	
}
