package week7.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class CreateChange extends Base{

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

		b.waitForElementClickable(By.xpath("//span[text()='Change']"));
		
		String attributeValue = driver.findElementByXPath("//span[text()='Change']/parent::a").getAttribute("class").toString();	
		if(attributeValue.contains("app-node sn-aside-group-ti"
				+ "tle sn-aside-group-title_selectable"
				+ " sn-aside-group-title_nav sn-aside-"
				+ "group-title_hidden nav-application-overwrite"))
		{
		driver.findElementByXPath("//span[text()='Change']").click();
		}
		b.waitForElementClickable(By.xpath("(//div[text()='Create New'])[3]"));
		driver.findElementByXPath("(//div[text()='Create New'])[3]").click();
		
		driver.switchTo().frame(driver.findElementById("gsft_main"));
		
		String chReqText="Normal: ";
		b.waitForElementClickable(By.xpath("//div//a[contains(text(),'"+chReqText+"')]"));	
		driver.findElementByXPath("//div//a[contains(text(),'"+chReqText+"')]").click();
		
		String chReqNum = driver.findElementById("change_request.number").getAttribute("value");
		System.out.println(chReqNum);
		
		driver.findElementById("sysverb_insert").click();
		
		WebElement searchReq = driver.findElementByXPath("(//input[@class='form-control'])[1]");
		searchReq.sendKeys(chReqNum);
		searchReq.sendKeys(Keys.ENTER);
		
		String chReq_Number = driver.findElementByXPath("//table[@id='change_request_table']//tr[1]//td[3]").getText();
		if(chReqNum.equals(chReq_Number))
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
