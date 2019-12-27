package Learning;

import java.util.List;

import org.openqa.selenium.WebElement;

import Base.LaunchBrowser;

public class LearnWebTables extends LaunchBrowser {

	public static void main(String[] args) {
		
		String url="http://leafground.com/pages/table.html";
		LaunchBrowser.launchBrowser(url);
		
		List<WebElement> tableRows = driver.findElementsByXPath("//table[@id='table_id']//tr");
		//driver.findElements(By.xpath("//tr"));
		int rowSize = tableRows.size();
		
		List<WebElement> tableColumns = driver.findElementsByXPath("//table[@id='table_id']//tr[2]//td");
		int colSize=tableColumns.size();
		
		System.out.println("Rows: "+rowSize);
		System.out.println("Columns: "+colSize);
		
		for(int i=2;i<=rowSize;i++)
		{
			for(int j=1;j<=colSize;j++)
			{
				String text = driver.findElementByXPath("//table[@id='table_id']//tr["+i+"]//td["+j+"]").getText();
				
				if(text.equals(""))
				{
					
				}
				
			}
		}
	}

}
