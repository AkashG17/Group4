package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	@FindBy (xpath="//input[@id='username']")
	private WebElement username;
	
	@FindBy (xpath="//input[@name='pwd']")
	private WebElement password;
	
	@FindBy (xpath="//input[@type='checkbox']")
	private WebElement radioButton;
	
	@FindBy (xpath="//a[@id='loginButton']")
	private WebElement loginButton;
	
	
	

	public  Loginpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void enterUsername()
	{
		username.sendKeys("akg171717@gmail.com");
	}
	
	public void enterPassword()
	{
		password.sendKeys("Developer");
	}
	public void clickradioButton()
	{
		radioButton.click();
	}
	public void clickloginButton()
	{
		loginButton.click();
	}
	
}
