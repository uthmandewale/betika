package com.betika.pageEvents;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.betika.base.BaseTest;
import com.betika.pageObjects.MyBetsPageObjects;
import com.betika.utils.ElementFetch;

public class MyBetsPageEvents extends BaseTest implements MyBetsPageObjects {
	
	DashboardPageEvents DashboardPageEvents = new DashboardPageEvents();
	ElementFetch element = new ElementFetch();
	
	public void redirectToMyBetPageAndVerifyMyBetsPageIsOpen() {
		element.getWebElement("XPATH", buttonMyBets).click();
		Assert.assertTrue(element.getWebElements("XPATH", buttonTicketStatus).size()>0);
		
	}
	
	public void rebet() {
		element.getWebElement("XPATH", buttonMyBets).click();
		
		if(element.getWebElements("XPATH", cardOpenBest).size()==0) {
			
			DashboardPageEvents.addGamesToTicket();
			DashboardPageEvents.enterAmountAndPlaceBet("10");
			
			element.getWebElement("XPATH", buttonMyBets).click();
			
			element.getWebElement("XPATH", cardOpenBest).click();
			element.getWebElement("XPATH", buttonRebet).click();
			element.getWebElement("XPATH", buttonContinueRebet).click();
			String message = element.getWebElement("XPATH", notificationMessageHeader).getText();
			System.out.println(message);
			
		}
		else {
			
			element.getWebElement("XPATH", cardOpenBest).click();
			element.getWebElement("XPATH", buttonRebet).click();
			element.getWebElement("XPATH", buttonContinueRebet).click();
			String message = element.getWebElement("XPATH", notificationMessageHeader).getText();
			System.out.println(message);
		}
		
	}
	
	public void cashout() {
		element.getWebElement("XPATH", buttonMyBets).click();
		

		if(element.getWebElements("XPATH", cardOpenBest).size()==0) {
			
			DashboardPageEvents.addGamesToTicket();
			DashboardPageEvents.enterAmountAndPlaceBet("10");
			
			element.getWebElement("XPATH", buttonMyBets).click();
			
			element.getWebElement("XPATH", cardOpenBest).click();
			element.getWebElement("XPATH", linkCashout).click();
			element.getWebElement("XPATH", buttonCompleteCashout).click();
			element.getWebElement("XPATH", buttonContinueCashout).click();
			
//			String message = element.getWebElement("XPATH", notificationMessageHeader).getText();
//			System.out.println(message);
			
			
		}
		else {
		
			element.getWebElement("XPATH", cardOpenBest).click();
			element.getWebElement("XPATH", linkCashout).click();
			element.getWebElement("XPATH", buttonCompleteCashout).click();
			element.getWebElement("XPATH", buttonContinueCashout).click();
			
			
			if (element.getWebElements("XPATH", expiredCashout).size()>0) {
				
				System.out.println("Cashout expired");
				
			}
			else {
//				String message = element.getWebElement("XPATH", notificationMessageHeader).getText();
//				System.out.println(message);
				System.out.println("Cashout is successful");
				
				
			}
			
		}
		
		
	
		
	}
	
	public void cancel() {
		
		
		element.getWebElement("XPATH", buttonMyBets).click();
		
		
		if(element.getWebElements("XPATH", cardOpenBest).size()==0) {
			
			element.getWebElement("XPATH", buttonNav).click();
			DashboardPageEvents.addGamesToTicket();
			DashboardPageEvents.enterAmountAndPlaceBet("10");
			element.getWebElement("XPATH", cardOpenBest).click();
			WebElement ele = element.getWebElement("XPATH", buttonCancelBet);
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].click()", ele);
			//element.getWebElement("XPATH", buttonCancelBet).click();
			element.getWebElement("XPATH", buttonContinueCancel).click();
//			String message = element.getWebElement("XPATH", notificationMessageHeader).getText();
//			System.out.println(message);
			
		}
		else {
			
			element.getWebElement("XPATH", cardOpenBest).click();
			WebElement ele = element.getWebElement("XPATH", buttonCancelBet);
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].click()", ele);
			//element.getWebElement("XPATH", buttonCancelBet).click();
			element.getWebElement("XPATH", buttonContinueCancel).click();

		}
		
	
		
	}
	
	
	
	
	

}
