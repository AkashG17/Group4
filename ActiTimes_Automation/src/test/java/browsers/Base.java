package browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Base {
	public static WebDriver openChromeBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\akash\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		return driver;
	}

	public static WebDriver openFirefoxBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		return driver;
	}	
	
	public static WebDriver openOperaBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\operadriver.exe");
		WebDriver driver=new OperaDriver();
		return driver;
	}
	
}
