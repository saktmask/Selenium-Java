package week7.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class UpdateIncident extends Base{

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

		b.waitForElementClickable(By.xpath("(//div[@class='sn-widget-list-title' and text()='All'])[1]"));

		driver.findElementByXPath("(//div[@class='sn-widget-list-title' and text()='All'])[1]").click();

		driver.switchTo().frame(driver.findElementById("gsft_main"));
		String input="INC0010042";
		WebElement elementSearch = driver.findElementByXPath("(//input[@class='form-control'])[1]");
		elementSearch.sendKeys(input);
		elementSearch.sendKeys(Keys.ENTER);

		String incident_Number = driver.findElementByXPath("//table[@id='incident_table']//tr[1]//td[3]").getText();
		if(incident_Number.equals(input))
		{
			driver.findElementByXPath("//table[@id='incident_table']//tr[1]//td[3]").click();

			Select s=new Select(driver.findElementById("incident.state"));
			s.selectByVisibleText("In Progress");
			System.out.println("State:");
			System.out.println(s.getFirstSelectedOption().getText());

			Select s1=new Select(driver.findElementById("incident.urgency"));
			s1.selectByValue("1");
			System.out.println("Urgency:");
			System.out.println(s1.getFirstSelectedOption().getText());

			driver.findElementById("sysverb_update").click();

		}
		else
		{
			System.out.println("Selected different Incident");
		}
		System.out.println(driver.findElementByXPath("//table[@id='incident_table']//tr[1]//td[7]").getText());
		System.out.println(driver.findElementByXPath("//table[@id='incident_table']//tr[1]//td[8]").getText());

	}

}
