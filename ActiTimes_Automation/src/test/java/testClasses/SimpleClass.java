package testClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleClass {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\akash\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
	    ChromeDriver driver=new ChromeDriver();
	    driver.get("https://online.actitime.com/infotech/login.do");
	    WebElement user=driver.findElement(By.xpath("//input[@id='username']"));
	    user.sendKeys("akg171717@gmail.com");
	    WebElement pass=driver.findElement(By.xpath("//input[@name='pwd']"));
	    pass.sendKeys("Developer");
	    WebElement login=driver.findElement(By.xpath("//a[@id='loginButton']"));
	    login.click();
	}

}
