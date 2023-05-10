package action;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.http.entity.StringEntity;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.collect.ImmutableMap;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import pages.Customer;


public class Wrapper 
{



	public static AppiumDriver<MobileElement> kdriver;
	public static String dev = "SpwJDyHLY3GEM71voNqOSzpSq1HvqX1qLSzDQYSSvFc1";
	public static String CustomerNumber;
	public static String CustomerName = "Magesh8";
	public static String CustomerNameEdited = "Magesh8 Kumar";
	public static String TitleCustomerName = "Mr Magesh8 Kumar";
	public static String CustomerContact = "Magesh8 KumarContact";
	public static String EditedCustomerContact = "Magesh8 KumarContactEdited";
	public static String SurName = "Magesh8 Kumar";
	public static String Title = "Mr";
	public static String Address = "Floor 3";
	public static String Address2 = "241 Southwark Bridge Rd";
	public static String Address3 = "London";
	public static String postalCode = "SE163OO";
	public static String position = "Engineer";
	public static String postalCodeEdited = "SE163FP";
	public static String EditAddress = "Ashford";
	public static String EditedCompany="PhilipsCompany";
	public static String EstimateDescription = "Estimate template_Nametag";
	public static String Breakdown = "No Breakdown";
	public static String JobDescription = "Boiler services";
	public static String WAName = "Karikalan";
	public static String WA = "Karikalan Magesh8 Kumar";
	public static String CompanyName = "Commusoft";
	public static String Mobile = "8248724397";
	public static String EditMobile = "8888888888";
	public static String Email = "customer@commusoft.com";
	public static String EditEmail = "karnan@commusoft.com";
	public static String platform;
	public static String line;
	public static String temp = "Android";
	public static String JobID;
	public static String ProjectID;
	public static String value3;
	public static String Reportlink;


	//	public Wrapper()
	//	{
	//		PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getDriver()), this);
	//	}

	public void type(String xpath, String value)
	{
		{
			if(xpath.contains("$"))
			{
				xpath = xpath.replace("$", "");
				kdriver.findElement(By.name(xpath)).sendKeys(value);

			}
			else if(xpath.contains("#"))
			{
				xpath = xpath.replace("#", "");
				kdriver.findElement(By.id(xpath)).sendKeys(value); 
			}
			else if(xpath.contains("~"))
			{
				xpath = xpath.replace("~", "");
				kdriver.findElement(By.className(xpath)).sendKeys(value);
			}
			else
			{
				kdriver.findElement(By.xpath(xpath)).sendKeys(value);
			}
		}
	}
	public void doubleclickpoint(int Horizontal, int Vertical) throws InterruptedException
	{
		Thread.sleep(3000);
		(new TouchAction(kdriver)).tap(PointOption.point(Horizontal,Vertical)).perform();
		Thread.sleep(1000);
		(new TouchAction(kdriver)).tap(PointOption.point(Horizontal,Vertical)).perform();
		Thread.sleep(2000);
	}

