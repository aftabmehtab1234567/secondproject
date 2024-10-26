package StepDefination;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Pageobject.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Stepdef {
	
	public WebDriver driver;
	public LoginPage l;

	@Given("user Launch Chrome Browser")
	public void user_launch_chrome_browser() {
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--remote-allow-origins=*");

		//WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		l = new LoginPage(driver);
	}

	@When("User opens url {string}")
	public void user_opens_url(String url) throws InterruptedException {

		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(3000);

	}

	@When("User enter UserName as {string} and Password as {string}")
	public void user_enter_email_as_and_password_as(String uname, String pwd) {
		
		l.enterUname(uname);

		l.enterPassword(pwd);
	}

	@When("Click on Login")
	public void click_on_login() throws InterruptedException {
		l.clickOnLoginButton();
		Thread.sleep(2000);
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String exptitle) {

		String actualtitle = driver.getTitle();

		if (actualtitle.equals(exptitle)) {

			System.out.println("True");
		} else {
			System.out.println("False");

		}
	}

	@When("Close the Browser")
	public void close_the_browser() {
		driver.close();
	}

}
