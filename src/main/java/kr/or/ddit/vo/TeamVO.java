package kr.or.ddit.vo;

import java.util.List;

import lombok.Data;

@Data
public class TeamVO {
	
	private String teamId;
	private String teamName;
	private String depatId;
	
	private List<TeamMemberVO> teamMemberList;
	
}
