package kr.or.ddit.employee.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.commons.enumpkg.ServiceResult;
import kr.or.ddit.commons.exception.PKNotFoundException;
import kr.or.ddit.employee.dao.EmployeeMapper;
import kr.or.ddit.vo.AccountVO;
import kr.or.ddit.vo.EmployeeVO;
import kr.or.ddit.vo.OAuthVO;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Inject
	private EmployeeMapper employeeMapper;
	
	// 로그인 관련
	@Override
	public EmployeeVO readEmployeeFromAccount(AccountVO account) {
		AccountVO myAccount = employeeMapper.selectAccountInfo(account);
		
		if(myAccount==null) {
			// 로그인 실패했으면
			throw new PKNotFoundException("로그인 정보가 존재하지 않습니다.");
		} else {
			// 성공했으면
			return readEmployee(myAccount.getAccountMail());
		}
	}
	
	@Override
	public ServiceResult readEmployee(EmployeeVO emp) {
		ServiceResult result = ServiceResult.OK; // FAIL
		if(employeeMapper.selectEmployeeCount(emp)!=1) {
			// 없음
			result = ServiceResult.FAIL;
		} 
		
		return result; 
	}
	
	@Override
	public EmployeeVO readEmployeeFromAccountMail(String accountMail) {
		EmployeeVO emp = employeeMapper.selectEmployeeInfo(accountMail);
		if(emp==null) {
			// 로그인 실패했으면
			throw new PKNotFoundException("로그인 정보가 존재하지 않습니다.");
		} else {
			// 성공했으면
			return emp;
		}
	}
	
	
	public EmployeeVO readEmployee(String accountMail) {
		EmployeeVO employee = employeeMapper.selectEmployeeInfo(accountMail);
		if(employee==null) {
			// 로그인 실패했으면
			throw new PKNotFoundException("로그인 정보가 존재하지 않습니다.");
		} else {
			// 성공했으면
			return employee;
		}
	}
	
	// 로그인 관련
	@Override
	public OAuthVO readOAuthInfo(String employeeId) {
		OAuthVO myOAuth = employeeMapper.selectOAuthInfo(employeeId);
		
		if(myOAuth==null) {
			// oauth 정보가 없으면
			throw new PKNotFoundException("oAuth 정보를 확인할 수 없습니다.");
		} else {
			// oauth 정보가 있으면 리턴
			return myOAuth;
		}
	}
	
	
	// 회원가입관련
	@Override
	public EmployeeVO joinCheck(String empId) {
		EmployeeVO myEmp = employeeMapper.selectAccountJoinCheck(empId);
		if(myEmp==null) {
			throw new PKNotFoundException();
		} 
		return myEmp;
	}
	
	// 회원가입 및  회원정보수정관련
	@Override
	public ServiceResult modifyEmployee(EmployeeVO employee) {
		ServiceResult result = ServiceResult.FAIL;
		int rowcnt = employeeMapper.updateEmployee(employee);
		if(rowcnt>0) {
			// 성공
			result = ServiceResult.OK;
		} 
		return result;
	}


	
	
	

}
