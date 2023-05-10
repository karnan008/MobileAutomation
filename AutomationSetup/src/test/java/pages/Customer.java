package pages;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;

import action.Wrapper;
import action.Wrapper.DIRECTION;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender.Size;

public class Customer extends Wrapper{

	public Customer(AppiumDriver<MobileElement> ldriver, String platform)
	{
		this.kdriver = ldriver;

		this.platform=platform;

	}
	public void ScriptEnd() throws InterruptedException, IOException
	{
		if(platform==null) {
			iOSScriptEnd();
		}else if(platform.equals("Android")) {
		AndroidScriptEnd();
		}

	}
	public void singleclickpoint(int Horizontal, int Vertical) throws InterruptedException
	{
		if(platform==null) {
			
		}else if(platform.equals("Android")) {
		Thread.sleep(3000);
		(new TouchAction(kdriver)).tap(PointOption.point(Horizontal,Vertical)).perform();
		Thread.sleep(1000);
		}

	}
	public void scrolltothetop(int x, int y, int x1, int y1) throws InterruptedException
	{
		if(platform==null) {
			
		}else if(platform.equals("Android")) {
		Thread.sleep(3000);
		(new TouchAction(kdriver)).press(PointOption.point(x,y))
		.waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
		.moveTo(PointOption.point(x1,y1)).release().perform();
		Thread.sleep(2000);
		}
	}
	public void doubleclickpoint(int Horizontal, int Vertical) throws InterruptedException
	{
		if(platform==null) {
			
		}else if(platform.equals("Android")) {
		Thread.sleep(3000);
		(new TouchAction(kdriver)).tap(PointOption.point(Horizontal,Vertical)).perform();
		Thread.sleep(1000);
		(new TouchAction(kdriver)).tap(PointOption.point(Horizontal,Vertical)).perform();
		Thread.sleep(2000);
		}
	}
	public void Side_Menu() throws InterruptedException
	{
		if(platform==null) {
			Thread.sleep(3000);
			ExplicitWait_ElementToBeClickable("//XCUIElementTypeButton[1]");
			click("//XCUIElementTypeButton[1]");	
			
		}else if(platform.equals("Android")){
			Thread.sleep(4000);
			click("//android.widget.ImageButton[@content-desc=\"Menu opened\"]");
			Thread.sleep(2000);
		}	
	}
	public void CustomerType_Dropdown() throws InterruptedException 
	{
		if(platform==null) {
			ExplicitWait_ElementToBeClickable("//XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther");
			click("//XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther");
			
		}else if(platform.equals("Android")){
			Thread.sleep(10);
		}
	}
	public void Customer_Type(String type) throws InterruptedException
	{
		if(platform==null) {
			ExplicitWait_ElementToBeClickable("//XCUIElementTypePickerWheel");
			type("//XCUIElementTypePickerWheel", type);
			click("//XCUIElementTypeStaticText[@name='Done']");
			
		}else if(platform.equals("Android")){
			Thread.sleep(10);
		}
	}
	public void Title_dropdown() throws InterruptedException
	{
		if(platform==null) {
			ExplicitWait_ElementToBeClickable("//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther");
			click("//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther");
			
		}else if(platform.equals("Android")){
			Thread.sleep(10);
		}
	}
	public void Diary_Today() throws InterruptedException 
	{
		if(platform==null) {
		Thread.sleep(5000);
		click("//XCUIElementTypeButton[3]");
		Thread.sleep(8000); 
		}else if(platform.equals("Android")) {
			Thread.sleep(2000);
			click("//android.widget.TextView[@text=\"View Diary\"]");
			Thread.sleep(1000);
			click("#com.commusoft.v4:id/action_today");
		}
	}
	public void Diary_Plus() throws InterruptedException 
	{
		if(platform==null) {
		Thread.sleep(5000);
		click("//XCUIElementTypeButton[4]");
		Thread.sleep(8000); 
		}else if(platform.equals("Android")) {
			Thread.sleep(10);
		}
	}
	public void Book_Event() throws InterruptedException
	{
		if(platform==null) {
			Thread.sleep(10);
		}else if(platform.equals("Android")) {
		Thread.sleep(2000);
		click("//android.widget.TextView[@text=\"Book event\"]");
		}
	}
	public void SwipetoMain() throws InterruptedException
	{
		if(platform==null) {
			swipeScreeniOS(DIRECTION.RIGHT);
			swipeScreeniOS(DIRECTION.LEFT);
		}else if(platform.equals("Android")) {
		swipe(kdriver, DIRECTION.LEFT);
		swipe(kdriver, DIRECTION.RIGHT);
		}
	}
	public void Add_Customer() throws InterruptedException
	{
		if(platform==null) {
			
			scrollToIOSElement("//XCUIElementTypeStaticText[@name='Add Customer']");
			ExplicitWait_VisibilityOfEle("//XCUIElementTypeStaticText[@name='Add Customer']");
			click("//XCUIElementTypeStaticText[@name='Add Customer']");
			//click("//XCUIElementTypeCell[5]/XCUIElementTypeOther/XCUIElementTypeOther");
		}else if(platform.equals("Android")){
			Thread.sleep(10);
		}
	}
	public void Private_Customer() throws InterruptedException
	{
		if(platform==null) {
			Thread.sleep(10);
		}else if(platform.equals("Android")){
			click("//android.widget.TextView[@text='New Private Customer']");//live
			//click("//android.widget.TextView[@text='New Private customer']");//stage
		}
	}
	public void Customer_title(String title) throws InterruptedException
	{
		if(platform==null) {
			ExplicitWait_ElementToBeClickable("//XCUIElementTypePickerWheel");
			type("//XCUIElementTypePickerWheel",title);
			click("//XCUIElementTypeStaticText[@name='Done']");
			
		}else if(platform.equals("Android")){
			Thread.sleep(2000);
			click("#com.commusoft.v4:id/spinnerTitle");
			Thread.sleep(2000);
			click("//android.widget.TextView[@text='"+title+"']");
		}

	}
	public void Customer_Name()
	{
		type("#com.commusoft.v4:id/firstNameValue", "Appium");
	}
	public void Customer_Name(String name)
	{
		type("#com.commusoft.v4:id/firstNameValue",name );
	}
	public void Customer_SurName(String name) throws InterruptedException
	{
		if(platform==null) {
			ExplicitWait_PresenceOfEle("//XCUIElementTypeOther[1]/XCUIElementTypeOther[3]/XCUIElementTypeTextField");
			type("//XCUIElementTypeOther[1]/XCUIElementTypeOther[3]/XCUIElementTypeTextField",name);
			
		}else if(platform.equals("Android")){
			Thread.sleep(2000);
			type("#com.commusoft.v4:id/surnameValue", name);
		}
	}
	public void Customer_Telephone(String number) throws InterruptedException
	{
		if(platform==null) {
			ExplicitWait_PresenceOfEle("//XCUIElementTypeOther[1]/XCUIElementTypeOther[4]/XCUIElementTypeTextField");
			type("//XCUIElementTypeOther[1]/XCUIElementTypeOther[4]/XCUIElementTypeTextField",number);
			
		}else if(platform.equals("Android")){
			type("#com.commusoft.v4:id/telephoneValue", number);	
		}
	}
	public void Customer_Mobile(String number) throws InterruptedException
	{
		if(platform==null) {
			ExplicitWait_PresenceOfEle("//XCUIElementTypeOther[5]/XCUIElementTypeTextField");
			type("//XCUIElementTypeOther[5]/XCUIElementTypeTextField",number);
			
		}else if(platform.equals("Android")){
			type("#com.commusoft.v4:id/mobileValue", number);
		}
	}
	public void Customer_email(String email) throws InterruptedException
	{
		if(platform==null) {
			ExplicitWait_PresenceOfEle("//XCUIElementTypeOther[1]/XCUIElementTypeOther[6]/XCUIElementTypeTextField");
			type("//XCUIElementTypeOther[1]/XCUIElementTypeOther[6]/XCUIElementTypeTextField",email);
			
		}else if(platform.equals("Android")){
			type("#com.commusoft.v4:id/emailAddress", email);
		}
	}
	public void Customer_AddressLine1(String address) throws InterruptedException
	{
		if(platform==null) {
			ExplicitWait_PresenceOfEle("//XCUIElementTypeOther[1]/XCUIElementTypeTextField");
			type("//XCUIElementTypeOther[1]/XCUIElementTypeTextField",address);
			
		}else if(platform.equals("Android")){
			type("#com.commusoft.v4:id/formaddressLine1", address);
		}
	}
	public void Customer_AddressLine2(String address) throws InterruptedException
	{
		if(platform==null) {
			ExplicitWait_PresenceOfEle("//XCUIElementTypeOther[2]/XCUIElementTypeOther[3]/XCUIElementTypeTextField");
			type("//XCUIElementTypeOther[2]/XCUIElementTypeOther[3]/XCUIElementTypeTextField", address);
			
		}else if(platform.equals("Android")){
			
		}
	}
	public void Customer_AddressTown(String address) throws InterruptedException
	{
		if(platform==null) {
			ExplicitWait_PresenceOfEle("//XCUIElementTypeOther[2]/XCUIElementTypeOther[4]/XCUIElementTypeTextField");
			type("//XCUIElementTypeOther[2]/XCUIElementTypeOther[4]/XCUIElementTypeTextField", address);
			
		}else if(platform.equals("Android")){
			
		}
	}
	public void Customer_postalCode(String address) throws InterruptedException
	{
		if(platform==null) {
			ExplicitWait_PresenceOfEle("//XCUIElementTypeOther[2]/XCUIElementTypeOther[7]/XCUIElementTypeTextField");
			type("//XCUIElementTypeOther[2]/XCUIElementTypeOther[7]/XCUIElementTypeTextField", address);
			
		}else if(platform.equals("Android")){
			
		}
	}
	public void Customer_Save() throws InterruptedException
	{
		if(platform==null) {
			ExplicitWait_PresenceOfEle("//XCUIElementTypeButton[@name='Save']");
			click("//XCUIElementTypeButton[@name='Save']");
			
		}else if(platform.equals("Android")){
			click("//android.widget.TextView[@content-desc=\"Save\"]");
			Thread.sleep(4000);
		}		
	}
	public void NameValidation() throws InterruptedException
	{
		if(platform==null) {
			ExplicitWait_VisibilityOfEle("//XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[2]");
			String CusNam = gettext("//XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[2]");
			assertEquals(TitleCustomerName, CusNam, "Fine");
			
		}else if(platform.equals("Android")){
			
		}		
	}
	public void ContactNameValidation() throws InterruptedException
	{
		if(platform==null) {
			Thread.sleep(3000);
			ExplicitWait_VisibilityOfEle("//XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[2]/XCUIElementTypeStaticText[1]");
			String conNam = gettext("//XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[2]/XCUIElementTypeStaticText[1]");
			//assertEquals(Title+""+CustomerContact, conNam, "Fine");
			assertEquals(Title+" "+CustomerContact, conNam);
			
		}else if(platform.equals("Android")){
			
		}		
	}
	public void ReminderValidation(String num) throws InterruptedException
	{
		if(platform==null) {
			ExplicitWait_VisibilityOfEle("//XCUIElementTypeStaticText[@name=\""+num+"\"]");
			String conNam = gettext("//XCUIElementTypeStaticText[@name=\""+num+"\"]");
			//assertEquals(Title+""+CustomerContact, conNam, "Fine");
			assertEquals(num, conNam);
			
		}else if(platform.equals("Android")){
			
		}		
	}
	public void WAValidation(String name) throws InterruptedException
	{
		if(platform==null) {
			ExplicitWait_VisibilityOfEle("//XCUIElementTypeStaticText[@name=\""+name+"\"]");//Mr Karikalan Magesh1 Kumar
			String CusNam = gettext("//XCUIElementTypeStaticText[@name=\""+name+"\"]");
			assertEquals(Title+" "+WAName+" "+SurName, CusNam, "Fine");
			
		}else if(platform.equals("Android")){
			
		}		
	}
	
