package kr.or.ddit.vo;

import javax.validation.constraints.NotBlank;

import kr.or.ddit.commons.validate.LoginGroup;
import lombok.Data;

@Data
public class AccountVO {
	@NotBlank(groups = LoginGroup.class)
	private String accountMail;
	
	@NotBlank(groups = LoginGroup.class)
	private String accountPass;
	
	private String accountYn;

}
