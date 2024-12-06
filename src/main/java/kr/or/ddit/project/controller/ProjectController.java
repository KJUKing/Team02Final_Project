package kr.or.ddit.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.project.service.ProjectService;

@Controller
@RequestMapping("/{companyId}/project")
public class ProjectController {
	
	@Autowired
	private ProjectService service;
	
	@GetMapping
	public String getProjectList() {
		return "project/projectList";
	}
}
