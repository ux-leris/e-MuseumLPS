package br.ufscar.sor.dcomp.ihc.muvi.view;

import br.ufscar.sor.dcomp.ihc.muvi.view.util.ExpectedMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author USER
 */
public class HomeViewTest {

	private final String url = "http://localhost:8080/muvi/";
	private WebDriver driver;
	private static Map<String, Object> expected;

	public HomeViewTest() {
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

	@Test
	public void isThePageLoadingCorrectly() {
		WebElement h1, a, ap;
		
		assertEquals(expected.get("title"), driver.getTitle());

		/* section */
		assertNotNull(driver.findElement(new By.ByTagName("section")));
		/* article */
		assertNotNull(driver.findElement(new By.ByTagName("article")));

		/* h1 */
		h1 = driver.findElement(new By.ByTagName("h1"));
		assertNotNull(h1);
		assertEquals(expected.get("museumname"), h1.getText());
		/* /h1 */

		/* div */
		assertNotNull(driver.findElement(By.tagName("div")));
		
		List<WebElement> aList = driver.findElements(By.tagName("a"));
		/* a, a>p */
		a = aList.get(0);
		assertEquals(expected.get("aclass"), a.getAttribute("class"));
		ap = a.findElement(By.tagName("p"));
		assertNotNull(ap);
		assertEquals(expected.get("paleatory"), ap.getText());
		/* /a, /a>p */
		
		/* a, a>p */
		a = aList.get(1);
		assertEquals(expected.get("aclass"), a.getAttribute("class"));
		ap = a.findElement(By.tagName("p"));
		assertNotNull(ap);
		assertEquals(expected.get("pguided"), ap.getText());
		/* /a, /a>p */
		
		/* /div */

		/* /article */
		/* /section */
	}

	@Test
	public void canIEnterInAleatoryNavigation() {
		assertEquals(expected.get("title"), driver.getTitle());
		
		List<WebElement> aList = driver.findElements(By.tagName("a"));
		WebElement a = aList.get(0);
		assertEquals(expected.get("aclass"), a.getAttribute("class"));
		WebElement ap = a.findElement(By.tagName("p"));
		assertNotNull(ap);
		assertEquals(expected.get("paleatory"), ap.getText());
		a.click();
		
		assertEquals(expected.get("titlealeatory"), driver.getTitle());
	}

	@Test
	public void canIEnterInGuidedNavigation() {
		assertEquals(expected.get("title"), driver.getTitle());
		
		List<WebElement> aList = driver.findElements(By.tagName("a"));
		WebElement a = aList.get(1);
		assertEquals(expected.get("aclass"), a.getAttribute("class"));
		WebElement ap = a.findElement(By.tagName("p"));
		assertNotNull(ap);
		assertEquals(expected.get("pguided"), ap.getText());
		a.click();
		
		assertEquals(expected.get("titleguided"), driver.getTitle());
	}
}
