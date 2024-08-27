package testcases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import base.Base;

import pages.Login;

public class LoginTest extends Base {
	
	protected static Logger log = LogManager.getLogger(LoginTest.class);


	@Test
	public void checkLogin() throws IOException {

		Login login = new Login();
		login.loginApp(properties.getProperty("uname"), properties.getProperty("password"));
		login.verifyTile(properties.getProperty("title"));

	}
	
	
	@Test
	public void invalidCredentails() throws IOException {

		Login login = new Login();
		login.loginApp(properties.getProperty("uname"), "test");
		boolean checklogin = driver.getPageSource().contains(properties.getProperty("invalidLoginText"));
		Assert.assertEquals(checklogin, true);

	}

}
