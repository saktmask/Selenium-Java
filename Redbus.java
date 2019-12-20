package week4.project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Redbus {

	public static void main(String[] args) throws InterruptedException {
		// Set the property for ChromeDriver
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver1");

		// Initiate the ChromeBroswer
		ChromeDriver driver=new ChromeDriver();

		//URL
		driver.get("https://www.redbus.in/");

		// Maximize the browser
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(3000);
		
		WebElement srcElement = driver.findElementById("src");
		srcElement.sendKeys("Salem (All Locations)",Keys.ENTER);
		Thread.sleep(3000);
		
		WebElement destElement = driver.findElementById("dest");
		destElement.sendKeys("Chennai (All Locations)",Keys.ENTER);
		Thread.sleep(3000);
		
		driver.findElementByXPath("//div[@class='fl search-box date-box gtm-onwardCalendar']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//div[@id='rb-calendar_onward_cal']//table//*//td[@class='current day']").click();
		Thread.sleep(2000);
			
		//driver.findElementByXPath("//div[@class='fl search-box date-box gtm-returnCalendar']").click();
		//Thread.sleep(3000);
		//driver.findElementByXPath("//div[@id='rb-calendar_return_cal']//table//*//td[@class='current day']").click();
		Thread.sleep(3000);
		
		//driver.findElementByXPath("//div//button[@id='search_btn']").click();
		driver.findElementById("search_btn").click();
		
		driver.findElementByXPath("//ul//li//label[contains(@for,'dtAfter 6 pm')][1]").click();

	}

}
