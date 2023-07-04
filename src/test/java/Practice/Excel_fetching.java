package Practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_fetching {
	public static void main(String[] args) throws Throwable {
		//create obj of FIS
		FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		//create method frm workbook factory
	    Workbook wb = WorkbookFactory.create(fise);
	    //get sheet
	    Sheet sh = wb.getSheet("Organization"); 
	    //navigate to row
	    String ORGNAME = sh.getRow(4).getCell(1).getStringCellValue();
	    System.out.println(ORGNAME);
	}

}
