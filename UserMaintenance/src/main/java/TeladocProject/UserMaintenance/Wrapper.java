package TeladocProject.UserMaintenance;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wrapper {
	
	public static void impwait(WebDriver driver,int time) {
		  
		  driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	  
	  }
	 
	
	public static void click(WebDriver driver,String locator) {
		   try
		   {
			   WebDriverWait wait = new WebDriverWait(driver,60);
			   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		       driver.findElement(By.xpath(locator)).click();
		   }catch(Exception e) {
			   
		   }
	       
	       
	      
	}
	
	
	public static void send(WebDriver driver,String locator, String input) {
		   try
		   {
			   WebDriverWait wait = new WebDriverWait(driver,60);
			   wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locator)));
		       driver.findElement(By.name(locator)).sendKeys(input);
		   }catch(Exception e) {
			   
		   }
	       
	       
	      
	}
	
	

}
