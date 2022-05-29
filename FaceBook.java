package week2.day2;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FaceBook {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;

		driver.get("https://en-gb.facebook.com/");

		System.out.println("Browser Opened");

		driver.manage().window().maximize();

		System.out.println("Browser Maximized");

		WebElement findElement = driver.findElement(By.xpath("//a[@data-testid = 'open-registration-form-button']"));

		findElement.click();

		System.out.println("Create Account Started");

		driver.findElement(By.xpath("//input[@aria-label = 'First name']")).sendKeys("Dheeran");

		System.out.println("First Name Entered");

		driver.findElement(By.xpath("//input[@aria-label = 'Surname']")).sendKeys("AryaDev");

		System.out.println("SurName Entered");

		driver.findElement(By.xpath("//input[@aria-label = 'Mobile number or email address']")).sendKeys("sadasd@gmail.com");

		System.out.println("Email Entered");

		driver.findElement(By.xpath("//input[@aria-label = 'Re-enter email address']")).sendKeys("sadasd@gmail.com");

		System.out.println("Email Entered");

		driver.findElement(By.xpath("//input[@aria-label = 'New password']")).sendKeys("123456Qw$");

		System.out.println("New Password Entered");

		WebElement dropDay = driver.findElement(By.xpath("//select[@aria-label = 'Day']"));

		Select LovInput1 = new Select(dropDay);

		LovInput1.selectByValue("27");

		System.out.println("Date Entered");

		WebElement dropMonth = driver.findElement(By.xpath("//select[@aria-label = 'Month']"));

		Select LovInput2 = new Select(dropMonth);

		LovInput2.selectByVisibleText("Jan");

		System.out.println("Month Entered");

		WebElement dropYear= driver.findElement(By.xpath("//select[@aria-label = 'Year']"));

		Select LovInput3 = new Select(dropYear);

		LovInput3.selectByIndex(30);

		System.out.println("Year Entered");

		driver.findElement(By.xpath("//input[@value = '2']")).click();

		System.out.println("Gender Entered");

		driver.findElement(By.xpath("//button[@name= 'websubmit']")).click();

		System.out.println("Signed Up");

		driver.close();

		System.out.println("Browser Closed");

	}

}
