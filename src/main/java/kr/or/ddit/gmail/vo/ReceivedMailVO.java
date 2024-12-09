package kr.or.ddit.gmail.vo;

import lombok.Data;

@Data
public class ReceivedMailVO {
	private String rmailAccount;
	private String empId;
	private String rmailMessageid;
	private String rmailTitle;
	private String rmailDate;
	private String rmailTo;
	private String rmailFrom;
	private String rmailCalltime;
	
	
}
