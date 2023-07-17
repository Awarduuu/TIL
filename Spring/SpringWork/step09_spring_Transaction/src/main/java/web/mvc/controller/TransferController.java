package web.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;
import web.mvc.dto.TransferDTO;
import web.mvc.exception.MyException;
import web.mvc.service.TransferService;

@Controller
@RequiredArgsConstructor
public class TransferController {
	
	private final TransferService transferService;

	 @RequestMapping("/")
	 public String index() {
		 return "transaction";// WEB-INF/views/transaction.jsp¿Ãµø
	 }
	 
	 @RequestMapping("/transfer")
	 public String transfer(TransferDTO transferDTO) throws MyException {
		 transferService.transfer(transferDTO);
		 return "result";
	 }
	 
	 //@ExceptionHandler(RuntimeException.class)
	 @ExceptionHandler(MyException.class)
	 public ModelAndView error(MyException e) {
		 return new ModelAndView("error", "errMessage" , e.getMessage());
	 }
}