	public void Reminder_Save() throws InterruptedException
	{
		if(platform==null) {
			ExplicitWait_ElementToBeClickable("//XCUIElementTypeButton[@name='Save']");
			click("//XCUIElementTypeButton[@name='Save']");
			
		}else if(platform.equals("Android")){
			click("//android.widget.TextView[@content-desc=\"Save\"]");
			Thread.sleep(4000);
		}		
	}
	public void Reminder_Back() throws InterruptedException
	{
		if(platform==null) {
		Thread.sleep(2000);
		ExplicitWait_ElementToBeClickable("//XCUIElementTypeButton[@name='Reminders']");
		click("//XCUIElementTypeButton[@name='Reminders']");
		
		}else if(platform.equals("Android")) {
			
		}
	}
	public void EmailSend() throws InterruptedException 
	{
		if(platform==null) {
			ExplicitWait_ElementToBeClickable("//XCUIElementTypeButton[@name='Send']");
			click("//XCUIElementTypeButton[@name='Send']");
			
		}else if(platform.equals("Android")) {
			click("//android.widget.TextView[@content-desc=\"Save\"]");
			Thread.sleep(4000);
		}
	}
	public void Emailselect() throws InterruptedException 
	{
		if(platform==null) {
		ExplicitWait_ElementToBeClickable("//XCUIElementTypeStaticText[2]");
		click("//XCUIElementTypeStaticText[2]");
		
		}else if(platform.equals("Android")) {
			Thread.sleep(10);
		}
	}
	public void EmailDone() throws InterruptedException 
	{
		if(platform==null) {
			ExplicitWait_ElementToBeClickable("//XCUIElementTypeButton[@name='Done']");
			click("//XCUIElementTypeButton[@name='Done']");

		}else if(platform.equals("Android")) {

			click("//android.widget.TextView[@content-desc=\"Save\"]");
			Thread.sleep(4000);
		}
	}
	public void Done() throws InterruptedException 
	{
		if(platform==null) {
		Thread.sleep(2000);
		click("//XCUIElementTypeButton[@name='Done']");
		Thread.sleep(8000); 
		}else if(platform.equals("Android")){
			Thread.sleep(10);
		}
	}
	public void Ongoing_Diary() throws InterruptedException 
	{
		if(platform==null) {
		Thread.sleep(5000);
		click("//XCUIElementTypeSwitch");
		Thread.sleep(8000); 
		}else if(platform.equals("Android")) {
			Thread.sleep(2000);
			click("#com.commusoft.v4:id/bookdiaryeventView");
		}
	}
	public void EmailSubject() throws InterruptedException 
	{
		Thread.sleep(2000);
		type("//XCUIElementTypeOther[6]/XCUIElementTypeTextField","Email Subject");
		Thread.sleep(1000);
	}
	public void CusNum() throws InterruptedException 
	{
		if(platform==null) {
			ExplicitWait_VisibilityOfEle("//XCUIElementTypeOther[5]/XCUIElementTypeStaticText[2]");
			//ExplicitWait_PresenceOfEle("//XCUIElementTypeOther[5]/XCUIElementTypeStaticText[2]");
			//ExplicitWait_VisibilityOfEle("//XCUIElementTypeOther[5]/XCUIElementTypeStaticText[2]");
			CustomerNumber = gettext("//XCUIElementTypeOther[5]/XCUIElementTypeStaticText[2]");
			Thread.sleep(2000); 
			System.out.println(CustomerNumber);
		}else if(platform.equals("Android")){
			Thread.sleep(10);
		}
	}
	public void Menu_Button() throws InterruptedException 
	{
		if(platform==null) {
			Thread.sleep(2000);
			ExplicitWait_ElementToBeClickable("//XCUIElementTypeNavigationBar/XCUIElementTypeButton");
			click("//XCUIElementTypeNavigationBar/XCUIElementTypeButton");
			 
		}else if(platform.equals("Android")){
			Thread.sleep(10);
		}
	}
	public void Menu_ButtonWA() throws InterruptedException 
	{
		if(platform==null) {
			Thread.sleep(2000);
			ExplicitWait_ElementToBeClickable("//XCUIElementTypeStaticText[@name=\"rows\"]");
			click("//XCUIElementTypeStaticText[@name=\"rows\"]");
			 
		}else if(platform.equals("Android")){
			Thread.sleep(10);
		}
	}
	public void Daily() throws InterruptedException 
	{
		if(platform==null) {
			ExplicitWait_PresenceOfEle("//XCUIElementTypeStaticText[@name='Daily']");
			click("//XCUIElementTypeStaticText[@name='Daily']");
			
		}else if(platform.equals("Android")){
			Thread.sleep(10);
		}
	}
	public void Customer_Fav() throws InterruptedException
	{
		if(platform==null) {
			Thread.sleep(10);
		}else if(platform.equals("Android")){
			click("#com.commusoft.v4:id/favoriteIcon");	
		}
	}
	public void Customer_Back() throws InterruptedException
	{
		if(platform==null) {
			Thread.sleep(10);
		}else if(platform.equals("Android")){
			click("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");
		}
	}
	public void Customer_search() throws InterruptedException
	{
		if(platform==null) {
			ExplicitWait_ElementToBeClickable("//XCUIElementTypeStaticText[@name='Search']");
			click("//XCUIElementTypeStaticText[@name='Search']");
			ExplicitWait_VisibilityOfEle("//XCUIElementTypeSearchField[@name='Search']");
			click("//XCUIElementTypeSearchField[@name='Search']");
			
		}else if(platform.equals("Android")) {
			Thread.sleep(2000);
			click("#com.commusoft.v4:id/search_button");
			Thread.sleep(2000);
		}
	}
	public void ClickSearch() throws InterruptedException 
	{
		if(platform==null) {
			ExplicitWait_PresenceOfEle("//XCUIElementTypeSearchField");
			typeenter("//XCUIElementTypeSearchField");
			
		}else if(platform.equals("Android")) {
			Thread.sleep(10);
		}
	}
	public void Customer_Searchtext(String name)
	{
		if(platform==null) {
			ExplicitWait_PresenceOfEle("//XCUIElementTypeSearchField");
			type("//XCUIElementTypeSearchField",name);
		}else if(platform.equals("Android")) {
			type("#com.commusoft.v4:id/search_src_text", name);
		}
	}
	public void Customer_1select(String name) throws InterruptedException
	{
		if(platform==null) {
			Thread.sleep(2000);
			
			ExplicitWait_ElementToBeClickable("(//*[contains(@name,'"+name+"')])[3]");
			click("(//*[contains(@name,'"+name+"')])[3]");
	
		}else if(platform.equals("Android")) {
			Thread.sleep(5000);
			click("//android.widget.TextView[@text='"+name+"']");
			//click("(//android.widget.TextView[@text='"+TitleCustomerName+"'])[1]");
		}
	}
	public void Customer_Edit() throws InterruptedException
	{
		if(platform==null) {
			click("//XCUIElementTypeScrollView/XCUIElementTypeOther[2]");
			
		}else if(platform.equals("Android")) {
			Thread.sleep(3000);
			click("#com.commusoft.v4:id/customerInformation");
			Thread.sleep(3000);
			click("//android.widget.TextView[@content-desc=\"Edit\"]");
			Thread.sleep(3000);
		}
	}
	public void AddressLine2(String name) throws InterruptedException 
	{
		if(platform==null) {
			type("//XCUIElementTypeOther[2]/XCUIElementTypeOther[3]/XCUIElementTypeTextField", name);
			Thread.sleep(2000);
		}else if(platform.equals("Android")) {
			Thread.sleep(10);
		}
	}
	public void Menu_Close() throws InterruptedException
	{
		if(platform==null) {
			Thread.sleep(10);
		}else if(platform.equals("Android")) {
			Thread.sleep(2000);
			click("//android.widget.ImageButton[@content-desc=\"Menu closed\"]");
			Thread.sleep(2000);
		}
	}
	
