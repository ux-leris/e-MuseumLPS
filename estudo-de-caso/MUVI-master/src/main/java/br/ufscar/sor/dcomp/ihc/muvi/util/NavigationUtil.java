package br.ufscar.sor.dcomp.ihc.muvi.util;

import br.ufscar.sor.dcomp.ihc.muvi.model.MuviMuseum;
import br.ufscar.sor.dcomp.ihc.muvi.model.NavigationItem;
import com.lpsmuseum.behaviour.museum.navigation.Node;
import com.lpsmuseum.dto.Scenario;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author gois
 */
public class NavigationUtil {

    public static List<NavigationItem> arrangeData(List<Scenario> scenarios) {
        List<NavigationItem> navigationItems;

        navigationItems = new ArrayList<NavigationItem>();

		long l = 0;
		for (Scenario scenario : scenarios) {
			if (l != scenario.getId()) {
				navigationItems.add(new NavigationItem(scenario));
				l = scenario.getId();
			}
        }

        return navigationItems;
    }

    /*public static List<NavigationItem> arrangeData(List<MuseologicalObject> museologicalObjects) {
        List<NavigationItem> navigationItems;

        navigationItems = new ArrayList<NavigationItem>();

        for (MuseologicalObject museologicalObject : museologicalObjects) {
            boolean notNew = false;
            if (museologicalObject instanceof Image) {
                System.out.println("img: " + museologicalObject.getName());
            } else {
                System.out.println("txt: " + museologicalObject.getName());
            }
            for (NavigationItem navigationItem : navigationItems) {
                System.out.println("ni: " + navigationItem.getName());
                if (notNew = navigationItem.set(museologicalObject)) {
                    System.out.println("Atualizado");
                    break;
                }
            }

            if (!notNew) {
                navigationItems.add(new NavigationItem(museologicalObject));
                System.out.println("Inserido");
            }
        }

        return navigationItems;
    }*/
	
	public static ModelAndView getModelAndView(String view, MuviMuseum museum, 
			Node navigationNode) {
		ModelAndView mv = new ModelAndView(view);
		
		mv.addObject("museum", museum);
		mv.addObject("navigationNode", navigationNode);
		mv.addObject("items", new NavigationItem(navigationNode.getScenario()));
		
		System.out.println("--------------- Nav. Node ---------------");
		mv.addObject("hasPrevious", canBacktrack(navigationNode));
		System.out.println("Actual\t: " + navigationNode.getScenario().getName());
		mv.addObject("hasNext", haveNeighbor(navigationNode));
		System.out.println("-----------------------------------------");
		
		mv.addObject("atual", getCurrentIndex(museum, navigationNode) + 1);
		mv.addObject("numItems", museum.getScenarios().size());
		
		return mv;
	}
	
	private static boolean canBacktrack(Node node) {
		boolean canBacktrack;
		
		Node backtrack = node.doBacktrack();
		
		if (backtrack == null || backtrack.getScenario() == null) {
			System.out.println("Back\t: NULL");
			canBacktrack = false;
		} else {
			System.out.println("Back\t: " + backtrack.getScenario().getName());
			canBacktrack = true;
		}
		
		return canBacktrack;
	}
	
	private static boolean haveNeighbor(Node node) {
		boolean haveNeighbor;
		
		Node neighbor = null;
		
		if (node.getNeighbors().size() > 0)
			neighbor = node.getNeighbor();
		
		if (neighbor == null || neighbor.getScenario() == null) {
			System.out.println("Next\t: NULL");
			haveNeighbor = false;
		} else {
			System.out.println("Next\t: " + neighbor.getScenario().getName());
			haveNeighbor = true;
		}
		
		return haveNeighbor;
	}
	
	
	
	@SuppressWarnings("empty-statement")
	private static int getCurrentIndex(MuviMuseum museum, Node node) {
		int i = 0;
		
		for (List<Scenario> scenarios = museum.getScenarios(); i < scenarios.size(); i++) {
			if (scenarios.get(i).getId() == node.getScenario().getId())
				break;
		}
		
		return i;//museum.getScenarios().indexOf(node.getScenario());
	}

}
