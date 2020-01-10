package week7.assignments;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class CreateProblem extends Base{

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

		String option1="Problem";
		String option2="Create New";
		String shortDesc="Welcome";
		b.waitForElementClickable(By.xpath("//span[text()='Change']"));
		
		List<WebElement> applicationList = driver.findElementsByXPath("//ul[@id='concourse_application_tree']//li//a//span");
		List<String> appListString=new ArrayList<>();
		for (WebElement ele : applicationList) {
			appListString.add(ele.getText());
		}
		
		for (String string : appListString) {
			if(string.equals(option1))
			{
				driver.findElementByXPath("//ul[@id='concourse_application_tree']//li//a//span[text()='"+string+"']").click();
				
				driver.findElementByXPath("//ul[@id='concourse_application_tree']//li//a//span[text()='"+string+"']/../..//div[text()='"+option2+"']").click();
				
				driver.switchTo().frame(driver.findElementById("gsft_main"));
				String pblmNum = driver.findElementById("problem.number").getAttribute("value");
				System.out.println(pblmNum);
				
				driver.findElementById("problem.short_description").sendKeys(shortDesc);
				driver.findElementById("sysverb_insert").click();
				
				WebElement searchPblm = driver.findElementByXPath("(//input[@class='form-control'])[1]");
				searchPblm.sendKeys(pblmNum);
				searchPblm.sendKeys(Keys.ENTER);
				
				String chPblm_Number = driver.findElementByXPath("//table[@id='problem_table']//tr[1]//td[3]").getText();
				if(pblmNum.equals(chPblm_Number))
				{
					System.out.println("Problem created successfully");
					driver.close();
				}
				else
				{
					System.out.println("Problem not created");
				}
			}
		}
		
		
		
	}

}
