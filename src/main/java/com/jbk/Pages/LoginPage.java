package com.jbk.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jbk.Base.TestBase;

public class LoginPage extends TestBase
{
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="//button[text()='Sign In']")
	WebElement lgnBtn;
	
	@FindBy(xpath="//a[@href='index2.html']")
	WebElement loginPageHeading;
	
	public LoginPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	public String loginPageTitleTest() 
	{
		return driver.getTitle();		
	}
	
	public String loginPageHeadingTest()
	{
		return loginPageHeading.getText();
	}
	
	public DashboardPage loginTest(String uemail, String upassword)
	{
		email.sendKeys(uemail);
		password.sendKeys(upassword);
		lgnBtn.click();
		return new DashboardPage();		
	}
}
