package testcase;

import java.io.IOException;

import org.testng.annotations.Test;
import action.Baseclass;
import pages.Customer;



public class Smoke extends Baseclass{


	@Test (priority = 0) 
	public void Create_Customer() throws InterruptedException, IOException 
	{ 
		Customer customer = new Customer(kdriver,line);
		customer.Side_Menu();
		customer.Add_Customer();
		customer.CustomerType_Dropdown(); 
		customer.Customer_Type("Private Customer");
		customer.Title_dropdown(); 
		customer.Private_Customer();
		customer.Customer_title(Title); 
		customer.Customer_SurName(CustomerName);
		customer.Customer_Telephone("8248724397"); 
		customer.Customer_Mobile("8248724397");
		customer.Customer_email("karnan@commusoft.com"); 
		customer.Customer_AddressLine1(Address);
		customer.Customer_AddressLine2(Address2);
		customer.Customer_AddressTown(Address3);	
		customer.Customer_postalCode(postalCode);
		customer.Customer_Save(); 
		customer.CusNum(); 
		customer.Menu_Button(); 
		customer.Daily();
		customer.Customer_Fav();
		customer.Customer_Back();
	}
}