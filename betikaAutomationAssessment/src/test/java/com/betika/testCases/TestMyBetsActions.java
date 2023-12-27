package com.betika.testCases;

import org.testng.annotations.Test;
import com.betika.base.BaseTest;
import com.betika.pageEvents.BetikaPageEvents;
import com.betika.pageEvents.MyBetsPageEvents;
import com.betika.pageEvents.LoginPageEvents;

public class TestMyBetsActions extends BaseTest {
	
	
	
	LoginPageEvents LoginPageEvents = new LoginPageEvents();
	BetikaPageEvents BetikaPageAction = new BetikaPageEvents();
	MyBetsPageEvents MyBetsPageEvents = new MyBetsPageEvents();
	
	
	@Test(alwaysRun = true)
	public void myBestActionsRebet() {
		   LoginPageEvents.loginUserWithUsernamePassword(getTestAccount(), getTestPassword());
		   MyBetsPageEvents.redirectToMyBetPageAndVerifyMyBetsPageIsOpen();
		   MyBetsPageEvents.rebet();
	  

}
	@Test(alwaysRun = true)
	public void myBestActionsCashout() {
		   LoginPageEvents.loginUserWithUsernamePassword(getTestAccount(), getTestPassword());
		   MyBetsPageEvents.redirectToMyBetPageAndVerifyMyBetsPageIsOpen();
		   MyBetsPageEvents.cashout();
		  
}
	@Test(alwaysRun = true)
	public void myBestActionsCancel() {
		   LoginPageEvents.loginUserWithUsernamePassword(getTestAccount(), getTestPassword());
		   MyBetsPageEvents.redirectToMyBetPageAndVerifyMyBetsPageIsOpen();
		   MyBetsPageEvents.cancel();
		  

}
}
