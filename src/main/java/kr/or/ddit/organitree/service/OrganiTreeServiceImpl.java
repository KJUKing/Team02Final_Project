package kr.or.ddit.organitree.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.ddit.organitree.dao.OrganiTreeMapper;
import kr.or.ddit.vo.DepartmentVO;
import kr.or.ddit.vo.EmployeeVO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OrganiTreeServiceImpl implements OrganiTreeService {
	
	
	private final OrganiTreeMapper dao;
	
	@Override
	public List<DepartmentVO> readOrganiList() {		
		return dao.selectOrganiList();
	}

	@Override
	public List<EmployeeVO> readOrganiMemberList(String teamId) {
		
		return dao.selectOrganiTeamMemberList(teamId);
	}
	
	

}