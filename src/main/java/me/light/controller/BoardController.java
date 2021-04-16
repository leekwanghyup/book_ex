package me.light.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		service.register(board); 
		rttr.addFlashAttribute("result",board.getBno());
		return "redirect:/board/list"; 
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr, @ModelAttribute("cri") Criteria cri) {
	    if(service.modify(board)) {
	        rttr.addFlashAttribute("result","modify");
	    }
	    rttr.addAttribute("pageNum",cri.getPageNum());
	    rttr.addAttribute("amount",cri.getAmount());
	    return "redirect:/board/list";
	}
	
	@PostMapping("/remove")
	public String remove(Long bno, RedirectAttributes rttr, @ModelAttribute("cri") Criteria cri) {
	    if(service.remove(bno)) {
	        rttr.addFlashAttribute("result","remove");
	    }
	    rttr.addAttribute("pageNum",cri.getPageNum());
	    rttr.addAttribute("amount",cri.getAmount());
	    return "redirect:/board/list";
	}
}
