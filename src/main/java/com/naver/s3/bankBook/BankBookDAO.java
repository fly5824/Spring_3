package com.naver.s3.bankBook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.naver.s3.util.Pager_backUp;

@Repository
public class BankBookDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.naver.s3.bankBook.BankBookDAO";
	
	public int setUpdate(BankBookDTO bankBookDTO)throws Exception{
		
		return sqlSession.update(NAMESPACE+".setUpdate",bankBookDTO);
		
	}
	
	
	public int setDelete(BankBookDTO bankBookDTO)throws Exception{
		
		return sqlSession.delete(NAMESPACE+".setDelete", bankBookDTO);
		
	}
	
	

	public int setWrite(BankBookDTO bankBookDTO)throws Exception{

		int result = sqlSession.insert(NAMESPACE+".setWrite",bankBookDTO);
		//네임스페이스 안의 아이디를 적는거임 
		//update, insert, delete의 리턴은 모두 인트
		return result;
	}

	public List<BankBookDTO> getList(Pager_backUp pager)throws Exception {
		
		return sqlSession.selectList(NAMESPACE+".getList",pager);
	}

	public BankBookDTO getSelect(BankBookDTO bankBookDTO)throws Exception {
		
		bankBookDTO= sqlSession.selectOne(NAMESPACE+".getSelect", bankBookDTO);
		

		return bankBookDTO;
	}
}
