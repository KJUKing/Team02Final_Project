package kr.or.ddit.employee.hrController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/{companyId}/hrEmployee")
public class HrEmployeeController {
	
	@GetMapping
	public String hrEmployeeList(
			@PathVariable String companyId
	) {
		return "hrEmp/hrEmployeeList";
	}
}
