package com.jbk.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jbk.Base.TestBase;

public class DashboardPage extends TestBase
{
	@FindBy(xpath="//div//p[text()='Kiran']")
	WebElement loggedUser;
	
	@FindBy(xpath="//h1[contains(text(),'Dashboard')]")
	WebElement dashboardPageLabel;
	
	@FindBy(xpath="//a[@href='users.html']")
	WebElement userLink;
	
	@FindBy(xpath="//a[@href='operators.html']")
	WebElement operatorLink;
	
	@FindBy(xpath="/html/body/div/aside[1]/section/ul/li[5]/a")
	WebElement logoutLink;
	
	public DashboardPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean loggedUserTest()
	{
		return loggedUser.isDisplayed();		
	}
	
	public String dashboardPageTitleTest()
	{
		return driver.getTitle();		
	}
	
	public String dashboardPageLabelTest() 
	{
		return dashboardPageLabel.getText();		
	}
	
	public UserPage clickOnUserLink()
	{
		userLink.click();
		return new UserPage();		
	}
	
	public OperatorPage clickOnOperatorLink()
	{
		operatorLink.click();
		return new OperatorPage();		
	}
	
	public LogoutPage clickOnLogout() 
	{
		logoutLink.click();
		return new LogoutPage();
	}
	
}
