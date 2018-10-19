package com.jbk.TestCases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jbk.Base.TestBase;
import com.jbk.Pages.DashboardPage;
import com.jbk.Pages.LoginPage;
import com.jbk.Pages.OperatorPage;

public class OperatorPageTest extends TestBase
{
	LoginPage loginPage;
	DashboardPage dashboardPage;
	OperatorPage operatorPage;
	
	public OperatorPageTest() 
	{
		super();
	}
	
	@BeforeMethod
	public void operatorPageSetup() 
	{
		setup();
		loginPage = new LoginPage();
		dashboardPage = loginPage.loginTest(prop.getProperty("username"), prop.getProperty("password"));
		dashboardPage.clickOnOperatorLink();
		operatorPage = new OperatorPage();		
	}
	
	@Test(priority=1, description="Validate Operator Page Title", groups="Regression")
	public void verifyOperatorPageTitle()
	{
		String actualTitle = operatorPage.operatorPageTitleTest();
		assertEquals(actualTitle, "AdminLTE 2 | Operators");
	}
	
	@Test(priority=2, description="Validate Operator Page Label", groups="Regression")
	public void verifyOperatorPageLabel()
	{
		String actualLabel = operatorPage.operatorPageLabelTest();
		assertEquals(actualLabel, "Operators");
	}
	
	@Test(priority=3, description="Validate Operator Page Table Label", groups="Regression")
	public void verifyOperatorPageTableLabel()
	{
		String actualLabel = operatorPage.operatorPageTableLabelTest();
		assertEquals(actualLabel, "Operator List");
	}
	
	@Test(priority=4, description="Validate Operator Page Table Headings", groups="Regression")
	public void verifyOperatorTableHeading()
	{
		String actualHeading = operatorPage.operatorPageTableHeadingTest();
		assertEquals(actualHeading, "Operator");
	}
	
	@AfterMethod
	public void shutDown()
	{
		driver.quit();		
	}

}
