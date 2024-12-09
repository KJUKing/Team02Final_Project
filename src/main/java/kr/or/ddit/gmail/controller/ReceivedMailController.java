package kr.or.ddit.gmail.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/{companyId}/mail/received")
public class ReceivedMailController {
	@GetMapping
	public String getReceivedMailListPage(@PathVariable("companyId") String companyId) {
		return "mail/receivedMailList";
	}

}
