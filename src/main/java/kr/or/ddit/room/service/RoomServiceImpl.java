package kr.or.ddit.room.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.commons.enumpkg.ServiceResult;
import kr.or.ddit.room.dao.RoomMapper;
import kr.or.ddit.vo.RoomVO;
@Service
public class RoomServiceImpl implements RoomService {

	@Inject
	private RoomMapper dao;
	
	@Override
	public ServiceResult createRoom(RoomVO room) {
		if (dao.insertRoom(room) > 0) {
			return ServiceResult.OK;
		} else {
			return ServiceResult.FAIL;
		}
	}

	@Override
	public RoomVO readRoom(String roomId) {
		// TODO Auto-generated method stub
		return dao.selectRoom(roomId);
	}

	@Override
	public List<RoomVO> readRoomList() {
		// TODO Auto-generated method stub
		return dao.selectRoomList();
	}

	@Override
	public ServiceResult modifyRoom(RoomVO room) {
		if (dao.updateRoom(room) > 0) {
			return ServiceResult.OK;
		} else {
			return ServiceResult.FAIL;
		}
	}

	@Override
	public ServiceResult removeRoom(String roomId) {
		if (dao.deleteRoom(roomId) > 0) {
			return ServiceResult.OK;
		} else {
			return ServiceResult.FAIL;
		}
	}

}