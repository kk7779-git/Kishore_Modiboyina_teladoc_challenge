package pageObject;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import resources.Base;
import TeladocProject.UserMaintenance.Wrapper;

public class UserPage extends Base{

	public WebDriver driver;
	
	public UserPage(WebDriver driver) {
		this.driver = driver;
	}

	public String TFirstName;
	public String TLastName;
	public String TUserName;
	public String TEmail;
	public String TMobilephone;
	public String TPassword;
	
	public void adduser() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(".\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		
		TFirstName =  prop.getProperty("FirstName");
		TLastName =  prop.getProperty("LastName");
		TUserName =  prop.getProperty("UserName");
		TPassword =  prop.getProperty("Password");
		TEmail =  prop.getProperty("Email");
		TMobilephone =  prop.getProperty("Mobilephone");
		
		   	Wrapper.click(driver, "/html/body/table/thead/tr[2]/td/button");//Byxpath
			Wrapper.send(driver, "FirstName", TFirstName);//ByName 
			Wrapper.send(driver,"LastName", TLastName);//ByName 
			Wrapper.send(driver, "UserName",TUserName);//ByName 
			Wrapper.send(driver, "Password", TPassword);//ByName
			Wrapper.click(driver, "/html/body/div[3]/div[2]/form/table/tbody/tr[5]/td[2]/label[1]");//Byxpath
	       
	       Select dropdown = new Select(driver.findElement(By.name("RoleId")));  
	       dropdown.selectByVisibleText("Customer");
	       
	       Wrapper.send(driver, "Email", TEmail);//ByName
	       Wrapper.send(driver, "Mobilephone", TMobilephone);//ByName

	       Wrapper.click(driver, "/html/body/div[3]/div[3]/button[2]"); 
	       boolean textFoun = driver.getPageSource().toString().contains(TUserName);
	       assertTrue(textFoun);
	       
	}
	
	public void deleteuser(String user) {
		boolean textFoun = false;
		String before_xpath = "/html/body/table/tbody/tr[";
		String after_xpath = "]/td[3]";
		List<WebElement> elements = driver.findElements(By.xpath("/html/body/table/tbody/tr"));
		
		for(int row=1; row <=elements.size()-1; row++) {
			
			String username = driver.findElement(By.xpath(before_xpath+row+after_xpath)).getText();
			System.out.println(username);
			if(username.contains(user)) {
				//change getname to click while running
				driver.findElement(By.xpath(before_xpath+row+after_xpath+"/../td[11]/button/i")).click();
				driver.findElement(By.cssSelector(".btn-primary")).click();
				break;
				}	
		}
		
		for(int row=1; row <=elements.size()-1; row++) {
			
			String username = driver.findElement(By.xpath(before_xpath+row+after_xpath)).getText();
			System.out.println(username);
			if(username.contains(user)) {
				textFoun = true;
				System.out.println("User not deleted"+user);
				}
		}assertFalse(textFoun);
			
				

		
	}
	
	

}
