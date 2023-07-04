package Practice;

import java.awt.Desktop.Action;
import java.awt.event.ActionEvent;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.text.StringContent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrgWithIndustry {
	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		Random r=new Random();
		int rannum = r.nextInt(1000);
		//to open webpage
		driver.get("http://localhost:8888/");
		//to maximize webpage
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		//enter url
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		//enter the password
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		//click on login button
		driver.findElement(By.xpath("(//input[@value='Login'])[2]")).click();
		//we have to click on organization module
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		//click on org lookup image(+)
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		//write org name
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("wipro"+rannum);
		//now we need to handle industry dropdown(we have to choose chemical)
		WebElement indty = driver.findElement(By.xpath("//select[@name='industry']"));
		//create select class
		Select s=new Select(indty);
		s.selectByValue("Chemicals");
		//click on save button
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
		//logout from aap
		WebElement adminimg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		//create action class
		//we just move our courser to administrator icon we will not click on that that's why we r using action class
		Actions a=new Actions(driver);
		a.moveToElement(adminimg).perform();
		//navigate to sign out 
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	}

}
