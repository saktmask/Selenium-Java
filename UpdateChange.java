package week7.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class UpdateChange extends Base{

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
			Select s=new Select(driver.findElementById("change_request.state"));
			s.selectByVisibleText("Assess");
			String selOption=s.getFirstSelectedOption().getText();
			//System.out.println(selOption);
			/*WebElement chgAsgmtGroup = driver.findElementById("sys_display.change_request.assignment_group");
			chgAsgmtGroup.sendKeys(Keys.CLEAR);
			Thread.sleep(3000);
			chgAsgmtGroup.sendKeys("Software");
			Thread.sleep(3000);
			chgAsgmtGroup.sendKeys(Keys.ENTER);*/
			
			if(selOption.equals("Assess"))
			{
				driver.findElementById("sysverb_update").click();
			}
			else
			{
				System.out.println("Incorrect state selected");
			}
			
			System.out.println("State: "+driver.findElementByXPath("//table[@id='change_request_table']//tr[1]//td[6]").getText());
			driver.close();
		}
		else
		{
			System.out.println("Incorrect change selected");
		}

	}

}
