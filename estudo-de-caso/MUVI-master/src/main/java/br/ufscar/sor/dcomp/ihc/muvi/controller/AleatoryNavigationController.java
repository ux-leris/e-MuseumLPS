package br.ufscar.sor.dcomp.ihc.muvi.controller;

import br.ufscar.sor.dcomp.ihc.muvi.model.MuviMuseum;
import br.ufscar.sor.dcomp.ihc.muvi.util.NavigationUtil;
import com.lpsmuseum.behaviour.museum.navigation.Node;
import com.lpsmuseum.dto.Museum;
import com.lpsmuseum.service.MuseumService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author USER
 */
@Controller
public class AleatoryNavigationController {
	
	private MuviMuseum museum;
	private String view;

	public AleatoryNavigationController() throws Exception {
		Museum museum = new MuseumService().findById(1L);
		if (museum == null)
			throw new Exception("Museum doesn't exist");
		this.museum = new MuviMuseum(museum);
		view = "aleatory-navigation";
	}

	@RequestMapping("navegar/a/proximo")
	public ModelAndView next(HttpServletRequest request, @RequestParam(required = false) Node node) {
		System.out.println("Indo para o próximo cenário...");
		
		Node navigationNode = (node != null) ? node : (Node) request.getSession().getAttribute("navigationNode");
		navigationNode = navigationNode.getNeighbor();
		request.getSession().setAttribute("navigationNode", navigationNode);
		
		return NavigationUtil.getModelAndView(view, museum, navigationNode);
	}

	@RequestMapping("navegar/a/anterior")
	public ModelAndView back(HttpServletRequest request, @RequestParam(required = false) Node node) {
		System.out.println("Indo para o cenário anterior...");
		
		Node navigationNode = (node != null) ? node : (Node) request.getSession().getAttribute("navigationNode");
		navigationNode = navigationNode.doBacktrack();
		request.getSession().setAttribute("navigationNode", navigationNode);
		
		return NavigationUtil.getModelAndView(view, museum, navigationNode);
	}
	
	@RequestMapping("navegar/a/ir")
	public ModelAndView goToScenario(HttpServletRequest request, 
			@RequestParam(value = "para") Long scenarioId, 
			@RequestParam(required = false) Node node) {
		System.out.println("Indo para o cenário de id " + scenarioId);
		
		Node navigationNode = (node != null) ? node : (Node) request.getSession().getAttribute("navigationNode");
		
		if (navigationNode.getScenario().getId() < scenarioId)
			while (navigationNode.getScenario().getId() != scenarioId)
				navigationNode = navigationNode.getNeighbor();
		else
			while (navigationNode.getScenario().getId() != scenarioId)
				navigationNode = navigationNode.doBacktrack();
		
		request.getSession().setAttribute("navigationNode", navigationNode);
		
		return NavigationUtil.getModelAndView(view, museum, navigationNode);
	}
}
