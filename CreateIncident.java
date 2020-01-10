package week7.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class CreateIncident extends Base {

	public static void main(String[] args) throws InterruptedException {
		Base b=new Base();
		String url="https://dev69210.service-now.com/";
		b.launchBrowser(url);
		String title = driver.getTitle();
		System.out.println(title);

		driver.switchTo().frame(0);

		logger.info("Entering username");
		driver.findElementById("user_name").sendKeys("admin");
		
		logger.info("Entering password");
		driver.findElementById("user_password").sendKeys("India@1234");
		
		logger.info("Clicking Login button");
		driver.findElementById("sysverb_login").click();

		Thread.sleep(3000);

		driver.findElementByXPath("(//div[text()='Incidents'])[1]").click();

		driver.switchTo().frame(driver.findElementById("gsft_main"));

		b.waitForElementClickable(By.id("sysverb_new"));
		driver.findElementById("sysverb_new").click();

		String title2 = driver.getTitle();
		System.out.println(title2);

		b.waitForElementClickable(By.id("incident.number"));
		String src_IncidentNumber = driver.findElementById("incident.number").getAttribute("value");
		System.out.println(src_IncidentNumber);
			
		driver.findElementById("incident.short_description").sendKeys("Test Description");

		driver.findElementById("sysverb_insert").click();

		Thread.sleep(3000);

		WebElement elementSearch = driver.findElementByXPath("(//input[@class='form-control'])[1]");
		elementSearch.sendKeys(src_IncidentNumber);
		elementSearch.sendKeys(Keys.ENTER);

		String incident_Number = driver.findElementByXPath("//table[@id='incident_table']//tr[1]//td[3]").getText();

		if(src_IncidentNumber.equals(incident_Number))
		{
			System.out.println("Created successfully");
			driver.close();

		}
		else
		{
			System.out.println("Not created");
		}

	}

}
