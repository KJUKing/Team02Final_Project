package kr.or.ddit.room.vo;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.roomTime.vo.RoomTimeVO;
import kr.or.ddit.timeReservation.vo.TimeReservationVO;
import lombok.Data;
import lombok.ToString;

@Data
public class RoomVO {
	private String roomId;
	private String roomHosu;
	private String roomName;
	private Long roomNum;
	private byte[] roomImg;
	private MultipartFile roomImage;
	
	public void setRoomImage(MultipartFile roomImage) throws IOException {
		if(roomImage==null || roomImage.isEmpty()) return; 
		this.roomImage = roomImage;
		this.roomImg = roomImage.getBytes();
	}
	
	public String getBase64Img() {
		if(roomImg!=null && roomImg.length>0) {
			return Base64.getEncoder().encodeToString(roomImg);
		}else {
			return null;
		}
	}
	
	private String roomDetail;
	private String roomYn;
	
	
	private List<RoomTimeVO> roomTimeList;
	
}