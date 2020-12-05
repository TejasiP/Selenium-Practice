package com.selenium.datadriven;

import org.testng.annotations.Test;

import com.selenium.pageobjects.Fdobject;

import org.testng.annotations.BeforeTest;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.testng.annotations.AfterTest;

public class FD_DataDriven {
	Fdobject fd = new Fdobject();
	FileInputStream fin;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell principle,roi,period,frequency;
	DataFormatter df;

	@BeforeTest
	public void beforeTest() throws Exception {

		fd.openBrowser("chrome");
		fd.exportPageFactory();

		fin = new FileInputStream(fd.projectPath + "\\testdata\\FDCal.xlsx");
		wb = new XSSFWorkbook(fin);
		sheet = wb.getSheet("Sheet1");
		df=new DataFormatter();

	}

	@Test(priority = 0, description = "Test cases to verify fixed depoist amount")
	public void fdAmount1() throws Exception {

		fd.openBaseUrl();
		
		int rowCount=sheet.getLastRowNum();

		for(int i=1;i<=rowCount;i++) {
			
		row=sheet.getRow(i); // i-> rows		
		int j=0; // j -> cells
		
		
		principle=row.getCell(j);
		String principalValue=df.formatCellValue(principle);
		
		roi=row.getCell(j+1);
		String roiValue=df.formatCellValue(roi);
		
		period=row.getCell(j+2);
		String periodValue=df.formatCellValue(period);
		
		frequency=row.getCell(j+3);
		String frequencyValue=df.formatCellValue(frequency);

		
		fd.typeValue(fd.txtPrincipal, principalValue);
		fd.typeValue(fd.txtInterest, roiValue);
		fd.typeValue(fd.txtTenure, periodValue);
		fd.handledropDown(fd.dropDowntenurePeriod, "year(s)");
		fd.handledropDown(fd.dropDownfrequency, frequencyValue);
		fd.btnClick(fd.btnCalculate);
		fd.pause(2);
		String maturityValue = fd.returnText(fd.maturityValue);
		System.out.println("Maturity Value for "+principalValue+" : " + maturityValue);
		fd.pause(2);
		
		//use typecasting to convert Maturity value to integer or use contains to validate Maturity value
		//using Assert and contains
		
//		Assert.assertTrue(maturityValue.contains("2400"));
//		Assert.assertTrue(maturityValue.contains("5920"));
//		Assert.assertTrue(maturityValue.contains("8520"));
//		Assert.assertTrue(maturityValue.contains("9200"));
		
		}
	}

	@AfterTest
	public void afterTest() {

		 fd.closeBrowser();
	}

  
}
