package kr.or.ddit.employee.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.account.service.AccountService;
import kr.or.ddit.account.vo.AccountVO;
import kr.or.ddit.commons.enumpkg.ServiceResult;
import kr.or.ddit.commons.exception.PKNotFoundException;
import kr.or.ddit.commons.validate.JoinGroup;
import kr.or.ddit.commons.validate.LoginGroup;
import kr.or.ddit.employee.service.EmployeeService;
import kr.or.ddit.employee.service.GoogleOAuthService;
import kr.or.ddit.employee.vo.EmployeeVO;
import kr.or.ddit.employee.vo.OAuthVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/{companyId}")
public class EmployeeJoinCheckController {
	
	@Inject
	private EmployeeService empService;
	@Inject
	private AccountService accountService;
	@Inject
	private GoogleOAuthService oauthService;
	
	@ModelAttribute("myEmp")
	public EmployeeVO myEmp(Model model) {
		EmployeeVO modelEmp = (EmployeeVO)model.getAttribute("myEmp");
		if(modelEmp!=null) {
			return modelEmp;
		} else {
			return new EmployeeVO();
		}
	}

	
	@GetMapping("mailCheck")
	public String mailCheck(
			@PathVariable("companyId") String companyId,
			@Validated(LoginGroup.class) AccountVO myAccount,
			BindingResult errors,
			RedirectAttributes redirectAttributes,
			HttpSession session
	) {
		if(!errors.hasErrors()) {
			try {
				AccountVO account = accountService.readAccountExist(myAccount);
				if (account.getAccountYn().equals("Y")) {
					// 회원 가입 가능한 계정의 경우, employee도 가지고 이동
					EmployeeVO myEmp = empService.readEmployeeForJoin(account.getAccountMail());
					session.setAttribute("emp", myEmp);
					redirectAttributes.addFlashAttribute("myEmp", myEmp);
					return String.format("redirect:/%s/join", companyId);
				} else {
					// 이미 회원가입이 완료된 경우
					redirectAttributes.addFlashAttribute("message", "이미 회원가입이 완료된 회원입니다.");
					redirectAttributes.addFlashAttribute("messageKind", "error");
					return String.format("redirect:/%s/login", companyId);
				}
			} catch (PKNotFoundException e) {
				// 등록된 계정이 없는 경우
				redirectAttributes.addFlashAttribute("message", "일치하는 정보가 없습니다.");
				redirectAttributes.addFlashAttribute("messageKind", "error");
				return String.format("redirect:/%s/login", companyId);
			}

		} else {
			redirectAttributes.addFlashAttribute("message", "빈 칸 없이 입력해주세요.");
			redirectAttributes.addFlashAttribute("messageKind", "error");
			return String.format("redirect:/%s/login", companyId);
		}
	}
		

	// 회원가입 페이지 보여주는 양식
	@GetMapping("join")
	public String getJoinForm() {
		return "/employee/employeeJoinForm";
	}
	
	@PostMapping("join")
	public String join(
			@PathVariable("companyId") String companyId,
			@Validated(JoinGroup.class) @ModelAttribute("myEmp")EmployeeVO myEmp,
			BindingResult errors,
			RedirectAttributes redirectAttributes,
			HttpSession session
	) {
		log.info(myEmp.toString());
		// 1. session에 저장되어있는 oauth 정보 insert
		OAuthVO myOAuth = (OAuthVO) session.getAttribute("myOAuth");
		redirectAttributes.addFlashAttribute("myOAuth",myOAuth);
		redirectAttributes.addFlashAttribute("myEmp",myEmp);
		
		// oauth 인증절차를 거치지 않았다면,
		if(myOAuth==null) {
			redirectAttributes.addFlashAttribute("message", "구글 계정 인증을 진행해주세요.");
			redirectAttributes.addFlashAttribute("messageKind", "error");
			return "redirect:/"+companyId+"/join";
		}
		
		ServiceResult empResult = empService.modifyEmployee(myEmp);
		ServiceResult oAuthResult = oauthService.createOAuth(myOAuth);
		ServiceResult accountResult = accountService.modifyStatusAccount(myOAuth.getOauthEmpmail());
		if(empResult==ServiceResult.OK && oAuthResult==ServiceResult.OK && accountResult==ServiceResult.OK) {
			// oauth insert랑 emp update 성공했을 때
			// session에 저장되어있는 데이터 초기화하기
			session.invalidate();
			redirectAttributes.addFlashAttribute("message", "회원가입에 성공했습니다!");
			redirectAttributes.addFlashAttribute("messageKind", "success");
			return "redirect:/"+companyId+"/login";
		} else {
			// 둘 중에 하나라도 실패했을 때
			redirectAttributes.addFlashAttribute("message", "회원가입에 실패했습니다. 다시 시도해주세요.");
			redirectAttributes.addFlashAttribute("messageKind", "error");
			return "redirect:/"+companyId+"/join";
		}		
	}
}