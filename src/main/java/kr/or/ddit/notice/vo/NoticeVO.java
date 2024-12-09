package kr.or.ddit.notice.vo;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import kr.or.ddit.atch.vo.AtchFileDetailVO;
import kr.or.ddit.atch.vo.AtchFileVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.lang.Nullable;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoticeVO {

    private String noticeNo;          // 공지사항 번호 (PK)
    @NotBlank
    @Size(max = 200)
    private String noticeName;        // 공지사항 제목
    @NotBlank
    @Size(max = 4000)
    private String noticeContent;     // 공지사항 내용

    @DateTimeFormat(iso = ISO.DATE_TIME)
    private LocalDate noticeDate;     // 작성일

    private byte[] noticeImg;         // 공지사항 이미지 (BLOB -> byte[])
    private String noticeImportant;   // 중요 공지 여부 (Y/N)
    private String empId;             // 작성자 사원 번호 (FK)

    // 첨부파일 관련 추가
    @Nullable
    private Integer atchFileId;

    @JsonIgnore
    @ToString.Exclude
    @Nullable
    @Valid
    private AtchFileVO atchFile;

    @JsonIgnore
    @ToString.Exclude
    private MultipartFile[] uploadFiles;

    public void setUploadFiles(MultipartFile[] uploadFiles) {
        List<AtchFileDetailVO> fileDetails = Optional.ofNullable(uploadFiles)
                .map(Arrays::stream)
                .orElse(Stream.empty())
                .filter(f->!f.isEmpty())
                .map(AtchFileDetailVO::new)
                .collect(Collectors.toList());
        if(!fileDetails.isEmpty()) {
            this.uploadFiles = uploadFiles;
            atchFile = new AtchFileVO();
            atchFile.setFileDetails(fileDetails);
        }
    }
}


