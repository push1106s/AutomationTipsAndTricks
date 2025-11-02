package testScript;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TableDataHandling {


	@Test
	public void tableDemo() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='orangehrm-header-container']//button[@type='button']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Pushpa");
		driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--active']")).sendKeys("110");
		driver.findElement(By.xpath("//button[@type='submit']")).click();


		//Selects two checkboxes using JavaScript, scrolls them into view, clicks them, then clicks a confirmation button
		for (int i=1;i<3;i++){
			WebElement element = driver.findElement(By.xpath("//input[@type='checkbox' and @value ='"+i+"']"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(500);
			js.executeScript("arguments[0].click();", element);
			Thread.sleep(1000);
		}

		WebElement ele = driver.findElement(By.xpath("//div[contains(@class,'orangehrm-horizontal-padding')]//button"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
		js.executeScript("arguments[0].click();", ele);
		Thread.sleep(2000);
	
		
		
// Clicks a button, waits for a toast message, prints it, and verifies it confirms successful deletion
		driver.findElement(By.xpath("//div[@role='document']//button[2]")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("oxd-toaster_1")));
		String toastText = toast.getText();
		System.out.println("Message"+ toastText);
		Assert.assertTrue(toastText.contains("Successfully Deleted"));


	}


}
