package kr.or.ddit.notice.service;

import kr.or.ddit.atch.vo.AtchFileDetailVO;
import kr.or.ddit.commons.enumpkg.ServiceResult;
import kr.or.ddit.commons.paging.PaginationInfo;
import kr.or.ddit.notice.vo.NoticeVO;

import java.util.List;

public interface NoticeService {

    /**
     * 공지사항 작성
     * @param notice
     * @return
     */
    public ServiceResult createNotice(NoticeVO notice);

    /**
     * 공지사항 수정
     * @param notice
     * @return
     */
    public ServiceResult modifyNotice(NoticeVO notice);

    /**
     * 공지사항 삭제
     * @param NoticeNo
     * @return
     */
    public void removeNotice(String NoticeNo);

    /**
     * 공지사항 리스트
     * @return
     */
    public List<NoticeVO> readNoticeList(PaginationInfo<NoticeVO> paging); // Pagination 넣어야함


    /**
     * 공지사항 상세조회
     * @param NoticeNo
     * @return
     */
    public NoticeVO readNoticeDetail(String NoticeNo);

    public AtchFileDetailVO download(int atchFileId, int fileSn);

    public void removeFile(int atchFileId, int fileSn);
}
