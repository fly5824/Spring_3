package com.naver.s3.bankBook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/bankbook/*")
public class BankBookController {

	@Autowired
	private BankBookService bankBookService;
	
	@RequestMapping(value = "bankbookList")
	// 밸류값이 들어오면 실행할 메서드
	public void getList(Model model) throws Exception {
		List<BankBookDTO> ar = bankBookService.getList();
		// 그담에 제이에스피에 뿌리기	
		model.addAttribute("list",ar); //이름, 보낼 데이터		
	}
	
	@RequestMapping (value = "bankbookSelect")
	public ModelAndView getSelect(BankBookDTO bankBookDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		bankBookDTO = bankBookService.getSelect(bankBookDTO);
		
		mv.addObject("dto",bankBookDTO);
		mv.setViewName("bankbook/bankbookSelect");
		
		return mv;
		// 뱅크북 서비스 메서드 호출 -> 모델앤뷰 객체 -> 애드 오브젝트 -> 셋뷰네임(제이에스피의 경로)
		
		
	}
	
}
