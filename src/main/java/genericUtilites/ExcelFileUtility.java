package genericUtilites;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
	public String ReadDataFromExcel(String SheetName, int rowNo, int cellNo) throws Throwable {
		FileInputStream fise=new FileInputStream(IconstantUtility.xlpath);
		Workbook wb = WorkbookFactory.create(fise);
		Sheet sh = wb.getSheet(SheetName);
	    Row rw = sh.getRow(rowNo);
	    Cell ce = rw.getCell(cellNo);
	   return ce.getStringCellValue();
	}

}
