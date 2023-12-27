package com.betika.pageObjects;

public abstract interface  ResgistrationPageObjects {
	
	String pageLabel = "//div[@class='session__header']//span[contains(text(),'Register')]" ;
	String textFieldPhoneNumber = "//input[@placeholder='e.g. 0712 234567']";
	String textFieldPassword = "//div[@class='session__form']//div[2]//div[1]//input[1]";
	String textFieldConfirmPassword = "//div[@class='app']//div[3]//div[1]//input[1]";
	String checkBoxTerms = "//span[@class='checkmark']";
	String buttonRegister = "//div[@class='session__form__button__container']";
	
}
