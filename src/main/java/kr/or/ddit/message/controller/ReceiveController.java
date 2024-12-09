package kr.or.ddit.message.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/{companyId}/message/receive")
public class ReceiveController {
	
	@GetMapping
	public String getReceiveList(@PathVariable("companyId") String companyId,
            HttpSession session,
            Model model) {
		
		return "message/receiveList";
	}
}
