package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import genericUtilites.ExcelFileUtility;
import genericUtilites.PropertyFileUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample1 {
	public static void main(String[] args) throws Throwable {
		WebDriver driver=null;
		PropertyFileUtility p=new PropertyFileUtility();
		String BROWSER = p.ReadDataFromProprtyFile("browser");
		String URL = p.ReadDataFromProprtyFile("url");
		String UN = p.ReadDataFromProprtyFile("username");
		String PWD = p.ReadDataFromProprtyFile("password");
		//System.out.println(PWD);
		//runtime polymorphism
		if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		 else if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		 else if(BROWSER.equalsIgnoreCase("edge"))
		 {
			 WebDriverManager.edgedriver().setup();
			 driver=new EdgeDriver();
		 }
		 else {
			 System.out.println("output is invalid");
		 }
		driver.get(URL);
		//excel fetching
		ExcelFileUtility e=new ExcelFileUtility();
		String admintb = e.ReadDataFromExcel("Sheet1", 1, 1);
		driver.findElement(By.id("username")).sendKeys(admintb);
	}

}
