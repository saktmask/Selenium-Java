package Learning;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import Base.LaunchBrowser;

public class ERail extends LaunchBrowser {

	public static void main(String[] args) throws InterruptedException {
		
		/*System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver1");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://erail.in/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);*/
		
		String url="https://erail.in/";
		LaunchBrowser lb=new LaunchBrowser();
		lb.launchBrowser(url);
		Thread.sleep(3000);
		
		WebElement fromStn = driver.findElementById("txtStationFrom");
		fromStn.clear();
		fromStn.sendKeys("MAS",Keys.TAB);
		
		WebElement toStn = driver.findElementById("txtStationTo");
		toStn.clear();
		toStn.sendKeys("SBC",Keys.TAB);
				
		//driver.findElementById("buttonFromTo").click();
		
		//Thread.sleep(3000);
		LaunchBrowser.findElementById("buttonFromTo").click();
		
		driver.findElementById("chkSelectDateOnly").click();
		
		List<WebElement> elements_trainNames = driver.findElementsByXPath("//table[@class='DataTable TrainList TrainListHeader']//tbody//td[2]//a");
		List<String> li=new ArrayList<>();
		for (int i = 0; i <elements_trainNames.size(); i++) {
			li.add(elements_trainNames.get(i).getText());
		}
		
		System.out.println(li);
	
	}

}
