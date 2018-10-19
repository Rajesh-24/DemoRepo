package com.jbk.TestCases;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jbk.Base.TestBase;
import com.jbk.Pages.AddUserPage;
import com.jbk.Pages.DashboardPage;
import com.jbk.Pages.LoginPage;
import com.jbk.Pages.UserPage;
import com.jbk.Utils.TestDataProvider;

public class AddUserPageTest extends TestBase
{
	LoginPage loginPage;
	DashboardPage dashboardPage;
	UserPage userPage;
	AddUserPage addUserPage = new AddUserPage();
	
	public AddUserPageTest() 
	{
		super();
	}
	
	@BeforeMethod
	public void addUserPageSetup() 
	{
		setup();
		loginPage = new LoginPage();
		dashboardPage = loginPage.loginTest(prop.getProperty("username"), prop.getProperty("password"));
		dashboardPage.clickOnUserLink();
		userPage = new UserPage();
		addUserPage= userPage.clickOnAddUser();		
	}
	
	@Test(priority=1, description="Validate Add User Page Title", groups="Regression")
	public void verifyAddUserPageTitle()
	{
		String actualTitle = addUserPage.addUserPageTitleTest();
		assertEquals(actualTitle, "AdminLTE 2 | Add User");
	}
	
	@Test(priority=2, description="Validate Add User Page Label", groups="Regression")
	public void verifyAddUserPageLabel()
	{
		String actualLabel = addUserPage.addUserPageLabelTest();
		assertEquals(actualLabel, "Add User");
	}
	
	@Test(priority=3, description="Validate Add User Form Labels", groups="Regression")
	public void verifyAddUserPageFormLables()
	{
		List<String> actuaFormLabels = addUserPage.addUserPageFormLabelsTest();
		System.out.println(actuaFormLabels);
		List<String> expectedFormLabels = new ArrayList<String>();
		
		expectedFormLabels.add("Username");
		expectedFormLabels.add("Mobile");
		expectedFormLabels.add("Email");
		expectedFormLabels.add("Gender");
		expectedFormLabels.add("State");
		expectedFormLabels.add("Password");
		System.out.println(expectedFormLabels);
		
		assertEquals(actuaFormLabels, expectedFormLabels);
	}
	
	@Test(priority=4, dataProvider="userData", dataProviderClass=TestDataProvider.class, description="Validate Add User Form", groups="Regression")
	public void verifyAddUserForm(String username, String mobile, String email, String gender, String state, String password)
	{
		String actualAlertText = addUserPage.addNewUserTest(username,mobile,email,gender,state,password);
        assertEquals(actualAlertText,"User Added Successfully. You can not see added user.","Add User Failed");     		
	}
	
	@AfterMethod
	public void shutDown()
	{
		driver.quit();		
	}

}
