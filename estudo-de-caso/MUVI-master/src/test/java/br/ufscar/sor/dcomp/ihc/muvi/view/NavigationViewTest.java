package br.ufscar.sor.dcomp.ihc.muvi.view;

import br.ufscar.sor.dcomp.ihc.muvi.view.util.ExpectedMap;
import java.util.Map;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.ComparisonFailure;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author USER
 */
public class NavigationViewTest {

	private final String url = "http://localhost:8080/muvi/";
	private WebDriver driver;
	private static Map<String, Object> expected;

	public NavigationViewTest() {
	}

	@BeforeClass
	public static void setUpClass() {
		expected = ExpectedMap.get();
	}

	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		
		driver.get(url);
	}

	@After
	public void tearDown() {
		driver.quit();
	}
	
	public void asserPageLoad() {
		assertEquals(expected.get("titlealeatory"), driver.getTitle());
		
		/* menu */
		WebElement menu = driver.findElement(By.id("menu"));
		assertNotNull(menu);
		assertEquals("section", menu.getTagName());
		/* /menu */
		
		/* section#object-section */
		WebElement objectSection = driver.findElement(By.id("object-section"));
		assertNotNull(objectSection);
		assertEquals("section", objectSection.getTagName());

		/* nav>ul */
		WebElement lidiv = driver.findElement(By.id("backto"));
		assertNotNull(lidiv);
		assertEquals(expected.get("buttonclass"), lidiv.getAttribute("class").split(" ")[0]);
		WebElement lidiva = driver.findElement(By.id("abackto"));
		assertNotNull(lidiva);
		assertEquals(expected.get("anavbutton"), lidiva.getAttribute("class"));
		lidiv = driver.findElement(By.id("state"));
		assertNotNull(lidiv);
		assertEquals(expected.get("stateclass"), lidiv.getAttribute("class").split(" ")[0]);
		lidiv = driver.findElement(By.id("goto"));
		assertNotNull(lidiv);
		assertEquals(expected.get("buttonclass"), lidiv.getAttribute("class").split(" ")[0]);
		lidiva = driver.findElement(By.id("abackto"));
		assertNotNull(lidiva);
		assertEquals(expected.get("anavbutton"), lidiva.getAttribute("class"));
		/* /nav>ul */

		/* navigation-board */
		/* header */
		WebElement h1title = driver.findElement(By.id("title"));
		assertNotNull(h1title);
		assertFalse(expected.get("empty").equals(h1title.getText()));
		/* /header */

		/* article */
		WebElement item = driver.findElement(By.id("item"));
		assertNotNull(item);
		assertEquals("article", item.getTagName());

		WebElement itemdiv = driver.findElement(By.className("with-more"));
		assertNotNull(itemdiv);
		assertFalse(expected.get("empty").equals(itemdiv.getText()));

		// This not work (timeout)
		//assertNull(driver.findElement(By.id("amore")));
		/* /article */
		/* footer */
		WebElement footer = driver.findElement(By.id("object-footer"));
		assertNotNull(footer);
		assertEquals(expected.get("hideclass"), footer.getAttribute("class"));

		WebElement divmore = driver.findElement(By.id("divmore"));
		assertNotNull(divmore);
		assertEquals(expected.containsKey("empty"), divmore.getText());
		/* /footer */
		/* /navigation-board */

		/* /section#object-section */
		
		/* challenge */
		WebElement challengeSection = driver.findElement(By.id("challenge-section"));
		assertNotNull(challengeSection);
		assertEquals("section", challengeSection.getTagName());
		
		/* header */
		WebElement challengeTitle = driver.findElement(By.id("challenge-title"));
		assertNotNull(challengeTitle);
		assertEquals(expected.get("empty"), challengeTitle.getText());
		/* /header */
		
		/* article */
		WebElement alternatives = driver.findElement(By.id("alternatives"));
		assertNotNull(alternatives);
		assertEquals("article", alternatives.getTagName());
		assertEquals(expected.get("empty"), alternatives.getText());
		/* /article */
		
		/* footer */
		WebElement aCancel = driver.findElement(By.id("challenge-cancel"));
		assertEquals("a", aCancel.getTagName());
		assertEquals(expected.get("buttonclass"), aCancel.getAttribute("class"));
		assertEquals(expected.get("cancelbuttontext"), aCancel.getText());
		
		WebElement aDone = driver.findElement(By.id("challenge-done"));
		assertEquals("a", aDone.getTagName());
		assertEquals(expected.get("buttonclass"), aDone.getAttribute("class"));
		assertEquals(expected.get("donebuttontext"), aDone.getText());
		/* /footer */
		/* /challenge */
	}

	public void isThePageLoadingCorrectly(String mode) {
		if (mode.equals("aleatory"))
			driver.findElements(By.tagName("a")).get(0).click();
		else if (mode.equals("guided"))
			driver.findElements(By.tagName("a")).get(1).click();

		asserPageLoad();
	}

	@Test
	public void isTheAleatoryNavigationPageLoadingCorrectly() {
		isThePageLoadingCorrectly("aleatory");
	}

	@Test
	public void isTheGuidedNavigationPageLoadingCorrectly() {
		isThePageLoadingCorrectly("guided");
	}

	@Test(expected = ComparisonFailure.class)
	public void isThePageNotLoadingCorrectly() {
		isThePageLoadingCorrectly("");
	}

	public void isScenarioAdvancing(String mode, boolean withKeyboard) {
		if (mode.equals("aleatory"))
			driver.findElements(By.tagName("a")).get(0).click();
		else if (mode.equals("guided"))
			driver.findElements(By.tagName("a")).get(1).click();
		
		if (withKeyboard)
			driver.findElement(By.tagName("body")).sendKeys(Keys.LEFT);
		else
			driver.findElement(By.id("agoto")).click();
		
		asserPageLoad();
	}

	@Test
	public void isTheFirstAleatoryNavigationScenarioAdvancingWithKeyboard() {
		isScenarioAdvancing("aleatory", true);
	}

	@Test
	public void isTheFirstAleatoryNavigationScenarioAdvancingWithoutKeyboard() {
		isScenarioAdvancing("aleatory", false);
	}

	@Test
	public void isTheFirstGuidedNavigationScenarioAdvancingWithKeyboard() {
		isScenarioAdvancing("guided", true);
	}

	@Test
	public void isTheFirstGuidedNavigationScenarioAdvancing() {
		isScenarioAdvancing("guided", false);
	}

	@Test(expected = Exception.class)
	public void isTheLastAleatoryNavigationScenarioAdvancingWithKeyboard() {
		isScenarioAdvancing("aleatory", true);
	}
	
	@Test(expected = Exception.class)
	public void isTheLastAleatoryNavigationScenarioAdvancingWithoutKeyboard() {
		isScenarioAdvancing("aleatory", false);
	}

	@Test(expected = Exception.class)
	public void isTheLastGuidedNavigationScenarioAdvancingWithKeyboard() {
		isScenarioAdvancing("guided", true);
	}

	@Test(expected = Exception.class)
	public void isTheLastGuidedNavigationScenarioAdvancingWithoutKeyboard() {
		isScenarioAdvancing("guided", false);
	}

	public void isScenarioComingBack(String mode, boolean withKeyboard) {
		driver.get(url + mode);
		
		if (withKeyboard)
			driver.findElement(By.tagName("body")).sendKeys(Keys.RIGHT);
		else
			driver.findElement(By.id("abackto")).click();
		
		asserPageLoad();
	}

	@Test(expected = Exception.class)
	public void isTheFirstAleatoryNavigationScenarioComingBackWithKeyboard() {
		isScenarioAdvancing("aleatory", true);
	}

	@Test(expected = Exception.class)
	public void isTheFirstAleatoryNavigationScenarioComingBackWithoutKeyboard() {
		isScenarioAdvancing("aleatory", false);
	}

	@Test(expected = Exception.class)
	public void isTheFirstGuidedNavigationScenarioComingBackWithKeyboard() {
		isScenarioAdvancing("guided", true);
	}

	@Test(expected = Exception.class)
	public void isTheFirstGuidedNavigationScenarioComingBackWithoutKeyboard() {
		isScenarioAdvancing("guided", false);
	}

	public void isTheLastAleatoryNavigationScenarioComingBackWithKeyboard() {
		isScenarioAdvancing("aleatory", true);
	}

	public void isTheLastAleatoryNavigationScenarioComingBackWithoutKeyboard() {
		isScenarioAdvancing("aleatory", false);
	}

	public void isTheLastGuidedNavigationScenarioComingBackWithKeyboard() {
		isScenarioAdvancing("guided", true);
	}

	public void isTheLastGuidedNavigationScenarioComingBackWithoutKeyboard() {
		isScenarioAdvancing("guided", false);
	}
}
