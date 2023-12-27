package com.betika.testCases;

import org.testng.annotations.Test;
import com.betika.base.BaseTest;
import com.betika.pageEvents.BetikaPageEvents;
import com.betika.pageEvents.RegistrationPageEvents;
import com.betika.pageEvents.RegistrationVerificationPageEvents;


public class TestUserRegistration extends BaseTest {
	
	
	BetikaPageEvents BetikaPageAction = new BetikaPageEvents();
	RegistrationPageEvents RegistrationPageEvents = new RegistrationPageEvents();
	RegistrationVerificationPageEvents RegistrationVerificationPageEvents =new RegistrationVerificationPageEvents();
	
	@Test(alwaysRun = true)
	public void TestUserRegistrationWithoutAccountVerification() {
		

		BetikaPageAction.verifyBetikaHomePageIsLoaded();
		BetikaPageAction.navigateToBetikaUserRegistrationPage();
		RegistrationPageEvents.verifyRegistrationPageIsLoaded();
		RegistrationPageEvents.completeRegiostrationForm(getPhoneNumber(), getRegPassword(), getRegPassword());
		RegistrationVerificationPageEvents.verifyProspectiveUserRedirectedToAccountVerificationPage();
		
		
	}
	 

}
