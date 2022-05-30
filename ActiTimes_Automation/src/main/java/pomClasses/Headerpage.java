package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Headerpage {

	@FindBy (xpath="//div[@id='container_reports']")
	private WebElement reports;
	
	@FindBy (xpath="//div[@id='container_users']")
	private WebElement users;
	
	@FindBy (xpath="//a[text()='Logout']")
	private WebElement logout;
	
	@FindBy (xpath="//div[@id='container_tasks']")
	private WebElement tasks;
	
	public Headerpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickreports()
	{
		reports.click();
	}
	public void clickusers()
	{
		users.click();
	}
	public void clicklogout()
	{
		logout.click();
	}
	public void clicktasks()
	{
		tasks.click();
	}
	
}
