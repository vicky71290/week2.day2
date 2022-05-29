package week2.day2;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HyperLinks {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("http://leafground.com/pages/Link.html");
		System.out.println("Browser Opened");
		driver.manage().window().maximize();
		System.out.println("Browser Maximized");

		WebElement webElement = driver.findElement(By.xpath("//a[contains(text(),'Home Page')]"));
		webElement.click();
		System.out.println("Gone to Home Page");

		driver.findElement(By.xpath("//h5[text() = 'HyperLink']//parent::a")).click();
		System.out.println("Back to HyperLink Page");

		String location = driver.findElement(By.xpath("//a[contains(text(),'Find where am supposed')]")).getAttribute("href");
		System.out.println("Page will navigate to " + location);

		driver.findElement(By.xpath("//a[contains(text(),'Verify')]")).click();
		String brokenPage = driver.getTitle();
		System.out.println(brokenPage);

		if (brokenPage.contains("Not Found")) {
			System.out.println("Yes, its a broken page");
		}
		else {
			System.out.println("No,its not a broken page");
		}
		
		System.out.println("Relaunching the Page");
		driver.get("http://leafground.com/pages/Link.html");
		
		List<WebElement> links = driver.findElements(By.tagName("a")); // using tagname with anchor denotes the hyperlinks
		int numberOfLinks = links.size();
		System.out.println("The Number of HyperLinks in the page is " + numberOfLinks );

		driver.close();
		System.out.println("Exiting the Browser");

	}

}
