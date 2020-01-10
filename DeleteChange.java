package week7.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class DeleteChange extends Base{

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
		
		if(attributeValue.equals("app-node sn-aside-group-ti"
				+ "tle sn-aside-group-title_selectable"
				+ " sn-aside-group-title_nav sn-aside-"
				+ "group-title_hidden nav-application-overwrite"))
		{
		driver.findElementByXPath("//span[text()='Change']").click();
		}
		
		b.waitForElementClickable(By.xpath("(//div[text()='All'])[3]"));
		driver.findElementByXPath("(//div[text()='All'])[3]").click();

		
		driver.switchTo().frame(driver.findElementById("gsft_main"));
		
		WebElement stateTextBox = b.FindElementByXpath("(//input[@placeholder='Search' and @aria-label='Search column: state'])[1]");
		stateTextBox.sendKeys("New");
		Thread.sleep(2000);
		stateTextBox.sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);
		
		WebElement chReqNum = driver.findElementByXPath("//table[@id='change_request_table']//tr[1]//td[3]/a");
		String text_ReqNum = chReqNum.getText();
		System.out.println(text_ReqNum);
		
		WebElement searchReq = driver.findElementByXPath("(//input[@class='form-control'])[1]");
		searchReq.sendKeys(text_ReqNum);
		searchReq.sendKeys(Keys.ENTER);
		
		driver.findElementByXPath("//table[@id='change_request_table']//tr[1]//td[3]").click();
		
		//b.waitForVisibilityOfElement(By.id("change_request.number"));
	/*	String current_chReqNum = b.FindElementById("change_request.number").getAttribute("value");
		System.out.println(chReqNum);
		System.out.println(current_chReqNum);
		
		if(chReqNum.equals(current_chReqNum))
		{*/
			b.FindElementById("sysverb_delete").click();
			
			//b.waitForVisibilityOfElement(By.className("modal-body container-fluid"));
			b.FindElementById("ok_button").click();
		/*}
		else
		{
			System.out.println("Not equal request number");
		}*/
		
	}

}
