package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ReviewAssignmnetPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ReviewAssignment {
	
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private ReviewAssignmnetPOM ReviewAssignmnetPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		ReviewAssignmnetPOM = new ReviewAssignmnetPOM(driver);
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

		loginPOM.sendUserName("Teacher01");
		loginPOM.sendPassword("akshay");
		loginPOM.clickLoginBtn(); 

	}
	@Test(dependsOnMethods = "validLoginTest")
	public void reviewAssignment() throws InterruptedException {

		ReviewAssignmnetPOM.clickSelectCourseCourse();
		ReviewAssignmnetPOM.clickAssignmentlink();
		ReviewAssignmnetPOM.clickAssignment();
		ReviewAssignmnetPOM.clickcorrectandrate();
		ReviewAssignmnetPOM.sendscore("35");
		ReviewAssignmnetPOM.clickSendMessage();
		ReviewAssignmnetPOM.assertupdatemsg();
		
		
		screenShot.captureScreenShot("Assgn_Reviewed");
	}
	@Test(dependsOnMethods = "reviewAssignment")
	public void validLogOutTest() throws InterruptedException {
		Thread.sleep(3000);
		loginPOM.profileclick();
		loginPOM.clicklogoutBtn();
	}	

}
