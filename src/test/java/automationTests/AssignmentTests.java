package automationTests;

import org.testng.annotations.Test;
import java.io.File;
import java.sql.SQLException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


import webAndAPIAutomation.GetWeatherData;



public class AssignmentTests {
	
	ExtentReports extent;
	ExtentTest logger;
	
	@BeforeTest
	public void startReport() {
	     	 
		 extent = new ExtentReports(System.getProperty("user.dir") +"/ExecutionReports/TestVagrantExtentReport.html", true);
	
		 extent.addSystemInfo("Host Name", "Bangalore");
		 extent.addSystemInfo("Environment", "QA");
		 extent.addSystemInfo("User Name", "Saurav");
		 extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	     }
	
	// Test Scenario 1
	
	@Test
	public void weatherDataComparison() throws ClassNotFoundException, SQLException {
		logger = extent.startTest("TC01 : Data comparison between UI & API");
		
		logger.log(LogStatus.PASS, "Conneting to API & UI");
		logger.log(LogStatus.INFO, "API: http://api.openweathermap.org/data/2.5/weather");
		
		GetWeatherData.compareFromApiAndUI();
		
		
		logger.log(LogStatus.PASS, "Test Case Passed!!");
	}
	
	
	@AfterMethod
	 public void getResult(ITestResult result){
	 
	 if(result.getStatus() == ITestResult.FAILURE){
	 logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
	 logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
	 }else if(result.getStatus() == ITestResult.SKIP){
	 logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
	 }
	 extent.endTest(logger);
	 }
	
	@AfterTest
	 public void endReport(){
		extent.flush();
		extent.close();
		
	}
	


}
