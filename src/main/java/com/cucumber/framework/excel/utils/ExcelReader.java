package com.cucumber.framework.excel.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public Object readExcelCellValue(String fileName,String sheetname,int rowNumber,int columnNumber) throws IOException {
		FileInputStream fis=new FileInputStream(fileName);
		XSSFWorkbook wbook=new XSSFWorkbook(fis);
		XSSFSheet wsheet=wbook.getSheet(sheetname);
		XSSFRow row=wsheet.getRow(rowNumber);
		XSSFCell cell=row.getCell(columnNumber);
		CellType cellType=cell.getCellType();
		Object cellData=null;
		if(cellType.equals(CellType.NUMERIC)) {
			cellData=cell.getNumericCellValue();
		}else if(cellType.equals(CellType.STRING)) {
			cellData=cell.getStringCellValue();
		}
		wbook.close();
		return cellData;
	}
	public void writeExcelCellValue(String fileName,String sheetname,int rowNumber,int columnNumber,Object value) throws IOException {
		FileInputStream fis=new FileInputStream(fileName);
		XSSFWorkbook wbook=new XSSFWorkbook(fis);
		XSSFSheet wsheet=wbook.getSheet(sheetname);
		XSSFRow row;
		try {
			row=wsheet.getRow(rowNumber);
		}
		catch (Exception e) {
			row=wsheet.createRow(rowNumber);
		}
		XSSFCell cell;
		try {
			cell=row.getCell(columnNumber);
		}
		catch (Exception e) {
			cell=row.createCell(rowNumber);
		}
		cell.setCellValue(value.toString());
		FileOutputStream fos=new FileOutputStream(fileName);
		wbook.write(fos);
		wbook.close();
	}
	public Object[][] readExcelSheetData(String fileName,String sheetname) throws IOException {
		FileInputStream fis=new FileInputStream(fileName);
		XSSFWorkbook wbook=new XSSFWorkbook(fis);
		XSSFSheet wsheet=wbook.getSheet(sheetname);
		Iterator<Row> rowIterator=wsheet.rowIterator();
		int numberOfRows=wsheet.getLastRowNum();
		int numberOfColumns=wsheet.getRow(0).getLastCellNum();
		Object[][] excelData=new Object[numberOfRows][numberOfColumns];
		int rowNumber=0;
		while(rowIterator.hasNext()) {
			Row row=rowIterator.next();
			Iterator<Cell> cellIterator=row.cellIterator();
			int cellNumber=0;
			while(cellIterator.hasNext()) {
				Cell cell=cellIterator.next();
				CellType cellType=cell.getCellType();
				Object cellData=null;
				if(cellType.equals(CellType.NUMERIC)) {
					cellData=cell.getNumericCellValue();
				}else if(cellType.equals(CellType.STRING)) {
					cellData=cell.getStringCellValue();
				}
				excelData[rowNumber][cellNumber]=cellData;
				cellNumber++;
			}
			rowNumber++;
		}
		
		return excelData;
	}
	public Map<String,Object> readExcelRowData(String fileName,String sheetname,String scenarioName,int scenarioColumnNumber) throws IOException {
		FileInputStream fis=new FileInputStream(fileName);
		XSSFWorkbook wbook=new XSSFWorkbook(fis);
		XSSFSheet wsheet=wbook.getSheet(sheetname);
		Iterator<Row> rowIterator=wsheet.rowIterator();
		Map<String,Object> rowData=new HashMap<String,Object>();
		int rowNumber=0;
		while(rowIterator.hasNext()) {
			Row row=rowIterator.next();
			Cell cell1=row.getCell(scenarioColumnNumber);
			
			if(scenarioName.equals(cell1.getStringCellValue())) {
				Iterator<Cell> cellIterator=row.cellIterator();
				int cellNumber=0;
				while(cellIterator.hasNext()) {
					Cell cell=cellIterator.next();
					CellType cellType=cell.getCellType();
					Object cellData=null;
					if(cellType.equals(CellType.NUMERIC)) {
						cellData=cell.getNumericCellValue();
					}else if(cellType.equals(CellType.STRING)) {
						cellData=cell.getStringCellValue();
					}
					String columnHeader=wsheet.getRow(0).getCell(cellNumber).getStringCellValue();
					rowData.put(columnHeader, cellData);
					cellNumber++;
			}
			break;
		}
		}	
		return rowData;
	}

}
