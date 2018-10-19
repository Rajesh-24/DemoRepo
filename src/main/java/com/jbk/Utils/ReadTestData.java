package com.jbk.Utils;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.jbk.Base.TestBase;

public class ReadTestData extends TestBase
{
	String filePath = prop.getProperty("testDataPath");
	
	FileInputStream fis;
	XSSFWorkbook wb;	
	XSSFSheet sheet;	
	XSSFRow row;
	XSSFCell cell;
	
	public ReadTestData(int sheetNumber) 
	{
		try 
		{
			fis = new FileInputStream(filePath);
			wb= new XSSFWorkbook(fis);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		sheet =wb.getSheetAt(sheetNumber);
	}
	
	public String readData(int rowNum, int colNum)
	{
		String data=null;
		
		row = sheet.getRow(rowNum);
		cell = row.getCell(colNum);
		if (cell.getCellTypeEnum()==CellType.STRING)
		{
			data = cell.getStringCellValue();			
		}
		else if (cell.getCellTypeEnum()==CellType.NUMERIC)
		{
			data = String.valueOf((long)cell.getNumericCellValue());			
		}
		return data;
	}
	
	public int rowCount() 
	{
		int rows =sheet.getLastRowNum()+1;
		return rows;
	}
	
	public int colCount()
	{
		row = sheet.getRow(0);
		int cols = row.getLastCellNum();
		return cols;		
	}
	
}
