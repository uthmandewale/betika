package com.betika.utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import com.betika.base.BaseTest;

public class SuiteListener implements ITestListener, IAnnotationTransformer {
	
	public void onTestFailure(ITestResult result) {
		String filename = System.getProperty("user.dir") + File.separator+"screenshots"+File.separator+result.getMethod().getMethodName();
		
		File fil = ((TakesScreenshot)BaseTest.driver).getScreenshotAs(OutputType.FILE);
		
		try {
		FileUtils.copyFile(fil, new File(filename+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	 public void transform(
		      ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		 annotation.setRetryAnalyzer(RetryAnalyzer.class);
	 }


}
