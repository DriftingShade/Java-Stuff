package com.snosack.beltprep.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.snosack.beltprep.models.Artist;
import com.snosack.beltprep.models.User;
import com.snosack.beltprep.services.ArtistService;
import com.snosack.beltprep.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ArtistController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	ArtistService artServ;
	
	@GetMapping("/artists/new")
	public String newForm(@ModelAttribute("artist") Artist artist, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if(userId == null) {
			return "redirect:/";
		}
		User user = userService.findUser(userId);
		model.addAttribute("user", user);
		model.addAttribute("artist", artist);
		return "newArtist.jsp";
	}
	
	@PostMapping("/artists/new")
	public String create(@Valid @ModelAttribute("artist") Artist artist, BindingResult result, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/";
		}
		if (result.hasErrors()) {
			User user = userService.findUser(userId);
			model.addAttribute("user", user);
			model.addAttribute("artist", artist);
			return "newArtist.jsp";
		} else {
			User user = userService.findUser(userId);
			artist.setUser(user);
			artServ.createArtist(artist);
			return "redirect:/dashboard";
		}
	}
	
	@GetMapping("/artists/{artistId}")
	public String view(@PathVariable("artistId") Long id, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/";
		}
		User user = userService.findUser(userId);
		model.addAttribute("user", user);
		Artist artist = artServ.findArtist(id);
		model.addAttribute(artist);
		return "oneArtist.jsp";
	}
	
	@GetMapping("/artists/{artistId}/edit")
	public String edit(@PathVariable("artistId") Long id, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/";
		}
		User user = userService.findUser(userId);
		model.addAttribute("user", user);
		Artist artist = artServ.findArtist(id);
		model.addAttribute("artist", artist);
		return "editArtist.jsp";
	}
	
	@RequestMapping(value="/artists/{artistId}", method=RequestMethod.PUT)
	public String update(@PathVariable("artistId") Long artistId, @Valid @ModelAttribute("artist") Artist artist, BindingResult result, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/";
		}
		if (result.hasErrors()) {
			User user = userService.findUser(userId);
			model.addAttribute("user", user);
			model.addAttribute("artist", artist);
			return "editArtist.jsp";
		} else {
			User user = userService.findUser(userId);
			artist.setUser(user);
			artist.setId(artistId);
			artServ.updateArtist(artist);
			return "redirect:/dashboard";
		}
	}
	
	@RequestMapping(value="/artists/{artistId}/delete", method=RequestMethod.DELETE)
	public String delete(@PathVariable("artistId") Long id) {
		artServ.deleteArtist(id);
		return "redirect:/dashboard";
	}
}
