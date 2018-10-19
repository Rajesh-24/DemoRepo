package com.jbk.TestCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jbk.Base.TestBase;
import com.jbk.Pages.AddUserPage;
import com.jbk.Pages.DashboardPage;
import com.jbk.Pages.LoginPage;
import com.jbk.Pages.UserPage;

public class UserPageTest extends TestBase
{
	LoginPage loginPage;
	DashboardPage dashboardPage;
	UserPage userPage;
	AddUserPage addUserPage = new AddUserPage();
	
	public UserPageTest() 
	{
		super();
	}
	
	@BeforeMethod
	public void userPageSetup()
	{
		setup();
		loginPage = new LoginPage();
		dashboardPage =loginPage.loginTest(prop.getProperty("username"), prop.getProperty("password"));
		dashboardPage.clickOnUserLink();
		userPage = new UserPage();		
	}
	
	@Test(priority=1, description="Validate User Page Title", groups="Regression")
	public void verifyUserPageTitle()
	{
		String actualTitle = userPage.userPageTitleTest();
		assertEquals(actualTitle, "AdminLTE 2 | User");
	}
	
	@Test(priority=2, description="Validate User Page Label", groups="Regression")
	public void verifyUserPageLabel() 
	{
		String actualLabel = userPage.userPageLabelTest();
		assertEquals(actualLabel, "Users");
	}
	
	@Test(priority=3, description="Validate Add User Page Button", groups="Regression")
	public void verifyLoginPageBtn()
	{
		boolean addUserBtn = userPage.addUserBtnTest();
		assertTrue(addUserBtn);
		
		addUserPage=userPage.clickOnAddUser();
	}
	
	@AfterMethod
	public void shutDown()
	{
		driver.quit();		
	}

}
