package com.jbk.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jbk.Base.TestBase;

public class UserPage extends TestBase
{
	@FindBy(xpath="//h1[contains(text(),'Users')]")
	WebElement userPageLabel;
	
	@FindBy(xpath="//button[text()='Add User']")
	WebElement addUserBtn;
	
	public UserPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	public String userPageTitleTest() 
	{
		return driver.getTitle();
	}
	
	public String userPageLabelTest()
	{
		return userPageLabel.getText();		
	}
	
	public boolean addUserBtnTest() 
	{
		return addUserBtn.isDisplayed();		
	}
	
	public AddUserPage clickOnAddUser()
	{
		addUserBtn.click();
		return new AddUserPage();
	}

}
