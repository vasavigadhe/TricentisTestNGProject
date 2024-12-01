package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class DeskTopExcelUtils {
	String productName = null; String Processor;
	public String AddProduct(String filePath, String sheetName) throws IOException {
	File f = new File(filePath);
	FileInputStream fis = new FileInputStream(f);
	XSSFWorkbook wb = new XSSFWorkbook(fis);
	Sheet sheet = wb.getSheet(sheetName);
	
	Row headerRow = sheet.getRow(0); //assume that header is in first row
	int ColomnIndex = -1;
	
	for(Cell cell: headerRow) {
		if(cell.getStringCellValue().equalsIgnoreCase("Product")) {
			ColomnIndex = cell.getColumnIndex();
			break;
		}
	}
	
	Row productRow = sheet.getRow(1);
	if(productRow!= null) {
		Cell ProductCell = productRow.getCell(ColomnIndex);
		if(ProductCell != null) {
			productName = ProductCell.getStringCellValue();
			
		}
	}
	wb.close();
	
	return productName;
	
	}
	
	public String AddProcessor(String filePath, String sheetName) throws IOException {
		File f = new File(filePath);
		FileInputStream fi = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		Sheet sheet = wb.getSheet(sheetName);
		
		Row row = sheet.getRow(0);
		int Proindex = -1;
		
		for(Cell cell: row) {
			if(cell.getStringCellValue().equalsIgnoreCase("Processor")) {
				Proindex = cell.getColumnIndex();
			}
		}
		
		Row proRow = sheet.getRow(1);
		if(proRow != null) {
			Cell ProCell = proRow.getCell(Proindex);
			if(ProCell != null) {
				Processor = ProCell.getStringCellValue();
			}
		}
		wb.close();
		
		return Processor;
		
	}
}
