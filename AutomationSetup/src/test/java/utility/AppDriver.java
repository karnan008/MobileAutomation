package utility;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class AppDriver {
	
	private static ThreadLocal<AppiumDriver<MobileElement>> driver = new ThreadLocal<>();
	
	public static AppiumDriver<MobileElement> getDriver()
	{
		return driver.get();
	}
	
	

	public static void setDriver(AppiumDriver<MobileElement> Driver) {
		driver.set(Driver);
		
	}
	

}
