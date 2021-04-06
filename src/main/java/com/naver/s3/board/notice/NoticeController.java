package com.naver.s3.board.notice;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.naver.s3.board.BoardDTO;
import com.naver.s3.util.Pager;
import com.naver.s3.util.Pager_backUp;

@Controller
@RequestMapping(value = "/notice/*")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	
	
	@GetMapping("noticeSelect")
	public ModelAndView getSelect(BoardDTO boardDTO)throws Exception{
		
		ModelAndView mv = new ModelAndView();
		
		boardDTO =noticeService.getSelect(boardDTO);
		mv.addObject("dto",boardDTO);
		mv.addObject("board","notice");
		mv.setViewName("board/boardSelect");
		return mv;
	}
	
	@RequestMapping("noticeList")
	public ModelAndView getList(Pager pager)throws Exception{
		ModelAndView mv = new ModelAndView();
		
		System.out.println(pager.getCurPage());
		
		List<BoardDTO>ar = noticeService.getList(pager);
		//List<NoticeDTO> ar =noticeService.getList(curPage);
		mv.addObject("list",ar);
		mv.setViewName("board/boardList");
		mv.addObject("board","notice");
		mv.addObject("pager",pager);
		return mv;
	}
	

	
	@RequestMapping("noticeInsert")
	public ModelAndView SetInsert()throws Exception{	
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/boardInsert");
		mv.addObject("board","notice");
		
		return mv;
	
	}
	
	@RequestMapping(value="noticeInsert", method = RequestMethod.POST)
	public String SetInsert(NoticeDTO noticeDTO ,Model model)throws Exception{	
		
		int result = noticeService.setInsert(noticeDTO);
//		Random random = new Random();
//		int result = random.nextInt();
		
		String message ="실패";
		
		if(result>0) {
			message= "성공";
		}
		
		model.addAttribute("msg",message);
		model.addAttribute("path", "./noticeList");
		
		return "common/commonResult";
	}
	
	
	
	@PostMapping(value="noticeDelete")
	public ModelAndView setDelete(BoardDTO boardDTO)throws Exception{	
		ModelAndView mv = new ModelAndView();
		int result = noticeService.setDelete(boardDTO);
		String message = "삭제실패";
		String path="./noticeList";

		if(result>0) {
			message="삭제성공";
		}
		
		mv.addObject("msg",message);
		mv.addObject("path",path);
		
		mv.setViewName("common/commonResult");
		
		return mv;
}

	
	@PostMapping(value="noticeUpdate")
	public ModelAndView setUpdate(BoardDTO boardDTO,ModelAndView mv) throws Exception{
		int result = noticeService.setUpdate(boardDTO);
		
		if(result>0) {
			mv.setViewName("redirect:./noticeList");
			//성공하면 리스트로 이동
		}else {
			mv.addObject("msg","수정실패");
			mv.addObject("path","./noticeList");
			mv.setViewName("common/commonResult");
			//실패하면 앨럿창으로 수정실패, 리스트로 이동
		}
		
		return mv;
	}
	@GetMapping(value="noticeUpdate")
	public ModelAndView setUpdate(BoardDTO boardDTO)throws Exception{	
		ModelAndView mv = new ModelAndView();
		boardDTO = noticeService.getSelect(boardDTO);
		
		mv.addObject("dto",boardDTO);
		mv.addObject("board","notice");
		mv.setViewName("board/boardUpdate");
		
		return mv;
	}
}
