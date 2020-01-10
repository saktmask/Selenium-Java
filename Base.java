package week7.assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base extends LearnLogger {
	public static ChromeDriver driver;

	public void launchBrowser(String url)
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver1");
		logger.info("Setting system property");
		driver = new ChromeDriver();
		
		//Loading a url
		driver.get(url);
		logger.info("Entering URL");
		driver.manage().window().maximize();
		logger.info("Maximising window");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);

	}
	
	public void waitForVisibilityOfElement(By locator)
	{
		logger.debug("Waiting for visibility of element");
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void waitForElementClickable(By locator)
	{
		logger.debug("Waiting for element to be clickable");
		WebDriverWait wait = new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(locator));	
	}
	
	public void waitForElementClickable(WebElement ele)
	{
		logger.debug("Waiting for element to be clickable");
		WebDriverWait wait = new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(ele));	
	}
	
	public WebElement FindElementByXpath(String xpath)
	{
		waitForElementClickable(By.xpath(xpath));
		return driver.findElementByXPath(xpath);
	}
	
	public WebElement FindElementById(String id)
	{
		waitForElementClickable(By.id(id));
		return driver.findElementById(id);
	}
	
	public void pageLoadWait()
	{
		logger.debug("Waiting for page gets loaded");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.MILLISECONDS);
	}

}
