package kr.or.ddit.roomReservation.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.roomReservation.dao.RoomReservationMapper;
import kr.or.ddit.vo.RoomReservationVO;

@Service
public class RoomReservationServiceImpl implements RoomReservationService {

	@Inject
	private RoomReservationMapper dao;
	
	@Override
	public boolean createRoomReser(RoomReservationVO roomReser) {
		// TODO Auto-generated method stub
		return dao.insertRoomReser(roomReser)>0;
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
	public boolean modifyRoomReser(RoomReservationVO roomReser) {
		// TODO Auto-generated method stub
		return dao.updateRoomReser(roomReser)>0;
	}

	@Override
	public boolean removeRoomReser(String reserId) {
		// TODO Auto-generated method stub
		return dao.deleteRoomReser(reserId)>0;
	}

}
