package com.training.pom;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SubscribeClassPOM {
	private WebDriver driver; 
	String count1, count2;

	public SubscribeClassPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[contains(text(),'Classes')]")
	private WebElement classeslink; 

	@FindBy(xpath="//tr[@id='37']//a[1]//img[1]")
	private WebElement classoption;

	@FindBy(xpath="//tr[@id='37']//td[2]")
	private WebElement usercount;

	@FindBy(xpath="//select[@id='elements_not_in']/option[contains(text(),'- AKP')]")
	private WebElement subscribe; 

	@FindBy(xpath="//*[@class='fa fa-arrow-right']")
	private WebElement moveright;

	@FindBy(xpath="//*[@class='btn btn-primary']")
	private WebElement Submit;

	public void selectclasslink () {
		this.classeslink.click();
	}

	public void assertPageTitle() {
		String expectedTitle = "My Organization - My education";
		String actualTitle=driver.getTitle();
		//assert Title of the page 
		assertEquals(actualTitle, expectedTitle);
	}

	public void selectClasses() {
		count1 = usercount.getText();
		this.classoption.click(); 
		System.out.println("Current enrolled users:" +count1);
	}

	public void SubcribeUser() {
		subscribe.click(); 
	}

	public void ClickMoveRight() {
		this.moveright.click(); 
	}
	public void SubscribeUserClass() {
		this.Submit.click(); 
	}
	public void VerifyUserCount() {

		// Verify the User count if new new user is added
		count2 = usercount.getText();
		System.out.println("Updated enrolled users to:" +count2);

		int initialCount = Integer.valueOf(count1);
		int updatedtedCount = Integer.valueOf(count2);
		Assert.assertTrue(updatedtedCount > initialCount);
	}

}

