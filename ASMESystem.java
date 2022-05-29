package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ASMESystem {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://acme-test.uipath.com/login");

		System.out.println("Browser Opened");

		WebElement findElement = driver.findElement(By.id("email"));

		findElement.sendKeys("kumar.testleaf@gmail.com");

		driver.findElement(By.id("password")).sendKeys("leaf@12");

		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();

		String PageTitile = driver.getTitle();

		System.out.println(PageTitile);

		driver.findElement(By.xpath("//a[contains(text(),'Log Out')]")).click();

		System.out.println("Logged Out");

		System.out.println("Exiting the Browser");

		driver.close();

	}

}
