package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.CreateTestPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CreateTest {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private CreateTestPOM CreateTestPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		CreateTestPOM = new CreateTestPOM(driver);
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

		CreateTestPOM.clickSelectCourseCourse();
		CreateTestPOM.clickTestlink();
		CreateTestPOM.clickTest();
		CreateTestPOM.sendTestName("TEST  001");
		CreateTestPOM.clickAdvanceParam();
		CreateTestPOM.sendframeText("This is to test");
		CreateTestPOM.clickFeedback();
		CreateTestPOM.clickStartTime();
		CreateTestPOM.setStartTime();
		CreateTestPOM.sendPercentage("50");
		CreateTestPOM.clicksubmitExerciseBtn();
		
		CreateTestPOM.clickMultipleChoice();
		CreateTestPOM.sendquestion("which course your learning");
		CreateTestPOM.sendOption1("Selenium");
		CreateTestPOM.sendOption2("C");
		CreateTestPOM.sendOption3("C++");
		CreateTestPOM.sendOption4("R");
		CreateTestPOM.clickAns1();
		CreateTestPOM.addNextQues();
		CreateTestPOM.assertQues1Text();
		CreateTestPOM.clickMultipleChoice();
		CreateTestPOM.sendquestion("which language are you using in selenium");
		CreateTestPOM.sendOption1("C++");
		CreateTestPOM.sendOption2("Java");
		CreateTestPOM.sendOption3("PHP");
		CreateTestPOM.sendOption4("C#");
		CreateTestPOM.clickAns2();
		CreateTestPOM.addNextQues();
		CreateTestPOM.assertQues2Text();
		CreateTestPOM.previwQues();
		CreateTestPOM.startTest();
		CreateTestPOM.answerQues();
		
		screenShot.captureScreenShot("Test_Created");
	}
	@Test(dependsOnMethods = "createTest")
	public void validLogOutTest() throws InterruptedException {
		Thread.sleep(3000);
		loginPOM.profileclick();
		loginPOM.clicklogoutBtn();
	}	

}
