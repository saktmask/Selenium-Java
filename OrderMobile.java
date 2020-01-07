package week7.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class OrderMobile extends Base {

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

		driver.switchTo().frame(driver.findElementById("gsft_main"));

		b.waitForVisibilityOfElement(By.xpath("(//td[@id='dropzone2']//div[@class=' drag_section_part glide-grid-block'])[4]"));

		b.waitForElementClickable(By.xpath("//img[@alt='Mobiles']"));
		driver.findElementByXPath("//img[@alt='Mobiles']").click();
		
		String model="Apple iPhone 6s";
		driver.findElementByXPath("//table//tr//td//a//strong[text()='"+model+"']").click();

		//driver.findElementById("sc_category_item").click();

		//Data allowed
		Select dataAllowOption=new Select(driver.findElementByXPath("(//select[@class='form-control cat_item_option '])[1]"));
		dataAllowOption.selectByValue("unlimited");
	
		//Color
		Select mobileColor=new Select(driver.findElementByXPath("(//select[@class='form-control cat_item_option '])[2]"));
		mobileColor.selectByVisibleText("Rose Gold");
	
		//Storage
		Select strogeAllowed=new Select(driver.findElementByXPath("(//select[@class='form-control cat_item_option '])[3]"));
		strogeAllowed.selectByValue("onetwentyeight");
		
		//Order now
		driver.findElementById("oi_order_now_button").click();
		
		//Get request number
		String reqNum = driver.findElementByXPath("//a[@id='requesturl']").getText();
		System.out.println(reqNum);
	}

}
