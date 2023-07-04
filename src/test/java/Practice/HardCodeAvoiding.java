package Practice;

import java.awt.Desktop.Action;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hpsf.Property;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HardCodeAvoiding {
	public static void main(String[] args) throws Throwable {
		WebDriver driver=null;
		Random r=new Random();
		int rannum = r.nextInt(1000);
		//property file
		FileInputStream fisp=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		//create property class obj
		Properties p=new Properties();
		p.load(fisp);
		String BROWSER = p.getProperty("browser");
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		
		//excel fetching
		FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
		Sheet sh = wb.getSheet("Organization");
		//organization name
		String ORGNAME = sh.getRow(1).getCell(2).getStringCellValue();
	
		//navigate to industry type
		String INDUSTRYTYPE = sh.getRow(4).getCell(3).getStringCellValue();
		
		//launch the browser
	   /* WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get(URL); */
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("invalid browser name");
		}
		//launch url
		driver.get(URL);
		//mazimise window
		driver.manage().window().maximize();
		//wait
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		//login to aap
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		
		//click on organization
		driver.findElement(By.xpath("//a[.='Organizations']")).click();
		//click on + sign
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		//fill organization name
		driver.findElement(By.xpath("//input[@class='detailedViewTextBox']")).sendKeys(ORGNAME);
		//industry [click on clemical industry]
		WebElement ind = driver.findElement(By.xpath("//select[@name='industry']"));
		//create obj of select class
		Select s=new Select(ind);
		s.selectByValue(INDUSTRYTYPE);
		
		//save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
			//verification
		Thread.sleep(5000);
		String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(orgHeader.contains("wipro"))
		{
			System.out.println("ts is pass");
		}
		else
		{
			System.out.println("fail");
		}
		//logout
		WebElement adminimg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		//create action class
		Actions a=new Actions(driver);
		a.moveToElement(adminimg).perform();
		
		//navigate to sign out
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	}

}
