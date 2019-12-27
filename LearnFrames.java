package Learning;

import org.openqa.selenium.WebElement;
import Base.LaunchBrowser;

public class LearnFrames extends LaunchBrowser {

	public static void main(String[] args) {
		
		String url="http://leafground.com/pages/frame.html";
		launchBrowser(url);
		
		WebElement frameEle = driver.findElementByXPath("//iframe[@src='default.html']");
		driver.switchTo().frame(frameEle);
		driver.findElementById("Click").click();
		String str=driver.findElementById("Click").getText();
		System.out.println(str);
		driver.switchTo().defaultContent();
		
		WebElement frameEle1 = driver.findElementByXPath("//iframe[@src='page.html']");
		driver.switchTo().frame(frameEle1);
		driver.switchTo().frame("frame2");
		driver.findElementById("Click1").click();
		String str1=driver.findElementById("Click1").getText();
		System.out.println(str1);
		driver.switchTo().defaultContent();
		
		WebElement frameEle2 = driver.findElementByXPath("//iframe[@src='countframes.html']");
		driver.switchTo().frame(frameEle2);
		//driver.switchTo().frame("frame2");
		System.out.println(driver.findElementsByXPath("//iframe").size());
		driver.switchTo().defaultContent();
		
		
	}

}
