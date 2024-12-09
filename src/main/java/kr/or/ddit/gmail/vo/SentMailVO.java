package kr.or.ddit.gmail.vo;

import lombok.Data;

@Data
public class SentMailVO {
	private String smailAccount;
	private String empId;
	private String smailMessageid;
	private String smailTitle;
	private String smailDate;
	private String smailTo;
	private String smailFrom;
	private String smailCalltime;

}
