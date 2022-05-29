package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

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

		driver.findElement(By.linkText("Find Leads")).click();

		System.out.println("Clicked on Find Leads");

		driver.findElement(By.xpath("//span[text() = 'Email']")).click();

		System.out.println("Clicked on Email");

		Thread.sleep(5000);

		driver.findElement(By.name("emailAddress")).sendKeys("aadvik@gmail.com");

		System.out.println("Entered Email");

		Thread.sleep(5000);

		String LeadName = driver.findElement(By.xpath("//div[@class= 'x-grid3-cell-inner x-grid3-col-firstName'] /a")).getText();

		System.out.println("Lead Name is " + LeadName);

		driver.findElement(By.xpath("//div[@class= 'x-grid3-cell-inner x-grid3-col-partyId'] /a")).click();

		System.out.println ("Clicked the First Lead");

		driver.findElement(By.xpath("//a[@class= 'subMenuButton' and text() = 'Duplicate Lead']")).click();

		System.out.println ("Clicked the Duplicate");

		Thread.sleep(5000);

		String TitleName = driver.findElement(By.id("sectionHeaderTitle_leads")).getText();

		System.out.println("Title Name is " + TitleName);

		if (TitleName.equalsIgnoreCase("Duplicate Lead") ) {

			driver.findElement(By.xpath("//input[@class= 'smallSubmit' and @value = 'Create Lead' ]")).click();
			
			System.out.println("If Loop Successful and clicked the Create Lead");

		}
		
		else {
			
			System.out.println("Wrong Title Name");
		}

		System.out.println("Not Entered into Else Part");
		
		Thread.sleep(5000);

		String FirstName = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		
		System.out.println("First Name is " +  FirstName);
		
		if(FirstName.equalsIgnoreCase(LeadName)) {

				System.out.println("Lead Duplicated Successfully");
			
		}

			else {

				System.out.println("Not Duplicated Properly");

			}

		driver.close();
		
	}

}
