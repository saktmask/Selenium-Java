package week4.day2.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver.WindowType;

public class Amazon {

	public static void main(String[] args) throws InterruptedException {
		
		// Set the property for ChromeDriver
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver1.exe");
		
		// Initiate the ChromeBroswer
		ChromeDriver driver=new ChromeDriver();
		
		// Maximize the browser
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//URL
		driver.get("https://www.amazon.in/");
		Thread.sleep(2000);
		
		driver.findElementById("twotabsearchtextbox").sendKeys("oneplus 7 pro mobiles");
		driver.findElementByXPath("(//input[@class='nav-input'])[1]").click();
		System.out.println(driver.findElementByClassName("a-price-whole").getText());
		
		//Click on first mobile image
		driver.findElementByXPath("//span/a/div/img[1]").click();

		//Move to new window
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> listHandle=new ArrayList<>(windowHandles);
		String str=listHandle.get(1);
		driver.switchTo().window(str);
		String review=driver.findElementById("acrCustomerReviewText").getText();
		System.out.println(review);
	
		driver.findElementById("add-to-cart-button").click();
		String msg=driver.findElementByXPath("//h1[contains(@class,'a-size-medium a-text-bold')]").getText();
		System.out.println(msg);
		
		if(msg.contains("Added to Cart"))
		{
		driver.findElementByXPath("//span//a[contains(@id,'hlb-ptc-btn-native')][1]").click();
		String title=driver.getTitle();
		System.out.println(title);
		driver.findElementByXPath("//input[@id='continue']").click();
		String alertMsg=driver.findElementByXPath("(//div[@class='a-alert-content'])[2]").getText();
		System.out.println(alertMsg);
		driver.quit();
		}
		else
		{
			System.out.println("Item already exists in cart");
			driver.quit();
		}
	}

}
