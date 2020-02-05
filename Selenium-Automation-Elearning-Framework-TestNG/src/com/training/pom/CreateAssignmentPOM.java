package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAssignmentPOM {
	private WebDriver driver; 

	public CreateAssignmentPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[contains(text(),'SeleniumBasics')]")
	private WebElement SelectCourse; 
	
	@FindBy(xpath="//a[contains(text(), 'Assignments')]")
	private WebElement Assignmentlink;
	
	@FindBy(xpath="//div[@class='actions']//a[1]//img[1]")
	private WebElement createAssignment;
	
	@FindBy(id="form1_new_dir")
	private WebElement asgnName;
	
	@FindBy(xpath="//iframe[@class='cke_wysiwyg_frame cke_reset']")
	private WebElement frameText;
	
	@FindBy(xpath="//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']//p")
	private WebElement frameContent;
	
	@FindBy(id="advanced_params")
	private WebElement advParamBtn;
	
	@FindBy(id="form1_qualification")
	private WebElement maxScore;
	
	@FindBy(id="form1_submit")
	private WebElement validatebtn;
	
	@FindBy(xpath="//table[@id='workList']/tbody[1]/tr[2]/td[1]")
	private WebElement ckbox;
	
	
	public void clickSelectCourseCourse() {
		this.SelectCourse.click(); 
	}
	public void clickAssignmentlink() {
		this.Assignmentlink.click(); 
	}
	public void createAssignmentlink() {
		this.createAssignment.click(); 
	}
	public void sendasgnName(String asgnName) {
		this.asgnName.clear();
		this.asgnName.sendKeys(asgnName);
	}
	public void sendframeText(String str01) {
		driver.switchTo().frame(frameText);
		frameContent.clear();
		frameContent.sendKeys(str01);
		driver.switchTo().defaultContent();
	}
	public void AdvanceSettings() {
		this.advParamBtn.click(); 
	}
	
	public void sendMaxScore(String maxScore) {
		this.maxScore.clear();
		this.maxScore.sendKeys(maxScore);
	}
	public void validatebtn() {
		this.validatebtn.click(); 
	}
	public void selectcheckbox() {
		this.ckbox.click(); 
	}

}
