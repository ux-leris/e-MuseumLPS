package com.lpsmuseum.webmuseum.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lpsmuseum.dto.MuseologicalObject;
import com.lpsmuseum.dto.Scenario;
import com.lpsmuseum.service.MuseologicalObjectService;
import com.lpsmuseum.service.ScenarioService;

@Controller
public class ScenarioController {
	@RequestMapping("scenario")
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView("scenario/list");
		ArrayList<Scenario> sc = new ScenarioService().listScenarios();
		mv.addObject("list", sc);
		return mv;
	}
	
	@RequestMapping("scenario/create")
	public ModelAndView form() {
		ModelAndView mv = new ModelAndView("scenario/form");
		ArrayList<MuseologicalObject> obj = new MuseologicalObjectService().listObjects();
		mv.addObject("objects", obj);
		return mv;
	}
	
	@RequestMapping("scenario/edit")
	public ModelAndView edit(Long id) {
		ModelAndView mv = new ModelAndView("scenario/edit");
		mv.addObject("scenario", new ScenarioService().findById(id));
		return mv;
	}
	
	@RequestMapping("scenario/delete")
	public String delete(Long id){
		new ScenarioService().deleteScenario(id);
		return "forward:/scenario";
	}
}
