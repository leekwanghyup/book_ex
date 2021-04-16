package me.light.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.log4j.Log4j;
import me.light.domain.BoardVO;
import me.light.domain.Criteria;
import me.light.service.BoardService;

@Log4j
@Controller
@RequestMapping("/board/**")
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		log.info("BoardController : mapping - /board/list");
		model.addAttribute("list", service.getList(cri)); 
	}
	
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		service.register(board); 
		rttr.addFlashAttribute("result",board.getBno());
		return "redirect:/board/list"; 
	}
	
	@RequestMapping("/get")
	public String get(Long bno, Model model) {
		log.info("BoardController : mapping - /board/get");
		model.addAttribute("board",service.get(bno) );
		return "/board/get"; 
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr) {
	    if(service.modify(board)) {
	        rttr.addFlashAttribute("result","succes");
	    }
	    return "redirect:/board/list";
	}
	
	@PostMapping("/remove")
	public String remove(Long bno, RedirectAttributes rttr) {
	    if(service.remove(bno)) {
	        rttr.addFlashAttribute("result","succes");
	    }
	    return "redirect:/board/list";
	}
}
