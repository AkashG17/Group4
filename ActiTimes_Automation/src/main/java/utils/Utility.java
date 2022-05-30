package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	public static void captureScreenshot(WebDriver driver) throws IOException
	{
		TakesScreenshot t=(TakesScreenshot)driver;
		File source=t.getScreenshotAs(OutputType.FILE);
		String f=new SimpleDateFormat("dd-mm-yyyy_hh mm ss").format(new Date());
		File dest=new File("test-output\\Screenshots"+f+".jpeg");
		FileHandler.copy(source,dest);
	}

}
