package com.jbk.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jbk.Base.TestBase;

public class OperatorPage extends TestBase
{
	@FindBy(xpath="//h1[contains(text(),'Operators')]")
	WebElement operatorPageLabel;
	
	@FindBy(xpath="//h3[contains(text(),'Operator List')]")
	WebElement operatorPageTableLabel;
	
	List<WebElement> tableHeadings = driver.findElements(By.tagName("th"));
	
	public OperatorPage() 
	{
		PageFactory.initElements(driver, this);		
	}
	
	public String operatorPageTitleTest()
	{
		return driver.getTitle();				
	}

	public String operatorPageLabelTest()
	{
		return operatorPageLabel.getText();		
	}
	
	public String operatorPageTableLabelTest()
	{
		return operatorPageTableLabel.getText();		
	}
	
	public String operatorPageTableHeadingTest()
	{
		String tableHeads = null;
		for (WebElement theadings : tableHeadings) 
		{
			tableHeads=theadings.getText();			
		}
		return tableHeads;		
	}
}
