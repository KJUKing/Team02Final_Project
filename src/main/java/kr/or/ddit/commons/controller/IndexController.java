package kr.or.ddit.commons.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.employee.vo.EmployeeVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/a001/main")
public class IndexController{
	
	@GetMapping
   public String index(
		   HttpSession session 		  
		   ){
	  
	   EmployeeVO myEmp = (EmployeeVO)session.getAttribute("myEmp");
	   
	   if(myEmp==null) {
		   // session에 저장된 정보가 없음 즉, 로그인되어있지 않은 상태임
		   return "redirect:/a001/login";
	   } else {
		   return "index";
	   }
	   
	   
   }
}

