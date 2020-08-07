package webAndAPIAutomation;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import reusables.CommonUtils;

public class GetUIWeatherData {
	
	   
    public static ArrayList<GetWeatherData> getDataFromWebUI() {
    	
    	ArrayList<GetWeatherData> UIData= new ArrayList<GetWeatherData>();
    	System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");  
    	WebDriver driver = new ChromeDriver();
        driver.get("https://www.ndtv.com/");
        driver.manage().window().maximize();
        
        WebDriverWait wait1 = new WebDriverWait(driver, 20);
        wait1.until(ExpectedConditions.presenceOfElementLocated(By.id("h_sub_menu")));
        driver.findElement(By.id("h_sub_menu")).click();
        
        WebDriverWait wait2 = new WebDriverWait(driver, 20);
        wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(), 'WEATHER')]")));
        driver.findElement(By.xpath("//a[contains(text(), 'WEATHER')]")).click();
        
        WebDriverWait wait3 = new WebDriverWait(driver, 20);
        wait3.until(ExpectedConditions.presenceOfElementLocated(By.id("searchBox")));
        driver.findElement(By.id("searchBox")).sendKeys("guwahati");
        
        WebDriverWait waitcheckbox = new WebDriverWait(driver, 20);
        waitcheckbox.until(ExpectedConditions.presenceOfElementLocated(By.id("Guwahati")));
        if(driver.findElement(By.id("Guwahati")).isSelected()) {
            
        	WebDriverWait waittitle = new WebDriverWait(driver, 20);
            waittitle.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@title='Guwahati']")));
        	driver.findElement(By.xpath("//div[@title='Guwahati']")).click();
        	WebDriverWait wait4 = new WebDriverWait(driver, 20);
    	    wait4.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(), 'Guwahati')]")));
    	    String city1 = driver.findElement(By.xpath("//span[contains(text(), 'Guwahati')]")).getText();
    	    String temperature = driver.findElement(By.xpath("//b[contains(text(), 'Temp in Degrees')]")).getText();
    	    String humidity = driver.findElement(By.xpath("//b[contains(text(), 'Humidity')]")).getText();
    	    
    	    //fetching integer data from string
    	    System.out.println(city1);
    	    String temp = CommonUtils.extractInt(temperature);
    	    int itemp1 =Integer.parseInt(temp);
    	    System.out.println(itemp1);
    	    String humid = CommonUtils.extractInt(humidity);
    	    int ihumid1 =Integer.parseInt(humid);
    	    System.out.println(ihumid1);
    	    
    	    GetWeatherData data1 = new GetWeatherData(city1,itemp1,ihumid1);
    	    UIData.add(data1);
        }
        else {
        	WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Guwahati")));
        	driver.findElement(By.id("Guwahati")).click();
        	WebDriverWait waittitle = new WebDriverWait(driver, 20);
            waittitle.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@title='Guwahati']")));
        	driver.findElement(By.xpath("//div[@title='Guwahati']")).click();
        	WebDriverWait wait4 = new WebDriverWait(driver, 20);
    	    wait4.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(), 'Guwahati')]")));
    	    String city2 = driver.findElement(By.xpath("//span[contains(text(), 'Guwahati')]")).getText();
    	    String temperature = driver.findElement(By.xpath("//b[contains(text(), 'Temp in Degrees')]")).getText();
    	    String humidity = driver.findElement(By.xpath("//b[contains(text(), 'Humidity')]")).getText();
        	
    	    //fetching integer data from string
    	    System.out.println(city2);
    	    String temp = CommonUtils.extractInt(temperature);
    	    int itemp2 =Integer.parseInt(temp);
    	    System.out.println(itemp2);
    	    String humid = CommonUtils.extractInt(humidity);
    	    int ihumid2 =Integer.parseInt(humid);
    	    System.out.println(ihumid2);
    	    
    	    GetWeatherData data2 = new GetWeatherData(city2,itemp2,ihumid2);
    	    UIData.add(data2);
    	   
        }
          return UIData;
          
    	}
    
    public static void closeDriver()
    {
    	WebDriver driver = new ChromeDriver();
    	driver.quit();
    }
       
}
