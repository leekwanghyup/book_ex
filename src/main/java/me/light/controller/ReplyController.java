package me.light.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import me.light.domain.Criteria;
import me.light.domain.ReplyVO;
import me.light.service.ReplyService;

@Controller
@RequestMapping("/replies")
public class ReplyController {
	
	@Autowired
	private ReplyService service; 
	
	@PostMapping(value = "/new", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = { MediaType.TEXT_PLAIN_VALUE})
	@ResponseBody
    public ResponseEntity<String> create(@RequestBody ReplyVO vo) {
        int insertCount = service.register(vo);
        return insertCount == 1  
                ?  new ResponseEntity<>("success", HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // 목록
    @GetMapping(value = "/pages/{bno}/{page}", 
		produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
	public ResponseEntity<List<ReplyVO>> getList(
			@PathVariable("page") int page,  @PathVariable("bno") Long bno){
		Criteria cri = new Criteria(page, 10); 
		return new ResponseEntity<>(service.getList(cri, bno),HttpStatus.OK);
		// 요청 :  http://localhost:8080/replies/pages/4097/1 
	}

    //조회  
	@GetMapping(value = "/{rno}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public ResponseEntity<ReplyVO> get(@PathVariable("rno") Long rno){
		return new ResponseEntity<ReplyVO>(service.get(rno), HttpStatus.OK); 
	}
	// 요청 : http://localhost:8080/replies/5
	
	//삭제 
	@DeleteMapping(value = "/{rno}", produces = {MediaType.TEXT_PLAIN_VALUE})
	@ResponseBody
	public ResponseEntity<String> remove(@PathVariable("rno") Long rno){
		if(service.remove(rno) != 1) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<String>("succes",HttpStatus.OK); 
	}
	
	//수정
	@RequestMapping(value="/{rno}", method = {RequestMethod.PUT, RequestMethod.PATCH}, 
			consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE ) 
	@ResponseBody
	public ResponseEntity<String> modify(@RequestBody ReplyVO vo, @PathVariable("rno") Long rno){
		vo.setRno(rno);
		if(service.modify(vo) != 1) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR); 
		}
		return new ResponseEntity<String>("success", HttpStatus.OK); 
	}
	
}
