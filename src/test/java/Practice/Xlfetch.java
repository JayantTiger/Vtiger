package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import genericUtilites.ExcelFileUtility;
import genericUtilites.IconstantUtility;
import genericUtilities.Iconstant;

public class Xlfetch {
	public static void main(String[] args) throws Throwable {
	/*	//open file in java readable format
		FileInputStream fise=new FileInputStream(IconstantUtility.xlpath);
		//create workbook factor
		Workbook wb = WorkbookFactory.create(fise);
		//get the sheet
		Sheet sh = wb.getSheet("Sheet1");
		//get the control of row
		Row rw = sh.getRow(0);
		//get the cell
		Cell ce = rw.getCell(0);
		//fetch the data
		String data = ce.getStringCellValue();
		System.out.println(data);    */
		ExcelFileUtility excel=new ExcelFileUtility();
		 String data = excel.ReadDataFromExcel("Sheet1", 0, 0);
		 System.out.println(data);
		
	}

}
