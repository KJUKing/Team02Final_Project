package kr.or.ddit.employee.vo;

import lombok.Data;

@Data
public class OAuthVO {
	private String empId;
	private String oauthAccess;
	private String oauthRefresh;
	private String oauthEmpmail;
}
