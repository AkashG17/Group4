package testClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pomClasses.Loginpage;

public class VerifyLogin {
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\akash\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
	    WebDriver driver=new ChromeDriver();
	    driver.get("https://online.actitime.com/infotech/login.do");
	    Loginpage loginpage=new Loginpage(driver);
	    loginpage.enterUsername();
	    loginpage.enterPassword();
	    loginpage.clickloginButton();
	    String url=driver.getCurrentUrl();
	    String title=driver.getTitle();
	    if(url.equals("https://online.actitime.com/infotech/timetrack/enter.do"))
	    {
	    	
	    }
	    else
	    {
	    	System.out.println("Fail");
	    }
		
	    
	    
	   
		
		
	}

}
