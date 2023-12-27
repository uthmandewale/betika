package com.betika.pageEvents;

import org.testng.Assert;

import com.betika.base.BaseTest;
import com.betika.pageObjects.DashboardPageObjects;
import com.betika.utils.ElementFetch;

public class DashboardPageEvents extends BaseTest implements DashboardPageObjects{
	
	
	
	ElementFetch element = new ElementFetch();
	
	public boolean isLogin() {
		
		if(element.getWebElements("XPATH", buttonDeposit).size()>0) {
			return true;
		}
		return false;
		
	}
	public void addGamesToTicket() {

		element.getWebElement("XPATH", buttonNav).click();
		System.out.println("hey");
		element.getWebElement("XPATH", buttonSelectOdd1x2one).click();
		element.getWebElement("XPATH", buttonSelectOdd1x2two).click();
		element.getWebElement("XPATH", buttonSelectOdd1x2three).click();

	}
	
	public void verifyShareBetSlipOnSocialMedia() {
		element.getWebElement("XPATH", buttonShare).click();
		Assert.assertTrue(element.getWebElements("XPATH", bookingLink).size()>0);
		
		Assert.assertTrue(element.getWebElements("XPATH", buttonCopyLink).size()>0);
		element.getWebElement("XPATH", closeModal);
		
	}
	
	public void enterAmountAndPlaceBet(String stake) {
		  System.out.println("here1");
		element.getWebElement("XPATH", amount).clear();
		element.getWebElement("XPATH", amount).sendKeys(stake);
		  System.out.println("here3");
		element.getWebElement("XPATH", buttonPlaceBet).click();
		  System.out.println("here");
		Assert.assertTrue((element.getWebElements("XPATH", MessageConfirmBet).size()>0));
		
	}

}
