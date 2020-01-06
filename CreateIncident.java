package week7.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateIncident extends Base {

	public static void main(String[] args) throws InterruptedException {
		Base b=new Base();
		String url="https://dev69210.service-now.com/";
		b.launchBrowser(url);
		String title = driver.getTitle();
		System.out.println(title);

		driver.switchTo().frame(0);

		driver.findElementById("user_name").sendKeys("admin");
		driver.findElementById("user_password").sendKeys("India@1234");
		driver.findElementById("sysverb_login").click();

		Thread.sleep(3000);

		driver.findElementByXPath("(//span[text()='Incident'])[1]").click();
		driver.findElementByXPath("(//div[@class='sn-widget-list-title' and text()='Create New'])[1]").click();
		String title2 = driver.getTitle();
		System.out.println(title2);

		driver.switchTo().frame(driver.findElementById("gsft_main"));

		b.waitForElementClickable(By.id("sys_display.incident.caller_id"));

		String src_IncidentNumber = driver.findElementById("incident.number").getText();

		WebElement element_CallerId = driver.findElementById("sys_display.incident.caller_id");
		element_CallerId.sendKeys("System Administrator");
		Thread.sleep(2000);
		element_CallerId.sendKeys(Keys.TAB);

		driver.findElementById("incident.short_description").sendKeys("Test Description");

		driver.findElementById("sysverb_insert").click();

		String incident_Number = driver.findElementByXPath("//table[@id='incident_table']//tr[1]//td[3]").getText();
		System.out.println(incident_Number);

		if(src_IncidentNumber.equals(incident_Number))
		{
			System.out.println("Created successfully");
		}
		else
		{
			System.out.println("Not created");
		}


	}

}
