package kr.or.ddit.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.cloud.service.CloudStorageService;

@Controller
@RequestMapping("/{companyId}/perCloud")
public class PersonalCloudStorageController {
	
	@Autowired
	private CloudStorageService service;
	
	@GetMapping
	public String getPersonalCloudStorage() {
		return "cloud/personalStorage";
	}
}