	public void Wholeback3() throws InterruptedException
	{
		if(platform==null) {
			Thread.sleep(10);
		}else if(platform.equals("Android")) {
			click("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");
			Thread.sleep(3000);
			click("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");
			Thread.sleep(3000);
			click("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");
			Thread.sleep(3000);
		}
	}
	public void Wholeback2() throws InterruptedException
	{
		if(platform==null) {
			Thread.sleep(10);
		}else if(platform.equals("Android")) {
			click("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");
			Thread.sleep(3000);
			click("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");
			Thread.sleep(3000);
		}
	}
	public void Edit_CustomerName(String name) throws InterruptedException
	{
		if(platform==null) {
			
			ExplicitWait_VisibilityOfEle("//XCUIElementTypeOther[1]/XCUIElementTypeOther[3]/XCUIElementTypeTextField");
			clear("//XCUIElementTypeOther[1]/XCUIElementTypeOther[3]/XCUIElementTypeTextField");
			type("//XCUIElementTypeOther[1]/XCUIElementTypeOther[3]/XCUIElementTypeTextField", name);
			
		}else if(platform.equals("Android")) {
			
		}
	}
	public void Edit_telephone(String number) throws InterruptedException
	{
		if(platform==null) {
			ExplicitWait_VisibilityOfEle("//XCUIElementTypeOther[1]/XCUIElementTypeOther[4]/XCUIElementTypeTextField");
			clear("//XCUIElementTypeOther[1]/XCUIElementTypeOther[4]/XCUIElementTypeTextField");
			ExplicitWait_VisibilityOfEle("//XCUIElementTypeOther[1]/XCUIElementTypeOther[4]/XCUIElementTypeTextField");
			type("//XCUIElementTypeOther[1]/XCUIElementTypeOther[4]/XCUIElementTypeTextField",number);
			
		}else if(platform.equals("Android")) {
			clear("#com.commusoft.v4:id/telephoneValue");
			Thread.sleep(3000);
			type("#com.commusoft.v4:id/telephoneValue", "7777777777");
			Thread.sleep(3000);
		}
	}
	public void Edit_mobile(String number) throws InterruptedException
	{
		if(platform==null) {
			ExplicitWait_VisibilityOfEle("//XCUIElementTypeOther[1]/XCUIElementTypeOther[5]/XCUIElementTypeTextField");
			clear("//XCUIElementTypeOther[1]/XCUIElementTypeOther[5]/XCUIElementTypeTextField");
			ExplicitWait_VisibilityOfEle("//XCUIElementTypeOther[1]/XCUIElementTypeOther[5]/XCUIElementTypeTextField");
			type("//XCUIElementTypeOther[1]/XCUIElementTypeOther[5]/XCUIElementTypeTextField",number);
			
		}else if(platform.equals("Android")) {
			
		}
	}
	public void Edit_Email(String email) throws InterruptedException
	{
		if(platform==null) {
			
			ExplicitWait_VisibilityOfEle("//XCUIElementTypeOther[1]/XCUIElementTypeOther[6]/XCUIElementTypeTextField");
			clear("//XCUIElementTypeOther[1]/XCUIElementTypeOther[6]/XCUIElementTypeTextField");
			type("//XCUIElementTypeOther[1]/XCUIElementTypeOther[6]/XCUIElementTypeTextField", email);
			
		}else if(platform.equals("Android")) {
			
		}
	}
	public void Edit_PostalCode(String code) throws InterruptedException
	{
		if(platform==null) {
			click("//XCUIElementTypeButton[@name=\"Done\"]");
			ExplicitWait_VisibilityOfEle("//XCUIElementTypeOther[2]/XCUIElementTypeOther[7]/XCUIElementTypeTextField");
			clear("//XCUIElementTypeOther[2]/XCUIElementTypeOther[7]/XCUIElementTypeTextField");
			type("//XCUIElementTypeOther[2]/XCUIElementTypeOther[7]/XCUIElementTypeTextField", code);
			
		}else if(platform.equals("Android")) {
			
		}
	}
	public void Back() throws InterruptedException 
	{
		if(platform==null) {
			Thread.sleep(2000);
			ExplicitWait_ElementToBeClickable("//XCUIElementTypeButton[@name='Back']");
			click("//XCUIElementTypeButton[@name='Back']");
		}else if(platform.equals("Android")) {
			Thread.sleep(10);
		}
	}
	public void Customer_edit1() throws InterruptedException
	{
		click("//android.widget.TextView[@content-desc=\"Edit\"]");
		Thread.sleep(3000);

	}

