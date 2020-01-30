package com.training.pom;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/* ############# EMAIL FACILITY IS NOT AVAILABLE HENCE CODE IS UPTO SEND MAIL ################ */

public class ForgotPwdPOM {
	private WebDriver driver; 

	public ForgotPwdPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'I lost my password')]")
	private WebElement frgtlink;
	
	@FindBy(id="lost_password_user")
	private WebElement username;
	
	@FindBy(id="lost_password_submit")
	private WebElement submit;
	
	public void clickFrgtLink() {
	this.frgtlink.click(); 
	}
	
	public void assertPageTitle() {
		String expectedTitle = "My Organization - My education";
		String actualTitle=driver.getTitle();
		//assert Title of the page 
		assertEquals(actualTitle, expectedTitle);
	}
	public void sendUserName(String username) {
		this.username.clear();
		this.username.sendKeys(username);
	}
	public void clicksubmitBtn() {
		this.submit.click(); 
	}
}