	public void ExplicitWait_PresenceOfEle(String xpath) 
	{
		WebDriverWait wait=new WebDriverWait(kdriver, 160);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath)));
	}

	public void ExplicitWait_VisibilityOfEle(String xpath) 
	{
		WebDriverWait wait=new WebDriverWait(kdriver, 160);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));

	}

	public void ExplicitWait_ElementToBeClickable(String xpath) 
	{
		WebDriverWait wait=new WebDriverWait(kdriver, 160);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	}
	public void click(String option)
	{
		{
			if(option.contains("$"))
			{
				option = option.replace("$", "");
				kdriver.findElement(By.name(option)).click();

			}
			else if(option.contains("#"))
			{
				option = option.replace("#", "");
				kdriver.findElement(By.id(option)).click(); 
			}
			else if(option.contains("~"))
			{
				option = option.replace("~", "");
				kdriver.findElement(By.className(option)).click();
			}
			else
			{
				//option = option.replace("//", "");
				kdriver.findElement(By.xpath(option)).click();
			}
		}
	}

	public void Scrollsimulator(String direction) throws InterruptedException
	{
		if(platform==null) {

			JavascriptExecutor js = (JavascriptExecutor) kdriver;
			HashMap<String, String> scrollObject = new HashMap<String, String>();
			scrollObject.put("direction", direction);
			js.executeScript("mobile: scroll", scrollObject);
			Thread.sleep(2000);
		}else if (platform.equals("Android")) {

		}
	}

	public void scrollToIOSElement(String xpath) {

		RemoteWebElement element = (RemoteWebElement)kdriver. findElement(By.xpath(xpath));
		String elementID = element.getId();
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("element", elementID);
		scrollObject.put("toVisible", "not an empty string");
		kdriver.executeScript("mobile:scroll", scrollObject);

	}

	public void Sysout(String text) 
	{
		String urlString = "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s";
		String apiToken = "896751198:AAE9Xnl-I9yRLETN_l_p1zr06_Fr_SEWXEU";
		String chatId = "-760145184";
		urlString = String.format(urlString, apiToken, chatId, text);
		try {
			URL url = new URL(urlString);
			URLConnection conn = url.openConnection();
			InputStream is = new BufferedInputStream(conn.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public MobileElement scrollToAndroidElement(AppiumDriver<MobileElement> driver, String text) {
		return driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector())" +
				".scrollIntoView(new UiSelector().text(\"" + text + "\").instance(0));"));
	}

	public void clear(String xpath)
	{
		{
			if(xpath.contains("$"))
			{
				xpath = xpath.replace("$", "");
				kdriver.findElement(By.name(xpath)).clear();

			}
			else if(xpath.contains("#"))
			{
				xpath = xpath.replace("#", "");
				kdriver.findElement(By.id(xpath)).clear(); 
			}
			else if(xpath.contains("~"))
			{
				xpath = xpath.replace("~", "");
				kdriver.findElement(By.className(xpath)).clear();
			}
			else
			{
				kdriver.findElement(By.xpath(xpath)).clear();
			}
		}
	}
	public void New2Old() throws InterruptedException, IOException
	{

		ExplicitWait_ElementToBeClickable("//XCUIElementTypeNavigationBar[@name=\"CommusoftV2.CSHomeTabbedView\"]/XCUIElementTypeButton");
		click("//XCUIElementTypeNavigationBar[@name=\"CommusoftV2.CSHomeTabbedView\"]/XCUIElementTypeButton");
		ExplicitWait_ElementToBeClickable("//XCUIElementTypeStaticText[@name=\"Labs\"]");
		click("//XCUIElementTypeStaticText[@name=\"Labs\"]");
		ExplicitWait_ElementToBeClickable("//XCUIElementTypeApplication[@name=\"Commusoft\"]/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeSwitch");
		click("//XCUIElementTypeApplication[@name=\"Commusoft\"]/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeSwitch");
		Thread.sleep(2000);
		click("//XCUIElementTypeButton[@name=\"Save\"]");
		ExplicitWait_ElementToBeClickable("//XCUIElementTypeButton[@name=\"newUIBackButton\"]");
		kdriver.terminateApp("com.commusoft.commusoftv2");
		kdriver.activateApp("com.commusoft.commusoftv2");
		Thread.sleep(5000);
	}
	public void Old2New() throws InterruptedException, IOException
	{

		ExplicitWait_ElementToBeClickable("//XCUIElementTypeButton[1]");
		click("//XCUIElementTypeButton[1]");
		scrollToIOSElement("//XCUIElementTypeStaticText[@name=\"Commusoft Labs\"]");
		click("//XCUIElementTypeStaticText[@name=\"Commusoft Labs\"]");
		ExplicitWait_ElementToBeClickable("//XCUIElementTypeApplication[@name=\"Commusoft\"]/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeSwitch");
		click("//XCUIElementTypeApplication[@name=\"Commusoft\"]/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeSwitch");
		Thread.sleep(2000);
		click("//XCUIElementTypeButton[@name=\"Save\"]");
		ExplicitWait_ElementToBeClickable("//XCUIElementTypeButton[1]");
		Thread.sleep(5000);
		kdriver.terminateApp("com.commusoft.commusoftv2");
		kdriver.activateApp("com.commusoft.commusoftv2");
		Thread.sleep(5000);
	}
	public void selectdropdownvalue(String xpath, String value) throws InterruptedException
	{
		if(xpath.contains("#"))
		{
			xpath = xpath.replace("#", "");
			Select sc = new Select(kdriver.findElement(By.id(xpath)));
			sc.selectByValue(value);
		}else
			if(xpath.contains("$"))
			{
				xpath = xpath.replace("$", "");
				Select sc = new Select(kdriver.findElement(By.name(xpath)));
				sc.selectByValue(value);
			}else
			{
				Select fcc = new Select(kdriver.findElement(By.xpath(xpath)));
				fcc.selectByValue(value);
			}

		Thread.sleep(3000);
	}

	public void Assertion(String ER , String AR, String R)
	{
		Assert.assertEquals(AR, ER,R);
	}

	public String gettext(String xpath)
	{
		{
			if(xpath.contains("$"))
			{
				xpath = xpath.replace("$", "");
				return kdriver.findElement(By.name(xpath)).getText();


			}
			else if(xpath.contains("#"))
			{
				xpath = xpath.replace("#", "");
				return kdriver.findElement(By.id(xpath)).getText(); 

			}
			else if(xpath.contains("~"))
			{
				xpath = xpath.replace("~", "");
				return kdriver.findElement(By.className(xpath)).getText();

			}
			else
			{

				// xpath = xpath.replace("//", "");
				return kdriver.findElement(By.xpath(xpath)).getText();

			}
		}
	}

















	public void isdisplayed(String xpath)
	{
		{
			if(xpath.contains("$"))
			{
				xpath = xpath.replace("$", "");
				kdriver.findElement(By.name(xpath)).isDisplayed();


			}
			else if(xpath.contains("#"))
			{
				xpath = xpath.replace("#", "");
				kdriver.findElement(By.id(xpath)).isDisplayed(); 

			}
			else if(xpath.contains("~"))
			{
				xpath = xpath.replace("~", "");
				kdriver.findElement(By.className(xpath)).isDisplayed();

			}
			else
			{

				// xpath = xpath.replace("//", "");
				kdriver.findElement(By.xpath(xpath)).isDisplayed();

			}
		}
	}
	public void isenabled(String xpath)
	{
		{
			if(xpath.contains("$"))
			{
				xpath = xpath.replace("$", "");
				kdriver.findElement(By.name(xpath)).isEnabled();


			}
			else if(xpath.contains("#"))
			{
				xpath = xpath.replace("#", "");
				kdriver.findElement(By.id(xpath)).isEnabled(); 

			}
			else if(xpath.contains("."))
			{
				xpath = xpath.replace(".", "");
				kdriver.findElement(By.className(xpath)).isEnabled();

			}
			else
			{
				// xpath = xpath.replace("//", "");
				kdriver.findElement(By.xpath(xpath)).isEnabled();

			}
		}
	}
	public void typeenter(String xpath)
	{
		{
			if(xpath.contains("$"))
			{
				xpath = xpath.replace("$", "");
				kdriver.findElement(By.name(xpath)).sendKeys(Keys.ENTER);

			}
			else if(xpath.contains("#"))
			{
				xpath = xpath.replace("#", "");
				kdriver.findElement(By.id(xpath)).sendKeys(Keys.ENTER); 

			}
			else if(xpath.contains("~"))
			{
				xpath = xpath.replace("~", "");
				kdriver.findElement(By.className(xpath)).sendKeys(Keys.ENTER);

			}
			else
			{
				//xpath = xpath.replace("//", "");
				kdriver.findElement(By.xpath(xpath)).sendKeys(Keys.ENTER);
			}
		}
	}



	public void MobileEnter() throws InterruptedException
	{
		if(platform==null) {
			Thread.sleep(10);
		}else if(platform.equals("Android")) {
			Thread.sleep(2000);
			kdriver.executeScript("mobile:performEditorAction", ImmutableMap.of("action", "done"));
			Thread.sleep(12000);
		}
	}
	public void dclick(String xpath)
	{
		if(xpath.contains("$"))
		{
			xpath = xpath.replace("$", "");
			Actions actions = new Actions(kdriver);
			MobileElement elementLocator = kdriver.findElement(By.name(xpath));
			actions.doubleClick(elementLocator).perform();

		}
		else if(xpath.contains("#"))
		{
			xpath = xpath.replace("#", "");
			Actions actions = new Actions(kdriver);
			MobileElement elementLocator = kdriver.findElement(By.id(xpath));
			actions.doubleClick(elementLocator).perform(); 
		}
		else if(xpath.contains("~"))
		{
			xpath = xpath.replace("~", "");
			Actions actions = new Actions(kdriver);
			MobileElement elementLocator = kdriver.findElement(By.className(xpath));
			actions.doubleClick(elementLocator).perform();
		}
		else
		{
			//xpath = xpath.replace("//", "");
			Actions actions = new Actions(kdriver);
			MobileElement elementLocator = kdriver.findElement(By.xpath(xpath));
			actions.doubleClick(elementLocator).perform();
		}
	}

	public void scrollDown()
	{
		Dimension dimension = kdriver.manage().window().getSize();
		int scrollStart = (int)(dimension.getHeight()*0.5);
		int scrollEnd = (int)(dimension.getHeight()*0.9);

		new TouchAction((PerformsTouchActions) kdriver)
		.press(PointOption.point(0,scrollStart))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
		.moveTo(PointOption.point(0,scrollEnd))
		.release().perform();
	}
	public void scrolltothetop(int x, int y, int x1, int y1) throws InterruptedException
	{
		Thread.sleep(3000);
		(new TouchAction(kdriver)).press(PointOption.point(x,y))
		.waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
		.moveTo(PointOption.point(x1,y1)).release().perform();
		Thread.sleep(2000);
	}
	public void clickpoint(int Horizontal, int Vertical) throws InterruptedException
	{
		Thread.sleep(3000);
		(new TouchAction(kdriver)).tap(PointOption.point(Horizontal,Vertical)).perform();
		Thread.sleep(2000);

	}

	public enum DIRECTION {
		DOWN, UP, LEFT, RIGHT;
	}
	public void swipe(AppiumDriver<MobileElement> driver, DIRECTION direction) throws InterruptedException {
		//ios 
		Thread.sleep(3000);
		Dimension size = driver.manage().window().getSize();

		int startX = 0;
		int endX = 0;
		int startY = 0;
		int endY = 0;

		switch (direction) {
		case RIGHT:
			startY = (int) (size.height / 2);
			startX = (int) (size.width * 0.90);
			endX = (int) (size.width * 0.05);
			(new TouchAction(driver)).press(PointOption.point(startX,startY))
			.waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
			.moveTo(PointOption.point(endX,startY))
			.release()
			.perform();

			break;

		case LEFT:
			startY = (int) (size.height / 2);
			startX = (int) (size.width * 0.10);
			endX = (int) (size.width * 0.90);
			(new TouchAction(driver))
			.press(PointOption.point(startX,startY))
			.waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
			.moveTo(PointOption.point(endX,startY))
			.release()
			.perform();

			break;

		case UP:
			endY = (int) (size.height * 0.70);
			startY = (int) (size.height * 0.30);
			startX = (size.width / 2);
			(new TouchAction(driver))
			.press(PointOption.point(startX,startY))
			.waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
			.moveTo(PointOption.point(endX,startY))
			.release()
			.perform();

			break;


		case DOWN:
			startY = (int) (size.height * 0.70);
			endY = (int) (size.height * 0.30);
			startX = (size.width / 2);
			(new TouchAction(driver))
			.press(PointOption.point(startX,startY))
			.waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
			.moveTo(PointOption.point(endX,startY))
			.release()
			.perform();


			break;

		}
	}
	public void Savebtn() throws InterruptedException
	{
		Thread.sleep(2000);
		click("//android.widget.TextView[@content-desc=\"Save\"]");
		Thread.sleep(2000);
	}


	public void signature(int startX, int startY, int endX, int endY) throws InterruptedException
	{

		new TouchAction((AppiumDriver<MobileElement>)(kdriver))
		.press(new PointOption<>().withCoordinates(startX, startY))//startX, startY - 200, 1300
		.moveTo(new PointOption<>().withCoordinates(endX, endY))//endX, endY - 500, 900
		.moveTo(new PointOption<>().withCoordinates(endX+50, endY+50))
		.release()
		.perform();
		Thread.sleep(2000);
	}
	public void Ongoing_EstimateNo() throws InterruptedException
	{
		String EstimateNo = gettext("#com.commusoft.v4:id/typenoValue");
		Thread.sleep(3000);
		click("//android.widget.TextView[@text='"+EstimateNo+"']");
	}


	public void swipeScreeniOS(DIRECTION right) {
		System.out.println("swipeScreen(): dir: '" + right + "'"); // always log your actions

		// Animation default time:
		//  - Android: 300 ms
		//  - iOS: 200 ms
		// final value depends on your app and could be greater
		final int ANIMATION_TIME = 200; // ms

		final int PRESS_TIME = 200; // ms

		int edgeBorder = 10; // better avoid edges
		PointOption pointOptionStart, pointOptionEnd;

		// init screen variables
		Dimension dims = kdriver.manage().window().getSize();

		// init start point = center of screen
		pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);

		switch (right) {
		case DOWN: // center of footer
			pointOptionEnd = PointOption.point(dims.width / 2, dims.height - edgeBorder);
			break;
		case UP: // center of header
			pointOptionEnd = PointOption.point(dims.width / 2, edgeBorder);
			break;
		case LEFT: // center of left side
			pointOptionEnd = PointOption.point(edgeBorder, dims.height / 2);
			break;
		case RIGHT: // center of right side
			pointOptionEnd = PointOption.point(dims.width - edgeBorder, dims.height / 2);
			break;
		default:
			throw new IllegalArgumentException("swipeScreen(): dir: '" + right + "' NOT supported");
		}

		// execute swipe using TouchAction
		try {
			new TouchAction(kdriver)
			.press(pointOptionStart)
			// a bit more reliable when we add small wait
			.waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
			.moveTo(pointOptionEnd)
			.release().perform();
		} catch (Exception e) {
			System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
			return;
		}

		// always allow swipe action to complete
		try {
			Thread.sleep(ANIMATION_TIME);
		} catch (InterruptedException e) {
			// ignore
		}
	}




















	public void slackMessageCommusoft(String text) throws IOException, InterruptedException
	{
		URL url = new URL("https://hooks.slack.com/services/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");
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		http.setRequestMethod("POST");
		http.setDoOutput(true);
		http.setRequestProperty("Content-type", "application/json");

		Date today = new Date();
		SimpleDateFormat  DATE_FORMAT = new SimpleDateFormat("dd MMMM yyyy");
		String date = DATE_FORMAT.format(today);
		String data = "{\"text\":\""+text+"\"}";


		byte[] out = data.getBytes(StandardCharsets.UTF_8);

		OutputStream stream = http.getOutputStream();
		stream.write(out);
		System.out.println(http.getResponseCode() + " " + http.getResponseMessage());
		http.disconnect();

	}



	public void slackAndroid() throws IOException, InterruptedException
	{
		URL url = new URL("https://hooks.slack.com/services/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");
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		http.setRequestMethod("POST");
		http.setDoOutput(true);
		http.setRequestProperty("Content-type", "application/json");

		Date today = new Date();
		SimpleDateFormat  DATE_FORMAT = new SimpleDateFormat("dd MMMM yyyy");
		String date = DATE_FORMAT.format(today);
		String data = "{\r\n"
				+ "	\"attachments\": [\r\n"
				+ "		{\r\n"
				+ "			\"color\": \"#f2c744\",\r\n"
				+ "			\"blocks\": [\r\n"
				+ "				{\r\n"
				+ "					\"type\": \"section\",\r\n"
				+ "					\"text\": {\r\n"
				+ "						\"type\": \"mrkdwn\",\r\n"
				+ "						\"text\": \"New Kick-start in Automation:\\n*<https://www.commusoft.co.uk/|Commusoft-Automation Script Started>*\"\r\n"
				+ "					}\r\n"
				+ "				},\r\n"
				+ "				{\r\n"
				+ "					\"type\": \"section\",\r\n"
				+ "					\"fields\": [\r\n"
				+ "						{\r\n"
				+ "							\"type\": \"mrkdwn\",\r\n"
				+ "							\"text\": \"*Started By:*\\nKarnan Athisivam\"\r\n"
				+ "						},\r\n"
				+ "						{\r\n"
				+ "							\"type\": \"mrkdwn\",\r\n"
				+ "							\"text\": \"*Automation:*\\nMobile\"\r\n"
				+ "						},\r\n"
				+ "						{\r\n"
				+ "							\"type\": \"mrkdwn\",\r\n"
				+ "							\"text\": \"*Date:*\\n"+date+"\"\r\n"
				+ "						},\r\n"
				+ "						{\r\n"
				+ "							\"type\": \"mrkdwn\",\r\n"
				+ "							\"text\": \"*Platform:*\\n"+"Android"+"\"\r\n"
				+ "						}\r\n"
				+ "					]\r\n"
				+ "				}\r\n"
				+ "			]\r\n"
				+ "		}\r\n"
				+ "	]\r\n"
				+ "}";


		byte[] out = data.getBytes(StandardCharsets.UTF_8);

		OutputStream stream = http.getOutputStream();
		stream.write(out);
		System.out.println(http.getResponseCode() + " " + http.getResponseMessage());
		http.disconnect();

	}
	public void slackiOS() throws IOException, InterruptedException
	{
		URL url = new URL("https://hooks.slack.com/services/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");
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		http.setRequestMethod("POST");
		http.setDoOutput(true);
		http.setRequestProperty("Content-type", "application/json");

		Date today = new Date();
		SimpleDateFormat  DATE_FORMAT = new SimpleDateFormat("dd MMMM yyyy");
		String date = DATE_FORMAT.format(today);
		String data = "{\r\n"
				+ "	\"attachments\": [\r\n"
				+ "		{\r\n"
				+ "			\"color\": \"#6ff244\",\r\n"
				+ "			\"blocks\": [\r\n"
				+ "				{\r\n"
				+ "					\"type\": \"section\",\r\n"
				+ "					\"text\": {\r\n"
				+ "						\"type\": \"mrkdwn\",\r\n"
				+ "						\"text\": \"New Kick-start in Automation:\\n*<https://www.commusoft.co.uk/|Commusoft-Automation Script Started>*\"\r\n"
				+ "					}\r\n"
				+ "				},\r\n"
				+ "				{\r\n"
				+ "					\"type\": \"section\",\r\n"
				+ "					\"fields\": [\r\n"
				+ "						{\r\n"
				+ "							\"type\": \"mrkdwn\",\r\n"
				+ "							\"text\": \"*Started By:*\\nKarnan Athisivam\"\r\n"
				+ "						},\r\n"
				+ "						{\r\n"
				+ "							\"type\": \"mrkdwn\",\r\n"
				+ "							\"text\": \"*Automation:*\\nMobile\"\r\n"
				+ "						},\r\n"
				+ "						{\r\n"
				+ "							\"type\": \"mrkdwn\",\r\n"
				+ "							\"text\": \"*Date:*\\n"+date+"\"\r\n"
				+ "						},\r\n"
				+ "						{\r\n"
				+ "							\"type\": \"mrkdwn\",\r\n"
				+ "							\"text\": \"*Platform:*\\n"+"iOS"+"\"\r\n"
				+ "						}\r\n"
				+ "					]\r\n"
				+ "				}\r\n"
				+ "			]\r\n"
				+ "		}\r\n"
				+ "	]\r\n"
				+ "}";

		byte[] out = data.getBytes(StandardCharsets.UTF_8);

		OutputStream stream = http.getOutputStream();
		stream.write(out);

		System.out.println(http.getResponseCode() + " " + http.getResponseMessage());
		http.disconnect();

	}
	public void AndroidScriptEnd() throws IOException, InterruptedException
	{
		URL url = new URL("https://hooks.slack.com/services/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");
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		http.setRequestMethod("POST");
		http.setDoOutput(true);
		http.setRequestProperty("Content-type", "application/json");

		Date today = new Date();
		SimpleDateFormat  DATE_FORMAT = new SimpleDateFormat("dd MMMM yyyy");
		String date = DATE_FORMAT.format(today);
		String data = "{\r\n"
				+ "	\"attachments\": [\r\n"
				+ "		{\r\n"
				+ "			\"blocks\": [\r\n"
				+ "				{\r\n"
				+ "					\"type\": \"section\",\r\n"
				+ "					\"text\": {\r\n"
				+ "						\"type\": \"mrkdwn\",\r\n"
				+ "						\"text\": \"Automation Status:\\n*<https://app.commusoft.co.uk/|Script Completed>*\"\r\n"
				+ "					}\r\n"
				+ "				},\r\n"
				+ "				{\r\n"
				+ "					\"type\": \"section\",\r\n"
				+ "					\"fields\": [\r\n"
				+ "						{\r\n"
				+ "							\"type\": \"mrkdwn\",\r\n"
				+ "							\"text\": \"*Completed By:*\\nKarnan Athisivam\"\r\n"
				+ "						},\r\n"
				+ "						{\r\n"
				+ "							\"type\": \"mrkdwn\",\r\n"
				+ "							\"text\": \"*Automation:*\\nMobile\"\r\n"
				+ "						},\r\n"
				+ "						{\r\n"
				+ "							\"type\": \"mrkdwn\",\r\n"
				+ "							\"text\": \"*Date:*\\n"+date+"\"\r\n"
				+ "						},\r\n"
				+ "						{\r\n"
				+ "							\"type\": \"mrkdwn\",\r\n"
				+ "							\"text\": \"*Platform:*\\nAndroid\"\r\n"
				+ "						}\r\n"
				+ "					]\r\n"
				+ "				}\r\n"
				+ "			]\r\n"
				+ "		}\r\n"
				+ "	]\r\n"
				+ "}";

		byte[] out = data.getBytes(StandardCharsets.UTF_8);

		OutputStream stream = http.getOutputStream();
		stream.write(out);

		System.out.println(http.getResponseCode() + " " + http.getResponseMessage());
		http.disconnect();

	}
	public void iOSScriptEnd() throws IOException, InterruptedException
	{
		URL url = new URL("https://hooks.slack.com/services/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");
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		http.setRequestMethod("POST");
		http.setDoOutput(true);
		http.setRequestProperty("Content-type", "application/json");

		Date today = new Date();
		SimpleDateFormat  DATE_FORMAT = new SimpleDateFormat("dd MMMM yyyy");
		String date = DATE_FORMAT.format(today);
		String data = "{\r\n"
				+ "	\"attachments\": [\r\n"
				+ "		{\r\n"
				+ "			\"blocks\": [\r\n"
				+ "				{\r\n"
				+ "					\"type\": \"section\",\r\n"
				+ "					\"text\": {\r\n"
				+ "						\"type\": \"mrkdwn\",\r\n"
				+ "						\"text\": \"Automation Status:\\n*<https://app.commusoft.co.uk/|Script Completed>*\"\r\n"
				+ "					}\r\n"
				+ "				},\r\n"
				+ "				{\r\n"
				+ "					\"type\": \"section\",\r\n"
				+ "					\"fields\": [\r\n"
				+ "						{\r\n"
				+ "							\"type\": \"mrkdwn\",\r\n"
				+ "							\"text\": \"*Completed By:*\\nKarnan Athisivam\"\r\n"
				+ "						},\r\n"
				+ "						{\r\n"
				+ "							\"type\": \"mrkdwn\",\r\n"
				+ "							\"text\": \"*Automation:*\\nMobile\"\r\n"
				+ "						},\r\n"
				+ "						{\r\n"
				+ "							\"type\": \"mrkdwn\",\r\n"
				+ "							\"text\": \"*Date:*\\n"+date+"\"\r\n"
				+ "						},\r\n"
				+ "						{\r\n"
				+ "							\"type\": \"mrkdwn\",\r\n"
				+ "							\"text\": \"*Platform:*\\niOS\"\r\n"
				+ "						}\r\n"
				+ "					]\r\n"
				+ "				}\r\n"
				+ "			]\r\n"
				+ "		}\r\n"
				+ "	]\r\n"
				+ "}";

		byte[] out = data.getBytes(StandardCharsets.UTF_8);

		OutputStream stream = http.getOutputStream();
		stream.write(out);

		System.out.println(http.getResponseCode() + " " + http.getResponseMessage());
		http.disconnect();

	}
	public void Switch_New_Old_UI() 
	{
		try {
			if(kdriver.findElement(By.xpath("*//XCUIElementTypeOther[1]/XCUIElementTypeButton[4]")).isDisplayed())
			{
				//Old to new
				Customer customer = new Customer(kdriver, line);
				customer.Side_Menu();
				scrollToIOSElement("//XCUIElementTypeStaticText[@name=\"Commusoft Labs\"]");
				click("//XCUIElementTypeStaticText[@name=\"Commusoft Labs\"]");
				ExplicitWait_ElementToBeClickable("*//XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeSwitch");
				click("*//XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeSwitch");
				click("//XCUIElementTypeButton[@name=\"Save\"]");
				kdriver.terminateApp("com.commusoft.commusoftv2");
				kdriver.launchApp();
			}
		} catch (Exception e) {
			//New to Old
			ExplicitWait_ElementToBeClickable("//XCUIElementTypeNavigationBar[@name=\"CommusoftV2.CSHomeTabbedView\"]/XCUIElementTypeButton");
			click("//XCUIElementTypeNavigationBar[@name=\"CommusoftV2.CSHomeTabbedView\"]/XCUIElementTypeButton");
			ExplicitWait_ElementToBeClickable("//XCUIElementTypeStaticText[@name=\"Labs\"]");
			click("//XCUIElementTypeStaticText[@name=\"Labs\"]");
			ExplicitWait_ElementToBeClickable("*//XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeSwitch");
			click("*//XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeSwitch");
			ExplicitWait_ElementToBeClickable("//XCUIElementTypeButton[@name=\"Save\"]");
			click("//XCUIElementTypeButton[@name=\"Save\"]");
			kdriver.terminateApp("com.commusoft.commusoftv2");
			kdriver.launchApp();
		}
	}












	public void EMAIL()
	{

		String to = "aaaadhsugsbballzyvzcus6c3i@commusoft.slack.com"; // recipient's email address
	      final String from = "magicalautomation@gmail.com"; // sender's email address
	      String host = "smtp.gmail.com"; // Gmail SMTP server
	      final String password = "magicalautomation2022"; // Gmail account password

	      Properties properties = System.getProperties();
	      properties.put("mail.smtp.host", host);
	      properties.put("mail.smtp.port", "586");
	      properties.put("mail.smtp.auth", "true");
	      properties.put("mail.smtp.starttls.enable", "true");

	      // Create a session with the Gmail SMTP server
	      Session session = Session.getInstance(properties,
	         new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	               return new PasswordAuthentication(from, password);
	            }
	         });

	      try {
	         // Create a MimeMessage object
	         MimeMessage message = new MimeMessage(session);

	         // Set the sender and recipient addresses
	         message.setFrom(new InternetAddress(from));
	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

	         // Set the subject of the email
	         message.setSubject("Test Email with PDF Report");

	         // Create the message body and attachment
	         MimeBodyPart messageBodyPart = new MimeBodyPart();
	         messageBodyPart.setText("This is a test email with a PDF report attached.");

	         MimeBodyPart attachmentBodyPart = new MimeBodyPart();
	         DataSource source = new FileDataSource("./PDFReport/KTestReport.pdf");
	         attachmentBodyPart.setDataHandler(new DataHandler(source));
	         attachmentBodyPart.setFileName("./PDFReport/KTestReport.pdf");

	         // Create a multipart message with the message body and attachment
	         Multipart multipart = new MimeMultipart();
	         multipart.addBodyPart(messageBodyPart);
	         multipart.addBodyPart(attachmentBodyPart);
	         message.setContent(multipart);

	         // Send the email
	         Transport.send(message);
	         System.out.println("Email sent successfully.");
	      } catch (MessagingException mex) {
	         mex.printStackTrace();
	      }

	}





	@FindBy(xpath="//android.widget.TextView[@text='Book event']")
	public WebElement Book_Event;

	@FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Menu opened\"]")
	public MobileElement Menu;


}