	public void Customer_More() throws InterruptedException
	{
		if(platform==null) {
			Thread.sleep(10);
		}else if(platform.equals("Android")) {
			Thread.sleep(3000);
			click("//android.widget.TextView[@content-desc=\"Open\"]");//more
			Thread.sleep(3000);
		}
	}
	public void Customer_Ongoing() throws InterruptedException
	{
		if(platform==null) {
			Thread.sleep(2000);
			ExplicitWait_PresenceOfEle("(//XCUIElementTypeStaticText[@name=\"Ongoing works\"])");
			
			//dclick("//XCUIElementTypeCollectionView[1]/XCUIElementTypeCell[5]");//18427
			dclick("(//XCUIElementTypeStaticText[@name=\"Ongoing works\"])");//16410
			
		}else if(platform.equals("Android")) {
		Thread.sleep(2000);
		click("//android.widget.TextView[@text='On going work']");//on going
		Thread.sleep(2000);
		}
	}
	public void Ongoing_Plus() throws InterruptedException
	{
		if(platform==null) {
			Thread.sleep(2000);
			click("//XCUIElementTypeButton[@name='Add']");
			Thread.sleep(3000);
		}else if(platform.equals("Android")) {
			Thread.sleep(1000);
			click("#com.commusoft.v4:id/fab_expand_menu_button");
		}
	}
	
	public void Estimate_Des() throws InterruptedException 
	{
		if(platform==null) {
		Thread.sleep(5000);
		click("//XCUIElementTypeOther[2]/XCUIElementTypeOther");
		Thread.sleep(8000); 
		}else if(platform.equals("Android")) {
			Thread.sleep(2000);
			click("#com.commusoft.v4:id/templatespinnerView");
			Thread.sleep(2000);
			click("//android.widget.TextView[2]");
		}
	}
	public void Customer_PlusBtn() throws InterruptedException
	{
		if(platform==null) {
			ExplicitWait_ElementToBeClickable("//XCUIElementTypeButton[@name='Add']");
			click("//XCUIElementTypeButton[@name='Add']");
			ExplicitWait_ElementToBeClickable("//XCUIElementTypeButton[@name='Add contact']");
			click("//XCUIElementTypeButton[@name='Add contact']");
		}else if(platform.equals("Android")) {
			Thread.sleep(2000);
			click("#com.commusoft.v4:id/fab_expand_menu_button");//+ button
			Thread.sleep(2000);
		}
	}
	public void Ongoing_PlusBtn() throws InterruptedException
	{
		if(platform==null) {
			ExplicitWait_ElementToBeClickable("//XCUIElementTypeButton[@name='Add']");
			click("//XCUIElementTypeButton[@name='Add']");
			
		}else if(platform.equals("Android")) {
			Thread.sleep(2000);
			click("#com.commusoft.v4:id/fab_expand_menu_button");//+ button
			Thread.sleep(2000);
		}
	}
	public void AddNotebtn() throws InterruptedException 
	{
		if(platform==null) {
			Thread.sleep(5000);
			ExplicitWait_ElementToBeClickable("//XCUIElementTypeButton[@name='Add']");
			click("//XCUIElementTypeButton[@name='Add']");
			ExplicitWait_ElementToBeClickable("//XCUIElementTypeButton[@name='Add new note']");
			click("//XCUIElementTypeButton[@name='Add new note']");
		}else if(platform.equals("Android")) {
			Thread.sleep(2000);
			click("#com.commusoft.v4:id/fab_expand_menu_button");//+ button
			Thread.sleep(4000);
			click("//android.widget.TextView[@text='Add new note']");
			Thread.sleep(2000);
		}
	}
	public void Reminders() throws InterruptedException
	{
		if(platform==null) {
			Thread.sleep(2000);
			//dclick("//XCUIElementTypeCollectionView[1]/XCUIElementTypeCell[3]/XCUIElementTypeOther");//18427
			dclick("(//XCUIElementTypeStaticText[@name=\"notification\"])[3]");//
			Thread.sleep(4000);
		}else if(platform.equals("Android")) {
		click("//android.widget.TextView[@text='Reminders']");
		Thread.sleep(2000);
		}
	}
	public void Reminderplus() throws InterruptedException
	{
		if(platform==null) {
			Thread.sleep(10);
		}else if(platform.equals("Android")) {
		click("#com.commusoft.v4:id/fab_expand_menu_button");
		Thread.sleep(2000);
		}
	}
	public void ServiceReminder() throws InterruptedException
	{
		if(platform==null) {
			click("//XCUIElementTypeStaticText[@name='Service reminders']");
			ExplicitWait_ElementToBeClickable("//XCUIElementTypeButton[@name='Add']");
			click("//XCUIElementTypeButton[@name='Add']");
			ExplicitWait_ElementToBeClickable("//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther");
			click("//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther");

		}else if(platform.equals("Android")) {
		click("//android.widget.TextView[@text='Add new service reminder']");
		Thread.sleep(2000);
		click("#com.commusoft.v4:id/spinnerserviceTypeView");
		Thread.sleep(2000);
		}
	}
	
