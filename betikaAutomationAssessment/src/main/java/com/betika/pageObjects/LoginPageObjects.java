package com.betika.pageObjects;

public abstract interface LoginPageObjects {
	
	String textFieldPhoneNumber = "//input[@placeholder='e.g. 0712 234567']";
	String textFieldPassword = "//input[@type='password']";
	String buttonLogin = "//button[@class='button account__payments__submit session__form__button login button button__secondary']";
	
}
