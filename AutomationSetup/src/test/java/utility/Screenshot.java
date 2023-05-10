package utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import action.Baseclass;


public class Screenshot extends Baseclass {


	public static String errflpath;
	
	public static String capture(WebDriver driver) throws IOException 
	{
	File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	File Dest = new File("./ScreenShot/" + currentdate()+ ".png");
	errflpath = Dest.getAbsolutePath();
	FileUtils.copyFile(scrFile, Dest);
	return errflpath;
	}
	
	
	public static String currentdate()
	{
		DateFormat customformat = new SimpleDateFormat("MM/dd_yyyy_HH_mm_ss");
		
		Date currentDate = new Date();
		
	return	customformat.format(currentDate);
	}
}
