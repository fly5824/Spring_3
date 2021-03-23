package com.naver.s3.bankBook;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class BankBookController {
	
	@Autowired
	private BankbookService bankbookService;
	
	//상품 리스트
	@RequestMapping(value="bankbook/bankbookList")
	public void bankbookList(Model model)throws Exception{
		//모델쓰는거 매개변수에 모델넣고 서비스불러오기
		
		List<BankBookDTO> ar = bankbookService.getList();
		
		model.addAttribute("list",ar);
		model.addAttribute("kind","BankBook");
	}

	//상품등록
	@RequestMapping(value="/bankbook/bankbookAdd")
	public void bankbookAdd()throws Exception {
		
		
	}
	
	@RequestMapping(value="/bankbook/bankbookAdd",method=RequestMethod.POST)
	public ModelAndView bankbookAdd(BankBookDTO bankBookDTO, ModelAndView mv) throws Exception{
		
		int result = bankbookService.setWrite(bankBookDTO);
		
		mv.setViewName("redirect:/bankbook/bankbookAdd");
		
		return mv;
		
	}
	//상품 상세정보
		@RequestMapping(value="/bankbook/bankbookSelect")
		public ModelAndView bankbookSelect(BankBookDTO bankBookDTO, ModelAndView mv) throws Exception{
			
			bankBookDTO= bankbookService.getSelect(bankBookDTO);		
			mv.addObject("dto", bankBookDTO);
			mv.setViewName("bankbook/bankbookSelect");
			
			return mv;
		}
		
	//상품수정
	@RequestMapping(value="/bankbook/bankbookUpdate")
	public ModelAndView bankbookUpdate(BankBookDTO bankBookDTO, ModelAndView mv) {
		mv.setViewName("bankbook/bankbookUpdate");
		
		return mv;
		
		
	}
	
	//상품삭제
	@RequestMapping(value="/bankbook/bankbookDelete")
		public ModelAndView bankbookDelete(BankBookDTO bankBookDTO, ModelAndView mv) {
			
		mv.setViewName("bankbook/bankbookDelete");
		
		return mv;
	
		}
		
		

}
