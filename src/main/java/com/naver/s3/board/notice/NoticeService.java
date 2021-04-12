package com.naver.s3.board.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.naver.s3.board.BoardDTO;
import com.naver.s3.board.BoardFileDTO;
import com.naver.s3.board.BoardService;
import com.naver.s3.util.FileManager;
import com.naver.s3.util.Pager;
import com.naver.s3.util.Pager_backUp;

@Service
public class NoticeService implements BoardService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	@Autowired
	private FileManager fileManager;
	@Autowired
	private HttpSession session;

	public int setFileDelete(BoardFileDTO boardFileDTO) throws Exception{
		//삭제할 파일의 파일네임을 가져오기
		//1.조회
		boardFileDTO=noticeDAO.getFileSelect(boardFileDTO);
		System.out.println(boardFileDTO.getFileName());
		//2.테이블삭제
		int result = noticeDAO.setFileDelete(boardFileDTO);
		//3.hdd삭제
		if(result>0) {
			fileManager.delete("notice", boardFileDTO.getFileName(),session);
		}
	return result;	
	}
	
	public List<BoardDTO> getList(Pager pager)throws Exception{
		//startRow, lastRow 계산구간============
		pager.makeRow();
		
		//==========페이징계산============================
		long totalCount = noticeDAO.getTotalCount(pager);
		pager.makeNum(totalCount);
		//--------------------------------------
		
		return noticeDAO.getList(pager);
	}

	@Override
	public BoardDTO getSelect(BoardDTO boardDTO) throws Exception {
		
		return noticeDAO.getSelecct(boardDTO);
	}

	@Override
	public int setInsert(BoardDTO boardDTO, MultipartFile [] files) throws Exception {
		
	long num = noticeDAO.getNum();
	
	boardDTO.setNum(num);
	
	int result = noticeDAO.setInsert(boardDTO);
	
	//글번호찾기
		
	for(MultipartFile mf:files) {
		BoardFileDTO boardFileDTO = new BoardFileDTO();
		
		
		String fileName= fileManager.save("notice", mf, session);
		
		boardFileDTO.setNum(num);
		boardFileDTO.setFileName(fileName);
		boardFileDTO.setOrigineName(mf.getOriginalFilename());
		
		noticeDAO.setFileInsert(boardFileDTO);
	}
		
	
		return result;//noticeDAO.setInsert(boardDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO,MultipartFile [] files) throws Exception {
		for(MultipartFile mutiparFile:files) {
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			//1. file들을 hdd에 저장
			String fileName =fileManager.save("notice", mutiparFile, session);
			boardFileDTO.setFileName(fileName);
			boardFileDTO.setOrigineName(mutiparFile.getOriginalFilename());
			boardFileDTO.setNum(boardDTO.getNum());
			//2. 데이터베이스에 insert
			noticeDAO.setFileInsert(boardFileDTO);
		}
		return noticeDAO.setUpdate(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.setDelete(boardDTO);
	}


}
