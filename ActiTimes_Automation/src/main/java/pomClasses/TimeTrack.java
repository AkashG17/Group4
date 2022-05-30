package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TimeTrack {
	
	@FindBy (xpath="//span[text()='Submit Week for Approval']")
	public WebElement weeklyReport;
	
	public TimeTrack(WebDriver driver)	
	{
		PageFactory.initElements(driver, this);
	}


}
