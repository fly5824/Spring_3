package com.naver.s3.member;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.naver.s3.util.FileManager;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private FileManager fileManager;
	
	public int memberDelete(MemberDTO memberDTO) throws Exception{
		
		return memberDAO.memberDelete(memberDTO);
		
	}
	
	
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception{
		
		return memberDAO.memberLogIn(memberDTO);
	}
	
	public int memberJoin(MemberDTO memberDTO, MultipartFile avatar , HttpSession session) throws Exception{

		fileManager.save("member", avatar, session);
		
		return 0;
		//return memberDAO.memberJoin(memberDTO);
		
		
	}
	
	public int memberUpdate(MemberDTO memberDTO)throws Exception{
		
		return memberDAO.memberUpdate(memberDTO);
	}
	
}
