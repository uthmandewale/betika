package com.betika.testCases;

import org.testng.annotations.Test;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import com.betika.pageEvents.BetikaPageEvents;
import com.betika.pageEvents.LoginPageEvents;
import com.betika.utils.ElementFetch;

import com.betika.pageEvents.DashboardPageEvents;
import com.betika.base.BaseTest;


public class TestUserLogin extends BaseTest {
	
	LoginPageEvents LoginPageEvents = new LoginPageEvents();
	BetikaPageEvents BetikaPageAction = new BetikaPageEvents();
	DashboardPageEvents DashboardPageEvents = new DashboardPageEvents();
    ElementFetch element = new ElementFetch();

	
	@Test (dataProvider = "LoginDatas", alwaysRun = true)
	
	public void TestUserLogins(String data, ITestContext context) {
		
	String user[] = data.split(",");
	
	System.out.println(user[0]);
		System.out.println(user[1]);
       BetikaPageAction.navigateToBetikaLoginPage();
		
		LoginPageEvents.verifyLoginPageIsLoaded();
	   LoginPageEvents.loginUserWithUsernamePassword(user[0], user[1]);
	
	if (DashboardPageEvents.isLogin()==true)
	{
		System.out.println("Login credentials is valid and user login successfully");
	}
	else 
	{
		System.out.println("Oops, invalid login details");
		
	}	
	
 }

	
	@DataProvider(name = "LoginDatas")
	public String[] JsonReader() throws IOException, ParseException {
		
		JSONParser jsonparser = new JSONParser();
		
		FileReader reader = new FileReader(System.getProperty("user.dir")+"/configurations/user.json");
				Object obj = jsonparser.parse(reader);
		JSONObject jsonobject = (JSONObject) obj;
		JSONArray array = (JSONArray)jsonobject.get("userCredentials");
		
		String arr[] = new String[array.size()];
		
		for (int i=0; i<array.size(); i++) {
			JSONObject users = (JSONObject) array.get(i);
			String username=(String) users.get("username");
					
			String password = (String) users.get("password");
			
			arr[i] = username +","+password;
		}
		
		return arr; 
		
				
	}	

}
