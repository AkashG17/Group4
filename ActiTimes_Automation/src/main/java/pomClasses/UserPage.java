package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPage {
	@FindBy (xpath="(//td[@class='userNameCell first'])[1]")
	private WebElement firstMember;
	
	@FindBy (xpath="(//div[contains(@class,'small on animated')])[1]")
	public WebElement accessRadioButton;
	
	@FindBy (xpath="(//div[@class='hideButton_panelContainer'])[1]")
	public WebElement crossbtnOfUsers;
	
	public UserPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void clickfirstMember()
	{
		firstMember.click();
	}
	public void clickcrossbtnOfUsers()
	{
		crossbtnOfUsers.click();
	}
	
}
