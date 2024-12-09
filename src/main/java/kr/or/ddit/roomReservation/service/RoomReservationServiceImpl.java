package kr.or.ddit.roomReservation.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.commons.enumpkg.ServiceResult;
import kr.or.ddit.roomReservation.dao.RoomReservationMapper;
import kr.or.ddit.roomReservation.vo.RoomReservationVO;

@Service
public class RoomReservationServiceImpl implements RoomReservationService {

	@Inject
	private RoomReservationMapper dao;
	
	@Override
	public ServiceResult createRoomReser(RoomReservationVO roomReser) {
		if (dao.insertRoomReser(roomReser) > 0) {
			return ServiceResult.OK;
		} else {
			return ServiceResult.FAIL;
		}
	}

	@Override
	public RoomReservationVO readRoomReser(String reserId) {
		// TODO Auto-generated method stub
		return dao.selectRoomReser(reserId);
	}

	@Override
	public List<RoomReservationVO> readRoomReserList() {
		// TODO Auto-generated method stub
		return dao.selectRoomReserList();
	}

	@Override
	public ServiceResult modifyRoomReser(RoomReservationVO roomReser) {
		if (dao.updateRoomReser(roomReser) > 0) {
			return ServiceResult.OK;
		} else {
			return ServiceResult.FAIL;
		}
	}

	@Override
	public ServiceResult removeRoomReser(String reserId) {
		if (dao.deleteRoomReser(reserId) > 0) {
			return ServiceResult.OK;
		} else {
			return ServiceResult.FAIL;
		}
	}

}
