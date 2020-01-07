package week7.assignments;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class AssignIncident extends Base{

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
		
		driver.findElementByXPath("(//div[text()='Incidents'])[1]").click();

		driver.switchTo().frame(driver.findElementById("gsft_main"));

		String input="INC0010392";
		WebElement elementSearch = driver.findElementByXPath("(//input[@class='form-control'])[1]");
		elementSearch.sendKeys(input);
		elementSearch.sendKeys(Keys.ENTER);

		String incident_Number = driver.findElementByXPath("//table[@id='incident_table']//tr[1]//td[3]").getText();
		if(incident_Number.equals(input))
		{
			driver.findElementByXPath("//h2[@class='navbar-title list_title ' and text()='Incidents'] ").click();
			driver.findElementByXPath("//div[@role='menuitem' and text()='View']").click();
			driver.findElementByXPath("//div[@class='context_item' and text()='Default view']").click();
			
			driver.findElementByXPath("//table[@id='incident_table']//tr[1]//td[3]/a").click();	
			
			Thread.sleep(3000);
			
			WebElement elementAssignGroup = driver.findElementById("sys_display.incident.assignment_group");
			elementAssignGroup.sendKeys(Keys.CLEAR);
			Thread.sleep(1000);
			elementAssignGroup.sendKeys("Software");
			elementAssignGroup.sendKeys(Keys.TAB);

			WebElement elementAssignTo = driver.findElementById("sys_display.incident.assigned_to");
			elementAssignTo.sendKeys(Keys.CLEAR);
			Thread.sleep(1000);
			elementAssignTo.sendKeys("ITIL User");
			elementAssignTo.sendKeys(Keys.TAB);

			driver.findElementById("activity-stream-textarea").sendKeys("Assigned to ITIL");


			driver.findElementById("sysverb_update").click();

			System.out.println("Priority: "+driver.findElementByXPath("//table[@id='incident_table']//tr[1]//td[7]").getText());
			System.out.println("State: "+driver.findElementByXPath("//table[@id='incident_table']//tr[1]//td[8]").getText());
			System.out.println("Assignment group: "+driver.findElementByXPath("//table[@id='incident_table']//tr[1]//td[10]").getText());
			System.out.println("Assigned to:"+driver.findElementByXPath("//table[@id='incident_table']//tr[1]//td[11]").getText());


		}
		else
		{
			System.out.println("Selected different Incident");
		}


	}

}
