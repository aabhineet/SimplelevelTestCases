package com.training.pom;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReviewAssignmnetPOM {
	private WebDriver driver; 

	public ReviewAssignmnetPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[contains(text(),'SeleniumBasics')]")
	private WebElement SelectCourse; 
	
	@FindBy(xpath="//a[contains(text(), 'Assignments')]")
	private WebElement Assignmentlink;
	
	@FindBy(xpath="//a[contains(text(),'Hands on Excercises')]")
	private WebElement Assignment;
	
	@FindBy(xpath="//div[@class='panel panel-default']//a[2]//img[1]")
	private WebElement correctasgn;
	
	@FindBy(id="qualification")
	private WebElement score;
	
	@FindBy(id="work_comment_button")
	private WebElement submit;
	
	@FindBy(xpath=" //*[@class='alert alert-info' and contains(text(),'Update successful')]")
	private WebElement updatemsg;
	
	@FindBy(xpath="//a[contains(text(),'Hands on Excercises')]")
	private WebElement asgnpage;
	
	@FindBy(xpath="//table[@id='results']/tbody[1]/tr[2]/td[5]")
	private WebElement Status;
	
	@FindBy(xpath="//table[@id='results']/tbody[1]/tr[2]/td[3]")
	private WebElement scoredisplayed;
	
	public void clickSelectCourseCourse() {
		this.SelectCourse.click(); 
	}
	public void clickAssignmentlink() {
		this.Assignmentlink.click(); 
	}
	public void clickAssignment() {
		this.Assignment.click(); 
	}
	public void clickcorrectandrate() {
		this.correctasgn.click(); 
	}
	public void sendscore(String marks) {
		this.score.clear();
		this.score.sendKeys(marks);
	}
	public void clickSendMessage() {
		this.submit.click(); 
	}
	public void assertupdatemsg() {
		String expectedText = "Update successful";
		String actualText=updatemsg.getText();
		//assert Update Message
		assertEquals(actualText, expectedText);	
		// Move to Assignment Page
		this.asgnpage.click();
		// assert Status of Assignment
		String actualstatus = Status.getText();
		String expectedstatus = "Revised";
		assertTrue(actualstatus.equals(expectedstatus));
		// Get the marks displayed
		String scoredisp  = scoredisplayed.getText();
		System.out.println(scoredisp);
		
	}
}
