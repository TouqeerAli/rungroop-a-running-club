package com.rungroup.web.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.rungroup.web.dto.ClubDTO;
import com.rungroup.web.model.Club;
import com.rungroup.web.service.ClubService;

@Controller
public class ClubController {
	private ClubService clubService;

	@Autowired
	public ClubController(ClubService clubService) {
		super();
		this.clubService = clubService;
	}
	
	@GetMapping("/clubs")
	public String listClubs(Model model) {
		List<ClubDTO> clubs = clubService.findAllClubs();
		model.addAttribute("clubs", clubs);
		return "clubs-list";
		
	}
	
	@GetMapping("/clubs/new")
	public String craeteClub(Model model) {
		Club club = new Club();
		model.addAttribute("club", club);
		
		return "clubs-create";
		
	}
	
	@PostMapping("/clubs/new")
	public String saveClub(@ModelAttribute("club") Club club) {
		clubService.saveClub(club);
		return "redirect:/clubs";
	}
	
	
}
