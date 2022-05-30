package testClasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import browsers.Base;
import pomClasses.Headerpage;

import pomClasses.Loginpage;
import pomClasses.TasksPage;
import pomClasses.TimeTrack;

public class TestNGAssertionLogin {
	WebDriver driver;
	 Loginpage loginpage;
	 Headerpage headerpage;
	 TimeTrack timeTrack;
	 TasksPage tasksPage;
	 
	 @Parameters ("browserName")
	 @BeforeTest
	 public  void launchBrowser(String browser)
	 {
		 System.out.println("browser");
		 if (browser.equalsIgnoreCase("Chrome"))
		 {
			 driver=Base.openChromeBrowser();
		 }
		 if (browser.equalsIgnoreCase("Firefox"))
		 {
			 driver=Base.openFirefoxBrowser();
		 }
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	 }
	 
	@BeforeClass
	public void browserLaunch()
	{
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\akash\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
//	     driver=new ChromeDriver();
//	     driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	    driver.get("https://online.actitime.com/infotech/login.do");
	    driver.manage().window().maximize();
	}
	@BeforeMethod
	public void beforeMethod() throws InterruptedException
	{      timeTrack=new TimeTrack(driver);
		   loginpage=new Loginpage(driver);
		   headerpage=new Headerpage(driver);
		    loginpage.enterUsername();
		    Thread.sleep(2000);
		    loginpage.enterPassword();
		    loginpage.clickloginButton();
		
	}
	
	@Test
	public void verufyTimeTrackTab() throws InterruptedException
	{
	     	Thread.sleep(1000);
		    String url=driver.getCurrentUrl();
		    String title=driver.getTitle();
		    Assert.assertEquals(url, "https://online.actitime.com/infotech/timetrack/enter.do");
		    Assert.assertEquals(title, "actiTIME - Enter Time-Track");
		    Thread.sleep(2000);
		    boolean status=timeTrack.weeklyReport.isDisplayed();
		    Assert.assertEquals(status, true);
		    
		    SoftAssert soft=new SoftAssert();
		    soft.assertEquals(url, "https://online.actitime.com/infotech/timetrack/enter.do");
		    soft.assertEquals(title, "actiTIME - Enter Time-Track");
		    soft.assertEquals(status, true);
		    System.out.println(status);
		    soft.assertAll();
		   
	}
	
	@Test
	public void verifyingTaskTab() throws InterruptedException
	{
		 tasksPage=new TasksPage(driver);
		 
		headerpage.clicktasks();
		String taskpageUrl=driver.getCurrentUrl();
		Assert.assertEquals(taskpageUrl, "https://online.actitime.com/infotech/tasks/tasklist.do");	
		
	}
	@AfterMethod
	public void afterMethod() throws InterruptedException
	{
		 
			Thread.sleep(2000);
			headerpage.clicklogout();
	}
	@AfterClass
	public void afterClass()
	{ driver.close();
	  loginpage=null;
	  headerpage=null;
	  timeTrack=null;
	  tasksPage=null;
	  
		
	}
	@AfterTest
	public void afterTest()
	{
		 driver=null;
		 System.gc();
		  
	}

}
