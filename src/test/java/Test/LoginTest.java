package Test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Action.Actions;
import Utility.XcelReader;

public class LoginTest {
	WebDriver driver;
	Actions test;

	@BeforeTest
	public void before() throws IOException, InterruptedException {
	     test = new Actions();

	}

	@Test(priority=1)
	public void navigateToUrl() {
		driver = test.navigateUrl();
		
	}

	@Test(priority=2)
	public void loginGmail() throws InterruptedException {
		test.login();
		
	}

	@Test(dataProvider = "credentials", priority=3)
	public void composeMail(String receipent, String subject, String body) throws InterruptedException {
		test.compose(receipent, subject, body);
		Thread.sleep(2000);
	}

	@DataProvider(name = "credentials")
	public Object[][] Data() throws Exception {
		XcelReader	xreader = new XcelReader();
		String[][] obj;
		obj = (String[][]) xreader.getArrayObject();
		return obj;
	}

	@AfterClass
	public void after() {
		driver.close();

	}
}
