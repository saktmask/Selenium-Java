package week4.day2.project;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.sl.In;

public class ZoomCar {
	
	public static void main(String[] args) throws InterruptedException {
		
				// Set the property for ChromeDriver
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver1.exe");
				
				// Initiate the ChromeBroswer
				ChromeDriver driver=new ChromeDriver();
				
				// Maximize the browser
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				//URL
				driver.get("https://www.zoomcar.com/chennai");
				Thread.sleep(2000);
				
				driver.findElementByXPath("//a[.='Start your wonderful journey']").click();
				
				driver.findElementByXPath("(//div[@class='items'])[1]").click();
				driver.findElementByClassName("proceed").click();
				
				
				driver.findElementByXPath("//div[@class='day'][1]").click();
				driver.findElementByClassName("proceed").click();
				
				System.out.println(driver.findElementByXPath("//div[@class='label time-label']").getText());
				
				driver.findElementByXPath("//button[@class='proceed']").click();
				Thread.sleep(2000);
				
//				driver.findElementByXPath("//div[text()=' Price: High to Low ']").click();
				
				WebElement ele=driver.findElementByXPath("//div[@class='car-listing']//div[@class='car-item']");
				List<WebElement> list = ele.findElements(By.xpath("//div[@class='price']"));
				List<WebElement> book=ele.findElements(By.xpath("//button[@class='book-car']"));
				book.size();
				int len=list.size();
				List<Integer> ls = new ArrayList<>();
				List<String> bookList=new ArrayList<>();
				for(int i=0;i<list.size();i++)
				{
					ls.add(Integer.parseInt(list.get(i).getText().replaceAll("\\D", "")));
				
				}
				
				for (WebElement sBook: book) {
					bookList.add(sBook.getText());
				}
				
				System.out.println(ls);
				
				Collections.sort(ls);
				Collections.reverse(ls);
				System.out.println(ls);
						
								
				int max=Collections.max(ls);
				//int indexOf = ls.indexOf(max);
				
				
				//list.get(indexOf).click();
				System.out.println(max);
				driver.findElementByXPath("//button[@class='book-car']["+len+"]").click();
				

	}

}
