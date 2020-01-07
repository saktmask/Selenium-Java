package week7.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class CreateIncidentNegative extends Base {

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

		System.out.println(src_IncidentNumber);
		Select s=new Select(driver.findElementById("incident.state"));
		s.selectByVisibleText("In Progress");

		Select s1=new Select(driver.findElementById("incident.urgency"));
		s1.selectByValue("1");

		driver.findElementById("sysverb_insert").click();

		
		boolean displayed=driver.
				findElementByXPath("(//div[@role='alert' "
						+ "and @class='outputmsg outputmsg_error notification notification-error'])").isDisplayed();
		if(displayed)
		{
			String text = driver.
					findElementByXPath("(//div[@role='alert' "
							+ "and @class='outputmsg outputmsg_error notification notification-error'])").getText();
			System.out.println(text);
			driver.close();
		}

	}

}
