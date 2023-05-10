package action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
import java.util.Date;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import utility.Screenshot;


//karnaested
public class Baseclass extends Wrapper{

	private static PdfPTable table;
	private static PdfWriter writer;
	 private static final String OUTPUT_FOLDER = "./PDFReport/";
	    private static final String FILE_NAME = "KTestReport.pdf";
	    
	    public int passedTestsCount;
	    public int failedTestsCount;
	    public int skippedTestsCount;

	public ExtentReports report;
	public ExtentTest logger;
	public static Document document;
	public Phrase phrase;
	public FileOutputStream fos;


	public static IOSDriver<MobileElement> startAppium_IOS() {
		try {
			
		    DesiredCapabilities capabilities = new DesiredCapabilities();
		    capabilities.setCapability("platformName", "iOS");
		    capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
		    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 13");
		    capabilities.setCapability(MobileCapabilityType.UDID, "9ED55B23-592E-4A5E-9712-0BCE268746CC");
		  //  capabilities.setCapability("useNewWDA", false);
		    capabilities.setCapability("platformVersion", "15.2");
		    capabilities.setCapability("bundleId", "com.commusoft.commusoftv2");
		    //capabilities.setCapability("xcodeOrgId", "55G9JTD8VK");
		    //capabilities.setCapability("xcodeSigningId", "iPhone Developer");
		    capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
//		    capabilities.setCapability("updatedWDABundleId", "com.commusoft.commusoftv2");
		  //  capabilities.setCapability(MobileCapabilityType.APP, "/Users/karnan/Desktop/AUTOMATION/Live_IPA/CommusoftV2.ipa");
			
			
			
			
			
			
			
//			DesiredCapabilities caps = new DesiredCapabilities();
//			caps.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
//			caps.setCapability(MobileCapabilityType.APPLICATION_NAME, "Commusoft");
//			caps.setCapability(MobileCapabilityType.UDID, "d7cbb47d9598a870094d7cd584a35339217a4b09");
//			caps.setCapability(CapabilityType.BROWSER_NAME, "");
//			caps.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.commusoft.commusoftv2");
//			caps.setCapability(MobileCapabilityType.NO_RESET, true);
//			caps.setCapability(MobileCapabilityType.APPLICATION_NAME, "Commusoft");
//			caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 10000);
//			caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");

			kdriver = new IOSDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
			//kdriver = new IOSDriver<MobileElement>((dev), caps, "Commusoft_iOS",ReportType.CLOUD_AND_LOCAL);
			document = new Document();
            writer = PdfWriter.getInstance(document, new FileOutputStream(OUTPUT_FOLDER + FILE_NAME));
            document.open();
            Paragraph paragraph = new Paragraph("TEST RESULTS.");
            paragraph.setFont(FontFactory.getFont(FontFactory.HELVETICA_BOLD));
            document.add(paragraph);
           
            
            Paragraph spacing = new Paragraph();
            spacing.setSpacingAfter(8f);
            document.add(spacing);
            PdfContentByte canvas1 = writer.getDirectContentUnder();
            canvas1.saveState();
            canvas1.setColorFill(BaseColor.LIGHT_GRAY);
            canvas1.rectangle(0, 0, 595, 842);
            canvas1.fill();
            canvas1.restoreState();
            
            Paragraph platform = new Paragraph();
            platform.add("Platform : iOS");
            document.add(platform);
            
            Paragraph RanBy = new Paragraph();
            RanBy.add("Ran By : Karnan Athisivam");
            document.add(RanBy);
            
            Paragraph StartedAt = new Paragraph();
            LocalTime currentTime = LocalTime.now();
            StartedAt.add("Started At : "+currentTime);
            document.add(StartedAt);
            
            
            Image logo = Image.getInstance("/Users/karnan/Desktop/AUTOMATION/Commusoft/Mobile_Automation/PDFReport/CommusoftLogo.png");
            logo.setAbsolutePosition(document.right() - logo.getScaledWidth(), document.top() - logo.getScaledHeight());
            PdfContentByte canvas = writer.getDirectContent();
            canvas.addImage(logo);
            
            
            spacing.setSpacingAfter(20f);
            document.add(spacing);
           

            
 
            table = new PdfPTable(new float[] { 1, 1, 1, 1, 1 });
            table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);

            
//            PdfPCell image = new PdfPCell();
//            table.addCell(image);
            
            table.addCell("Test Case Name");
            table.addCell("Test Description");
            table.addCell("Status");
            //table.addCell("Screenshot");
            table.addCell("Start Time");
            table.addCell("End Time");
			
		}catch (Exception e) {
		}
		return (IOSDriver<MobileElement>) kdriver;
	}

	public static AndroidDriver<MobileElement> startAppium_Android() {
		try {
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			//caps.setCapability(MobileCapabilityType.VERSION, "9");
			//caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Star_Android");
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi");
			//caps.setCapability(MobileCapabilityType.UDID, "ZF62248MWJ"); 
			caps.setCapability(MobileCapabilityType.UDID, "jrd6hmy5mzhihihu");
			//caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
			caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 10000);
			//caps.setCapability(MobileCapabilityType.NO_RESET, true);
			caps.setCapability(MobileCapabilityType.APPLICATION_NAME, "Commusoft");
			//caps.setCapability("ApplicationName", "Commusoft");
			//caps.setCapability("appWaitForLaunch", true);
			caps.setCapability("appPackage", "com.commusoft.v4");
			caps.setCapability("appActivity", "com.commusoft.v4.Setup.Activities.SplashScreen");
			kdriver = new IOSDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
			//kdriver = new AndroidDriver<MobileElement>((dev), caps, "Commusoft_Android",ReportType.CLOUD_AND_LOCAL);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		//Returning the instance of the driver to the parent method
		return (AndroidDriver<MobileElement>) kdriver;
	}

	@BeforeSuite(alwaysRun = true)
	public void initial() throws IOException
	{

		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File("./Reports/Mobile_SmokeTest_Result.html"));
		report = new ExtentReports();
		report.attachReporter(extent);
		logger = report.createTest("Mobile Smoke Test");
		

	}

	@BeforeTest(alwaysRun = true)
	public void LaunchDevice() throws IOException, InterruptedException {
//		try {

//			String cmd = "adb.exe -s jrd6hmy5mzhihihu shell getprop net.bt.name";
//			Runtime run = Runtime.getRuntime();
//			Process pr = run.exec(cmd);
//			pr.waitFor();
//			BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
//			line = "";
//			
//			line=buf.readLine();
//			System.out.println("device name:"+buf.readLine());
			
			
			
//			kdriver = startAppium_Android();
//			slackAndroid();
//			
			kdriver = startAppium_IOS();
			//slackiOS();
			
			
			
			
			//for Linux
//			line = "iOS";
//
//			if(line.equalsIgnoreCase("Android")) {
//
//				kdriver = startAppium_Android();
//				//Sysout("Android Automation Kick-Started");
//				slackAndroid();
//			}
//
//		}catch (Exception e) {
//			kdriver = startAppium_IOS();
//			//Sysout("iOS Automation Kick-Started");
//			slackiOS();
//		}



	}



	




	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException, InterruptedException, DocumentException
	{
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.log(Status.PASS, "Method Been Executed Sucessfully:-" +result.getName());
			System.out.println( "Method Been Executed Sucessfully:-" +result.getName());
			addTestResultToTable(result.getName(), result.getMethod().getDescription(), "PASS", result.getStartMillis(),
	                result.getEndMillis());
			
			passedTestsCount++;

		}else 
			if(ITestResult.FAILURE==result.getStatus())
			{
				logger.log(Status.FAIL, "Method Been Failed:-" +result.getName());
				logger.fail("Test Failed :- " +result.getName(), MediaEntityBuilder.createScreenCaptureFromPath(Screenshot.capture(kdriver)).build());
				System.out.println( "Method Fail:-" +result.getName());
				addTestResultToTable(result.getName(), result.getMethod().getDescription(), "FAIL", result.getStartMillis(),
		                result.getEndMillis());
				failedTestsCount++;

			}else
			{
				logger.log(Status.SKIP, "Method been Skiped");
				logger.skip(result.getThrowable());
				System.out.println("Method Been Executed Successfully:"+result.getThrowable());
				addTestResultToTable(result.getName(), result.getMethod().getDescription(), "SKIPPED", result.getStartMillis(),
		                result.getEndMillis());
				skippedTestsCount++;


			}

	}
	@AfterSuite
	public void tearDown() throws IOException, InterruptedException, DocumentException{

//		String cmd = "adb.exe -s jrd6hmy5mzhihihu shell getprop net.bt.name";
//		Runtime run = Runtime.getRuntime();
//		Process pr = run.exec(cmd);
//		pr.waitFor();
//		BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
//		line = "";
//		
//		line=buf.readLine();
		
		//for lilnux
//		line="iOS";
//		
//		if(line.equalsIgnoreCase("Android")) {
//
//			AndroidScriptEnd();
//		}
//
//	else {
//		iOSScriptEnd();
//	}
		

//		document.close();
	

		int total = passedTestsCount+failedTestsCount+skippedTestsCount;
		System.out.println(passedTestsCount);
		System.out.println(failedTestsCount);
		System.out.println(skippedTestsCount);
		System.out.println(total);
	
		
		 document.add(table);
         document.close();
         writer.close();
		report.flush();
		
		
		
		EMAIL();
		kdriver.close();

	}
	
	
	
	
	
	
	
	
	
	
	private void addTestResultToTable(String testName, String testDescription, String status, long startTime,
            long endTime) {
        table.addCell(testName);
        table.addCell(testDescription);
        table.addCell(status);
        table.addCell(new Date(startTime).toString());
        table.addCell(new Date(endTime).toString());
    }
	

}
