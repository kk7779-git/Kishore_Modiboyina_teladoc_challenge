package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import TeladocProject.UserMaintenance.Wrapper;

public class Base {
	
	public WebDriver driver;
	
	public WebDriver intializeDriver() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\kkmod\\eclipse-workspace\\UserMaintenance\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {  
			driver = new ChromeDriver();  
			
		}
		else if(browserName.equals("firefox")) {
			
			//FireFox code
			
		}
		else if(browserName.equals("IE")) {
			
			//IE code
		}
		
		Wrapper.impwait(driver, 45);
        return driver;
	}

}
