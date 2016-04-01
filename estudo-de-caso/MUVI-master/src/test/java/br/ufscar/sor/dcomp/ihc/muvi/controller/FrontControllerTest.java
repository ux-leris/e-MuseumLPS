package br.ufscar.sor.dcomp.ihc.muvi.controller;

import br.ufscar.sor.dcomp.ihc.muvi.model.MuviMuseum;
import br.ufscar.sor.dcomp.ihc.muvi.model.NavigationItem;
import com.lpsmuseum.behaviour.museum.navigation.AleatoryNavigation;
import com.lpsmuseum.behaviour.museum.navigation.GuidedNavigation;
import com.lpsmuseum.behaviour.museum.navigation.Node;
import com.lpsmuseum.dto.Museum;
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
public class FrontControllerTest {
	
	private Museum museum;
	
	public FrontControllerTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
	}
	
	@AfterClass
	public static void tearDownClass() {
	}
	
	@Before
	public void setUp() {
		museum = new MuseumService().listMuseum().get(0);
	}
	
	@After
	public void tearDown() {
		museum = null;
	}

	/**
	 * Test of home method, of class FrontController.
	 * @throws java.lang.Exception
	 */
	@Test
	public void testHome() throws Exception {
		System.out.println("home");
		
		FrontController instance = new FrontController();
		
		ModelAndView expResult = new ModelAndView();
		expResult.setViewName("home");
		expResult.addObject("museum", new MuviMuseum(museum));
		
		ModelAndView result = instance.home();
		Map<String, Object> modelExpResult = expResult.getModel();
		Map<String, Object> modelResult = result.getModel();
		
		// This doesn't works, because MuviMuseum@1 is not equals to MuviMuseum@2 ...
		//assertEquals(modelExpResult.get("museum"), modelResult.get("museum"));
		// ... so
		assertEquals(((MuviMuseum) modelExpResult.get("museum")).getId(), 
				((MuviMuseum) modelResult.get("museum")).getId());
	}

	/**
	 * Test of navegar method, of class FrontController.
	 */
	@Test
	public void testNavegarAleatorio() throws Exception {
		System.out.println("navegar");
		
		HttpServletRequest request = null;
		String mode = "aleatory";
		FrontController instance = new FrontController();
		
		MuviMuseum museum = new MuviMuseum(this.museum);
		museum.setNavigation(new AleatoryNavigation());
		Node navigationNode = museum.navigate();
		
		ModelAndView expResult = new ModelAndView();
		expResult.setViewName(mode + "-navigation");
		expResult.addObject("museum", museum);
		assertNotNull(navigationNode);
		expResult.addObject("navigationNode", navigationNode);
		expResult.addObject("items", new NavigationItem(navigationNode.getScenario()));
		expResult.addObject("hasPrevious", false);
		expResult.addObject("hasNext", true);
		expResult.addObject("atual", 1);
		expResult.addObject("numItems", museum.getScenarios().size());
		
		instance.home();
		ModelAndView result = instance.navegar(request, mode);
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
		assertFalse((Boolean) modelResult.get("hasPrevious"));
		assertTrue((Boolean) modelResult.get("hasNext"));
		assertEquals(modelExpResult.get("atual"), modelResult.get("atual"));
		assertEquals(modelExpResult.get("numItems"), modelResult.get("numItems"));
	}

	/**
	 * Test of navegar method, of class FrontController.
	 */
	@Test
	public void testNavegarGuiado() throws Exception {
		System.out.println("navegar");
		
		HttpServletRequest request = null;
		String mode = "guided";
		FrontController instance = new FrontController();
		
		MuviMuseum museum = new MuviMuseum(this.museum);
		museum.setNavigation(new GuidedNavigation());
		Node navigationNode = museum.navigate();
		
		ModelAndView expResult = new ModelAndView();
		expResult.setViewName(mode + "-navigation");
		expResult.addObject("museum", museum);
		assertNotNull(navigationNode);
		expResult.addObject("navigationNode", navigationNode);
		expResult.addObject("items", new NavigationItem(navigationNode.getScenario()));
		expResult.addObject("hasPrevious", false);
		expResult.addObject("hasNext", true);
		expResult.addObject("atual", 1);
		expResult.addObject("numItems", museum.getScenarios().size());
		
		instance.home();
		ModelAndView result = instance.navegar(request, mode);
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
		assertFalse((Boolean) modelResult.get("hasPrevious"));
		assertTrue((Boolean) modelResult.get("hasNext"));
		assertEquals(modelExpResult.get("atual"), modelResult.get("atual"));
		assertEquals(modelExpResult.get("numItems"), modelResult.get("numItems"));
	}
	
}
