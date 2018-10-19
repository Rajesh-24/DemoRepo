package com.jbk.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.jbk.Base.TestBase;

public class AddUserPage extends TestBase
{
	@FindBy(xpath="//h1[contains(text(),'Add User')]")
	WebElement addUserPageLabel;
	
	@FindBy(xpath="//label[text()='Username']")
	WebElement usernameLabel;
	
	@FindBy(xpath="//label[text()='Mobile']")
	WebElement mobileLabel;
	
	@FindBy(xpath="//label[text()='Email']")
	WebElement emailLabel;
	
	@FindBy(xpath="//label[text()='Gender']")
	WebElement genderLabel;
	
	@FindBy(xpath="//label[text()='State']")
	WebElement stateLabel;
	
	@FindBy(xpath="//label[text()='Password']")
	WebElement  passwordLabel;
	
	@FindBy(id="username")
	WebElement username;
	
	@FindBy(id="mobile")
	WebElement mobile;
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="Male")
	WebElement genderMale;
	
	@FindBy(id="Female")
	WebElement genderFemale;
	
	@FindBy(xpath="//select[@class='form-control']")
	WebElement state;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement btnSubmit;
		
	public AddUserPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	public String addUserPageTitleTest()
	{
		return driver.getTitle();		
	}
	
	public String addUserPageLabelTest()
	{
		return addUserPageLabel.getText();
	}
	
	public List<String>	addUserPageFormLabelsTest()
	{
		//List<String> formLabels = new ArrayList<String>();
		List<String> formLabels = new ArrayList<String>();
		
		formLabels.add(usernameLabel.getText());
		formLabels.add(mobileLabel.getText());
		formLabels.add(emailLabel.getText());
		formLabels.add(genderLabel.getText());
		formLabels.add(stateLabel.getText());
		formLabels.add(passwordLabel.getText());
		
		return formLabels;
	}
	
	public String addNewUserTest(String u_name, String u_mobile, String u_email, String u_gender, String u_state, String u_pass)
	{
		username.sendKeys(u_name);
		mobile.sendKeys(u_mobile);
		email.sendKeys(u_email);
		
		if (u_gender.equalsIgnoreCase("Male"))
		{
			genderMale.click();			
		}
		else if (u_gender.equalsIgnoreCase("Female"))
		{
			genderFemale.click();			
		}
		
		Select select = new Select(state);
		select.selectByVisibleText(u_state);
		password.sendKeys(u_pass);
		btnSubmit.click();
		
		return driver.switchTo().alert().getText();
	}
}
