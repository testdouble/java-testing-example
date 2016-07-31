package support;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
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
			try {
				return new FirefoxDriver();
			} catch (RuntimeException e) {
				String path;
				if (System.getProperty("os.name").contains("win")) {
					path = "bin/FirefoxPortable/App/Firefox/firefox.exe";
				} else {
					path = "bin/Firefox.app/Contents/MacOS/firefox";
				}
				return new FirefoxDriver(new FirefoxBinary(new File(path)), new FirefoxProfile());
			}
		} else if (browserName.equals("chrome")) {
			try {
				return new ChromeDriver();
			} catch (Exception e) {
				System.setProperty("webdriver.chrome.driver", "bin/chromedriver.exe");
				return new ChromeDriver();
			}
		} else if (browserName.equals("msie")) {
			try {
				return new InternetExplorerDriver();
			} catch (Exception e) {
				System.setProperty("webdriver.ie.driver", "bin/IEDriverServer.exe");
				return new InternetExplorerDriver();
			}
		} else {
			throw new RuntimeException("Unrecognized system property 'browser': " + browserName);
		}
	}
}
