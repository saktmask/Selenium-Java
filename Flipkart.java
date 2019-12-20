package week4.project;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Flipkart {

	public static void main(String[] args) throws InterruptedException {
		// Set the property for ChromeDriver
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver1");

		// Initiate the ChromeBroswer
		ChromeDriver driver=new ChromeDriver();

		//URL
		driver.get("https://www.flipkart.com/");

		// Maximize the browser
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElementByXPath("//button[contains(text(),'✕')]").click();
		//Thread.sleep(3000);
		//Actions class
		Actions a =new Actions(driver);
		WebElement electronics=driver.findElementByXPath("//span[text()='Electronics']");
		WebElement mi = driver.findElementByXPath("//li//a[@title='Mi' and @href='/mobiles/mi~brand/pr?sid=tyy,4io&otracker=nmenu_sub_Electronics_0_Mi']");
		Thread.sleep(2000);
		a.moveToElement(electronics).perform();;	
		Thread.sleep(3000);
		a.click(mi).perform();

		Thread.sleep(2000);

		System.out.println(driver.getTitle());

		//To select specific checkbox
		//driver.findElementByXPath("(//input[@class='_3uUUD5']/preceding::div[@class='_1p7h2j'])[2]").click();

		//Get number of pages
		List<WebElement> pagesList = driver.findElementsByXPath("//nav//a");
		System.out.println("No of Pages:");
		System.out.println(pagesList.size());


		List<String> lis=new ArrayList<>();

		for(int j=1;j<pagesList.size();j++) {
			Thread.sleep(2000);
			driver.findElementByXPath("(//nav//a[contains(@class,'_2Xp0TH')])["+(j)+"]").click();
			Thread.sleep(3000);

			//Get list of mobiles in current page
			List<WebElement> mobileElements = driver.findElementsByXPath("//div[@class='_1HmYoV _35HD7C'][2]//div[@class='_3wU53n']");
			if(mobileElements.size()!=0)
			{
				for(int i=0;i<mobileElements.size();i++)
				{
					lis.add(mobileElements.get(i).getText());
				}
			}
			else
			{
				//Close the browser if there are no elements in the current page
				driver.close();
				break;
			}
		}

		System.out.println("No of mobiles: "+lis.size());
		for (String string : lis) {
			System.out.println(string);
		}

	}

}
