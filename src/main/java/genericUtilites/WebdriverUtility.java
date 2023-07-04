package genericUtilites;

import java.io.File;
import java.nio.file.Files;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebdriverUtility {
	/**
	 * this is used to maximize the browser
	 * @author Anshu
	 * @param driver
	 */
	public void maximizeBrowser(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * this id used to minimize the browser
	 * @author Anshu
	 * @param driver
	 */
	public void minimizeBrowser(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	/**
	 * this method is used to wait the selenium load entire elements on webpage
	 * @author Anshu
	 * @param driver
	 */
	public void waitTillPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	/**
	 * this method is used to handle list box whose tag is select
	 * @author Anshu
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement  element, int index)
	{
		Select s=new Select(element);
	   s.selectByIndex(index);
	   
	}
	/**
	* this method is used to handle list box
	 * @author Anshu
	 * @param element
	 * @param value
	 */
	public void handleDropDown(WebElement element, String value)//here element first then string
	{
		Select s=new Select(element);
		s.selectByValue(value);
	}
	/**
	 *  this method is used to handle list box
	 * @author Anshu
	 * @param visible
	 * @param element
	 */
	public void handleDropDown(String visible, WebElement element) //here string first then element
	{
		Select s=new Select(element);
		s.selectByVisibleText(visible);
	}
	/**
	 * this method is used to move the courser to particular elements
	 * @author Anshu
	 * @param driver
	 * @param element
	 */
	public void mouseOverAction(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * this method is used to right click on webpage
	 * @author Anshu
	 * @param driver
	 */
	public void rightClickAction(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.contextClick().perform();
	}
	/**
	 * this method is used to right click on particular element
	 * @author Anshu
	 * @param driver
	 * @param element
	 */
    public void rightClickOnParticularElement( WebDriver driver, WebElement element)
    {
    	Actions act=new Actions(driver);
    	act.contextClick(element).perform();
    }
    /**
     * this method is used to double click purpose
     * @author Anshu
     * @param driver
     */
    public void doubleClickAction(WebDriver driver)
    {
    	Actions act=new Actions(driver);
    	act.doubleClick().perform();
    }
    /**
     * this method is useful to double click on particular element
     * @author Anshu
     * @param driver
     * @param element
     */
    public void doubleClickAction(WebDriver driver, WebElement element)
    {
    	Actions act=new Actions(driver);
    	act.doubleClick(element).perform();
    }
    /**
     * this method is used to drag & drop the element
     * @author Anshu
     * @param driver
     * @param srcelement
     * @param targetelement
     */
    public void dragAndDrop(WebDriver driver, WebElement srcelement, WebElement targetelement)
    {
    	Actions act=new Actions(driver);
    	act.dragAndDrop(srcelement, targetelement).perform();
    }
    /**
     * this method is used to drag & drop purpose
     * @author Anshu
     * @param driver
     * @param src
     * @param x
     * @param y
     */
    public void dragAndDrop(WebDriver driver, WebElement src, int x, int y)
    {
    	Actions act=new Actions(driver);
    	act.dragAndDropBy(src, x, y).perform();
    }
    /**
     * this method is used to handle the iframe
     * @author Anshu
     * @param driver
     * @param index
     */
    public void switchToFram(WebDriver driver, int index) {
    	driver.switchTo().frame(index);
    }
    /**
     * this method is used to handle the iframe
     * @author Anshu
     * @param driver
     * @param index
     */
    public void switchToFram(WebDriver driver, String nameOrld)
    {
    	driver.switchTo().frame(nameOrld);
    }
    /**
     * this method is used to handle the iframe
     * @author Anshu
     * @param driver
     * @param index
     */
    public void switchToFram(WebDriver driver, WebElement element)
    {
    	driver.switchTo().frame(element);    
    	}
    /**
     * this method is used to handle the iframe
     * @author Anshu
     * @param driver
     * @param index
     */
    public void switchToParentFram(WebDriver driver)
    {
    	driver.switchTo().parentFrame();
    }
    /**
     * this method is used to handle the iframe
     * @author Anshu
     * @param driver 
     * @param driver
     * @param index
     */
    public void switchToDefaultFram(WebDriver driver)
    {
    	driver.switchTo().parentFrame();
    }
    /**
     * This method is used to handle the Alert popup
     * @author Ankush
     * @param driver
     */
    public void acceptAlert(WebDriver driver) {
    	driver.switchTo().alert().accept();
    }
    /**
     * This method is used to handle the alert popup
     * @author Ankush
     * @param driver
     */
    public void dismissAlert(WebDriver driver) {
    	driver.switchTo().alert().dismiss();;
    }
    /**
     * This method is used to handle the alert popup
     * @author Ankush
     * @param driver
     * @return
     */
    public String getAlertText(WebDriver driver) {
    	return driver.switchTo().alert().getText();
    }
    /**
     * This method is used to take the scrrenshot
     * @author Ankush
     * @param driver
     * @param screenshoName 
     * @param screenshoName
     * @return 
     * @return
     * @throws Throwable
     */
   public String takesScreenshot(WebDriver driver, String screenshoName)throws Throwable
   {
	   TakesScreenshot ts= (TakesScreenshot).driver;
	   File src = ts.getScreenshotAs(OutputType.FILE);
	   File dest=new File(".\\Screenshots"+screenshoName +".png");
		Files.copy(src, dest);
		return dest.getAbsolutePath();//It is useful for Extent reoprt
   }
   /**
    * This method is used to handle the windows
    * @author Ankush
    * @param driver
    * @param partialWindowTitle
    */
   public void switchToWindow(WebDriver driver, String partialWindowTitle) {
   	Set<String> winIds = driver.getWindowHandles();
   	for(String winId:winIds) {
   		String actT = driver.switchTo().window(winId).getTitle();
   		if(actT.contains(partialWindowTitle)) {
   			break;
   		}
   	}
}}
