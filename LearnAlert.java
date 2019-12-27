package Learning;

import org.openqa.selenium.Alert;

import Base.LaunchBrowser;

public class LearnAlert extends LaunchBrowser {

	public static void main(String[] args) throws InterruptedException {
		LaunchBrowser lb=new LaunchBrowser();
		String url="http://leafground.com/pages/Alert.html";
		lb.launchBrowser(url);
		
		
		driver.findElementByXPath("//button[contains(@onclick,'normalAlert()')]").click();
		Thread.sleep(3000);
		Alert a = driver.switchTo().alert();
		a.accept();
		
		driver.findElementByXPath("//button[contains(@onclick,'confirmAlert()')]").click();
		Thread.sleep(3000);
		Alert a1 = driver.switchTo().alert();
		a1.dismiss();
		
		driver.findElementByXPath("//button[contains(@onclick,'confirmPrompt()')]").click();
		Thread.sleep(3000);
		Alert a2 = driver.switchTo().alert();
		a2.sendKeys("Welcome to learning");
		a2.accept();
		String text = driver.findElementByXPath("//p[@id='result1']").getText();
		System.out.println(text);
		
		
		
		driver.close();

	}

}
