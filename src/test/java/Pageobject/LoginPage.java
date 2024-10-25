package Pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;

	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;

		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "user-name")
	@CacheLookup
	WebElement username;

	@FindBy(id = "password")
	@CacheLookup
	WebElement password;

	@FindBy(id = "login-button")
	@CacheLookup
	WebElement button;
	
	@FindBy(id = "react-burger-menu-btn")
	@CacheLookup
	WebElement menu;

	@FindBy(xpath = "//*[@id=\"logout_sidebar_link\"]")
	WebElement logout;

	public void enterUname(String uname) {
		username.sendKeys(uname);
	}

	public void enterPassword(String pwd) {
		password.clear();
		password.sendKeys(pwd);

	}

	public void clickOnLoginButton() {
		button.click();
	}
	
	public void clickOnMenuButton() {
		menu.click();
		
	}

	public void clickOnLogOutButton() {
		logout.click();
	}

}	
