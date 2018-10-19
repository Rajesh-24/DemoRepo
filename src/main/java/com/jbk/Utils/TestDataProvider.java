package com.jbk.Utils;

import org.testng.annotations.DataProvider;

public class TestDataProvider 
{
	ReadTestData reader;
	
	@DataProvider(name="userData")
	public Object getuserData() 
	{
		reader = new ReadTestData(0);
		int rows=reader.rowCount();
		int cols=reader.colCount();
		
		Object data[][] = new Object[rows][cols];
		
		for (int i = 0; i < rows; i++) 
		{
			for (int j = 0; j < cols; j++) 
			{
				data[i][j] = reader.readData(i, j);				
			}
			
		}
		return data;
	}
}
