package com.betika.pageEvents;

import org.testng.Assert;

import com.betika.base.BaseTest;
import com.betika.pageObjects.RegistartionVerificationPageObjects;
import com.betika.utils.ElementFetch;

public class RegistrationVerificationPageEvents  extends BaseTest implements RegistartionVerificationPageObjects {

	//String T = driver.getTitle();
	ElementFetch element = new ElementFetch();
	public void verifyProspectiveUserRedirectedToAccountVerificationPage() {
		
		Assert.assertEquals(element.getWebElement("XPATH", buttonVerifyAndLogin).getText(), "Verify and Log In");
		System.out.println(driver.getTitle());
		Assert.assertTrue(element.getWebElements("XPATH", ResendCode).size()>0);
		Assert.assertTrue(element.getWebElements("XPATH", buttonVerifyAndLogin).size()>0);
		Assert.assertTrue(element.getWebElements("XPATH", textFieldVerificationCode).size()>0);
		Assert.assertTrue(element.getWebElements("XPATH", ResendCode).size()>0);
		
	}
}
