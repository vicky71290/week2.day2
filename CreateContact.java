package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

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

		driver.findElement(By.linkText("Contacts")).click();

		System.out.println("Clicked on Contacts");

		driver.findElement(By.linkText("Create Contact")).click();

		System.out.println("Clicked on Create Contact");

		driver.findElement(By.id("firstNameField")).sendKeys("Contact1 First Name");

		System.out.println("Entered First Name");

		driver.findElement(By.id("lastNameField")).sendKeys("Contact1 Last Name");

		System.out.println("Entered Last Name");
		
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Contact1 Local Name");

		System.out.println("Entered First Name Local");
		
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Contact1 Local Last Name");

		System.out.println("Entered Last Name Local");
		
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys("SCI");

		System.out.println("Entered Dept Name");
		
		driver.findElement(By.id("createContactForm_description")).sendKeys("Selenium Learning");

		System.out.println("Entered Desc ");
		
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("test@gmail.com");

		System.out.println("Entered Desc ");
		
		WebElement LovSelect = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		
		Select LovInput2  = new Select(LovSelect);
		
		LovInput2.selectByVisibleText("New York");

		System.out.println("Entered State ");
		
		driver.findElement(By.name("submitButton")).click();

		System.out.println("Created Contact ");
		
		driver.findElement(By.linkText("Edit")).click();

		System.out.println("Edit Started");
		
		driver.findElement(By.id("updateContactForm_description")).clear();

		System.out.println("Cleared Desc ");
		
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("Notes");

		System.out.println("Important Notes Updated");
		
		driver.findElement(By.xpath("//input[@name = 'submitButton' and @value = 'Update']")).click();

		System.out.println("Updated");
		
		String pageTitle = driver.getTitle();

		System.out.println("Page Title is " +  pageTitle);

		driver.close();

		System.out.println("Browser Closed");

	}

}
