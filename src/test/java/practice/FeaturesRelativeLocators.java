package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;import com.google.common.cache.Weigher;

import io.github.bonigarcia.wdm.WebDriverManager;
import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

public class FeaturesRelativeLocators {

	public static void main(String[] args) {
	
		WebDriver driver=null;
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		String url="https://rahulshettyacademy.com/angularpractice/";
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// above relative locators  
		WebElement name=driver.findElement(By.xpath("//input[@name='name']"));
		String labelname=driver.findElement(withTagName("label").above(name)).getText();
		System.out.println(labelname);
		
		// below relative locators
		WebElement dob=driver.findElement(By.xpath("//label[@for='dateofBirth']"));
		driver.findElement(withTagName("input").below(dob)).sendKeys("01/01/1991");
		
		// toleft of relative locators
		WebElement icecreamLabel=driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
		driver.findElement(withTagName("input").toLeftOf(icecreamLabel)).click();
		
		// toright of relative locators
		WebElement radioButton=driver.findElement(By.xpath("//input[@value='option1']"));
		String textOf=driver.findElement(withTagName("label").toRightOf(radioButton)).getText();
		System.out.println(textOf);
	}
	
}
