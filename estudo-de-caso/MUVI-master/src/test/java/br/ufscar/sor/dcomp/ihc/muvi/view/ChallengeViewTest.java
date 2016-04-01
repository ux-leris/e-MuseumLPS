package br.ufscar.sor.dcomp.ihc.muvi.view;

import br.ufscar.sor.dcomp.ihc.muvi.view.util.ExpectedMap;
import java.util.Map;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author USER
 */
public class ChallengeViewTest {

	private final String url = "http://localhost:8080/muvi/";
	private WebDriver driver;
	private static Map<String, Object> expected;
	//private ScreenshotHelper screenshotHelper;

	public ChallengeViewTest() {
	}

	@BeforeClass
	public static void setUpClass() {
		expected = ExpectedMap.get();
	}

	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get(url);
		//screenshotHelper = new ScreenshotHelper();
	}

	@After
	public void tearDown() {
		//screenshotHelper.saveScreenshot("screenshor.png");
		driver.quit();
	}

	@Test
	public void canICancelAChallengeInAleatoryNavigation() {
		driver.findElements(By.tagName("a")).get(0).click();

		WebElement challengeButton = null;
		while (challengeButton == null) {
			try {
				challengeButton = driver.findElement(By.id("challenge"));
			} catch (NoSuchElementException exception) {
				driver.findElement(By.id("agoto")).click();
			}
		}
		String bgColor = challengeButton.getCssValue("background-color");
		WebElement challengeSection = driver.findElement(By.id("challenge-section"));
		assertEquals(expected.get("buttonclass"), challengeButton.findElement(By.tagName("a")).getAttribute("class"));
		assertEquals(expected.get("empty"), challengeSection.getAttribute("class"));
		driver.findElement(By.id("challenge-cancel")).click();
		assertEquals(expected.get("buttondoneandworng"), challengeButton.findElement(By.tagName("a")).getAttribute("class"));
		assertEquals(expected.get("hideclass"), challengeSection.getAttribute("class"));
		assertFalse(bgColor.equals(challengeButton.getCssValue("background-color")));
	}

	@Test
	public void canIDoneAChallengeInAleatoryNavigation() {
		driver.findElements(By.tagName("a")).get(0).click();

		WebElement challengeButton = null;
		driver.findElement(By.id("agoto")).click();
		driver.findElement(By.id("agoto")).click();
		driver.findElement(By.id("agoto")).click();
		challengeButton = driver.findElement(By.id("challenge"));

		String bgColor = challengeButton.getCssValue("background-color");
		WebElement challengeSection = driver.findElement(By.id("challenge-section"));
		assertEquals(expected.get("buttonclass"), challengeButton.findElement(By.tagName("a")).getAttribute("class"));
		assertEquals(expected.get("empty"), challengeSection.getAttribute("class"));

		WebElement alternative1 = driver.findElement(By.className("alternative"));
		assertNotNull(alternative1);
		assertFalse(expected.get("empty").equals(alternative1.getText()));
		alternative1.click();

		WebElement done = driver.findElement(By.id("challenge-done"));
		assertEquals(expected.get("notdonetext"), done.getText());
		done.click();
		assertEquals(expected.get("donetext"), done.getText());
		done.click();
		assertEquals(expected.get("buttondoneandcorrect"), challengeButton.findElement(By.tagName("a")).getAttribute("class"));
		assertEquals(expected.get("hideclass"), challengeSection.getAttribute("class"));
		assertFalse(bgColor.equals(challengeButton.getCssValue("background-color")));
	}

	/*private class ScreenshotHelper {
  
	 public void saveScreenshot(String screenshotFileName) throws IOException {
	 File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	 FileUtils.copyFile(screenshot, new File(screenshotFileName));
	 }
	 }*/
}
