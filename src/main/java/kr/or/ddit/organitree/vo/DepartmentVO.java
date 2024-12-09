package kr.or.ddit.organitree.vo;

import java.util.List;

import kr.or.ddit.employee.vo.EmployeeVO;
import lombok.Data;

@Data
public class DepartmentVO {
	
	private String departCode;
	private String departParentcode;
	private String contractId;
	private String departName;
	private String departStatus;
	private String departHead;
	
	private List<EmployeeVO> employeeList;
	
}
