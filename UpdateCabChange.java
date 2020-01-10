package week7.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class UpdateCabChange extends Base{

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
		//System.out.println(attributeValue);
		if(attributeValue.contains("app-node sn-aside-group-ti"
				+ "tle sn-aside-group-title_selectable"
				+ " sn-aside-group-title_nav sn-aside-"
				+ "group-title_hidden nav-application-overwrite"))
		{
		driver.findElementByXPath("//span[text()='Change']").click();
		}
		b.waitForElementClickable(By.xpath("(//div[text()='All'])[3]"));
		driver.findElementByXPath("(//div[text()='All'])[3]").click();
		
		driver.switchTo().frame(driver.findElementById("gsft_main"));
				
		String chReqNum="CHG0030012";
		WebElement searchReq = driver.findElementByXPath("(//input[@class='form-control'])[1]");
		searchReq.sendKeys(chReqNum);
		searchReq.sendKeys(Keys.ENTER);
		
		String chReq_Number = driver.findElementByXPath("//table[@id='change_request_table']//tr[1]//td[3]").getText();
		if(chReqNum.equals(chReq_Number))
		{
			driver.findElementByXPath("//table[@id='change_request_table']//tr[1]//td[3]").click();
			
			driver.findElementByXPath("//span[@class='tab_caption_text' and text()='Schedule']").click();
			
			b.waitForVisibilityOfElement(By.xpath("(//button[@id='change_request.start_date.ui_policy_sensitive'])[2]"));
			driver.findElementByXPath("(//button[@id='change_request.start_date.ui_policy_sensitive'])[2]").click();
			
			b.waitForVisibilityOfElement(By.xpath("//table[@class='calTable']//td[@class='calText calCurrentDate']/a"));
			driver.findElementByXPath("//table[@class='calTable']//td[@class='calText calCurrentDate']/a").click();
			driver.findElementById("GwtDateTimePicker_ok").click();
			
			b.waitForVisibilityOfElement(By.xpath("(//button[@id='change_request.end_date.ui_policy_sensitive'])[2]"));
			driver.findElementByXPath("(//button[@id='change_request.end_date.ui_policy_sensitive'])[2]").click();
			String endDate="16";
			
			b.waitForVisibilityOfElement(By.xpath("//table[@class='calTable']//td//a[text()='"+endDate+"']"));
			driver.findElementByXPath("//table[@class='calTable']//td//a[text()='"+endDate+"']").click();
			driver.findElementById("GwtDateTimePicker_ok").click();
			
			WebElement cabCheckBox = driver.findElementByXPath("//input[@name='change_request.cab_required']");
			String text=cabCheckBox.getAttribute("value").toString();
			if(!cabCheckBox.isSelected())
			{
				driver.findElementById("label.ni.change_request.cab_required").click();
				
				driver.findElementById("change_request.cab_date.ui_policy_sensitive").click();
				b.FindElementByXpath("//table[@class='calTable']//td//a[text()='"+endDate+"']").click();		
				driver.findElementById("sysverb_update").click();
				
				
				System.out.println("State: "+driver.findElementByXPath("//table[@id='change_request_table']//tr[1]//td[6]").getText());
				System.out.println("Start date: "+driver.findElementByXPath("//table[@id='change_request_table']//tr[1]//td[7]").getText());
				System.out.println("End date: "+driver.findElementByXPath("//table[@id='change_request_table']//tr[1]//td[8]").getText());
				driver.close();
			}
			
			
		}
		else
		{
			System.out.println("Incorrect change selected");
		}

	}

}
