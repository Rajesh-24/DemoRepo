package com.jbk.TestCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jbk.Base.TestBase;
import com.jbk.Pages.DashboardPage;
import com.jbk.Pages.LoginPage;
import com.jbk.Pages.LogoutPage;
import com.jbk.Pages.UserPage;

public class DashboardPageTest extends TestBase
{
	LoginPage loginPage;
	DashboardPage dashboardPage;
	UserPage userPage = new UserPage();
	LogoutPage logoutPage = new LogoutPage();
	
	public DashboardPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void dashboardPageSetup()
	{
		setup();
		loginPage = new LoginPage();
		dashboardPage= loginPage.loginTest(prop.getProperty("username"), prop.getProperty("password"));	
	}
	
	@Test(priority=1, description="Validate Dashboard Page Title", groups="Regression")
	public void verifyDashboardPageTitle()
	{
		String actualTitle = dashboardPage.dashboardPageTitleTest();
		assertEquals(actualTitle, "AdminLTE 2 | Dashboard");
	}
	
	@Test(priority=2, description="Validate Dashboard Page Label", groups="Regression")
	public void verifyDashboardPageLabel()
	{
		String actualLabel = dashboardPage.dashboardPageLabelTest();
		assertEquals(actualLabel, "Dashboard Control panel");
	}
	
	@Test(priority=3, description="Validate Logged User", groups="Regression")
	public void verifyLoggedUser() 
	{
		boolean loggedUser = dashboardPage.loggedUserTest();
		assertTrue(loggedUser);		
	}
	
	@Test(priority=4, description="Validate user link", groups="Regression")
	public void verifyUserLink()
	{
		userPage =dashboardPage.clickOnUserLink();		
	}
	
	@Test(priority=5, description="Validate operator link", groups="Regression")
	public void verifyLogoutLink()
	{
		logoutPage = dashboardPage.clickOnLogout();
	}
	
	@AfterMethod
	public void shutDown()
	{
		driver.quit();		
	}

}
