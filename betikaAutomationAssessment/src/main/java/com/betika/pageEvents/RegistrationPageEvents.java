package com.betika.pageEvents;

import org.testng.Assert;

import com.betika.base.BaseTest;
import com.betika.pageObjects.ResgistrationPageObjects;
import com.betika.utils.ElementFetch;

public class RegistrationPageEvents extends BaseTest implements ResgistrationPageObjects {
	
	ElementFetch element = new ElementFetch();
	
	public void verifyRegistrationPageIsLoaded() {
		
		Assert.assertEquals(element.getWebElement("XPATH", pageLabel).getText() , "Register");
		
	}
	
	public void completeRegiostrationForm(String phoneNumber, String password, String ConfrimPassword) {
		element.getWebElement("XPATH", textFieldPhoneNumber).sendKeys(phoneNumber);
		element.getWebElement("XPATH", textFieldPassword).sendKeys(password);
		element.getWebElement("XPATH", textFieldConfirmPassword).sendKeys(ConfrimPassword);
		element.getWebElement("XPATH", checkBoxTerms).click();
		element.getWebElement("XPATH", buttonRegister).click();
		System.out.println("---------");
		
	}
	

}


