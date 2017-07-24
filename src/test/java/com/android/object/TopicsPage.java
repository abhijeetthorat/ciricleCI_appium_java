package com.android.object;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import io.appium.java_client.android.AndroidDriver;

public class TopicsPage {

	AndroidDriver driver;
	Logger logger = Logger.getLogger("devpinoyLogger");

	@FindBy(className = "android.widget.RelativeLayout")
	List<WebElement> topicsId;
	
	@FindBy(className = "android.widget.TextView")
	List<WebElement> basicId;
	
	@FindBy(className = "android.widget.ImageView")
	List<WebElement> backId;

	@FindBy(id = "com.aza.androidtutorials:id/bStart")
	WebElement startTuto;
	
	@FindBy(id = "android:id/action_bar_title")
	WebElement titleId;
	
	@FindBy(id = "com.aza.androidtutorials:id/bQuestions")
	WebElement qsId;
	
	@FindBy(id = "com.aza.androidtutorials:id/bAbout")
	WebElement aboutId;
	
	@FindBy(id = "android:id/text1")
	WebElement topicTextId;
	
	@FindBy(id = "com.aza.androidtutorials:id/item2")
	WebElement nextId;
	
	@FindBy(id = "com.aza.androidtutorials:id/item1")
	WebElement previousId;
	
	
	
	
	public TopicsPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void getStartTutorials()
	{
		startTuto.click();
		Assert.assertEquals(titleId.getText(),"Topics");
		logger.info("Topics Assert is SuccessFully");
	}
	
	public void selectTopic()
	{
		topicsId.get(1).click();
		Assert.assertEquals(titleId.getText(),"Basics of Android");
		logger.info("Basics of Android");
	}
	
	public void getQuestion()
	{
		qsId.click();
		Assert.assertEquals(titleId.getText(),"Question/Answers");
		logger.info("Question/Answers Assert is SuccessFully");
	}
	
	public void getTopics()
	{
		basicId.get(1).click();
		Assert.assertEquals(titleId.getText(),"What is Android?");
		logger.info("What is Android?");

	}
	
	public void getNextTopic()
	{
		nextId.click();
		Assert.assertEquals(titleId.getText(),"History");
		logger.info("History");

	}
	
	public void getPreviousTopic()
	{
		previousId.click();
		Assert.assertEquals(titleId.getText(),"What is Android?");
		logger.info("What is Android?");

	}
	
	public void getNextQs()
	{
		nextId.click();
		Assert.assertEquals(titleId.getText(),"Question/Answers");
		logger.info("Question/Answers");

	}
	
	public void getPreviousQs()
	{
		previousId.click();
		Assert.assertEquals(titleId.getText(),"Question/Answers");
		logger.info("Question/Answers");

	}
	
	public void getAboutUs()
	{
		aboutId.click();
		Assert.assertEquals(titleId.getText(),"AboutUs");
		logger.info("AboutUs Assert is SuccessFully");
	}

	public void backToHomeTab() throws InterruptedException {	
		backId.get(0).click();
		logger.info("Switched back to Home Screen");
	}

public void verifyStartTutorialsTopics() throws InterruptedException {
		
		this.getStartTutorials();
		this.selectTopic();
//		this.getQuestion();
    	this.getTopics();
    	this.getNextTopic();
    	this.getPreviousTopic();
    	this.backToHomeTab();
    	this.backToHomeTab();
    	this.backToHomeTab();	
}

public void verifyQuestions() throws InterruptedException {
	this.getQuestion();
	this.getNextQs();
	this.getPreviousQs();
	Assert.assertEquals("test","AboutUs");
	this.backToHomeTab();
}



}
