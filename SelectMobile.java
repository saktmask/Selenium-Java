package week7.assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SelectMobile extends Base {

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
		
		
		b.waitForElementClickable(By.xpath("//h2[text()[normalize-space()='Mobiles']]"));
		driver.findElementById("//h2[text()[normalize-space()='Mobiles']]").click();
		
		driver.findElementByXPath("//table//tr//td//a//strong[text()='Apple iPhone 6s']").click();
		/*List<WebElement> mobileList = driver.findElementsByXPath("//table//tr//td//a//strong");
		mobileList.size(); */
		driver.findElementById("sc_category_item").click();

	}

}
