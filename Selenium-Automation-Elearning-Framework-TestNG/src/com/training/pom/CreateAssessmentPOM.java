package com.training.pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAssessmentPOM {
	private WebDriver driver; 

	public CreateAssessmentPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[contains(text(),'SeleniumBasics')]")
	private WebElement SelectCourse; 
	
	@FindBy(xpath="//a[contains(text(), 'Assessments')]")
	private WebElement Assessmentlink;
	
	@FindBy(xpath="//div[@class='col-sm-6']//a[2]//img[1]")
	private WebElement onlineactivity;
	
	@FindBy(xpath="//div[@class='filter-option']")
	private WebElement listclick;
	
	@FindBy(xpath="//div[@class='filter-option']")
	private WebElement listclick1;
	
	@FindBy(xpath="//form[@id='add_link']//div[@class='filter-option']")
	private WebElement listclick2;
	
	@FindBy(xpath="//select[@id='create_link_select_link']/option[2]")
	private WebElement activitytype;
	
	@FindBy(xpath="//select[@id='create_link_select_link']/option[2]")
	private WebElement typtoassess;
	
	@FindBy(xpath="//form[@id='add_link']//div[@class='filter-option']")
	private WebElement acttoassess;
	
	@FindBy(xpath="//input[@id='weight_mask']")  
	private WebElement weightage;
	
	@FindBy(xpath="//button[@id='add_link_submit']")
	private WebElement submit;
	
	@FindBy(xpath="//form[@id='form_gradebooklist_id']//a[1]//img[1]")
	private WebElement edit;
	
	@FindBy(xpath="//*[@id='visible']//*[@name='visible']")
	private WebElement visibletext;
	
	@FindBy(xpath="//button[@id='edit_link_form_submit']")
	private WebElement editlink;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement updatemsg;
	
	@FindBy(xpath="//div[@class='col-sm-6 text-right']//a[2]//img[1]")
	private WebElement certificate;
	
	public void clickSelectCourseCourse() {
		this.SelectCourse.click(); 
	}
	public void clickAssessmentlink() {
		this.Assessmentlink.click(); 
	}
	public void clickTest() {
		this.onlineactivity.click(); 
	}
	public void selectactivity() {
		this.listclick.click();
	}
	public void selecttyptoassess() {
		this.listclick1.click();
		this.typtoassess.click();
}
	public void selectacttoassess() {
		this.listclick2.click();
		this.acttoassess.click();
	}
	public void weightage(String weightage) {
		this.weightage.clear();
		this.weightage.sendKeys(weightage);
	}
	public void clickSubmit() {
		this.submit.click(); 
	}
	public void Edit() {
		this.edit.click(); 
	}
	// call weightage to update text
		public void clickvisibleText() {
			this.visibletext.click(); 
		}
		
		public void clickeditLink() {
			this.editlink.click(); 
		}
		public void asserteditText() {
			String expectedText = "Assessment edited";
			String actualText=updatemsg.getText();
			//assert 
			assertEquals(actualText, expectedText);
		}
		
		public void attachcertificate() {
			
			this.certificate.click();
			String expectedTitle = "My Organization - My education - SeleniumBasics";
			String actualTitle=driver.getTitle();
			//assert 
			assertEquals(actualTitle, expectedTitle);
		}
}
