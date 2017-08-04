package Test;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Action.Actions;
import Utility.XcelReader;

public class LoginTest {
	
	@DataProvider(name = "credentials",parallel = true)
	public Object[][] Data() throws Exception {
		XcelReader	xreader = new XcelReader();
		String[][] obj;
		obj = (String[][]) xreader.getArrayObject();
		return obj;
	}
	
	@Test(dataProvider = "credentials", priority=1)
	public void composeMail(String receipent,String subject,String body) throws InterruptedException, IOException {
		Actions	  test = new Actions();
		WebDriver driver = test.navigateUrl();
		test.login();
		test.compose(receipent, subject, body);
		Thread.sleep(2000);
       driver.close();
	}

}
