package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButton {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.manage().deleteAllCookies();

		driver.get("http://www.leafground.com/pages/radio.html");

		System.out.println("Browser Opened");

		driver.manage().window().maximize();

		System.out.println("Browser Maximized");

		WebElement RadioButton = driver.findElement(By.id("yes"));
		RadioButton.click();

		boolean defaultSelected = driver.findElement(By.xpath("//input[@value = '1' and @name = 'news']")).isSelected();

		if (defaultSelected == true){

			System.out.println("Default Selected radio button is Checked");
		}		
		
		else {

			System.out.println("Default Selected radio button is Unchecked");
		}
		
		boolean ageGroup = driver.findElement(By.xpath("//input[@value = '1' and @name = 'age']")).isSelected();
		
		if (ageGroup != true){

			driver.findElement(By.xpath("//input[@value = '1' and @name = 'age']")).click();
		
		}		
		
		else {

			System.out.println("Appropriate Age Group is already Selected");
		
		}
		
		driver.close();
		System.out.println("Exiting the Browser");

	}

}
