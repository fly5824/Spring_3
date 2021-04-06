package com.naver.s3.bankBook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.naver.s3.util.Pager_backUp;

@Controller
@RequestMapping(value = "/bankbook/*")
public class BankBookController {

	@Autowired
	private BankBookService bankBookService;
	
	@RequestMapping(value = "bankbookUpdate")
	public void setUpdate(BankBookDTO bankBookDTO, Model model)throws Exception{
		bankBookDTO= bankBookService.getSelect(bankBookDTO);
		model.addAttribute("dto",bankBookDTO);
		// ********어려운거
		// 매개변수 뱅크북 디티오에 담긴것은 뱅크북넘버 하나뿐임
		// 이 뱅크북 디티오를 가지고 뱅크북 서비스에있는 겟셀렉트 호출해서 덮어씌움
		// 모델 소환해서 셀렉트한 정보를 넘겨주기 제이에스피에
		
	}
	
	@RequestMapping(value = "bankbookUpdate",method = RequestMethod.POST)
	public String setUpdate(BankBookDTO bankBookDTO)throws Exception{
	int result=	bankBookService.setUpdate(bankBookDTO);
	return "redirect:./bankbookList";
	}
	
	
	@RequestMapping(value = "bankbookList")
	// 밸류값이 들어오면 실행할 메서드
	public void getList(Model model) throws Exception {
		List<BankBookDTO> ar = bankBookService.getList(null);
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
	
	@RequestMapping(value = "bankbookDelete")
	public String setDelete(BankBookDTO bankBookDTO) throws Exception{
		int result = bankBookService.setDelete(bankBookDTO);
		
		return "redirect:./bankbookList";
	}
	
}
