package kr.or.ddit.employee.service;

import kr.or.ddit.commons.enumpkg.ServiceResult;
import kr.or.ddit.vo.AccountVO;
import kr.or.ddit.vo.EmployeeVO;
import kr.or.ddit.vo.OAuthVO;

public interface EmployeeService {
	// 로그인 관련
	/**
	 * 로그인 시 이메일, 비밀번호 일치여부 확인 메소드
	 * 로그인 시 입력받은 이메일과 비밀번호로 Account 테이블 조회
	 * @param account : 이메일과 비밀번호
	 * @return : account의 데이터와 일치하는 employee
	 */
	public EmployeeVO readEmployeeFromAccount(AccountVO account);
	
	/**
	 * 비밀번호 찾기 혹은 문자인증 진행시 정보와 일치하는 정보가 있는지 확인
	 * @param emp
	 * @return OK(있음) FAIL(없음)
	 */
	public ServiceResult readEmployee(EmployeeVO emp);
	
	public EmployeeVO readEmployeeFromAccountMail(String accountMail);
		
	
	/**
	 * email 정보를 통해 oauth 정보 가지고 오기
	 * @param empEmail
	 * @return 일치하는 oauth 정보
	 */
	public OAuthVO readOAuthInfo(String empEmail);
	

	
	// 회원가입관련
	/**
	 * 회원가입 가능 여부 체크(account mail을 통해)
	 * @param 회원가입 창에서 회원이 작성한 mail
	 * @return table에 있는 회원이면 ServiceResult.OK, 없으면 ServiceResult.FAIL
	 * exception 처리 해야함
	 */
	public EmployeeVO joinCheck(String accountMail);
	
	// 회원가입 및 회원정보수정
	/**
	 * 회원의 회원가입(insert 아니고 update) 혹은 마이페이지를 통한 개인정보 수정
	 * @return
	 */
	public ServiceResult modifyEmployee(EmployeeVO employee);
	


}
