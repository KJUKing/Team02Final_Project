package kr.or.ddit.notice.dao;

import kr.or.ddit.commons.paging.PaginationInfo;
import kr.or.ddit.vo.NoticeVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NoticeMapper{
    public int insertNotice(NoticeVO notice);



    public NoticeVO selectNoticeById(int NoticeId);

    public int updateNotice(NoticeVO notice);

    public int deleteNotice(int NoticeId);

    public int selectTotalRecord(@Param("paging") PaginationInfo<NoticeVO> paging);

    public List<NoticeVO> selectNoticeList(@Param("paging") PaginationInfo<NoticeVO> paging);
}
