package com.naver.s3.board.comments;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommentsDAO {

	@Autowired
	private SqlSession sqlsession;
	private final String NAMESPACE="com.naver.s3.board.comments.CommentsDAO";
	
	public List<CommentsDTO> getList(CommentsDTO commentsDTO) throws Exception {
		
		return sqlsession.selectList(NAMESPACE+"getList",commentsDTO);
	}

}
