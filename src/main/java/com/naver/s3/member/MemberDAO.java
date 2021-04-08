package com.naver.s3.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.naver.s3.member.MemberDAO";
	
	//setMemberFileInsert
	public int setMemberFileInsert(MemberFileDTO memberFileDTO)throws Exception{
		
		return sqlSession.insert(NAMESPACE+".setMemberFileInsert",memberFileDTO);
	}
	
	public MemberFileDTO memberLoginFile(MemberDTO memberDTO)throws Exception{
		return sqlSession.selectOne(NAMESPACE+".memberLoginFile",memberDTO);
	}
	
	
	public int memberUpdate(MemberDTO memberDTO) throws Exception{
		//id를 제외하고 나머지를 업데이트
		
		return sqlSession.update(NAMESPACE+".memberUpdate",memberDTO);
		
	}
	
	public int memberDelete(MemberDTO memberDTO) throws Exception {
		
		return sqlSession.delete(NAMESPACE+".memberDelete",memberDTO);
		
		
	}
	
	
	public int memberJoin(MemberDTO memberDTO)throws Exception {
	
		return sqlSession.insert(NAMESPACE+".memberJoin",memberDTO);
		
	}
	
	public MemberDTO memberLogIn(MemberDTO memberDTO) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+".memberLogin",memberDTO);
	
	
		 
		
	}
}

