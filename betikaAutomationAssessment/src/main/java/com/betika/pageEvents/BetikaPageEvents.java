package com.betika.pageEvents;

import org.testng.Assert;

import com.betika.pageObjects.BetikaPageObjects;
import com.betika.utils.ElementFetch;

public class BetikaPageEvents implements BetikaPageObjects {
	
	ElementFetch element = new ElementFetch();
	public void verifyBetikaHomePageIsLoaded() {

		Assert.assertTrue(element.getWebElements("XPATH", loginButton).size()>0, "Sign button is visible so login page is loaded");
		
	}
	
	public void navigateToBetikaLoginPage() {
		element.getWebElement("XPATH", loginButton).click();
		
	}
	
	public void navigateToBetikaUserRegistrationPage() {
		element.getWebElement("XPATH", registerButton).click();
		
	}
	
}
