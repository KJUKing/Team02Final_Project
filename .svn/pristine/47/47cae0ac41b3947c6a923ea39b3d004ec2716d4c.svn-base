package kr.or.ddit.room.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.or.ddit.vo.RoomVO;
@Mapper
public interface RoomMapper {
	public int insertRoom(RoomVO room);
	public RoomVO selectRoom(String roomId);
	public List<RoomVO> selectRoomList();
	public int updateRoom(@Param("roomId")RoomVO room);
	public int deleteRoom(@Param("roomId") String roomId);
}
