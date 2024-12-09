package kr.or.ddit.room.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.commons.enumpkg.ServiceResult;
import kr.or.ddit.commons.validate.InsertGroup;
import kr.or.ddit.room.service.RoomService;
import kr.or.ddit.vo.NoticeVO;
import kr.or.ddit.vo.RoomVO;
import oracle.jdbc.proxy.annotation.Post;

@Controller
@RequestMapping("/{companyId}/room")
public class RoomController {
	
	@Autowired
	private RoomService service;
	
	public static final String MODELNAME = "room";
	
	@ModelAttribute(MODELNAME)
	   public RoomVO room() {
	      return new RoomVO();
	   }
	//시설 리스트
	@GetMapping
	public String getRoomList(
			@PathVariable("companyId") String companyId,
            HttpSession session,
            Model model) {
		
	        List<RoomVO> roomList = service.readRoomList();
	        model.addAttribute("roomList", roomList);
	        return "room/roomList";
	}
	
	//시설 상세보기
	@GetMapping("{roomId}")
	public String getRoomOne(@PathVariable("companyId") String companyId,
			@PathVariable("roomId") String roomId, Model model) {
		RoomVO room = service.readRoom(roomId);
		model.addAttribute("room", room);
		
		return "room/roomDetail";
	}
	
	//시설을 등록하는 폼
	@GetMapping("new")
	public String newRoomForm(@ModelAttribute(MODELNAME) RoomVO room) {
		
		return "room/roomForm";
	}
	
	//시설 등록
	@PostMapping
	public String insertRoom( @PathVariable("companyId") String companyId,
			@ModelAttribute(MODELNAME) RoomVO room, 
			HttpSession session,
			Errors errors,
			RedirectAttributes redirectAttributes) {
		
		//여기는 관리자만 가능하다...
		
        String lvn = null;
        redirectAttributes.addFlashAttribute(MODELNAME, room);

        if (!errors.hasErrors()){
        	//로직 실행~~
            ServiceResult result = service.createRoom(room);
            switch (result){
            //성공
                case OK:
                    lvn = "redirect:/"+ companyId+"/room";
                    break;
                    //실패
                
                default:
                	lvn ="redirect:/"+ companyId+"/room/new";
                    redirectAttributes.addFlashAttribute("message", "알 수 없는 오류가 발생했습니다.");
                    break;
            }
        } else {
        	// 기존 입력 데이터 전달
	         redirectAttributes.addFlashAttribute(MODELNAME, room);
            // 유효성 검사 실패인 경우 기존 데이터를 가지고 등록 폼으로 리다이렉트
            String errAttrName = BindingResult.MODEL_KEY_PREFIX + MODELNAME;
            redirectAttributes.addFlashAttribute(errAttrName, errors);
            lvn ="redirect:/"+ companyId+"/room/new";
        }
        return lvn;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
