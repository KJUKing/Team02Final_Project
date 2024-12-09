package kr.or.ddit.employee.vo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Base64;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.commons.validate.JoinGroup;
import kr.or.ddit.commons.validate.PhoneAuthGroup;
import kr.or.ddit.organitree.vo.PositionVO;
import kr.or.ddit.organitree.vo.TeamMemberVO;
import lombok.Data;
import net.coobird.thumbnailator.Thumbnails;

@Data
public class EmployeeVO {

	private String empId;
	@NotBlank(groups = JoinGroup.class)
	private String empPass;
	@NotBlank(groups = PhoneAuthGroup.class)
	private String empName;
	private String empBirth;
	@NotBlank(groups = JoinGroup.class)
	private String empGender;
	@NotBlank(groups = JoinGroup.class)
	private String empAddr1;
	@NotBlank(groups = JoinGroup.class)
	private String empAddr2;
	@NotBlank(groups = {PhoneAuthGroup.class,JoinGroup.class})
	@Pattern(regexp = "\\d{11}", message = "전화번호는 숫자 11자리여야 합니다.")
	private String empPhone;
	@NotBlank(groups = PhoneAuthGroup.class)
	private String empMail;
	private String empJoin;
	private String empStatus;
	// 회원 프로필 관리용 프러퍼티 (BLOB - Binary Large OBject)
	private byte[] empImg; // 데이터베이스 지원
	private MultipartFile empImage; // 클라이언트 업로드 파일 지원

	public void setEmpImage(MultipartFile empImage) throws IOException {
		if (empImage == null || empImage.isEmpty())
			return;

		this.empImage = empImage;
		this.empImg = compressImage(empImage);
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
		this.empSignimg = compressImage(empSignimage);
	}

	public String getBase64EmpSignimg() {
		if (empSignimg != null && empSignimg.length > 0) {
			return Base64.getEncoder().encodeToString(empSignimg);
		} else {
			return null;
		}
	}
	
	// 이미지 압축 메서드 (Thumbnailator 사용)
    private byte[] compressImage(MultipartFile image) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        // 이미지 압축 (예: 800px 크기 제한, 품질 70%)
        Thumbnails.of(empImage.getInputStream())
                  .size(300, 300)  // 크기 설정
                  .outputQuality(0.5)  // 품질 설정 (0.0 ~ 1.0)
                  .toOutputStream(outputStream);

        return outputStream.toByteArray();  // 압축된 이미지를 byte[]로 반환
    }

	private String posiId;
	private String departCode;
	
	
	private OAuthVO oAuth;

	private PositionVO position;
	private List<TeamMemberVO> teamMemberList;
	
	
}
