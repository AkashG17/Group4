package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TasksPage {
	@FindBy (xpath="//div[text()='Add New']")
	private WebElement addnewButton;
	
	@FindBy (xpath="(//div[@class='collapseButton'])[1]")
	private WebElement collapseButton;
	
	@FindBy (xpath="//div[text()='Spaceship testing']")
	public WebElement spaceshipTesting;
	
	@FindBy (xpath="(//div[text()='Bug fixing'])[1]")
	private WebElement bugFixing;
	
	@FindBy (xpath="(//div[@class='value'])[13]")
	private WebElement estimatedTime;
	
	@FindBy (xpath="(//div[text()='Bug fixing'])[2]")
	public WebElement bugFixingsHeader;
	
	
	@FindBy (xpath="(//div[@class='hideButton_panelContainer'])[3]")
	private WebElement cross;
	
	
	public TasksPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
    public void clickaddnewButton()
    {
	 addnewButton.click();
    }
    public void clickcollapseButton()
    {
    	collapseButton.click();
    }
    public void clickspaceshipTesting()
    {
    	spaceshipTesting.click();
    }
    public void clickbugFixing()
    {
    	bugFixing.click();
    }
    public void sendestimatedTime() throws InterruptedException
    {
    	estimatedTime.click();
    	Thread.sleep(1000);
    	estimatedTime.sendKeys("17");
    }
    public void clickcross()
    {
    	cross.click();
    }

    
}

