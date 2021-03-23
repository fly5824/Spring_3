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

@Repository
public class BankBookDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.naver.s3.bankBook.BankBookDAO";
	
	

	public int setWrite(BankBookDTO bankBookDTO)throws Exception{

		int result = sqlSession.insert(NAMESPACE+".setWrite",bankBookDTO);
		//네임스페이스 안의 아이디를 적는거임 
		//update, insert, delete의 리턴은 모두 인트
		return result;
	}

	public List<BankBookDTO> getList()throws Exception {
		ArrayList<BankBookDTO> ar = new ArrayList();

		

		return ar;
	}

	public BankBookDTO getSelect(BankBookDTO bankBookDTO)throws Exception {
		long num = 1L;
		bankBookDTO= sqlSession.selectOne(NAMESPACE+".getSelect", num);
		

		return bankBookDTO;
	}
}
