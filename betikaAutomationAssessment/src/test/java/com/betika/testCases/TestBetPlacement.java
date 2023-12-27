package com.betika.testCases;

import org.testng.annotations.Test;
import com.betika.base.BaseTest;
import com.betika.pageEvents.BetikaPageEvents;
import com.betika.pageEvents.DashboardPageEvents;
import com.betika.pageEvents.LoginPageEvents;

public class TestBetPlacement extends BaseTest{
	
	LoginPageEvents LoginPageEvents = new LoginPageEvents();
	BetikaPageEvents BetikaPageAction = new BetikaPageEvents();
	DashboardPageEvents DashboardPageEvents = new DashboardPageEvents();

	
	@Test(alwaysRun = true)
	public void TestBetPlacements() {
		   
		   DashboardPageEvents.addGamesToTicket();
		   LoginPageEvents.loginUserWithUsernamePassword(getTestAccount(), getTestPassword());
		   DashboardPageEvents.verifyShareBetSlipOnSocialMedia();
		   System.out.println("here");
		   DashboardPageEvents.enterAmountAndPlaceBet("3");	   
	}
	

}

