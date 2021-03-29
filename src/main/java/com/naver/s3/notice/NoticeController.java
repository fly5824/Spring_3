package com.naver.s3.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.naver.s3.util.Pager;

@Controller
@RequestMapping(value = "/notice/*")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping("noticeList")
	public ModelAndView getList(Pager pager)throws Exception{
		ModelAndView mv = new ModelAndView();
		
		System.out.println(pager.getCurPage());
		
		List<NoticeDTO>ar = noticeService.getList(pager);
		//List<NoticeDTO> ar =noticeService.getList(curPage);
		mv.addObject("list",ar);
		mv.setViewName("notice/noticeList");
		mv.addObject("pager",pager);
		return mv;
	}
	
	@RequestMapping("noticeSelect")
	public void getSelect(NoticeDTO noticeDTO ,Model model)throws Exception{	
		
		noticeDTO = noticeService.getSelect(noticeDTO);
		model.addAttribute("dto", noticeDTO);
		
	}
	
	@RequestMapping("noticeInsert")
	public void SetInsert()throws Exception{	
	
	}
	
	@RequestMapping(value="noticeInsert", method = RequestMethod.POST)
	public String SetInsert(NoticeDTO noticeDTO)throws Exception{	
		int result = noticeService.setInsert(noticeDTO);
		
		return "redirect:./noticeList";
	}
	
	@RequestMapping(value="noticeUpdate")
	public void setUpdate(NoticeDTO noticeDTO,Model model)throws Exception{	
		noticeDTO = noticeService.getSelect(noticeDTO);
		model.addAttribute("dto",noticeDTO);
	
	}
	
	@RequestMapping(value="noticeUpdate", method = RequestMethod.POST)
	public String setUpdate(NoticeDTO noticeDTO)throws Exception{	
		int result = noticeService.setUpdate(noticeDTO);
		
		return "redirect:./noticeList";
	}
	
	@RequestMapping(value="noticeDelete")
	public String setDelete(NoticeDTO noticeDTO)throws Exception{	
		int result = noticeService.setDelete(noticeDTO);
		
		return "redirect:./noticeList";
}
}
