package week7.assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	public static ChromeDriver driver;
	
	public void launchBrowser(String url)
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver1.exe");
		driver = new ChromeDriver();
		//Loading a url
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
	}
	
}
