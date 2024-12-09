package kr.or.ddit.organitree.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.organitree.service.OrganiTreeService;
import kr.or.ddit.vo.EmployeeVO;

@Controller
@RequestMapping("/work2gether/{companyId}/organiEmployee")
public class OrganiEmployeeController {
	
	@Inject
	private OrganiTreeService service;
	
	// 부서 내 사원 목록 조회  
	@GetMapping
	@ResponseBody
	public List<EmployeeVO> organiEmployeeList(
			@PathVariable String companyId
			, @RequestParam(required = true) String teamId
	){

		return service.readOrganiMemberList(teamId);
	}
	
}
