package week2.day2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriverException;

public class DeleteLead {

	public static void main(String[] args) throws WebDriverException, InterruptedException {

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

		driver.findElement(By.xpath("//span[text() = 'Phone']")).click();

		System.out.println("Clicked on Phone");

		//driver.findElement(By.xpath("//input[@name = 'phoneAreaCode']")).sendKeys("+91");

		//	System.out.println("Enterted Area Code");

		driver.findElement(By.xpath("//input[@name = 'phoneNumber']")).sendKeys("9840528334");

		System.out.println("Enterted Phone Number");

		driver.findElement(By.xpath("//button[text() = 'Find Leads']")).click();

		System.out.println("Clicked Find Leads");
		
		Thread.sleep(5000);

		WebElement eleLeadId = driver.findElement(By.xpath("//div[@class = 'x-grid3-cell-inner x-grid3-col-partyId']/a"));

		String LeadID = eleLeadId.getText();

		System.out.println(LeadID);

		eleLeadId.click();

		driver.findElement(By.linkText("Delete")).click();

		System.out.println("Clicked Delete");

		driver.findElement(By.linkText("Find Leads")).click();

		System.out.println("Clicked Find Leads");
		
		driver.findElement(By.xpath("//input[@name = 'id']")).sendKeys(LeadID);
		
		System.out.println("Entered the Deleted Lead ID");
		
		driver.findElement(By.xpath("//button[text() = 'Find Leads']")).click();
		
		System.out.println("Clicked the Find Leads to Search");
		
		Thread.sleep(5000);
		
		String LeadInfo = driver.findElement(By.xpath("//div[text() = 'No records to display']")).getText();
		
		System.out.println(LeadInfo);
		
		if (LeadInfo.equalsIgnoreCase("No records to display")) {
			
			System.out.println("Deleted Lead Successfully");
		}

		else {
			
			System.out.println("Issues are there in the Scripts");
		}

		driver.close();

	}

}
