package kr.or.ddit.organiSystem;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/{company}/organiSystem")
public class OrganiSystemController {
	
	@GetMapping
	public String organiSystem() {
		return "organiSystem/organiSystem";
	}
	
}
