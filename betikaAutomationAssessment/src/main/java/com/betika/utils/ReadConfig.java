package com.betika.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;

public class ReadConfig {
	
	 Properties prop;
		
		public ReadConfig() {
			File configFile = new File("./configurations//config.properties");
			
			try {
				FileInputStream conFile = new FileInputStream(configFile);
				prop = new Properties();
				prop.load(conFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		public String getApplicationUrl() {
			String baseUrl = prop.getProperty("baseURL");
			return baseUrl;
		}
		public String getUsername() {
			String username = prop.getProperty("username");
			return username;
		}
		public String getRegPassword() {
			String regPassword = prop.getProperty("regPassword");
			return regPassword;
		}
		
		public String getPhoneNumber() {
			
		 String phoneNumber = "071" + RandomStringUtils.randomNumeric(7);
		 
		 
		 return phoneNumber;
		}
		
		
		public String getTestAccount() {
			String testAccount = prop.getProperty("testAccount");
			return testAccount;
		}
		public String getTestPassword() {
			String testPassword = prop.getProperty("testPassword");
			return testPassword;
		}
}
