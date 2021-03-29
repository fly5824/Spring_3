package com.naver.s3.notice;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.naver.s3.util.Pager;

@Repository
public class NoticeDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.naver.s3.notice.NoticeDAO";
	
	public Long getTotalCount()throws Exception{
		return sqlSession.selectOne(NAMESPACE+".getTotalCount");
	}
	
	public List<NoticeDTO> getList(Pager pager)throws Exception {
	
		return sqlSession.selectList(NAMESPACE+".getList",pager);
	}
	
	
	public NoticeDTO getSelect(NoticeDTO noticeDTO)throws Exception{
		noticeDTO =sqlSession.selectOne(NAMESPACE+".getSelect",noticeDTO);
		return noticeDTO;
	}
	
	public int setInsert(NoticeDTO noticeDTO)throws Exception{
		
		int result = sqlSession.insert(NAMESPACE+".setInsert",noticeDTO);
		
		return result;
	}
	
	public int setDelete(NoticeDTO noticeDTO)throws Exception{
	
		int result = sqlSession.delete(NAMESPACE+".setDelete",noticeDTO);
		
		return result;
	}
	
	public int setUpdate(NoticeDTO noticeDTO)throws Exception{
		
		int result = sqlSession.update(NAMESPACE+".setUpdate",noticeDTO);
		return result;
		
	}
	
	}

