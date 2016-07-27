package selenium;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import support.Browser;

public class SimpleTest {

	WebDriver driver = Browser.launch();
	
	@Test
	public void sometest() {		
		driver.get("https://www.google.com");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Cheese!");
		
		element.submit();

		driver.findElement(By.id("res"));		
		assertThat(driver.findElement(By.tagName("body")).getText(), containsString("curds"));				
	}
	
	@After
	public void quitBrowser() {
		driver.quit();
	}

	
}