package kr.or.ddit.organitree.service;

import java.util.List;

import kr.or.ddit.vo.DepartmentVO;
import kr.or.ddit.vo.EmployeeVO;

public interface OrganiTreeService {
		
	public List<DepartmentVO> readOrganiList();

	public List<EmployeeVO> readOrganiMemberList(String teamId);
}
