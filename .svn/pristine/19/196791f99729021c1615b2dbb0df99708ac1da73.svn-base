package kr.or.ddit.employee.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.or.ddit.vo.AccountVO;
import kr.or.ddit.vo.EmployeeVO;
import kr.or.ddit.vo.OAuthVO;

@Mapper
public interface EmployeeMapper {
	// 로그인 관련
	/**
	 * 로그인 정보 확인
	 * @param account : email과 password가 담긴 account
	 * @return null / not null
	 */
	public AccountVO selectAccountInfo(AccountVO account);
	
	/**
	 * account를 통해 조회된 정보를 가진 employee 정보
	 * @param empEmail
	 * @return null / not null
	 */
	public EmployeeVO selectEmployeeInfo(@Param("empEmail")String empEmail);
	
	/**
	 * 문자 인증 시 or 비밀번호 찾기 시 해당하는 데이터가 있는지 count
	 * @param emp
	 * @return
	 */
	public int selectEmployeeCount(EmployeeVO emp);
	
	/** 
	 * email 주소와 정보가 일치하는 oauth 정보
	 * @param empEmail
	 * @return null / not null
	 */
	public OAuthVO selectOAuthInfo(String empEmail);
	

	// 회원가입 관련
	/**
	 * 회원가입 가능 여부 확인
	 * @return null / not null
	 */
	public EmployeeVO selectAccountJoinCheck(@Param("accountMail")String accountMail);
	

	// 회원가입 / 비밀번호 오류 인증 / 마이페이지 관련
	/**
	 * 정보 업데이트
	 * @param emp
	 * @return
	 */
	public int updateEmployee(EmployeeVO emp);

}
