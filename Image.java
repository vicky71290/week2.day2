package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Image {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("http://leafground.com/pages/Image.html");
		System.out.println("Browser Opened");
		driver.manage().window().maximize();
		System.out.println("Browser Maximized");
		
		WebElement ImageClick = driver.findElement(By.xpath("//label[contains(text(),'Click on this image to go home page')]/following-sibling::img"));
		ImageClick.click();
		System.out.println("Navigated to Home Page");
		
		driver.findElement(By.xpath("//a[contains(@href,'Image.html')]")).click();
		System.out.println("Moved Back to Image Page");

		System.out.println("Getting Page Title Before Clicking Broken Image");
		String PageTitle = driver.getTitle();
		
		driver.findElement(By.xpath("//label[contains(text(),'Am I Broken')]/following-sibling::img")).click();
		System.out.println("Clicked on the Broken Image with no anchor Link");
		
		System.out.println("Getting Page Title After Clicking Broken Image");
		String PageTitle1 = driver.getTitle();
		
		if (PageTitle.equalsIgnoreCase(PageTitle1)) {
			
			System.out.println("Matching Pagew Title Before and After Clicking the Broken Image");
			System.out.println("Yes, its a broken Image");
			
		}
		
		else {
			
			System.out.println("No, its not a broken Image");
			
		}
		
		driver.findElement(By.xpath("//label[contains(text(),'Click me using Keyboard or Mouse')]/following-sibling::img")).click();
		System.out.println("Clicked on Keyboard Mouse Icon");
		
		driver.close();
		System.out.println("Exiting the Browser");
		
	}

}
