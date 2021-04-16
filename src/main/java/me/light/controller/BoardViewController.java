package me.light.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;
import me.light.domain.Criteria;
import me.light.domain.PageDTO;
import me.light.service.BoardService;

@Log4j
@Controller
@RequestMapping("/board/**")
public class BoardViewController {

	@Autowired
	private BoardService service; 
	
	@GetMapping("/register")
	public void register() {}
	
	@GetMapping({"/get","/modify"})
	public void get(Long bno, Model model, @ModelAttribute("cri") Criteria cri) {
	    model.addAttribute("board",service.get(bno));
	}
	
	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		log.info("BoardController : mapping - /board/list");
		model.addAttribute("list", service.getList(cri));
		PageDTO pageDTO = new PageDTO(cri, service.getTotal(cri)); 
		System.out.println(pageDTO);
		model.addAttribute("pageMaker",pageDTO ); 
	}
}
	
