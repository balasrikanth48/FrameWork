package com.uiFramework.companyName.projectName.helper.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;

public class ExcelHelper 
{
	private Logger log=LoggerHelper.getlogger(ExcelHelper.class);
	
	/**
	 * this method will get data from excel sheet
	 * @param excellocation
	 * @param sheetname
	 * @return 
	 */
	public Object[][] getExcelData(String excellocation ,String sheetname)
	{
		try {
			 Object datasets[][]=null;
			 FileInputStream fs=new FileInputStream(new File(excellocation));
			 //instance of workbook
			 XSSFWorkbook workbook=new XSSFWorkbook(fs);
			 //gets sheet name
			 XSSFSheet sheet=workbook.getSheet(sheetname);
			 //get the total active row 
			 int totalrow=sheet.getLastRowNum();
			 //count the active column in a row
			 int totalcolumn=sheet.getRow(0).getLastCellNum();
			 
			 datasets=new Object[totalrow+1][totalcolumn];
			 // iterate each row one by one
			 Iterator<Row> rowitarator = sheet.iterator();
			 int i=0;
			 while (rowitarator.hasNext()) {
				  i++;
				 //for every row, we need to iterator over column
				Row row = (Row) rowitarator.next();
				Iterator<Cell> celliterator = row.cellIterator();
				int j=0;
				while (celliterator.hasNext()) {
					j++;
					Cell cell = (Cell) celliterator.next();
					
					switch (cell.getCellTypeEnum()) {
					case STRING:
					datasets[i-1][j-1]=cell.getStringCellValue();
						break;
						
					case NUMERIC:
						datasets[i-1][j-1]=cell.getNumericCellValue();
						break;
					case BOOLEAN:
						datasets[i-1][j-1]=cell.getBooleanCellValue();
						break;
					case BLANK:
						break;
					case ERROR:
						break;
					case FORMULA:
						datasets[i-1][j-1]=cell.getCellFormula();
						break;
					case _NONE:
						break;
					default:
						System.out.println("No Matching enum data type Found");
						
						break;

					}
					
				}
				
			}
			 
		
			 return datasets; 
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return null;
		
		
	}
	public void updateResult(String excelLocation, String Sheetname,String testCaseName,String testStatus)
	{
		try {
			Object datasets[][]=null;
			 FileInputStream fs=new FileInputStream(new File(excelLocation));
			 //instance of workbook
			 XSSFWorkbook workbook=new XSSFWorkbook(fs);
			 //gets sheet name
			 XSSFSheet sheet=workbook.getSheet(Sheetname);
			 int totalRows=sheet.getLastRowNum()+1;
			 for (int i = 0; i <totalRows; i++) 
			 {
				 XSSFRow r=sheet.getRow(i);
				 String ce=r.getCell(0).getStringCellValue();
				 if (ce.contains(testCaseName)) 
				 {
					r.createCell(3).setCellValue(testStatus);
					fs.close();
					log.info("Result is updated");
					FileOutputStream fo=new FileOutputStream(new File(excelLocation));
					fo.close();
					break;
					
				}
				 
		     	}
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
	
	public static void main(String[] args) 
	{
		ExcelHelper ExcelHelper = new ExcelHelper();
		String exellocation=com.uiFramework.companyName.projectName.helper.resource.ResourceHelper.getResourcePath("\\src\\main\\Resource\\configfile\\Book1.xlsx");
//		Object[][] data = ExcelHelper.getExcelData(exellocation,"Data");
//		System.out.println("data is:"+data[0][0]);
		ExcelHelper.updateResult(exellocation, "Data", "Login", "Pass");
		ExcelHelper.updateResult(exellocation, "Data", "facebook", "Pass");
		
	}
	
	
}
