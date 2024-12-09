package kr.or.ddit.vo;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;

@Data
public class QuestionVO {
	private String quNo;				// 문의 게시글 번호
	private String quTitle;				// 문의 게시글 제목
	private String quContent;			// 문의 게시글 내용
//	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate quDate;			// 문의 게시글 작성 날짜
	private String quYn;				// 문의 게시글 답변 여부
	private String answContent;			// 문의 게시글 답변 내용
//	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate answDate;			// 문의 게시글 답변 작성 날짜
	private String questionId;			// 문의 게시글 작성자 ID
	private CategoryVO categoryVO;		// 문의 게시글 카테고리 번호
	private String answerId;			// 문의 게시글 답변 작성자 ID(운영자)
}
