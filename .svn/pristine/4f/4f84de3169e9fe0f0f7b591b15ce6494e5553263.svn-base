package kr.or.ddit.roomReservation.vo;

import java.util.List;

import kr.or.ddit.roomTime.vo.RoomTimeVO;
import lombok.Data;
import lombok.ToString;

@Data
public class RoomReservationVO {
	private String reserId;
	private String timeCode;
	private String roomId;
	private String reserCause;
	private String reserStatus;
	private String empId;
	
	
	@ToString.Exclude
	private RoomTimeVO roomTime; //부모는 이렇게 받아오기
	
}
