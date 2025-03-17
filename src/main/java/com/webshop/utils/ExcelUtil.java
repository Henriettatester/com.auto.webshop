package com.webshop.utils;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil
{
	FileInputStream fis;
	XSSFWorkbook wb;
	
//call the constructor
	public ExcelUtil(String excelPath) {
		try 
		{
		File file = new File(excelPath);
		fis = new FileInputStream(file);
		wb = new XSSFWorkbook(fis);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("unable to load excel file");
		}
	}
	public int getRowCount(int sheetNo)
	{
		int count = wb.getSheetAt(sheetNo).getLastRowNum()+1;
		return count;
	}
	//overloading : two different methods with same name getRowCount 
	//but with different parameters
	
		public int getRowCount(String sheetName)
	{
		int count = wb.getSheet(sheetName).getLastRowNum()+1;
		return count;
	}
	
	public String getCellData(int sheetNo, int row, int cell)
	{
		String data = wb.getSheetAt(sheetNo).getRow(row).getCell(cell).toString();
		return data;
			}
	
	public String getCellData(String sheetName, int row, int cell)
	{
		String data = wb.getSheet(sheetName).getRow(row).getCell(cell).toString();
		return data;
			}
}
