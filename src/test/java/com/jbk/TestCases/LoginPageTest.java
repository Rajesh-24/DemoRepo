package com.jbk.TestCases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jbk.Base.TestBase;
import com.jbk.Pages.LoginPage;

public class LoginPageTest extends TestBase
{
	LoginPage loginPage;
	
	public LoginPageTest() 
	{
		super();
	}
	
	@BeforeMethod
	public void loginSetup()
	{
		setup();
		loginPage = new LoginPage();		
	}
	
	@Test(priority=1, description="Validate Login", groups="Regression")
	public void verifyLogin()
	{
		loginPage.loginTest(prop.getProperty("username"), prop.getProperty("password"));		
	}
	
	@Test(priority=2, description="Validate Login Page Title", groups="Regression")
	public void verifyLoginPageTitle()
	{
		String actualTitle = loginPage.loginPageTitleTest();
		assertEquals(actualTitle, "AdminLTE 2 | Log in");
	}
	
	@Test(priority=3, description="Validate Login Page Heading", groups="Regression")
	public void verifyLoginPageHeading()
	{
		String actualHeading = loginPage.loginPageHeadingTest();
		assertEquals(actualHeading, "AdminLTE");
	}
	
	@AfterMethod
	public void shutDown()
	{
		driver.quit();		
	}

}
