package com.training.pom;

import static org.testng.Assert.assertEquals;

import static org.testng.Assert.assertTrue;
import com.trianing.waits.WaitTypes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterPOM {
	private WebDriver driver; 

	public RegisterPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText="Sign up!")
	private WebElement signUpBtn;
	
	@FindBy(xpath="//*[@class='caption' and text()='Follow courses']")
	private WebElement radiostudent;
	
	@FindBy(xpath="//*[@class='caption' and text()='Teach courses']")
	private WebElement radioteacher;
	
	@FindBy(id="registration_firstname")
	private WebElement firstname;

	@FindBy(id="registration_lastname")
	private WebElement lastname;

	@FindBy(id="registration_email")
	private WebElement email;

	@FindBy(id="username")
	private WebElement username;

	@FindBy(id="pass1")
	private WebElement password;

	@FindBy(id="pass2")
	private WebElement confrmpassword;

	@FindBy(id="registration_phone")
	private WebElement phone;

	@FindBy(id="registration_language")
	private WebElement language;
	
	@FindBy(id="registration_submit")
	private WebElement submit;

	@FindBy(xpath="//*[@class='col-xs-12 col-md-12']/p[1]")
	private WebElement Text;

	public void clicksignUpBtn() {
		this.signUpBtn.click(); 
	}
	
	public void assertPageTitle() {
		String expectedTitle = "My Organization - My education - Registration";
		String actualTitle=driver.getTitle();
		//assert Title of the page 
		assertEquals(actualTitle, expectedTitle);
	}
	public void registerstudent() {
		boolean ckIschecked = radiostudent.isSelected();
		if(!ckIschecked) {
			radiostudent.click();
		}
	}
	public void registerTeacher() {
		boolean ckIschecked = radioteacher.isSelected();
		
		if(!ckIschecked) {
			radioteacher.click();
		}
	}

	public void firstName(String firstname) {
		this.firstname.clear();
		this.firstname.sendKeys(firstname);
	}

	public void lastName(String lastname) {
		this.lastname.clear();
		this.lastname.sendKeys(lastname);
	}

	public void email(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}

	public void username(String username) {
		this.username.clear();
		this.username.sendKeys(username);
	}
	public void password(String password) {
		this.password.clear();
		this.password.sendKeys(password);
	}
	public void confrmpassword(String confrmpassword) {
		this.confrmpassword.clear();
		this.confrmpassword.sendKeys(confrmpassword);
	}
	public void phone(String phone) {
		this.phone.clear();
		this.phone.sendKeys(phone);
	}

	public void selectlanguage(String str) {
		Select sellanguage= new Select(language);
		sellanguage.selectByVisibleText(str);
	}
	public void clickSubmit() {
		this.submit.click(); 
	}

	public void AssertRegisterText() {
		String actualText=Text.getText();
		//assertEquals(actualText, expectedText); 
		assertTrue(actualText.contains("Dear Akshay Jha"));
	}
}
