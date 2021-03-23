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
	
//	public MemberDTO logIn(MemberDTO memberDTO) throws Exception {
//		
//		String user = "user01";
//		String pw = "user01";
//		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
//		String driver = "oracle.jdbc.driver.OracleDriver";
//		
//		Class.forName(driver);
//		
//		Connection con = DriverManager.getConnection(url, user, pw);
//		
//		String sql = "select * from member where id=? and pw =?";
//		PreparedStatement st = con.prepareStatement(sql);
//		
//		st.setString(1,memberDTO.getID() );
//		st.setString(2,memberDTO.getPW() );
//
//		ResultSet rs = st.executeQuery();
//		
//		if(rs.next()) {
//			memberDTO.setNAME(rs.getString("NAME"));
//			memberDTO.setEMAIL(rs.getString("EMAIL"));
//			memberDTO.setMOBILE(rs.getString("PHONE"));
//					}else {
//		memberDTO=null;	
//		}
//		
//		rs.close();
//		st.close();
//		con.close();
//		
//		return memberDTO;
		 
		
		
	}


