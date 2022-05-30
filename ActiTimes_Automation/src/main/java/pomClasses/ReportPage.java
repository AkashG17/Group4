package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReportPage {
	
	@FindBy (xpath="//div[text()='Create Widget']")
	public WebElement createWidget;
	
	
	
	public ReportPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	

}
