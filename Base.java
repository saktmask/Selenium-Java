package week7.assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
	public static ChromeDriver driver;

	public void launchBrowser(String url)
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver1");
		driver = new ChromeDriver();
		//Loading a url
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);

	}
	
	public void waitForVisibilityOfElement(By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void waitForElementClickable(By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(locator));	
	}
	
	public void pageLoadWait()
	{
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.MILLISECONDS);
	}

}
