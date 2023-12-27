package com.betika.pageObjects;

public interface DashboardPageObjects {
	
	
	 
	String buttonDeposit = "//button[normalize-space()='Deposit']";
	String buttonProfileIcon = "//span[normalize-space()='Profile']";
	String buttonNav = "(//a[normalize-space()='Home'])[1]";
	
	String buttonFilterWhichDay = "(//button[@class='match-filter__button'])[1]";
	String selectDay = "//button[normalize-space()='Saturday']";
	String buttonFilterMarket = "(//button[@class='match-filter__button'])[3]";
	String buttonSelectOdd1x2one = "(//button)[14]";
	String buttonSelectOdd1x2two = "(//button)[19]";
	String buttonSelectOdd1x2three = "(//button)[16]";
	
	String amount = "//input[@placeholder='Enter stake']";
	String closeModal = "//button[normalize-space()='Cancel']";
		
	String buttonSelectOptionDC = "(//button[normalize-space()='Double Chance'])[1]";
	String buttonSelectOddDC = "(//button)[21]";
	String buttonSelectOptionBTT = "//button[normalize-space()='Both Teams To Score']";
	String buttonSelectOddBTTS = "(//button)[19]";
	
	
	String buttonShare = "(//button[@class='button account__payments__submit share-betslip__closed__button betslip__details__button button no-bg full'])[1]";
	String bookingLink = "(//input[@type='text'])[1]";
	String buttonCopyLink = "//button[normalize-space()='Copy Link']";
	String buttonPlaceBet = "(//button[@type='normal'])[1]";
			
	String MessageFundWallet = "//p[@class='account__section__desc deposit__desc deposit__desc--error']";
	String MessageConfirmBet = "(//div[@id='notifications-root'])[1]";
			
	String cardOpenBest = "(//div[@class='my-bets-bet__row'])[1]";
	String buttonRebet = "//button[@class='button account__payments__submit betdetails__summary__actions__item button no-bg icon rebet']";
	String buttonCancelBet = "//button[@class='button account__payments__submit betdetails__summary__actions__item__progress__cancel']";
	String buttonContinueCancel = "//button[@class='button account__payments__submit betdetails__summary__actions__item__progress__cancel']";
			
	String linkCashout =  "//body/div/div/div/div/div/div/div/div/div/div[1]/button[1]/span[1]";
	String buttonCompleteCashout = "//button[@class='button account__payments__submit cashout__modal__button button__secondary full text-center']";
			
			
			
}