	public void SelectReminder() throws InterruptedException
	{
		if(platform==null) {
			ExplicitWait_ElementToBeClickable("//XCUIElementTypePickerWheel");
			type("//XCUIElementTypePickerWheel","Boiler service");
			ExplicitWait_ElementToBeClickable("//XCUIElementTypeButton[@name='Done']");
			click("//XCUIElementTypeButton[@name='Done']");

		}else if(platform.equals("Android")) {
		click("//android.widget.TextView[@text='AC service']");
		Thread.sleep(2000);
		}
	}
	public void ReminderDate() throws InterruptedException
	{
		if(platform==null) {
			click("//XCUIElementTypeOther[2]/XCUIElementTypeOther");
			ExplicitWait_ElementToBeClickable("//XCUIElementTypeButton[@name='Done']");
			click("//XCUIElementTypeButton[@name='Done']");
			
		}else if(platform.equals("Android")) {
		click("#com.commusoft.v4:id/spinnerDateLayout");
		Thread.sleep(2000);
		click("//android.widget.Button[@text='DONE']");
		Thread.sleep(5000);
		}
	}
	public void Sendto(String titleCustomername) throws InterruptedException
	{
		if(platform==null) {
			ExplicitWait_ElementToBeClickable("//XCUIElementTypeOther[3]/XCUIElementTypeOther");
			click("//XCUIElementTypeOther[3]/XCUIElementTypeOther");
			ExplicitWait_ElementToBeClickable("//XCUIElementTypeButton[@name='Done']");
			click("//XCUIElementTypeButton[@name='Done']");
			
		}else if(platform.equals("Android")) {
		Thread.sleep(3000);
		click("#com.commusoft.v4:id/spinnersendToView");
		Thread.sleep(2000);
		click("//android.widget.TextView[@text='"+titleCustomername+" - Email']");
		Thread.sleep(4000);
		}
	}
	public void WA() throws InterruptedException
	{
		if(platform==null) {
			Thread.sleep(4000);
			//dclick("//XCUIElementTypeCollectionView[1]/XCUIElementTypeCell[2]/XCUIElementTypeOther");//18427	
			click("(//XCUIElementTypeStaticText[@name=\"Work Address\"])");//16410
		}else if(platform.equals("Android")) {
		click("//android.widget.TextView[@text='Work addresses']");
		Thread.sleep(2000);
		}
	}
	public void WA_Add() throws InterruptedException
	{
		if(platform==null) {
			ExplicitWait_ElementToBeClickable("//XCUIElementTypeButton[@name='Add']");
			click("//XCUIElementTypeButton[@name='Add']");
			
		}else if(platform.equals("Android")) {
		Thread.sleep(2000);
		click("#com.commusoft.v4:id/add");
		Thread.sleep(2000);
		}
	}
	public void WA_Name(String name) throws InterruptedException
	{
		if(platform==null) {
			ExplicitWait_ElementToBeClickable("//XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther");
			click("//XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther");//title
			ExplicitWait_VisibilityOfEle("//XCUIElementTypePickerWheel");
			type("//XCUIElementTypePickerWheel", "Mr");
			ExplicitWait_ElementToBeClickable("//XCUIElementTypeButton[@name='Done']");
			click("//XCUIElementTypeButton[@name='Done']");
			ExplicitWait_VisibilityOfEle("//XCUIElementTypeOther[2]/XCUIElementTypeOther[3]/XCUIElementTypeTextField");
			type("//XCUIElementTypeOther[2]/XCUIElementTypeOther[3]/XCUIElementTypeTextField", name);

		}else if(platform.equals("Android")) {
		Thread.sleep(2000);
		type("#com.commusoft.v4:id/firstNameValue", name);
		Thread.sleep(2000);
		}
	}
	public void WA_Surname(String lastname) throws InterruptedException
	{
		if(platform==null) {
			ExplicitWait_VisibilityOfEle("//XCUIElementTypeOther[2]/XCUIElementTypeOther[4]/XCUIElementTypeTextField");
			type("//XCUIElementTypeOther[2]/XCUIElementTypeOther[4]/XCUIElementTypeTextField", lastname);

		}else if(platform.equals("Android")) {
		Thread.sleep(2000);
		type("#com.commusoft.v4:id/surnameValue", lastname);
		Thread.sleep(2000);
		}
	}
	public void Scrollto_WA_Address() throws InterruptedException
	{
		if(platform==null) {
//			Thread.sleep(2000);
//			scrollToIOSElement("//XCUIElementTypeStaticText[@name='Address line 1 *']");
			Thread.sleep(2000);
		}else if(platform.equals("Android")) {
		Thread.sleep(2000);
		scrollToAndroidElement(kdriver, "Address Line 1 *");
		Thread.sleep(2000);
		}
	}
	public void WA_Address(String add) throws InterruptedException
	{
		if(platform==null) {
			
				
				
				
			
//				ExplicitWait_ElementToBeClickable("//XCUIElementTypeButton[@name='Done']");
//				click("//XCUIElementTypeButton[@name='Done']");
				ExplicitWait_VisibilityOfEle("//XCUIElementTypeOther[1]/XCUIElementTypeTextField");
				type("//XCUIElementTypeOther[1]/XCUIElementTypeTextField", add);
			
			
			

		}else if(platform.equals("Android")) {
		Thread.sleep(2000);
		type("#com.commusoft.v4:id/formaddressLine1", add);
		Thread.sleep(2000);
		}
	}
	public void Cus_Contact() throws InterruptedException
	{
		if(platform==null) {
			ExplicitWait_ElementToBeClickable("//XCUIElementTypeStaticText[@name='users']");
			click("//XCUIElementTypeStaticText[@name='users']");
		}else if(platform.equals("Android")) {
			Thread.sleep(2000);
			click("//android.widget.TextView[@text='Contacts']");
			Thread.sleep(2000);
		}
	}
	public void MoreiOS() throws InterruptedException 
	{
		if(platform==null) {
		ExplicitWait_ElementToBeClickable("//XCUIElementTypeStaticText[@name='rows']");
		click("//XCUIElementTypeStaticText[@name='rows']");
		
		}else if(platform.equals("Android")) {
			
		}
	}
	public void Choose_Contact() throws InterruptedException
	{
		if(platform==null) {
			Thread.sleep(10);
		}else if(platform.equals("Android")) {
			Thread.sleep(2000);
			click("//android.widget.TextView[@text='Create new contact']");
			Thread.sleep(2000);
		}
	}
	public void Contact_Surname(String name) throws InterruptedException
	{
		if(platform==null) {
			ExplicitWait_VisibilityOfEle("//XCUIElementTypeOther[1]/XCUIElementTypeOther[3]/XCUIElementTypeTextField");
			type("//XCUIElementTypeOther[1]/XCUIElementTypeOther[3]/XCUIElementTypeTextField",name);
			
		}else if(platform.equals("Android")) {
			Thread.sleep(2000);
			type("#com.commusoft.v4:id/contactSurNameValue", name);
			Thread.sleep(2000);
		}
	}
	public void ContactNum(String num) throws InterruptedException 
	{
		if(platform==null) {
			ExplicitWait_VisibilityOfEle("//XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeTextField");
			type("//XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeTextField",num);	
		}else if(platform.equals("Android")) {
			Thread.sleep(10);
		}
	}
	public void ContactMobile(String num) throws InterruptedException 
	{
		if(platform==null) {
			ExplicitWait_VisibilityOfEle("//XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeTextField");
			type("//XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeTextField", num);	
		}else if(platform.equals("Android")) {
			Thread.sleep(10);
		}
	}
	public void Position(String num) throws InterruptedException 
	{
		if(platform==null) {
			type("//XCUIElementTypeOther[3]/XCUIElementTypeOther[1]/XCUIElementTypeTextField", num);
		}else if(platform.equals("Android")) {
			Thread.sleep(10);
		}
	}
	public void ContactEmail(String email) throws InterruptedException 
	{
		if(platform==null) {
//			ExplicitWait_PresenceOfEle("//XCUIElementTypeButton[@name='Done']");
//			click("//XCUIElementTypeButton[@name='Done']");
			ExplicitWait_VisibilityOfEle("//XCUIElementTypeOther[3]/XCUIElementTypeOther[3]/XCUIElementTypeTextField");
			type("//XCUIElementTypeOther[3]/XCUIElementTypeOther[3]/XCUIElementTypeTextField",email);
		}else if(platform.equals("Android")) {
			Thread.sleep(10);
		}
	}
	public void Cus_notes() throws InterruptedException
	{
		if(platform==null) {
			ExplicitWait_ElementToBeClickable("//XCUIElementTypeStaticText[@name='notebook']");
			click("//XCUIElementTypeStaticText[@name='notebook']");
			
		}else if(platform.equals("Android")) {
			click("//android.widget.TextView[@text='Notes']");
			Thread.sleep(2000);
		}
	}
	public void Notes_plus() throws InterruptedException
	{
		Thread.sleep(2000);
		click("//android.widget.TextView[@text='Add new note']");
		Thread.sleep(2000);
	}
	public void Notes_Title(String name) throws InterruptedException
	{
		if(platform==null) {
			ExplicitWait_VisibilityOfEle("//XCUIElementTypeTextField");
			type("//XCUIElementTypeTextField", name);
		}else if(platform.equals("Android")) {
			type("#com.commusoft.v4:id/titleEdittext", name);
			Thread.sleep(2000);
		}
	}
	public void Notes_body(String name) throws InterruptedException
	{
		if(platform==null) {
			ExplicitWait_PresenceOfEle("//XCUIElementTypeTextView");
			type("//XCUIElementTypeTextView", name);
		}else if(platform.equals("Android")) {
			type("#com.commusoft.v4:id/noteEditText", name);
			Thread.sleep(2000);
		}
	}

