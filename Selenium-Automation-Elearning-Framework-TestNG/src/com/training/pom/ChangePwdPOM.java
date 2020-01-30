package com.training.pom;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePwdPOM {
	private WebDriver driver; 
	
	public ChangePwdPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath="//a[contains(text(),'Edit profile')]")
	private WebElement EditProfile; 
	
	@FindBy(id="profile_password0")
	private WebElement oldpassword;
	
	@FindBy(id="password1")
	private WebElement newpassword; 
	
	@FindBy(id="profile_password2")
	private WebElement cnfrmnewpassword;
	
	@FindBy(id="profile_apply_change")
	private WebElement change;
	
	@FindBy(xpath="//*[@class='alert alert-info']")
	private WebElement updateMessage;
	
	public void clickEditProfile() {
		this.EditProfile.click(); 
	}
	
	public void assertPageTitle() {
		String expectedTitle = "My Organization - My education - Profile";
		String actualTitle=driver.getTitle();
		//assert Title of the page 
		assertEquals(actualTitle, expectedTitle);
	}
	public void sendoldPassword(String oldpassword) {
		this.oldpassword.clear(); 
		this.oldpassword.sendKeys(oldpassword); 
	}
	
	public void sendnewPassword(String newpassword) {
		this.newpassword.clear(); 
		this.newpassword.sendKeys(newpassword); 
	}
	
	public void sendcnfrmnewPassword(String cnfrmnewpassword) {
		this.cnfrmnewpassword.clear(); 
		this.cnfrmnewpassword.sendKeys(cnfrmnewpassword); 
	}
	
	public void clickapplyChange() {
		this.change.click(); 
	}
	
	public void AssertupdateMessage() {
		String actualText=updateMessage.getText();
		String expectedText = "Your new profile has been saved";
		assertEquals(actualText, expectedText); 

		//assertTrue(actualText.contains(""));
	}
	
}