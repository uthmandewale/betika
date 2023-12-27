package com.betika.pageEvents;

import org.testng.Assert;

import com.betika.base.BaseTest;
import com.betika.pageObjects.BetikaPageObjects;
import com.betika.pageObjects.LoginPageObjects;
import com.betika.utils.ElementFetch;

public class LoginPageEvents extends BaseTest implements LoginPageObjects, BetikaPageObjects {
	
	ElementFetch element =  new ElementFetch();
	public void verifyLoginPageIsLoaded() 
	{

		Assert.assertTrue(element.getWebElements("XPATH", textFieldPhoneNumber).size()>0, "Sign button is visible so login page is loaded");
		Assert.assertEquals(element.getWebElement("XPATH", LoginPageObjects.buttonLogin).getText(), "Login");
	}
	
	public void loginUserWithUsernamePassword(String Username, String Password)
	{
		
		element.getWebElement("XPATH", BetikaPageObjects.loginButton).click();
		element.getWebElement("XPATH", LoginPageObjects.textFieldPhoneNumber).sendKeys(Username);
		element.getWebElement("XPATH", LoginPageObjects.textFieldPassword).sendKeys(Password);
		element.getWebElement("XPATH", LoginPageObjects.buttonLogin).click();
		//Assert.assertTrue(element.getWebElements("XPATH", BetikaPageObjects.loginButton).size()<1);
			
	}
	
	


}
