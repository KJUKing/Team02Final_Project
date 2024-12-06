package kr.or.ddit.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoticeVO {
    private String noticeNo;       // 공지사항 번호 (VARCHAR2(20))
    private String noticeName;     // 공지사항 제목 (VARCHAR2(100))
    private String noticeContent;  // 공지사항 내용 (VARCHAR2(4000))
    private Date noticeDate;     // 작성일 (DATE)
    private byte[] noticeImg;      // 공지사항 이미지 (BLOB)
    private String empId;          // 사원번호 (VARCHAR2(10))
    private String noticeImportant;          // 중요 여부 (CHAR(1))
}

