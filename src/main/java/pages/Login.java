package pages;

import java.io.IOException;

import org.testng.Assert;

import base.Base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login extends Base {
	
	/**
	 * @throws IOException
	 */
	public Login() throws IOException {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "user-name")
	WebElement userName;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "login-button")
	WebElement loginBtn;

	/**
	 * @param name
	 * @param pwd
	 */
	public void loginApp(String name, String pwd) {
		userName.sendKeys(name);
		password.sendKeys(pwd);
		loginBtn.click();
	}

	public void verifyTile(String name) {
		String tName = driver.getTitle();
		Assert.assertEquals(tName, name);
	}

}
