package kr.or.ddit.notice.service;

import kr.or.ddit.commons.enumpkg.ServiceResult;
import kr.or.ddit.commons.paging.PaginationInfo;
import kr.or.ddit.notice.dao.NoticeMapper;
import kr.or.ddit.vo.NoticeVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class NoticeServiceImpl implements NoticeService{

    @Autowired
    private final NoticeMapper dao;

    @Override
    public ServiceResult createNotice(NoticeVO notice) {
        return null;
    }

    @Override
    public ServiceResult modifyNotice(NoticeVO notice) {
        return null;
    }

    @Override
    public ServiceResult removeNotice(int NoticeId) {
        return null;
    }

    @Override
    public List<NoticeVO> readNoticeList(PaginationInfo<NoticeVO> paging) {

        if (paging != null) {
            int totalRecord = dao.selectTotalRecord(paging);
            paging.setTotalRecord(totalRecord);
        }
        return dao.selectNoticeList(paging);
    }

    @Override
    public NoticeVO readNoticeDetail(int NoticeId) {
        return null;
    }
}
