package kr.or.ddit.schedule.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/{companyId}/schedule")
public class ScheduleCotroller {
	
	@GetMapping
	public String getScheduleList(
			@PathVariable("companyId") String companyId,
            HttpSession session,
            Model model) {
		
		return "schedule/scheduleList";
	}
	
}
