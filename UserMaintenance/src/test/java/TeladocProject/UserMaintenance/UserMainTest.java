package TeladocProject.UserMaintenance;
import java.io.IOException;
import org.testng.annotations.Test;
import pageObject.UserPage;
import resources.Base;

public class UserMainTest extends Base {

	@Test
	public void createUser() throws IOException {//Creating User and validating it
		System.out.println("UserMain.createUser(): Creating User and validating it");
		driver = intializeDriver();
		driver.navigate().to("https://protect-us.mimecast.com/s/Dq2tCqx82YfMWNPOFZubbx?domain=way2automation.com");
		Wrapper.impwait(driver, 30);
		UserPage up = new UserPage(driver);
		up.adduser();

		// Implicit 
		Wrapper.impwait(driver, 45);

		driver.quit();
	}

	@Test
	public void deleteuser() throws IOException {
		System.out.println("UserMain.deleteuser(): Deleting User and validating it");
		driver = intializeDriver();
		driver.navigate().to("https://protect-us.mimecast.com/s/Dq2tCqx82YfMWNPOFZubbx?domain=way2automation.com");
		Wrapper.impwait(driver, 30);
		UserPage up = new UserPage(driver);
		up.deleteuser("novak");
		Wrapper.impwait(driver, 10);
		System.out.println("UserMain.deleteuser(): novak is deleted");

		driver.quit();

	}

}
