package week7.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateIncident extends Base {

	public static void main(String[] args) {
		String url="https://dev69210.service-now.com/";
		new Base().launchBrowser(url);
		String title = driver.getTitle();
		System.out.println(title);
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_name")));
		
		driver.findElementById("user_name").sendKeys("admin");
		driver.findElementById("user_password").sendKeys("India@1234");
		driver.findElementById("sysverb_login").click();
		
		WebDriverWait wait1 = new WebDriverWait(driver,10);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Incident'])[1]")));
		
		driver.findElementByXPath("(//span[text()='Incident'])[1]").click();
		driver.findElementByXPath("(//div[@class='sn-widget-list-title' and text()='Create New'])[1]").click();
	}

}
