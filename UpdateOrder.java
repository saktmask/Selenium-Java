package week7.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class UpdateOrder extends Base {

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

		Thread.sleep(5000);

		//b.pageLoadWait();

		b.waitForElementClickable(By.xpath("(//div[@class='sn-widget-list-title' and text()='Service Catalog'])[1]"));
		driver.findElementByXPath("(//div[@class='sn-widget-list-title' and text()='Service Catalog'])[1]").click();

		driver.findElementByXPath("//div[@class='sn-widget-list-title' and text()='My Requests']").click();
		
		driver.switchTo().frame(driver.findElementById("gsft_main"));
		
		String input="REQ0010005";
		WebElement elementSearch = driver.findElementByXPath("(//input[@class='form-control'])[1]");
		elementSearch.sendKeys(input);
		elementSearch.sendKeys(Keys.ENTER);

		Thread.sleep(3000);
		String request_Number = driver.findElementByXPath("//table[@id='task_table']//tr[1]//td[3]/a").getText();
		
		if(request_Number.equals(input))
		{
			driver.findElementByXPath("//table[@id='task_table']//tr[1]//td[3]/a").click();
			
			//Approval
			Select approvalOption=new Select(driver.findElementById("sc_request.approval"));
			approvalOption.selectByVisibleText("Requested");
		
			//Request State
			Select reqStateOption=new Select(driver.findElementById("sc_request.request_state"));
			reqStateOption.selectByVisibleText("Approved");
			
			//Update Button
			driver.findElementById("sysverb_update").click();
			
			
			System.out.println("Approval: "+driver.findElementByXPath("//table[@id='task_table']//tr[1]//td[9]").getText());
			System.out.println("Sate: "+driver.findElementByXPath("//table[@id='task_table']//tr[1]//td[10]").getText());
		
			driver.close();
		}
		else
		{
			System.out.println("Request no not matched");
			driver.close();
		}

	}

}
