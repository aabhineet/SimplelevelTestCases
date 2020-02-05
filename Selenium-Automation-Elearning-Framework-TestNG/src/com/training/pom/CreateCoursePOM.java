package com.training.pom;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateCoursePOM {
	private WebDriver driver; 
	
	public CreateCoursePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Create a course')]")
	private WebElement createCourse; 
	
	@FindBy(id="title")
	private WebElement courseName;
	
	@FindBy(id="advanced_params")
	private WebElement advSettingsBtn; 
	
	@FindBy(id="add_course_category_code")
	private WebElement categoryCode;
	
	@FindBy(id="add_course_wanted_code")
	private WebElement courseCode;
	
	@FindBy(id="add_course_course_language")
	private WebElement courseLanguage;
	
	@FindBy(id="add_course_submit")
	private WebElement courseSubmitbtn;
	
	@FindBy(xpath="//div[@class='help-course']//a[@class='btn btn-default']")
	private WebElement courseIntro;
	
	@FindBy(xpath="//iframe[@class='cke_wysiwyg_frame cke_reset']")
	private WebElement frameText;
	
	@FindBy(xpath="//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']//p")
	private WebElement frameContent;
	
	@FindBy(id="introduction_text_intro_cmdUpdate")
	private WebElement introText;
	
	@FindBy(xpath="//a[contains(text(), 'Course description')]")
	private WebElement Description;
	
	@FindBy(xpath="//section[@id='cm-content']//div[@class='row']//a[1]//img[1]")
	private WebElement courseDesc;
	
	@FindBy(id="course_description_title")
	private WebElement Title;
	
	@FindBy(id="cke_1_contents")
	private WebElement courseDescText;
	
	@FindBy(id="course_description_submit")
	private WebElement Submit;
	
	@FindBy(xpath="//div[@id='toolbar']//a[2]//img[1]")
	private WebElement objective;
	
	@FindBy(xpath="//a[3]//img[1]")
	private WebElement topics;
	
	@FindBy(xpath="//a[contains(text(),'SeleniumBasic1')]")
	private WebElement blkchn;
	
	@FindBy(xpath="//div[@class='panel-heading']")
	private WebElement DescText;
	
	@FindBy(xpath="//*/div[@id='description_2']/div[1]")
	private WebElement ObjText;
	
	@FindBy(xpath="//*/div[@id='description_3']/div[1]")
	private WebElement TopicText;
	
	public void clickCreateCourse() {
		this.createCourse.click(); 
//		this.blkchn.click();
	}
	
	
	public void sendCourseName(String courseName) {
		this.courseName.clear();
		this.courseName.sendKeys(courseName);
	}
	
	public void AdvanceSettings() {
		this.advSettingsBtn.click(); 
	}
	
	public void sendcategoryCode(String str) {
		Select catcode= new Select(categoryCode);
		catcode.selectByVisibleText(str);
	}
	
	public void sendCourseCode(String courseCode) {
		this.courseCode.clear();
		this.courseCode.sendKeys(courseCode);
	}
	public void sendlanguage(String str01) {
		Select courselang= new Select(courseLanguage);
		courselang.selectByVisibleText(str01);
	}
	
	public void clickCourseSubmitbtnBtn() {
		this.courseSubmitbtn.click(); 
	}
	
	public void assertPageTitle() {
		String expectedTitle = "My Organization - My education - SeleniumBasics";
		String actualTitle=driver.getTitle();
		//assert Title of the page 
		assertEquals(actualTitle, expectedTitle);
	}
	
	public void clickAddIntroduction() {
		this.courseIntro.click(); 
	}
	public void sendframeText(String str01) {
		driver.switchTo().frame(frameText);
		frameContent.clear();
		frameContent.sendKeys(str01);
		driver.switchTo().defaultContent();
	}
	public void clickSave() {
		this.introText.click(); 
	}
	
	public void clickdescription() {
		
		this.Description.click();
	}
	
	public void clickCourseDesc() {
		this.courseDesc.click(); 
	}
		
	public void sendTitle(String Title) {
		this.Title.clear();
		this.Title.sendKeys(Title);
	}
		public void clickSubmit() {
		this.Submit.click(); 
	}
		public void clickObjective() {
			this.objective.click(); 
		}
		public void clicktopics() {
			this.topics.click(); 
		}
		
		public void assertDescriptionText() {
			String expectedText = "Selenium course for beginners";
			String actualText=DescText.getText();
			//assert description added
			assertEquals(actualText, expectedText);	
		}
		public void assertObjectiveText() {
			String expectedText = "Selenium course for beginners";
			String actualText=ObjText.getText();
			//assert objective added
			assertEquals(actualText, expectedText);	
		}
		public void assertTopicText() {
			String expectedText = "Selenium course for beginners";
			String actualText=TopicText.getText();
			//assert topic added
			assertEquals(actualText, expectedText);	
		}
}

