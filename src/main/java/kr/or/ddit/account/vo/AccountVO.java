package kr.or.ddit.account.vo;

import javax.validation.constraints.NotBlank;

import kr.or.ddit.commons.validate.LoginGroup;
import kr.or.ddit.employee.vo.EmployeeVO;
import lombok.Data;

@Data
public class AccountVO {
	@NotBlank(groups = LoginGroup.class)
	private String accountMail;
	
	@NotBlank(groups = LoginGroup.class)
	private String accountPass;
	
	private String accountYn;
	
	private EmployeeVO employee;

}