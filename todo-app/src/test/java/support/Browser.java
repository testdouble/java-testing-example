package support;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browser {

	public static final int DEFAULT_TIMEOUT = 5;
	public static WebDriver browser;
	
	private static final String browserName;

	static {
		try {
			Properties properties = new Properties();
			properties.load(Browser.class.getClassLoader().getResourceAsStream("selenium.properties"));
			browserName = properties.getProperty("browser");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static WebDriver launch() {
		browser = createDriver();
		browser.manage().timeouts().implicitlyWait(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
		return browser;
	}

	public static WebElement any(String css) {
		return any(browser.findElement(By.cssSelector("html")), css);
	}

	public static WebElement any(WebElement parent, String css) {
		try {
			return parent.findElement(By.cssSelector(css));
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	public static WebElement anyImmediate(String css) {
		return anyImmediate(browser.findElement(By.cssSelector("html")), css);		
	}

	public static WebElement anyImmediate(WebElement parent, String css) {
		browser.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
		WebElement el = any(parent, css);
		browser.manage().timeouts().implicitlyWait(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
		return el;
	}
	
	private static WebDriver createDriver() {
		if (browserName.equals("firefox")) {
			return new FirefoxDriver();
		} else if (browserName.equals("chrome")) {
			return new ChromeDriver();
		} else if (browserName.equals("msie")) {
			return new InternetExplorerDriver();
		} else {
			throw new RuntimeException("Unrecognized system property 'browser': " + browserName);
		}
	}
}
