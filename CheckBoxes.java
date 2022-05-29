package week2.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBoxes {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("http://leafground.com/pages/checkbox.html");
		System.out.println("Browser Opened");
		driver.manage().window().maximize();
		System.out.println("Browser Maximized");

		WebElement LanguageBox = driver.findElement(By.xpath("//label[contains(text(),'Select the languages that you know?')]/following-sibling::input[1]"));
		LanguageBox.click();
		System.out.println("Clicking JAVA as I am Learning Now");

		driver.findElement(By.xpath("//label[contains(text(),'Select the languages that you know?')]/following-sibling::input[3]")).click();
		System.out.println("Clicking SQL");

		boolean SeleniumChecked = driver.findElement(By.xpath("//label[contains(text(),'Confirm Selenium is checked')]/following-sibling::input")).isSelected();
		System.out.println(SeleniumChecked);


		if (SeleniumChecked == true) {

			System.out.println("Yes, it is checked");

		}

		else {

			System.out.println("No, it is not checked");

		}

		boolean DeselectChecked = driver.findElement(By.xpath("//label[contains(text(),'DeSelect')]/following-sibling::input[1]")).isSelected();

		if (DeselectChecked == true) {

			driver.findElement(By.xpath("//label[contains(text(),'DeSelect')]/following-sibling::input[1]")).click();
			System.out.println("Deselecting the 1st Option");

		}

		else {

			System.out.println("1st Option  is not checked and No Action Required");

		}

		boolean DeselectChecked1 = driver.findElement(By.xpath("//label[contains(text(),'DeSelect')]/following-sibling::input[2]")).isSelected();

		if (DeselectChecked1 == true) {

			driver.findElement(By.xpath("//label[contains(text(),'DeSelect')]/following-sibling::input[2]")).click();
			System.out.println("Deselecting the 2nd Option");

		}

		else {

			System.out.println("No, it is not checked and No Action Required");

		}

		List<WebElement> MultipleElements = driver.findElements(By.xpath("//label[contains(text(),'Select all below checkboxes')]/following-sibling::input"));
		int NoOfLinks = MultipleElements.size();
		System.out.println("Number of options are " + NoOfLinks);

		for (int i = 0;i<NoOfLinks;i++) {
			
			int o = i+1;

			MultipleElements.get(i).click();
			System.out.println("Clicked the " + o + " Option");

		}

		driver.close();
		System.out.println("Exiting the Browser");

	}


}
