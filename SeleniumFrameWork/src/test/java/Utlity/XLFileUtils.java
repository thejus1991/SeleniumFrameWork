package Utlity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLFileUtils {
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;
	XSSFRow row;
	CellStyle style;
	String ProjectPath = System.getProperty("user.dir");
	String path =null;
	FileInputStream Finput;
	FileOutputStream Foutput;
	
	public XLFileUtils (String path)
	{
		this.path =path ;
	}
	
	public int getRowCount(String sheetname) throws IOException
	{
	Finput = new FileInputStream(path);
	workbook = new XSSFWorkbook(Finput);
	sheet= workbook.getSheet(sheetname);
	int rowCount = sheet.getLastRowNum();
	workbook.close();
	Finput.close();
	return rowCount;
	}
	public int getCellCount(String sheetname , int rowNum) throws IOException
	{
	Finput = new FileInputStream(path);
	workbook = new XSSFWorkbook(Finput);
	sheet= workbook.getSheet(sheetname);
	row = sheet.getRow(rowNum);
	int cellCount = row.getLastCellNum();
	workbook.close();
	Finput.close();
	return cellCount;
	
	}
	public String getCellData(String sheetname ,int rowNum , int colNum) throws IOException
	{
		Finput = new FileInputStream(path);
		workbook = new XSSFWorkbook(Finput);
		sheet= workbook.getSheet(sheetname);
		row = sheet.getRow(rowNum);
		cell = row.getCell(colNum);
		DataFormatter Formatter = new DataFormatter();
		String data;
		try
		{
		data= Formatter.formatCellValue(cell);
		}
		catch(Exception e)
		{
			data="";
		}
		workbook.close();
		Finput.close();
		return data;
		
	}
	public void setCellData(String sheetname ,int rowNum , int colNum ,String data) throws IOException
	{
		Finput = new FileInputStream(path);
		workbook = new XSSFWorkbook(Finput);
		sheet= workbook.getSheet(sheetname);
		row = sheet.getRow(rowNum);
		cell = row.createCell(colNum);
		cell.setCellValue(data);
		Foutput = new FileOutputStream(path);
		workbook.write(Foutput);
		workbook.close();
		Finput.close();
		Foutput.close();
		
	}
	
}
