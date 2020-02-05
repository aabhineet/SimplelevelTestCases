package com.training.pom;

import static org.testng.Assert.assertEquals;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateTestPOM {

	private WebDriver driver; 

	public CreateTestPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[contains(text(),'SeleniumBasics')]")
	private WebElement SelectCourse; 

	@FindBy(xpath="//a[contains(text(), 'Tests')]")
	private WebElement Testlink;

	@FindBy(xpath="//a[@class='btn btn-primary']")
	private WebElement createTest;

	@FindBy(id="exercise_title")
	private WebElement testName; 

	@FindBy(id="advanced_params")
	private WebElement advParambtn;

	@FindBy(xpath="//iframe[@class='cke_wysiwyg_frame cke_reset']")
	private WebElement frameText;

	@FindBy(xpath="//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']//p")
	private WebElement frameContent;

	@FindBy(id="exerciseType_0")
	private WebElement feedbackRadio;

	@FindBy(xpath="//label[contains(text(),'Enable start time')]")
	private WebElement startTime;

	@FindBy(id="start_time_alt_text")
	private WebElement startTimeValue;

	@FindBy(xpath="//*[@class='ui-datepicker-calendar']")
	private WebElement datepicker;

	@FindBy(xpath="//div[@class='ui_tpicker_hour_slider ui-slider ui-slider-horizontal ui-widget ui-widget-content ui-corner-all']")
	private WebElement hour;

	@FindBy(xpath="//button[@class='ui-datepicker-close ui-state-default ui-priority-primary ui-corner-all']")
	private WebElement done;

	@FindBy(id="pass_percentage")
	private WebElement percentage;

	@FindBy(id="exercise_admin_submitExercise")
	private WebElement submitExercise ;

	@FindBy(xpath="//section[@id='cm-content']//li[1]//div[1]//a[1]//img[1]")
	private WebElement multiple_choice;

	@FindBy(id="question_admin_form_questionName")
	private WebElement ques1;

	@FindBy(xpath="//tr[1]//td[3]//iframe[@class='cke_wysiwyg_frame cke_reset']")
	private WebElement Option1;

	@FindBy(xpath="//tr[2]//td[3]//iframe[@class='cke_wysiwyg_frame cke_reset']")
	private WebElement Option2;

	@FindBy(xpath="//tr[3]//td[3]//iframe[@class='cke_wysiwyg_frame cke_reset']")
	private WebElement Option3;

	@FindBy(xpath="//tr[4]//td[3]//iframe[@class='cke_wysiwyg_frame cke_reset']")
	private WebElement Option4;

	@FindBy(xpath="//tr[1]//td[2]")
	private WebElement rightoption1;

	@FindBy(xpath="//tr[2]//td[2]")
	private WebElement rightoption2;
	
	@FindBy(xpath="//div[@class='alert alert-info']")
	private WebElement alertText;
	
	@FindBy(xpath="//button[@id='submit-question']")
	private WebElement submitques;

	
	@FindBy(xpath="//div[@class='actions']//a[2]//img[1]")
	private WebElement previewbtn;

	@FindBy(xpath="//a[@class='btn btn-success btn-large']")
	private WebElement startTestbtn;

	@FindBy(xpath="//*[contains(@class, 'question_options')]//p[contains(text(),'Selenium')]")
	private WebElement answer1;

	@FindBy(xpath="//button[@name='save_now']")
	private WebElement nxtques;

	@FindBy(xpath="//*[contains(@class, 'question_options')]//p[contains(text(),'Java')]")
	private WebElement answer2;

	@FindBy(xpath="//button[@name='save_now']")
	private WebElement endTest;

	public void clickSelectCourseCourse() {
		this.SelectCourse.click(); 
	}
	public void clickTestlink() {
		this.Testlink.click(); 
	}
	public void clickTest() {
		this.createTest.click(); 
	}
	public void sendTestName(String testName) {
		this.testName.clear();
		this.testName.sendKeys(testName);
	}
	public void clickAdvanceParam() {
		this.advParambtn.click(); 
	}
	public void sendframeText(String str01) {
		driver.switchTo().frame(frameText);
		frameContent.clear();
		frameContent.sendKeys(str01);
		driver.switchTo().defaultContent();
	}
	public void clickFeedback() {
		boolean feedbackRadioIsSelected= feedbackRadio.isSelected();
		if(!feedbackRadioIsSelected) {
			this.feedbackRadio.click();
		}
	}
	public void clickStartTime() {
		this.startTime.click();
	}
	public void setStartTime() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", startTimeValue);

		boolean setTimeIsDispalyed= startTimeValue.isDisplayed();
		if (setTimeIsDispalyed) {
			this.startTimeValue.click();

			List<WebElement> columns = datepicker.findElements(By.tagName("td"));
			for (WebElement cell: columns) {

				if (cell.getText().equals("18")) {
					cell.click();
					break;
				}
			}
			Thread.sleep(4000);
			Actions act01 = new Actions(driver);
			act01.moveToElement(hour).dragAndDropBy(hour, 200, 0).build().perform();
			this.done.click();
		}
	}
	public void sendPercentage(String percentage) {
		this.percentage.clear();
		this.percentage.sendKeys(percentage);
	}

	public void clicksubmitExerciseBtn() throws InterruptedException {
		Thread.sleep(4000);
		this.submitExercise.click(); 
	}
	public void clickMultipleChoice() {
		this.multiple_choice.click(); 
	}

	public void sendquestion(String str01) {
		this.ques1.clear();
		this.ques1.sendKeys(str01);
	}
	public void sendOption1(String str01) {
		driver.switchTo().frame(Option1);
		frameContent.clear();
		frameContent.sendKeys(str01);
		driver.switchTo().defaultContent();
	}
	public void sendOption2(String str01) {
		driver.switchTo().frame(Option2);
		frameContent.clear();
		frameContent.sendKeys(str01);
		driver.switchTo().defaultContent();
	}
	public void sendOption3(String str01) {
		driver.switchTo().frame(Option3);
		frameContent.clear();
		frameContent.sendKeys(str01);
		driver.switchTo().defaultContent();
	}
	public void sendOption4(String str01) {
		driver.switchTo().frame(Option4);
		frameContent.clear();
		frameContent.sendKeys(str01);
		driver.switchTo().defaultContent();
	}
	public void clickAns1() {		
			this.rightoption1.click();
		}
	public void clickAns2() {		
		this.rightoption2.click();
	}
	public void addNextQues() {
		this.submitques.click();
	}
	
	public void assertQues1Text() {
		String expectedText = "1 questions, for a total score (all questions) of 0.";
		String actualText=alertText.getText();
		//assert description added
		assertEquals(actualText, expectedText);
	}
	public void assertQues2Text() {
		String expectedText = "2 questions, for a total score (all questions) of 0.";
		String actualText=alertText.getText();
		//assert description added
		assertEquals(actualText, expectedText);
	}
	public void previwQues() {
		this.previewbtn.click();
	}
	public void startTest() {
		this.startTestbtn.click();
	}
	public void answerQues() {
		this.answer1.click();
		this.nxtques.click();
		this.answer2.click();
		this.endTest.click();
		
	}

}
