package testClasses;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import browsers.Base;
import pomClasses.Headerpage;
import pomClasses.Loginpage;
import pomClasses.ReportPage;
import pomClasses.UserPage;
import utils.Utility;

public class TestNGVerifyReportAndUsers {
	WebDriver driver;
	Loginpage loginpage;
	Headerpage headerpage;
	ReportPage reportPage;
	UserPage userPage;
	
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
	public void beforeClass()
	{
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\akash\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
//	     driver=new ChromeDriver();
//	     driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	    driver.get("https://online.actitime.com/infotech/login.do");
	    driver.manage().window().maximize();
	
		
	}
	@BeforeMethod
	public void beforeMethod() throws InterruptedException
	{
		headerpage=new Headerpage(driver);
		loginpage=new Loginpage(driver);
	    loginpage.enterUsername();
	    Thread.sleep(2000);
	    loginpage.enterPassword();
	    loginpage.clickloginButton();
		
	}
	@Test
	public void reportPageValidation()
	{
	
		headerpage.clickreports();
		String url3=driver.getCurrentUrl();
		String title3=driver.getTitle();
		Assert.assertEquals(url3, "https://online.actitime.com/infotech/reports/dashboard.do");
		Assert.assertEquals(title3, "actiTIME - Reports Dashboard");
		reportPage=new ReportPage(driver);
		boolean status= reportPage.createWidget.isSelected();
		
		 Assert.assertFalse(status);
		 System.out.println(status);
	}
	@Test
	public void usersPageValidation() throws InterruptedException
	{
		headerpage.clickusers();
		String userpageUrl=driver.getCurrentUrl();
		String userpageTitle=driver.getTitle();
		Assert.assertEquals(userpageUrl, "https://online.actitime.com/infotech/administration/userlist.do");
		Assert.assertEquals(userpageTitle, "actiTIME - User List");
		userPage=new UserPage(driver);
		
		Thread.sleep(2000);
		
		userPage.clickcrossbtnOfUsers();
	}
    @AfterMethod
    public void afterMethod(ITestResult result) throws InterruptedException, IOException
    {
    	if(ITestResult.FAILURE==result.getStatus())
    	{
    		Utility.captureScreenshot(driver);
    	}
    	Thread.sleep(1000);
    	headerpage.clicklogout();
    }
    @AfterClass
	public void afterClass()
	{ driver.close();
	  loginpage=null;
	  headerpage=null;
	   reportPage=null;
		 userPage=null;	  		
	}
    @AfterTest
	public void afterTest()
	{
		 driver=null;
		 System.gc();
		  
	}
}
