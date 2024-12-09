package kr.or.ddit.employee.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.employee.vo.EmployeeVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/{companyId}/mypage")
public class EmployeeMyPageController {
	// 마이페이지 전체 페이지
	@GetMapping
	public String getMyPagePage() {
		return "employee/emplyeeMyPage";
	}
	
	// 개인정보수정 페이지로 이동
	@GetMapping("edit")
	public String getUpdateMyInfoForm(HttpSession session, Model model) {
		EmployeeVO myEmp = (EmployeeVO)session.getAttribute("myEmp");
		model.addAttribute("myEmp", myEmp);
		return "employee/employeeUpdateForm";
	}
	
	@PostMapping("edit")
	public String updateMyInfo() {
		return "";
	}
	
	
	// 나의 근태, 휴가 조회 페이지로 이동
	@GetMapping("mylist")
	public String getMyAttendanceVacation() {
		return "employee/employeeAttendanceVacationPage";
	}

}
