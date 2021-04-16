package me.light.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import me.light.service.BoardService;

@Controller
@RequestMapping("/board/**")
public class BoardViewController {

	@Autowired
	private BoardService service; 
	
	@GetMapping("/register")
	public void register() {}
	
	@GetMapping({"/get","/modify"})
	public void get(Long bno, Model model) {
	    model.addAttribute("board",service.get(bno));
	}
}
