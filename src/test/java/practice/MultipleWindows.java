package practice;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleWindows {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		WebDriver driver=null;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		String url="https://rahulshettyacademy.com/angularpractice/";
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String parentWindow=driver.getWindowHandle();
		driver.switchTo().newWindow(WindowType.TAB);
		//driver.switchTo().newWindow(WindowType.WINDOW);
		String courseName = null;
		
		Set<String> set= driver.getWindowHandles();
		for(String s:set) {
			if(!s.contentEquals(parentWindow)) {
				driver.switchTo().window(s);
				driver.get("https://rahulshettyacademy.com/#/index");
				
				courseName=driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
				driver.switchTo().window(parentWindow);
			}
		}
		
		WebElement name=driver.findElement(By.xpath("//input[@name='name']"));
		name.sendKeys(courseName);
		// get web element screen shot 
		File file=name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("test.png"));
		
		// get height and width 
		System.out.println(name.getRect().getDimension().getHeight());
		System.out.println(name.getRect().getDimension().getWidth());
		driver.quit();
		
	}
	
}
