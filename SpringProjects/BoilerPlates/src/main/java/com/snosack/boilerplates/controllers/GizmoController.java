package com.snosack.boilerplates.controllers;

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

import com.snosack.boilerplates.models.Gizmo;
import com.snosack.boilerplates.models.User;
import com.snosack.boilerplates.services.GizmoService;
import com.snosack.boilerplates.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class GizmoController {
	
	@Autowired
	UserService userServ;
	
	@Autowired
	GizmoService gizmoServ;
	
	@GetMapping("/addgizmo")
	public String addGizmo(@ModelAttribute("gizmo") Gizmo gizmo, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/";
		}
		User user = userServ.findUser(userId);
		model.addAttribute("user", user);
		model.addAttribute("gizmo", gizmo);
		return "create.jsp";
	}
	
	@PostMapping("/creategizmo")
	public String create(@Valid @ModelAttribute("gizmo") Gizmo gizmo, BindingResult result, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/";
		}
		if (result.hasErrors()) {
			User user = userServ.findUser(userId);
			model.addAttribute("user", user);
			model.addAttribute("gizmo", gizmo);
			return "create.jsp";
		} else {
			User user = userServ.findUser(userId);
			gizmo.setUser(user);
			gizmoServ.createGizmo(gizmo);
			return "redirect:/home";
		}
	}
	
	@GetMapping("/gizmos/{gizmoId}")
	public String view(Model model, @PathVariable("gizmoId") Long id, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/";
		}
		User user = userServ.findUser(userId);
		model.addAttribute("user", user);
		Gizmo gizmo = gizmoServ.findGizmo(id);
		model.addAttribute("gizmo", gizmo);
		return "view.jsp";
	}
	
	@GetMapping("/gizmos/{gizmoId}/edit")
	public String edit(@PathVariable("gizmoId") Long id, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/";
		}
		User user = userServ.findUser(userId);
		model.addAttribute("user", user);
		Gizmo gizmo = gizmoServ.findGizmo(id);
		model.addAttribute("gizmo", gizmo);
		return "edit.jsp";
	}
	
	@RequestMapping(value="/gizmos/{gizmoId}", method=RequestMethod.PUT)
	public String update(@PathVariable("gizmoId") Long gizmoId, @Valid @ModelAttribute("gizmo") Gizmo gizmo, BindingResult result, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/";
		}
		if (result.hasErrors()) {
			User user = userServ.findUser(userId);
			model.addAttribute("user", user);
			model.addAttribute("gizmo", gizmo);
			return "edit.jsp";
		} else {
			User user = userServ.findUser(userId);
			gizmo.setUser(user);
			gizmo.setId(gizmoId);
			gizmoServ.updateGizmo(gizmo);
			return "redirect:/home";
		}
	}
	
	@RequestMapping(value="/gizmos/{gizmoId}/delete", method=RequestMethod.DELETE)
	public String destroy(@PathVariable("gizmoId") Long id) {
		gizmoServ.deleteGizmo(id);
		return "redirect:/home";
	}

}