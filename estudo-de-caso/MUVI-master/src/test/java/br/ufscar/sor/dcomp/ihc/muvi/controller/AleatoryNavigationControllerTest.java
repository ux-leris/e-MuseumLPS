package br.ufscar.sor.dcomp.ihc.muvi.controller;

import br.ufscar.sor.dcomp.ihc.muvi.model.MuviMuseum;
import br.ufscar.sor.dcomp.ihc.muvi.model.NavigationItem;
import com.lpsmuseum.behaviour.museum.navigation.AleatoryNavigation;
import com.lpsmuseum.behaviour.museum.navigation.Node;
import com.lpsmuseum.service.MuseumService;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author USER
 */
public class AleatoryNavigationControllerTest {

	private static MuviMuseum museum;
	private static String view;
	private Node navigationNode;
	
	public AleatoryNavigationControllerTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
		museum = new MuviMuseum(new MuseumService().listMuseum().get(0));
		museum.setNavigation(new AleatoryNavigation());
		view = "aleatory-navigation";
	}
	
	@AfterClass
	public static void tearDownClass() {
		museum = null;
		view = null;
	}
	
	@Before
	public void setUp() {
		navigationNode = museum.navigate();
	}
	
	@After
	public void tearDown() {
		navigationNode = null;
	}

	/**
	 * Test of next method, of class AleatoryNavigationController.
	 */
	@Test
	public void testNextAtFirst() {
		System.out.println("next");
		
		HttpServletRequest request = null;
		AleatoryNavigationController instance = new AleatoryNavigationController();
		
		ModelAndView expResult = new ModelAndView();
		expResult.setViewName(view);
		expResult.addObject("museum", museum);
		assertNotNull(navigationNode);
		Node neighbor = navigationNode.getNeighbor();
		assertNotNull(neighbor);
		expResult.addObject("navigationNode", neighbor);
		expResult.addObject("items", new NavigationItem(neighbor.getScenario()));
		expResult.addObject("hasPrevious", true);
		expResult.addObject("hasNext", true);
		expResult.addObject("atual", 2);
		expResult.addObject("numItems", museum.getScenarios().size());
		
		ModelAndView result = instance.next(request, navigationNode);
		Map<String, Object> modelExpResult = expResult.getModel();
		Map<String, Object> modelResult = result.getModel();
		
		// This doesn't works, because MuviMuseum@1 is not equals to MuviMuseum@2 ...
		//assertEquals(modelExpResult.get("museum"), modelResult.get("museum"));
		// ... so
		assertEquals(((MuviMuseum) modelExpResult.get("museum")).getId(), 
				((MuviMuseum) modelResult.get("museum")).getId());
		assertEquals(
				((Node) modelExpResult.get("navigationNode"))
						.getScenario().getId(), 
				((Node) modelResult.get("navigationNode"))
						.getScenario().getId());
		assertEquals(((NavigationItem) modelExpResult.get("items")).getName(), 
				((NavigationItem) modelResult.get("items")).getName());
		assertTrue((Boolean) modelResult.get("hasPrevious"));
		assertTrue((Boolean) modelResult.get("hasNext"));
		assertEquals(modelExpResult.get("atual"), modelResult.get("atual"));
		assertEquals(modelExpResult.get("numItems"), modelResult.get("numItems"));
	}

	/**
	 * Test of back method, of class AleatoryNavigationController.
	 */
	@Test
	public void testBackAtFirst() {
		System.out.println("back");
		
		HttpServletRequest request = null;
		AleatoryNavigationController instance = new AleatoryNavigationController();
		
		ModelAndView expResult = new ModelAndView();
		expResult.setViewName(view);
		expResult.addObject("museum", museum);
		assertNotNull(navigationNode);
		Node backtrack = navigationNode.getNeighbor();
		assertNull(backtrack);
		// because assertNull must be true
		//expResult.addObject("navigationNode", backtrack);
		//expResult.addObject("items", new NavigationItem(backtrack.getScenario()));
		expResult.addObject("hasPrevious", false);
		expResult.addObject("hasNext", true);
		expResult.addObject("atual", 0);
		expResult.addObject("numItems", museum.getScenarios().size());
		
		ModelAndView result = instance.back(request, navigationNode);
		Map<String, Object> modelExpResult = expResult.getModel();
		Map<String, Object> modelResult = result.getModel();
		
		// This doesn't works, because MuviMuseum@1 is not equals to MuviMuseum@2 ...
		//assertEquals(modelExpResult.get("museum"), modelResult.get("museum"));
		// ... so
		assertEquals(((MuviMuseum) modelExpResult.get("museum")).getId(), 
				((MuviMuseum) modelResult.get("museum")).getId());
		assertEquals(
				((Node) modelExpResult.get("navigationNode"))
						.getScenario().getId(), 
				((Node) modelResult.get("navigationNode"))
						.getScenario().getId());
		assertEquals(((NavigationItem) modelExpResult.get("items")).getName(), 
				((NavigationItem) modelResult.get("items")).getName());
		assertTrue((Boolean) modelResult.get("hasPrevious"));
		assertTrue((Boolean) modelResult.get("hasNext"));
		assertEquals(modelExpResult.get("atual"), modelResult.get("atual"));
		assertEquals(modelExpResult.get("numItems"), modelResult.get("numItems"));
	}

	/**
	 * Test of next method, of class AleatoryNavigationController.
	 */
	@Test
	public void testNextAtMiddle() {
		System.out.println("next");
		
		HttpServletRequest request = null;
		AleatoryNavigationController instance = new AleatoryNavigationController();
		
		ModelAndView expResult = new ModelAndView();
		expResult.setViewName(view);
		expResult.addObject("museum", museum);
		assertNotNull(navigationNode);
		Node neighbor = navigationNode.getNeighbor().getNeighbor().getNeighbor();
		assertNotNull(neighbor);
		expResult.addObject("navigationNode", neighbor);
		expResult.addObject("items", new NavigationItem(neighbor.getScenario()));
		expResult.addObject("hasPrevious", true);
		expResult.addObject("hasNext", true);
		expResult.addObject("atual", 4);
		expResult.addObject("numItems", museum.getScenarios().size());
		
		ModelAndView result = instance.next(request, navigationNode.getNeighbor().getNeighbor());
		Map<String, Object> modelExpResult = expResult.getModel();
		Map<String, Object> modelResult = result.getModel();
		
		// This doesn't works, because MuviMuseum@1 is not equals to MuviMuseum@2 ...
		//assertEquals(modelExpResult.get("museum"), modelResult.get("museum"));
		// ... so
		assertEquals(((MuviMuseum) modelExpResult.get("museum")).getId(), 
				((MuviMuseum) modelResult.get("museum")).getId());
		assertEquals(
				((Node) modelExpResult.get("navigationNode"))
						.getScenario().getId(), 
				((Node) modelResult.get("navigationNode"))
						.getScenario().getId());
		assertEquals(((NavigationItem) modelExpResult.get("items")).getName(), 
				((NavigationItem) modelResult.get("items")).getName());
		assertTrue((Boolean) modelResult.get("hasPrevious"));
		assertTrue((Boolean) modelResult.get("hasNext"));
		assertEquals(modelExpResult.get("atual"), modelResult.get("atual"));
		assertEquals(modelExpResult.get("numItems"), modelResult.get("numItems"));
	}

	/**
	 * Test of back method, of class AleatoryNavigationController.
	 */
	@Test
	public void testBackAtMiddle() {
		System.out.println("back");
		
		HttpServletRequest request = null;
		AleatoryNavigationController instance = new AleatoryNavigationController();
		
		ModelAndView expResult = new ModelAndView();
		expResult.setViewName(view);
		expResult.addObject("museum", museum);
		assertNotNull(navigationNode);
		Node backtrack = navigationNode.getNeighbor().getNeighbor();
		assertNotNull(backtrack);
		expResult.addObject("navigationNode", backtrack);
		expResult.addObject("items", new NavigationItem(backtrack.getScenario()));
		expResult.addObject("hasPrevious", true);
		expResult.addObject("hasNext", true);
		expResult.addObject("atual", 2);
		expResult.addObject("numItems", museum.getScenarios().size());
		
		ModelAndView result = instance.back(request, navigationNode.getNeighbor());
		Map<String, Object> modelExpResult = expResult.getModel();
		Map<String, Object> modelResult = result.getModel();
		
		// This doesn't works, because MuviMuseum@1 is not equals to MuviMuseum@2 ...
		//assertEquals(modelExpResult.get("museum"), modelResult.get("museum"));
		// ... so
		assertEquals(((MuviMuseum) modelExpResult.get("museum")).getId(), 
				((MuviMuseum) modelResult.get("museum")).getId());
		assertEquals(
				((Node) modelExpResult.get("navigationNode"))
						.getScenario().getId(), 
				((Node) modelResult.get("navigationNode"))
						.getScenario().getId());
		assertEquals(((NavigationItem) modelExpResult.get("items")).getName(), 
				((NavigationItem) modelResult.get("items")).getName());
		assertTrue((Boolean) modelResult.get("hasPrevious"));
		assertTrue((Boolean) modelResult.get("hasNext"));
		assertEquals(modelExpResult.get("atual"), modelResult.get("atual"));
		assertEquals(modelExpResult.get("numItems"), modelResult.get("numItems"));
	}

	/**
	 * Test of next method, of class AleatoryNavigationController.
	 */
	@Test(expected = Exception.class)
	public void testNextAtLast() {
		System.out.println("next");
		
		HttpServletRequest request = null;
		AleatoryNavigationController instance = new AleatoryNavigationController();
		
		ModelAndView expResult = new ModelAndView();
		expResult.setViewName(view);
		expResult.addObject("museum", museum);
		assertNotNull(navigationNode);
		Node prevNeighbor = navigationNode;
		do { prevNeighbor = prevNeighbor.getNeighbor(); } while (prevNeighbor.getNeighbors().size() > 0);
		assertNotNull(prevNeighbor);
		// because assertNull must be true
		expResult.addObject("navigationNode", null);
		expResult.addObject("items", null);
		expResult.addObject("hasPrevious", true);
		expResult.addObject("hasNext", false);
		expResult.addObject("atual", museum.getScenarios().size() + 1);
		expResult.addObject("numItems", museum.getScenarios().size());
		
		ModelAndView result = instance.next(request, prevNeighbor);
		Map<String, Object> modelExpResult = expResult.getModel();
		Map<String, Object> modelResult = result.getModel();
		
		// This doesn't works, because MuviMuseum@1 is not equals to MuviMuseum@2 ...
		//assertEquals(modelExpResult.get("museum"), modelResult.get("museum"));
		// ... so
		assertEquals(((MuviMuseum) modelExpResult.get("museum")).getId(), 
				((MuviMuseum) modelResult.get("museum")).getId());
		assertEquals(
				((Node) modelExpResult.get("navigationNode"))
						.getScenario().getId(), 
				((Node) modelResult.get("navigationNode"))
						.getScenario().getId());
		assertEquals(((NavigationItem) modelExpResult.get("items")).getName(), 
				((NavigationItem) modelResult.get("items")).getName());
		assertTrue((Boolean) modelResult.get("hasPrevious"));
		assertTrue((Boolean) modelResult.get("hasNext"));
		assertEquals(modelExpResult.get("atual"), modelResult.get("atual"));
		assertEquals(modelExpResult.get("numItems"), modelResult.get("numItems"));
	}

	/**
	 * Test of back method, of class AleatoryNavigationController.
	 */
	@Test
	public void testBackAtLast() {
		System.out.println("back");
		
		HttpServletRequest request = null;
		AleatoryNavigationController instance = new AleatoryNavigationController();
		
		ModelAndView expResult = new ModelAndView();
		expResult.setViewName(view);
		expResult.addObject("museum", museum);
		assertNotNull(navigationNode);
		Node nextBacktrack = navigationNode;
		do { nextBacktrack = nextBacktrack.getNeighbor(); } while (nextBacktrack.getNeighbors().size() > 0);
		Node backtrack = nextBacktrack.doBacktrack();
		assertNotNull(backtrack);
		// because assertNull must be true
		//expResult.addObject("navigationNode", backtrack);
		//expResult.addObject("items", new NavigationItem(backtrack.getScenario()));
		expResult.addObject("hasPrevious", false);
		expResult.addObject("hasNext", true);
		expResult.addObject("atual", 0);
		expResult.addObject("numItems", museum.getScenarios().size());
		
		ModelAndView result = instance.back(request, nextBacktrack);
		Map<String, Object> modelExpResult = expResult.getModel();
		Map<String, Object> modelResult = result.getModel();
		
		// This doesn't works, because MuviMuseum@1 is not equals to MuviMuseum@2 ...
		//assertEquals(modelExpResult.get("museum"), modelResult.get("museum"));
		// ... so
		assertEquals(((MuviMuseum) modelExpResult.get("museum")).getId(), 
				((MuviMuseum) modelResult.get("museum")).getId());
		assertTrue((Boolean) modelResult.get("hasPrevious"));
		assertTrue((Boolean) modelResult.get("hasNext"));
		assertEquals(modelExpResult.get("atual"), modelResult.get("atual"));
		assertEquals(modelExpResult.get("numItems"), modelResult.get("numItems"));
	}

	/**
	 * Test of goToScenario method, of class AleatoryNavigationController.
	 */
	@Test
	public void testGoToScenario() {
		System.out.println("goToScenario");
		
		HttpServletRequest request = null;
		Long scenarioId = null;
		AleatoryNavigationController instance = new AleatoryNavigationController();
		
		ModelAndView expResult = new ModelAndView();
		expResult.setViewName(view);
		expResult.addObject("museum", museum);
		assertNotNull(navigationNode);
		Node neighbor = navigationNode.getNeighbor();
		assertNotNull(neighbor);
		scenarioId = neighbor.getScenario().getId();
		assertNotNull(scenarioId);
		expResult.addObject("navigationNode", neighbor);
		expResult.addObject("items", new NavigationItem(neighbor.getScenario()));
		expResult.addObject("hasPrevious", true);
		expResult.addObject("hasNext", true);
		expResult.addObject("atual", 5);
		expResult.addObject("numItems", museum.getScenarios().size());
		
		ModelAndView result = instance.goToScenario(request, scenarioId, navigationNode);
		Map<String, Object> modelExpResult = expResult.getModel();
		Map<String, Object> modelResult = result.getModel();
		
		// This doesn't works, because MuviMuseum@1 is not equals to MuviMuseum@2 ...
		//assertEquals(modelExpResult.get("museum"), modelResult.get("museum"));
		// ... so
		assertEquals(((MuviMuseum) modelExpResult.get("museum")).getId(), 
				((MuviMuseum) modelResult.get("museum")).getId());
		assertEquals(
				((Node) modelExpResult.get("navigationNode"))
						.getScenario().getId(), 
				((Node) modelResult.get("navigationNode"))
						.getScenario().getId());
		assertEquals(((NavigationItem) modelExpResult.get("items")).getName(), 
				((NavigationItem) modelResult.get("items")).getName());
		assertTrue((Boolean) modelResult.get("hasPrevious"));
		assertTrue((Boolean) modelResult.get("hasNext"));
		assertEquals(modelExpResult.get("atual"), modelResult.get("atual"));
		assertEquals(modelExpResult.get("numItems"), modelResult.get("numItems"));
	}
	
}
