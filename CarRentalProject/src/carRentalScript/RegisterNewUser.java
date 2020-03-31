package carRentalScript;


import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectRepository.IndexPage;
import utilityFunctions.GetExcelData;

public class RegisterNewUser {

	public static Logger log = LogManager.getLogger(RegisterNewUser.class.getName());
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","servers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Maximize Browser Window
		driver.manage().window().maximize();
		
		//Implicit Wait for 20 seconds
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Creating Object for Index Page
		IndexPage indexPage = new IndexPage(driver);
		//Creating Object for GetExcelData to get Register User Data From Excel
		GetExcelData regUserData = new GetExcelData();
		Map<String, String> data = regUserData.getData("resources/carrentaldata.xlsx", "registeruser");
		
		//Open Car Rental Index Page
		driver.get("http://localhost/carrental/index.php");
		
		log.info("**************** Starting Regiser New User Test Case *****************");
		
		//Click on Login / Register button
		indexPage.loginRegisterButton().click();
		log.info("Clicked on Login / Register Button");
		WebDriverWait wait= new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(indexPage.signUpLink()));
		
		//Click on Sign Up Link
		indexPage.signUpLink().click();
		log.info("Clicked on Sign Up Link");
		
		//Enter Full Name
		indexPage.fullName().sendKeys(data.get("fullname"));
		log.info("Entered Full Name in Full Name Text Box");
		
		//Enter Mobile Name
		indexPage.mobilenumber().sendKeys(data.get("mobile"));
		log.info("Entered Mobile Number in Mobile Number Text Box");
		
		//Enter Email Address
		indexPage.emailaddress().sendKeys(data.get("email"));
		log.info("Entered Email Address in Email Address Text Box");
				
		//Enter Password
		indexPage.password().sendKeys(data.get("password"));
		log.info("Entered Password in Password Text Box");
		
		//Enter Confirm Password
		indexPage.confirmpassword().sendKeys(data.get("password"));
		log.info("Entered Password in Confirm Password Text Box");

		//Click on Sign UP Button
		indexPage.signUpButton().click();
		log.info("Clicked on Sign Up Button");
		System.out.println("Clicked on sign up button");
		
		//Verify the Alert Message
		String expectedAlertMessage = "Registration successfull. Now you can login";
		String actualAlertMessage = driver.switchTo().alert().getText();
		if(expectedAlertMessage.equalsIgnoreCase(actualAlertMessage)) {
			log.info("Successful Registration Alert Message is Verified Successfully");
		}
		else {
			log.error("Successful Registration Alert Message Can't be verified");
		}
		driver.switchTo().alert().dismiss();
		
		log.info("**************** Ending Regiser New User Test Case *****************");
		
		driver.close();
		
	}

}
