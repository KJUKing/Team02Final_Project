package kr.or.ddit.room.service;

import java.util.List;

import kr.or.ddit.commons.enumpkg.ServiceResult;
import kr.or.ddit.vo.RoomVO;

public interface RoomService {
	public ServiceResult createRoom(RoomVO room);
	public RoomVO readRoom(String roomId);
	public List<RoomVO> readRoomList();
	public ServiceResult modifyRoom(RoomVO read);
	public ServiceResult removeRoom(String roomId);
}
