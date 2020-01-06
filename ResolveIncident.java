package week7.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ResolveIncident extends Base{

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
		
		String title1 = driver.getTitle();
		System.out.println(title1);

		Thread.sleep(3000);

		driver.findElementByXPath("(//div[@class='sn-widget-list-title' and text()='Incidents'])[1]").click();

		driver.switchTo().frame(driver.findElementById("gsft_main"));
		b.waitForElementClickable(By.xpath("(//input[@class='form-control'])[1]"));

		String input="INC0010042";
		WebElement elementSearch = driver.findElementByXPath("(//input[@class='form-control'])[1]");
		elementSearch.sendKeys(input);
		elementSearch.sendKeys(Keys.ENTER);

		String incident_Number = driver.findElementByXPath("//table[@id='incident_table']//tr[1]//td[3]").getText();
		if(incident_Number.equals(input))
		{
			driver.findElementByXPath("//table[@id='incident_table']//tr[1]//td[3]").click();

			Thread.sleep(3000);
			Select s=new Select(driver.findElementById("incident.state"));
			s.selectByVisibleText("Resolved");
			System.out.println("State:");
			System.out.println(s.getFirstSelectedOption().getText());

			driver.findElementByXPath("//span[@class='tab_caption_text' and text()='Resolution Information']").click();
			driver.findElementById("incident.close_notes").sendKeys("Resolving the incident");
			
			driver.findElementById("sysverb_update").click();

		}
		else
		{
			System.out.println("Selected different Incident");
		}

		System.out.println("State: "+driver.findElementByXPath("//table[@id='incident_table']//tr[1]//td[8]").getText());
	}

}
