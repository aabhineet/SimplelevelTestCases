package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.ChangePwdPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ChangePwd{
	
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private ChangePwdPOM ChangePwdPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		ChangePwdPOM = new ChangePwdPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test 
	public void pwdReset() {
		
		// Login as a registered user
		loginPOM.sendUserName("akshay");
		loginPOM.sendPassword("ibmtest3");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("Login_Successful");
	
		// User is on Home page after login to edit user profile
		ChangePwdPOM.clickEditProfile();
		
		// Validate Edit profile page is opened
		ChangePwdPOM.assertPageTitle();
		
		// Enter the details
		ChangePwdPOM.sendoldPassword("ibmtest3");
		ChangePwdPOM.sendnewPassword("ibmtest4");
		ChangePwdPOM.sendcnfrmnewPassword("ibmtest4");
		ChangePwdPOM.clickapplyChange();
		
		// Validate whether the profile is updated 
		ChangePwdPOM.AssertupdateMessage();
		screenShot.captureScreenShot("Pwd_Reset");	
	}
}
