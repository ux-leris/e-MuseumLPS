package com.lpsmuseum.webmuseum.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lpsmuseum.dto.Museum;
import com.lpsmuseum.service.MuseumService;

@Controller
public class MuseumController {
	
	@RequestMapping("museum")
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView("museum/list");
		ArrayList<Museum> mus = new MuseumService().listMuseum();
		mv.addObject("list", mus);
		return mv;
	}
	
	@RequestMapping("museum/edit")
	public ModelAndView edit(Long id){	
		ModelAndView mv = new ModelAndView("museum/edit");
		mv.addObject("museum", new MuseumService().findById(id));
		return mv;
	}
	
	@RequestMapping("museum/delete")
	public String delete(Long id){
		new MuseumService().deleteMuseum(id);
		return "redirect:/museum";
	}
}
