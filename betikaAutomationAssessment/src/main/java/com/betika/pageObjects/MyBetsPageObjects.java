package com.betika.pageObjects;

public interface MyBetsPageObjects {
	
	String buttonRebet = "//button[@class='button account__payments__submit betdetails__summary__actions__item button no-bg icon rebet']";
	String buttonContinueRebet = "//span[@class='confirm-dialogue__ok-btn']";
	
	String notificationMessageHeader = "(//div[@class='title'])[1]";
	
	String buttonCancelBet = "//button[@class='button account__payments__submit betdetails__summary__actions__item__progress__cancel']";
	String buttonContinueCancel = "(//span[@class='confirm-dialogue__ok-btn'])[1]";

			
	String linkCashout =  "//button[@class='button account__payments__submit cashout-bet-detail__button full']";
	String buttonCompleteCashout = "(//button[@class='button account__payments__submit cashout__modal__button button__secondary full text-center'])[1]";
	String buttonContinueCashout = "//span[@class='confirm-dialogue__ok-btn']";
	String expiredCashout = "(//small[normalize-space()='Cashout offer expired'])[1]";
	String cardOpenBest = "(//div[@class='my-bets-bet__row'])[1]";
	
	String buttonMyBets = "(//a[@href='/en-ke/mybets'])[1]";
	String buttonTicketStatus = "(//button[@class='my-bets__button'])[1]";
	
	String buttonNav = "(//a[normalize-space()='Home'])[1]";

		
}
