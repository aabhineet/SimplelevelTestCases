package com.training.pom;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginPOM {
	private WebDriver driver; 
	
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="login")
	private WebElement userName; 
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="form-login_submitAuth")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//a[@class='dropdown-toggle']")
	private WebElement profileclick;
	
	@FindBy(id="//a[@id='logout_button']")
	private WebElement logoutBtn;
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	public void assertPageTitle() {
		String expectedTitle = "My Organization - My education - My courses";
		String actualTitle=driver.getTitle();
		//assert Title of the page 
		assertEquals(actualTitle, expectedTitle);
	}
	
	public void profileclick() {
		this.profileclick.click(); 
	}
	public void clicklogoutBtn() {
		 Actions act = new Actions(driver);
		 act.moveToElement(logoutBtn).click();
	 
	}
}
