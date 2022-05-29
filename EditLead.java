package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.manage().deleteAllCookies();

		driver.get("http://leaftaps.com/opentaps/control/login");

		System.out.println("Browser Opened");

		driver.manage().window().maximize();

		System.out.println("Browser Maximized");

		WebElement element = driver.findElement(By.id("username"));

		element.sendKeys("DemoSalesManager");

		System.out.println("UserName Provided");

		driver.findElement(By.id("password")).sendKeys("crmsfa");

		System.out.println("Password Provided");

		driver.findElement(By.className("decorativeSubmit")).click();

		System.out.println("Logged In");

		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();

		System.out.println("Clicked on CRM/SFA");

		driver.findElement(By.linkText("Leads")).click();

		System.out.println("Clicked on Leads");

		driver.findElement(By.linkText("Find Leads")).click();

		System.out.println("Clicked on Find Leads");

		Thread.sleep(5000);

		String FirsttLeadID = driver.findElement(By.xpath("//div[@class= 'x-grid3-cell-inner x-grid3-col-partyId']/a[1]")).getText();

		System.out.println("First Lead id is " +  FirsttLeadID);

		driver.findElement(By.xpath("//div[@class= 'x-grid3-cell-inner x-grid3-col-partyId']/a[1]")).click();

		System.out.println("Clicked on First Lead ID");

		Thread.sleep(5000);

		String TitleName = driver.findElement(By.id("sectionHeaderTitle_leads")).getText();

		System.out.println("Title Name is " + TitleName );

		if (TitleName.trim().equalsIgnoreCase("View Lead")) {

			System.out.println("Title Name is Validated " );

			driver.findElement(By.xpath("//a[text() = 'Edit']")).click();

			System.out.println("Clicked on Edit " );

			driver.findElement(By.id("updateLeadForm_companyName")).clear();

			driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("SCB GBS");

			System.out.println("Entered Company Name" );

			driver.findElement(By.id("updateLeadForm_firstName")).sendKeys("ABC");

			driver.findElement(By.id("updateLeadForm_lastName")).sendKeys("LTD");

			driver.findElement(By.xpath("//input[@type = 'submit' and @value = 'Update']")).click();

			System.out.println("Clicked on Update" );

			boolean displayed = driver.findElement(By.id("viewLead_companyName_sp")).isDisplayed();

			System.out.println("Is Changed Company Name Displaying : " + displayed );

			String LeadName1 = driver.findElement(By.id("viewLead_companyName_sp")).getText();

			System.out.println("Changed Company Name is  : " + LeadName1 );

			System.out.println("SCB GBS ("+FirsttLeadID+")" );

			if( ("SCB GBS ("+FirsttLeadID+")") .equalsIgnoreCase(LeadName1))  {

				System.out.println("Changed Company Name is Appearing" );

			}

			else {

				System.out.println("Changed Comnpany Name is not Appearing" );

			}

		}

		else {

			System.out.println("Title Name is Wrong" );
		}

		System.out.println("Exiting the browser" );
		driver.close();
	}

}
