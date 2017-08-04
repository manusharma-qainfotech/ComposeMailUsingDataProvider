package Action;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Model.locators;
import Utility.SpecReader;

public class Actions {
	static WebDriver driver;
	static SpecReader reader;

	public Actions() throws IOException {
		reader = new SpecReader();
	}

	public WebDriver navigateUrl() {
		System.setProperty("webdriver.chrome.driver","C:\\\\\\\\Users\\\\manusharma\\\\Downloads\\\\chromedriver_win32\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize() ;
		driver.get("https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public void login() throws InterruptedException {
		getWebElement("Email").sendKeys("testautomation4193@gmail.com");
		getWebElement("next").click();
		Thread.sleep(2000);
		getWebElement("password").sendKeys("4193testautomation");
		getWebElement("next").click();
		Thread.sleep(2000);

	}

	public void compose(String receipent, String subject, String body) throws InterruptedException {
		getWebElement("compose").click();
		Thread.sleep(2000);
		getWebElement("to").sendKeys(receipent);
		
		getWebElement("subject").sendKeys(subject);
		
		getWebElement("body").sendKeys(body);
		
		getWebElement("send").click();
		
	}

	public static WebElement getWebElement(String elementName) {
		locators loc = reader.getObjByElement(elementName);
		WebElement element;
		String type = loc.getLocatorType();
		if (type.equals("css")) {
			element = driver.findElement(By.cssSelector(loc.getLocatorValue()));
		} else {

			element = driver.findElement(By.xpath(loc.getLocatorValue()));
		}
		return element;

	}

}
