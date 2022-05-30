package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pomClasses.Headerpage;

import pomClasses.Loginpage;
import pomClasses.TimeTrack;

public class TestNGWithBothAssert {

	WebDriver driver;
	 Loginpage loginpage;
	 Headerpage headerpage;
	 TimeTrack timeTrack;
	@BeforeClass
	public void browserLaunch()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\akash\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
	     driver=new ChromeDriver();
	     driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	    driver.get("https://online.actitime.com/infotech/login.do");
	    driver.manage().window().maximize();
	}
	@BeforeMethod
	public void beforeMethod() throws InterruptedException
	{      timeTrack=new TimeTrack(driver);
		   loginpage=new Loginpage(driver);
		    loginpage.enterUsername();
		    Thread.sleep(2000);
		    loginpage.enterPassword();
		    loginpage.clickloginButton();
		
	}
	
	@Test
	public void test() throws InterruptedException
	{
	     	Thread.sleep(1000);
		    String url=driver.getCurrentUrl();
		    String title=driver.getTitle();
		    Assert.assertEquals(url, "https://online.actitime.com/infotech/timetrack/enter.do");
		  
		    Thread.sleep(2000);
		    boolean status=timeTrack.weeklyReport.isDisplayed();
		 
		    
		    SoftAssert soft=new SoftAssert();
		   
		    soft.assertEquals(title, "actiTIME - Enter Time-Track");
		    soft.assertEquals(status, true);
		    System.out.println(status);
		    soft.assertAll();
	}
//	
	@AfterMethod
	public void afterMethod() throws InterruptedException
	{
		  headerpage=new  Headerpage(driver);
		Thread.sleep(2000);
		  headerpage.clicklogout();
	}

}
