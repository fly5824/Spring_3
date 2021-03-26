package com.naver.s3.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.naver.s3.notice.NoticeDAO";
	
	public List<NoticeDTO> getList()throws Exception {
		return sqlSession.selectList(NAMESPACE+".getList");
	}
	
	
	public NoticeDTO getSelect(NoticeDTO noticeDTO)throws Exception{
		noticeDTO =sqlSession.selectOne(NAMESPACE+".getSelect",noticeDTO);
		return noticeDTO;
	}
	
	public int setInsert(NoticeDTO noticeDTO)throws Exception{
		
		int result = sqlSession.insert(NAMESPACE+".setInsert",noticeDTO);
		
		return result;
	}

}
