package kr.or.ddit.vo;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Base64;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class EmployeeVO {
	private String empId;
	private String empPass;
	private String empName;
	private LocalDate empBirth;
	private String empGender;
	private String empAddr1;
	private String empAddr2;
	private String empPhone;
	private String accountMail;
	private LocalDate empJoin;
	
	private String empStatus;
	private Long empVacation;
	private String posiId;
	private String sempId;

	// 회원 프로필 관리용 프러퍼티 (BLOB - Binary Large OBject)
	private byte[] empImg; // 데이터베이스 지원
	private MultipartFile empImage; // 클라이언트 업로드 파일 지원

	public void setEmpImage(MultipartFile empImage) throws IOException {
		if (empImage == null || empImage.isEmpty())
			return;

		this.empImage = empImage;
		this.empImg = empImage.getBytes();
	}

	public String getBase64EmpImg() {
		if (empImg != null && empImg.length > 0) {
			return Base64.getEncoder().encodeToString(empImg);
		} else {
			return null;
		}
	}
	
	// 회원 도장 관리용 프러퍼티 (BLOB - Binary Large OBject)
	private byte[] empSignimg; // 데이터베이스 지원
	private MultipartFile empSignimage; // 클라이언트 업로드 파일 지원

	public void setEmpSignimage(MultipartFile empSignimage) throws IOException {
		if (empSignimage == null || empSignimage.isEmpty())
			return;

		this.empSignimage = empSignimage;
		this.empSignimg = empSignimage.getBytes();
	}

	public String getBase64EmpSignimg() {
		if (empSignimg != null && empSignimg.length > 0) {
			return Base64.getEncoder().encodeToString(empSignimg);
		} else {
			return null;
		}
	}
	
	
	
	

	private OAuthVO oAuth;
	private List<TeamMemberVO> teamMemberList;
}
