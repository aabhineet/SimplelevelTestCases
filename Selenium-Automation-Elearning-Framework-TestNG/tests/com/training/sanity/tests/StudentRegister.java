package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RegisterPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class StudentRegister{

	private WebDriver driver;
	private String baseUrl;
	private RegisterPOM RegisterPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}
	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		RegisterPOM = new RegisterPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void signUpTest() {
		
		RegisterPOM.clicksignUpBtn(); 
		// verify if the user is on the registration page
		RegisterPOM.assertPageTitle();
		screenShot.captureScreenShot("First");
		
		//Enter the details
		RegisterPOM.firstName("Akshay");
		RegisterPOM.lastName("Jha");
		RegisterPOM.email("akshajha@in.ibm.com");
		RegisterPOM.username("akzzsh");
		RegisterPOM.password("akshay");
		RegisterPOM.confrmpassword("akshay");
		RegisterPOM.phone("8452886923");
		RegisterPOM.selectlanguage("English");
		RegisterPOM.clickSubmit();
		
		//Validate if the user is created successfully
		RegisterPOM.AssertRegisterText();
		
		screenShot.captureScreenShot("Second");
			}
		}
