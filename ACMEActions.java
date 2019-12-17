package week4.day2.project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ACMEActions {

	public static void main(String[] args) throws InterruptedException {
				// Set the property for ChromeDriver
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver1.exe");
				
				// Initiate the ChromeBroswer
				ChromeDriver driver=new ChromeDriver();
				
				// Maximize the browser
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				//URL
				driver.get("https://acme-test.uipath.com/");
				Thread.sleep(2000);
				
				driver.findElementById("email").sendKeys("kumar.testleaf@gmail.com");
				driver.findElementById("password").sendKeys("leaf@12");
				
				driver.findElementById("buttonLogin").click();
				
				WebElement vendorButton = driver.findElementByXPath("(//div//button[contains(@class,'btn-default btn-lg')])[5]");
				Actions act= new Actions(driver);
				act.click(vendorButton);
				act.build().perform();
				WebElement searchVendor = driver.findElementByXPath("//ul//li//a[contains(@href,'/vendors/search')]");
				act.moveToElement(searchVendor).click().perform();
				
				driver.findElementById("vendorName").sendKeys("Blue Lagoon");
				driver.findElementById("buttonSearch").click();
				String text = driver.findElementByXPath("//table//tbody//tr[2]//td[5]").getText();
				System.out.println("Country Name: "+text);
				
				driver.findElementByXPath("//li//a[contains(@href,'/account/logout/')]").click();
				
				driver.quit();

	}

}
