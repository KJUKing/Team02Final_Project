package kr.or.ddit.room.service;

import static org.junit.jupiter.api.Assertions.*;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

import kr.or.ddit.annotation.RootContextWebConfig;
import kr.or.ddit.commons.enumpkg.ServiceResult;
import kr.or.ddit.vo.RoomVO;

@RootContextWebConfig
class RoomServiceImplTest {

	@Inject
	private RoomService service;
	
	@Test
	void testCreateRoom() {
		 RoomVO room = new RoomVO();
		    room.setRoomHosu("101"); // 예: 시설 호수
		    room.setRoomName("회의실"); // 예: 시설 이름
		    room.setRoomNum((long) 10); // 예: 수용 인원
		    room.setRoomImg(null); // 테스트에서는 이미지를 null로 처리
		    room.setRoomDetail("테스트 회의실입니다."); // 예: 시설 설명
		    room.setRoomYn("Y"); // 예: 이용 가능 여부

		    // 2. Service 호출 및 결과 검증
		    ServiceResult result = service.createRoom(room);
		    
	}
	

	@Test
	void testReadRoom() {
		assertNotNull(service.readRoom("R201"));
		
	
	}

	@Test
	void testReadRoomList() {
		assertDoesNotThrow(()->service.readRoomList());
	}

	@Test
	void testModifyRoom() {
		fail("Not yet implemented");
	}

	@Test
	void testRemoveRoom() {
		fail("Not yet implemented");
	}

}
