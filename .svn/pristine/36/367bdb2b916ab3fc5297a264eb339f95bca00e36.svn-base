package kr.or.ddit.employee.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.commons.exception.PKNotFoundException;
import kr.or.ddit.commons.validate.LoginGroup;
import kr.or.ddit.employee.service.EmployeeService;
import kr.or.ddit.event.loginGmailEvent.LoginSuccessEvent;
import kr.or.ddit.vo.AccountVO;
import kr.or.ddit.vo.EmployeeVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/{companyId}/login")
public class EmployeeLoginController {
	@Inject
	private EmployeeService employeeService;
	
	@Autowired
    private ApplicationEventPublisher eventPublisher;
	
	@GetMapping
	public String getLoginForm() {
		return "/employee/employeeLoginForm";
	}
	
	
	/**
	 * 사용자가 login 정보를 입력하여 전송하면 해당 메소드로 매핑
	 */
	@PostMapping
	public String loginResult(
			@PathVariable("companyId") String companyId,
			@Validated(LoginGroup.class) AccountVO account,
			BindingResult errors,
			RedirectAttributes redirectAttributes,
			HttpSession session
	) {
		
		String urlRegex = "redirect:/%s/%s";
		
		if (!errors.hasErrors()) {
			// 검증 성공의 경우
			
			// account 테이블에서 정보가 일치하는지 아닌지 확인
			// 맞다면 employee 테이블을 통해 정보를 가져온 후 session 저장
			// 로그인 성공 redirect:/
			// 맞지 않다면 로그인 실패 redirect:/a001/login
			try {
				EmployeeVO myEmp = employeeService.readEmployeeFromAccount(account);
				if(myEmp.getEmpStatus().equals("U")||myEmp.getEmpStatus().equals("V")) {
					// 상태(U : 재직중 / V : 휴가) 로그인 가능
					session.setAttribute("myEmp", myEmp);
					session.setAttribute("myOAuth", myEmp.getOAuth());
					session.setAttribute("companyId", companyId);
					
					// 비동기 이벤트 실행
					eventPublisher.publishEvent(new LoginSuccessEvent(this, myEmp.getOAuth()));
					
					return String.format(urlRegex, companyId, "main");
				} else if(myEmp.getEmpStatus().equals("S")) {
					// 상태(S : 정지) 문자 인증을 통한 정지 해제 필요
					// 문자 인증을 위한 폼을 띄우도록 유도..
					redirectAttributes.addFlashAttribute("message", "정지된 계정입니다. 문자 인증을 진행해주세요.");
					return String.format(urlRegex, companyId, "login");
				} else {
					// 상태(Q : 퇴사) 로그인 불가능
					redirectAttributes.addFlashAttribute("message", "퇴사한 회원입니다. 로그인이 불가능합니다.");
					return String.format(urlRegex, companyId, "login");
				}
			} catch(PKNotFoundException e) {
				// 검증 실패의 경우, 카운트 필요
				Map<String, Integer> count = (Map<String, Integer>)session.getAttribute("countPassword");
				if(count==null) {
					// null이면
					count = new HashMap<>();
					count.put(account.getAccountMail(), 1);
				} else {
					// null이 아니면
					Integer failCount = count.get(account.getAccountMail());
					if(failCount>3) {
						// 인증 필요
						// 쿼리문을 날려서 해당 계정 상태 업데이트..
						EmployeeVO updateEmp = employeeService.readEmployeeFromAccountMail(account.getAccountMail());
						log.info(updateEmp.toString());
						updateEmp.setEmpStatus("S");
						employeeService.modifyEmployee(updateEmp);
					} else {
						// 3회 미만이면...
						count.put(account.getAccountMail(), failCount+1);
					}
				}
				
				session.setAttribute("countPassword",count);
				redirectAttributes.addFlashAttribute("message", "일치하는 정보가 없습니다.");
				return String.format(urlRegex, companyId, "login");
			}
			
			
			
		} else {
			redirectAttributes.addFlashAttribute("message","다시 시도해주세요.");
			return String.format(urlRegex, companyId, "login");
		}


	}
}
