package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.SubscribeClassPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class SubscribeClass {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private SubscribeClassPOM SubscribeClassPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		SubscribeClassPOM = new SubscribeClassPOM(driver);
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
	public void validLoginTest() {
		
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
	
	}
	@Test(dependsOnMethods = "validLoginTest")
	public void SubscribeClasstoUser() throws InterruptedException {
		
		SubscribeClassPOM.selectclasslink();
		SubscribeClassPOM.assertPageTitle();
		SubscribeClassPOM.selectClasses();
		SubscribeClassPOM.SubcribeUser();
		SubscribeClassPOM.ClickMoveRight();
		SubscribeClassPOM.SubscribeUserClass();
		
		screenShot.captureScreenShot("Course_Added");
		
		// Verify the table value for new added student
		SubscribeClassPOM.VerifyUserCount();
	}
}
