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
import com.training.pom.CreateCoursePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CreateCourse {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private CreateCoursePOM CreateCoursePOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		CreateCoursePOM = new CreateCoursePOM(driver);
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
	public void SubscribeClasstoUser() throws InterruptedException {
		
		CreateCoursePOM.clickCreateCourse();
		CreateCoursePOM.sendCourseName("SeleniumBasics");
		CreateCoursePOM.AdvanceSettings();
		CreateCoursePOM.sendcategoryCode("Projects (PR001)");
		CreateCoursePOM.sendCourseCode("SLBA100");
		CreateCoursePOM.sendlanguage("English");
		CreateCoursePOM.clickCourseSubmitbtnBtn();
		CreateCoursePOM.assertPageTitle();
		CreateCoursePOM.clickAddIntroduction();
		CreateCoursePOM.sendframeText("Selenium course for beginners");
		CreateCoursePOM.clickSave();
		CreateCoursePOM.clickdescription();
		CreateCoursePOM.clickCourseDesc();
		CreateCoursePOM.sendTitle("Selenium course for beginners");
		CreateCoursePOM.sendframeText("Selenium course for beginners");
		CreateCoursePOM.clickSubmit();
		CreateCoursePOM.assertDescriptionText();
		CreateCoursePOM.clickObjective();
		CreateCoursePOM.sendTitle("Selenium course for beginners");
		CreateCoursePOM.sendframeText("Selenium course for beginners");
		CreateCoursePOM.clickSubmit();
		CreateCoursePOM.assertObjectiveText();
		CreateCoursePOM.clicktopics();
		CreateCoursePOM.sendTitle("Selenium course for beginners");
		CreateCoursePOM.sendframeText("Selenium course for beginners");
		CreateCoursePOM.clickSubmit();
		CreateCoursePOM.assertTopicText();
		
		
		screenShot.captureScreenShot("Course_Created");
	}
	@Test(dependsOnMethods = "SubscribeClasstoUser")
	public void validLogOutTest() throws InterruptedException {
		Thread.sleep(3000);
		loginPOM.profileclick();
		loginPOM.clicklogoutBtn();
	}	
}
