package com.android.object;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;

public class HomePage {

	AndroidDriver driver;
	Logger logger = Logger.getLogger("devpinoyLogger");

	@FindBy(className = "android.widget.Button")
	List<WebElement> buttonId;
	
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
	
	
	
	public HomePage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void getStartTutorials()
	{
		startTuto.click();
		Assert.assertEquals(titleId.getText(),"Topics");
		logger.info("Topics Assert is SuccessFully");
	}
	
	public void getQuestion()
	{
		qsId.click();
		Assert.assertEquals(titleId.getText(),"Question/Answers");
		logger.info("Question/Answers Assert is SuccessFully");
	}
	
	public void getAboutUs()
	{
		aboutId.click();
		Assert.assertEquals(titleId.getText(),"AboutUs");
		logger.info("AboutUs Assert is SuccessFully");
	}
	
	
	public void verifyStartTutorials()
	{
		Assert.assertEquals(startTuto.getText(),"START TUTORIALS");
		logger.info("START TUTORIALS Assert is SuccessFully");
	}
	
	public void verifyQuestion()
	{
		Assert.assertEquals(qsId.getText(),"QUESTION/ANSWERS");
		logger.info("QUESTION/ANSWERS Assert is SuccessFully");
	}
	
	public void verifyAboutUs()
	{
		Assert.assertEquals(aboutId.getText(),"ABOUT");
		logger.info("ABOUT Assert is SuccessFully");
	}
	
	public void backToHomeTab() throws InterruptedException {	
		backId.get(0).click();
		logger.info("Switched back to Home Screen");
	}

public void checkHomeScreenItems() throws InterruptedException {
		this.getStartTutorials();
		this.backToHomeTab();
		this.getQuestion();
		this.backToHomeTab();
		this.getAboutUs();
		this.backToHomeTab();		
}

public void checkHomeTabs() throws InterruptedException {
	this.verifyStartTutorials();	
	this.verifyQuestion();
	this.verifyAboutUs();
}

}
