package kr.or.ddit.approval.service;

import kr.or.ddit.vo.ElectronicVO;

import java.util.List;

public interface ElectronicService {

    /**
     * 결재문서 리스트조회
     * @param empId
     * @return
     */
    List<ElectronicVO> readElectronicList(String empId);

    /**
     * 결재문서 상세조회
     * @param electronicId
     * @param empId
     * @return
     */
    ElectronicVO readElectronicDetail(String electronicId, String empId);

    /**
     * 결재문서 생성
     * @param electronicVO
     */
    void createElectronic(ElectronicVO electronicVO);

    /**
     * 결재문서 수정(1차 결재자 조회 전까지만 가능)
     * @param electronicId
     * @param electronicVO
     * @param empId
     */
    void modifyElectronic(String electronicId, ElectronicVO electronicVO, String empId);

    /**
     * 결재문서 삭제
     * @param electronicId
     * @param empId
     */
    void removeElectronic(String electronicId, String empId);
}