	public void Notes_phonecall() throws InterruptedException
	{
		if(platform==null) {
			ExplicitWait_ElementToBeClickable("//XCUIElementTypeButton[@name='Add']");
			click("//XCUIElementTypeButton[@name='Add']");
			ExplicitWait_ElementToBeClickable("//XCUIElementTypeButton[@name='Add phone call']");
			click("//XCUIElementTypeButton[@name='Add phone call']");

		}else if(platform.equals("Android")) {
			click("//android.widget.TextView[@text='Add new phone call']");
			Thread.sleep(2000);
		}
	}
	public void Note_calltype() throws InterruptedException
	{
		if(platform==null) {
			ExplicitWait_ElementToBeClickable("//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther");
			click("//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther");
			ExplicitWait_ElementToBeClickable("//XCUIElementTypeButton[@name='Done']");
			click("//XCUIElementTypeButton[@name='Done']");
			
		}else if(platform.equals("Android")) {
		click("#com.commusoft.v4:id/callTypeSpinner");
		Thread.sleep(2000);
		}
	}
	public void Note_callchoose() throws InterruptedException
	{
		if(platform==null) {
			Thread.sleep(10);
		}else if(platform.equals("Android")) {
		click("//android.widget.TextView[@text='Incoming call']");
		Thread.sleep(2000);
		}
	}
	public void Notes_contactname() throws InterruptedException
	{
		if(platform==null) {
			Thread.sleep(10);
		}else if(platform.equals("Android")){
		click("#com.commusoft.v4:id/contactNameSpinner");
		Thread.sleep(2000);
		}
	}
	public void Phone_Notes() throws InterruptedException
	{
		if(platform==null) {
		click("//XCUIElementTypeTextView[@value='Tap to enter']");
		ExplicitWait_VisibilityOfEle("//XCUIElementTypeTextView");
		type("//XCUIElementTypeTextView","Phone Notes");
		
		}else if(platform.equals("Android")) {
			Thread.sleep(10);
		}
	}
	public void Notes_contactnamechoose(String name) throws InterruptedException
	{
		if(platform==null) {
			Thread.sleep(10);
		}else if(platform.equals("Android")) {
		click("//android.widget.TextView[@text='"+name+"']");
		Thread.sleep(2000);
		}
	}
	public void Phonecall() throws InterruptedException
	{
		if(platform==null) {
			ExplicitWait_ElementToBeClickable("//XCUIElementTypeOther[2]/XCUIElementTypeOther");
			click("//XCUIElementTypeOther[2]/XCUIElementTypeOther");
			ExplicitWait_ElementToBeClickable("//XCUIElementTypeButton[@name='Done']");
			click("//XCUIElementTypeButton[@name='Done']");
			ExplicitWait_ElementToBeClickable("//XCUIElementTypeOther[3]/XCUIElementTypeOther");
			click("//XCUIElementTypeOther[3]/XCUIElementTypeOther");
			ExplicitWait_ElementToBeClickable("//XCUIElementTypeButton[@name='Done']");
			click("//XCUIElementTypeButton[@name='Done']");
			
		}else if(platform.equals("Android")) {
		click("#com.commusoft.v4:id/contactNumberSpinner");
		Thread.sleep(2000);
		click("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]");
		Thread.sleep(2000);
		type("#com.commusoft.v4:id/noteEdittext", "Phone Call Notes");
		Thread.sleep(2000);
		}
	}
	public void Notes_Email() throws InterruptedException
	{
		if(platform==null) {
			Thread.sleep(2000);
			ExplicitWait_VisibilityOfEle("//XCUIElementTypeButton[@name='Add']");
			click("//XCUIElementTypeButton[@name='Add']");
			ExplicitWait_ElementToBeClickable("//XCUIElementTypeButton[@name='Send new email']");
			click("//XCUIElementTypeButton[@name='Send new email']");
			ExplicitWait_ElementToBeClickable("//XCUIElementTypeScrollView/XCUIElementTypeButton[1]/XCUIElementTypeStaticText");
			click("//XCUIElementTypeScrollView/XCUIElementTypeButton[1]/XCUIElementTypeStaticText");
		
		}else if(platform.equals("Android")) {
		click("//android.widget.TextView[@text='Send new email']");
		Thread.sleep(2000);
		click("#com.commusoft.v4:id/to");
		Thread.sleep(6000);
		click("#com.commusoft.v4:id/user_checkbox");
		Thread.sleep(2000);
		}

	}
	public void Note_Emailsubject(String sub) throws InterruptedException
	{
		if(platform==null) {
			ExplicitWait_VisibilityOfEle("//XCUIElementTypeOther[6]/XCUIElementTypeTextField");
			type("//XCUIElementTypeOther[6]/XCUIElementTypeTextField","Email Subject");

		}else if (platform.equals("Android")) {
			type("#com.commusoft.v4:id/subject", sub);
			Thread.sleep(2000);
		}
	}
	public void Notes_SMS(String name) throws InterruptedException
	{
		if(platform==null) {
			Thread.sleep(2000);
			click("//XCUIElementTypeButton[@name='Add']");
			Thread.sleep(3000);
			click("//XCUIElementTypeButton[@name='Send new sms']");
			Thread.sleep(4000);
			click("//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther");
			Thread.sleep(4000);
			click("//XCUIElementTypeButton[@name='Done']");
			Thread.sleep(2000);
			Thread.sleep(2000);
			click("//XCUIElementTypeOther[2]/XCUIElementTypeOther");
			Thread.sleep(4000);
			click("//XCUIElementTypeButton[@name='Done']");
			Thread.sleep(4000);
			type("//XCUIElementTypeTextView",name);
			Thread.sleep(4000);
		}else if(platform.equals("Android")) {
		click("//android.widget.TextView[@text='Send new SMS']");
		Thread.sleep(2000);
		click("#com.commusoft.v4:id/contactNameSpinner");
		Thread.sleep(2000);
		click("//android.widget.TextView[@text='"+name+"']");
		Thread.sleep(2000);
		click("#com.commusoft.v4:id/contactNumberSpinner");
		Thread.sleep(2000);
		click("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]");
		Thread.sleep(2000);
		type("#com.commusoft.v4:id/template", "Message body");
		Thread.sleep(2000);
		}
	}
	public void Attached_File(String name) throws InterruptedException
	{
		if(platform==null) {
			Thread.sleep(2000);
			click("//XCUIElementTypeButton[1]");	
			Thread.sleep(2000);
			click("//XCUIElementTypeStaticText[@name='Search']");
			Thread.sleep(3000);
			click("//XCUIElementTypeSearchField[@name='Search']");
			Thread.sleep(2000);
			type("//XCUIElementTypeSearchField",CustomerName);
			Thread.sleep(3000);
			typeenter("//XCUIElementTypeSearchField");
			Thread.sleep(8000);
			Thread.sleep(3000);
			click("(//*[contains(@name,'"+name+"')])[3]");
			Thread.sleep(4000);

			Thread.sleep(2000);
			click("//XCUIElementTypeStaticText[@name='rows']");//more button
			Thread.sleep(4000);
			click("//XCUIElementTypeCollectionView[1]/XCUIElementTypeCell[5]");//attached file
			Thread.sleep(2000);
			click("//XCUIElementTypeButton[@name='Add']");//+ button
			Thread.sleep(2000);
			click("//XCUIElementTypeButton[@name='Choose Photos from camera roll']");//camera roll
			Thread.sleep(3000);
			click("//XCUIElementTypeStaticText[@name='Recents']");//click 
			Thread.sleep(3000);
			click("//XCUIElementTypeCell[1]//XCUIElementTypeImage");//select the first image
			Thread.sleep(3000);
			if(kdriver.findElement(By.xpath("//XCUIElementTypeCell/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther")).isDisplayed())
			{
				System.out.println("First photo is selected successfully...");
			}
			click("//XCUIElementTypeButton[@name='Done']");//done button
			Thread.sleep(3000);

			String UploadedImage = gettext("//XCUIElementTypeCell[1]/XCUIElementTypeStaticText[1]");
			Date today = new Date();
			SimpleDateFormat  DATE_FORMAT = new SimpleDateFormat("EE dd MMMM yyyy");
			String date = DATE_FORMAT.format(today);
			if(UploadedImage.equals(date)) 
			{
				System.out.println("Image uploaded successfully...");
			}
			click("//XCUIElementTypeButton[@name='Back']");//back
			Thread.sleep(2000);
			click("//XCUIElementTypeButton[@name='Back']");//back
			Thread.sleep(2000);
			click("//XCUIElementTypeNavigationBar/XCUIElementTypeButton");//menu button
			Thread.sleep(2000); 
			click("//XCUIElementTypeStaticText[@name='Daily']");
			Thread.sleep(2000); 
		}else if (platform.equals("Android")) {
			
		}
	}
	public void Add_Company() throws InterruptedException
	{
		if(platform==null) {
			Thread.sleep(5000);
			click("//XCUIElementTypeButton[1]");	
			Thread.sleep(5000);
			scrollToIOSElement("//XCUIElementTypeStaticText[@name='Add Customer']");
			Thread.sleep(3000);
			click("//XCUIElementTypeStaticText[@name='Add Customer']");
			Thread.sleep(2000);
			click("//XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther");
			Thread.sleep(2000);
			Thread.sleep(2000);
			type("//XCUIElementTypePickerWheel", "Company");
			click("//XCUIElementTypeStaticText[@name='Done']");
			Thread.sleep(2000);
			type("//XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTextField", CompanyName);//company name
			Thread.sleep(2000);
			type("//XCUIElementTypeOther[2]/XCUIElementTypeTextField", Mobile);//mobile number
			Thread.sleep(2000);
			type("//XCUIElementTypeOther[1]/XCUIElementTypeOther[3]/XCUIElementTypeTextField", Email);//email
			Thread.sleep(2000);
			type("//XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeTextField", Address);//address
			Thread.sleep(2000);
			click("//XCUIElementTypeButton[@name='Save']");//save
			Thread.sleep(8000);
			click("//XCUIElementTypeNavigationBar/XCUIElementTypeButton");
			Thread.sleep(2000);
			
			Thread.sleep(3000);
			scrollToIOSElement("//XCUIElementTypeStaticText[@name='Daily']");
			Thread.sleep(3000);
			
			Thread.sleep(2000);
			click("//XCUIElementTypeStaticText[@name='Daily']");
			Thread.sleep(2000);
		}else if(platform.equals("Android")){
			Thread.sleep(10);
		}
	}
	public void Edit_Company() throws InterruptedException
	{
		if(platform==null) {
			Thread.sleep(10000);
			click("//XCUIElementTypeButton[1]");	
			Thread.sleep(2000);
			click("//XCUIElementTypeStaticText[@name='Search']");
			Thread.sleep(3000);
			click("//XCUIElementTypeSearchField[@name='Search']");
			Thread.sleep(2000);
			type("//XCUIElementTypeSearchField",CompanyName);
			Thread.sleep(3000);
			typeenter("//XCUIElementTypeSearchField");
			Thread.sleep(8000);
			Thread.sleep(3000);
			click("//XCUIElementTypeStaticText[@name='"+CompanyName+"']");
			Thread.sleep(4000);
			Thread.sleep(3000);
			click("//XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther");// click edit arrow button
			Thread.sleep(2000);
			clear("//XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTextField");
			type("//XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTextField", EditedCompany);
			Thread.sleep(2000);
			clear("//XCUIElementTypeOther[2]/XCUIElementTypeTextField");
			type("//XCUIElementTypeOther[2]/XCUIElementTypeTextField", EditMobile);//mobile number
			Thread.sleep(2000);
			clear("//XCUIElementTypeOther[1]/XCUIElementTypeOther[3]/XCUIElementTypeTextField");
			type("//XCUIElementTypeOther[1]/XCUIElementTypeOther[3]/XCUIElementTypeTextField", EditEmail);//email
			Thread.sleep(2000);
			clear("//XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeTextField");
			type("//XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeTextField", EditAddress);//address
			Thread.sleep(2000);
			click("//XCUIElementTypeButton[@name='Save']");//save
			Thread.sleep(6000);
			click("//XCUIElementTypeNavigationBar/XCUIElementTypeButton");
			Thread.sleep(4000);
			click("//XCUIElementTypeNavigationBar/XCUIElementTypeButton");
			Thread.sleep(2000);
			click("//XCUIElementTypeStaticText[@name='Daily']");
			Thread.sleep(2000);
		}else if(platform.equals("Android")){
			Thread.sleep(10);
		}
	}
	public void Add_Company_Contact() throws InterruptedException
	{
		if(platform==null) {
			
			Thread.sleep(10000);
			click("//XCUIElementTypeButton[1]");	
			Thread.sleep(2000);
			click("//XCUIElementTypeStaticText[@name='Search']");
			Thread.sleep(3000);
			click("//XCUIElementTypeSearchField[@name='Search']");
			Thread.sleep(2000);
			type("//XCUIElementTypeSearchField",EditedCompany);
			Thread.sleep(3000);
			typeenter("//XCUIElementTypeSearchField");
			Thread.sleep(8000);
			Thread.sleep(3000);
			click("//XCUIElementTypeStaticText[@name='"+EditedCompany+"']");
			Thread.sleep(5000);
			click("//XCUIElementTypeStaticText[@name='users']");//click contact
			Thread.sleep(2000);
			click("//XCUIElementTypeButton[@name='Add']");//+ button
			Thread.sleep(2000);
			click("//XCUIElementTypeButton[@name='Add contact']");//add contact
			Thread.sleep(4000);
			type("//XCUIElementTypeOther[1]/XCUIElementTypeOther[3]/XCUIElementTypeTextField", CompanyName);//contact sur name
			Thread.sleep(2000);
			click("//XCUIElementTypeButton[@name='Save']");//+ button
			Thread.sleep(3000);
			click("//XCUIElementTypeButton[@name='Back']");//+ button
			Thread.sleep(3000);
			click("//XCUIElementTypeNavigationBar/XCUIElementTypeButton");
			Thread.sleep(2000); 
			click("//XCUIElementTypeStaticText[@name='Daily']");
			Thread.sleep(2000);
			
		}else if(platform.equals("Android")){
			Thread.sleep(10);
		}
	}
	public void Edit_Company_Contact() throws InterruptedException
	{
		if(platform==null) {
			
			Thread.sleep(5000);
			click("//XCUIElementTypeButton[1]");//menu
			Thread.sleep(2000);
			click("//XCUIElementTypeStaticText[@name='Search']");
			Thread.sleep(3000);
			click("//XCUIElementTypeSearchField[@name='Search']");
			Thread.sleep(2000);
			type("//XCUIElementTypeSearchField",EditedCompany);
			Thread.sleep(3000);
			typeenter("//XCUIElementTypeSearchField");
			Thread.sleep(8000);
			Thread.sleep(3000);
			click("//XCUIElementTypeStaticText[@name='"+EditedCompany+"']");
			Thread.sleep(5000);
			click("//XCUIElementTypeStaticText[@name='users']");//click contact
			Thread.sleep(2000);
			click("//XCUIElementTypeStaticText[@name='Mr & Mrs "+CompanyName+"']");
			Thread.sleep(2000);
			click("//XCUIElementTypeButton[@name='View/Edit Contacts']");
			Thread.sleep(5000);
			type("//XCUIElementTypeOther[2]/XCUIElementTypeTextField", CustomerContact);//contactname
			Thread.sleep(2000);
			clear("//XCUIElementTypeOther[1]/XCUIElementTypeOther[3]/XCUIElementTypeTextField");
			type("//XCUIElementTypeOther[1]/XCUIElementTypeOther[3]/XCUIElementTypeTextField", EditedCustomerContact);//contact sur name
			Thread.sleep(2000);
			click("//XCUIElementTypeStaticText[@name='calendar']");// calendar date
			Thread.sleep(2000);
			click("//XCUIElementTypeButton[@name='Done']");//done
			Thread.sleep(2000);
			type("//XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeTextField", Mobile);
			Thread.sleep(2000);
			click("//XCUIElementTypeButton[@name='Save']");//save
			Thread.sleep(2000);
			click("//XCUIElementTypeButton[@name='Back']");//+ button
			Thread.sleep(3000);
			click("//XCUIElementTypeNavigationBar/XCUIElementTypeButton");
			Thread.sleep(2000); 
			click("//XCUIElementTypeStaticText[@name='Daily']");
			Thread.sleep(2000);
			
		}else if(platform.equals("Android")){
			Thread.sleep(10);
		}
	}
	public void Edit_WA(String name) throws InterruptedException
	{
		if(platform==null) {
			Thread.sleep(2000);
			click("//XCUIElementTypeButton[1]");	//side menu
			Thread.sleep(2000);
			click("//XCUIElementTypeStaticText[@name='Search']");
			Thread.sleep(3000);
			click("//XCUIElementTypeSearchField[@name='Search']");
			type("//XCUIElementTypeSearchField",CustomerName);
			typeenter("//XCUIElementTypeSearchField");
			Thread.sleep(8000);
			Thread.sleep(3000);
			click("(//*[contains(@name,'"+name+"')])[3]");
			Thread.sleep(4000);
			Thread.sleep(2000);
			click("//XCUIElementTypeStaticText[@name='rows']");//more
			Thread.sleep(4000);
			Thread.sleep(4000);
			//dclick("//XCUIElementTypeCollectionView[1]/XCUIElementTypeCell[2]/XCUIElementTypeOther");//18427	
			dclick("//XCUIElementTypeCollectionView[1]/XCUIElementTypeCell[3]/XCUIElementTypeOther");//16410
			Thread.sleep(2000);
			click("//XCUIElementTypeStaticText[@name='Mr "+WA+"']");//first wa click
			Thread.sleep(2000);
			click("//XCUIElementTypeButton[@name='View']");//click view WA
			Thread.sleep(6000);
			click("//XCUIElementTypeStaticText[@name='Mr "+WA+"']");//click WA edit
			Thread.sleep(2000);
			
			clear("//XCUIElementTypeOther[2]/XCUIElementTypeOther[3]/XCUIElementTypeTextField");//WA NAme
			type("//XCUIElementTypeOther[2]/XCUIElementTypeOther[3]/XCUIElementTypeTextField", "EditWAName");
			Thread.sleep(2000);
			clear("//XCUIElementTypeOther[2]/XCUIElementTypeOther[4]/XCUIElementTypeTextField");
			type("//XCUIElementTypeOther[2]/XCUIElementTypeOther[4]/XCUIElementTypeTextField", "EditWASur");
			Thread.sleep(2000);
			clear("//XCUIElementTypeOther[5]/XCUIElementTypeTextField");//wa moble
			type("//XCUIElementTypeOther[5]/XCUIElementTypeTextField", Mobile);
			Thread.sleep(2000);
			clear("//XCUIElementTypeOther[2]/XCUIElementTypeOther[6]/XCUIElementTypeTextField");
			type("//XCUIElementTypeOther[2]/XCUIElementTypeOther[6]/XCUIElementTypeTextField", Mobile);
			Thread.sleep(2000);
			clear("//XCUIElementTypeOther[7]/XCUIElementTypeTextField");//email
			type("//XCUIElementTypeOther[7]/XCUIElementTypeTextField", Email);
			Thread.sleep(2000);
			clear("//XCUIElementTypeOther[1]/XCUIElementTypeTextField");//address
			type("//XCUIElementTypeOther[1]/XCUIElementTypeTextField", Address);//address
			Thread.sleep(2000);
			click("//XCUIElementTypeButton[@name='Save']");//save WA
			Thread.sleep(6000);
			click("//XCUIElementTypeButton[@name='Back']");//back
			Thread.sleep(2000);
			click("//XCUIElementTypeButton[@name='Back']");//back
			Thread.sleep(2000);
			click("//XCUIElementTypeButton[@name='Back']");//back
			Thread.sleep(2000);
			click("//XCUIElementTypeNavigationBar/XCUIElementTypeButton");//menu
			Thread.sleep(2000);
			Thread.sleep(2000);
			click("//XCUIElementTypeStaticText[@name='Daily']");//daily
			Thread.sleep(2000);
		}else if(platform.equals("Android")) {
			
		}
	}
	
}
