package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.CreateAssessmentPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CreateAssessment {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private CreateAssessmentPOM CreateAssessmentPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		CreateAssessmentPOM = new CreateAssessmentPOM(driver);
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
	public void createTest() throws InterruptedException {

		CreateAssessmentPOM.clickSelectCourseCourse();
		CreateAssessmentPOM.clickAssessmentlink();
		CreateAssessmentPOM.clickTest();
		CreateAssessmentPOM.selectactivity();//("Tests");
		CreateAssessmentPOM.selecttyptoassess();//("Tests");
		CreateAssessmentPOM.selectacttoassess();//("TEST  001");
		CreateAssessmentPOM.weightage("50");
		CreateAssessmentPOM.clickSubmit();
		CreateAssessmentPOM.Edit();
		CreateAssessmentPOM.weightage("70");
		CreateAssessmentPOM.clickvisibleText();
		CreateAssessmentPOM.clickeditLink();
		CreateAssessmentPOM.asserteditText();
		CreateAssessmentPOM.attachcertificate();
		
		screenShot.captureScreenShot("Test_Created");
	}
	@Test(dependsOnMethods = "createTest")
	public void validLogOutTest() throws InterruptedException {
		Thread.sleep(3000);
		loginPOM.profileclick();
		loginPOM.clicklogoutBtn();
	}	


}
