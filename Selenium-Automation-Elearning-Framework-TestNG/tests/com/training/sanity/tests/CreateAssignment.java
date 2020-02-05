package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.CreateAssignmentPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CreateAssignment {
	
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private CreateAssignmentPOM CreateAssignmentPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		CreateAssignmentPOM = new CreateAssignmentPOM(driver);
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
	public void createAssignment() throws InterruptedException {

		CreateAssignmentPOM.clickSelectCourseCourse();
		CreateAssignmentPOM.clickAssignmentlink();
		CreateAssignmentPOM.createAssignmentlink();
		CreateAssignmentPOM.sendasgnName("Hands on Excercises");
		CreateAssignmentPOM.sendframeText("Excercise");
		CreateAssignmentPOM.AdvanceSettings();
		CreateAssignmentPOM.sendMaxScore("50");
		CreateAssignmentPOM.validatebtn();
		CreateAssignmentPOM.selectcheckbox();
		
		screenShot.captureScreenShot("Assgn_Created");
	}
	@Test(dependsOnMethods = "createAssignment")
	public void validLogOutTest() throws InterruptedException {
		Thread.sleep(3000);
		loginPOM.profileclick();
		loginPOM.clicklogoutBtn();
	}	


}
