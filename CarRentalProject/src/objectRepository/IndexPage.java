package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IndexPage {
	WebDriver driver;

	public IndexPage(WebDriver driver){
		this.driver = driver;
	}

	//Return Login/Register Button Element
	public WebElement loginRegisterButton() {
		return driver.findElement(By.xpath("//a[text()='Login / Register']"));
	}

	//Return Sign Up Link Element
	public WebElement signUpLink() {
		return driver.findElement(By.xpath("//a[text()='Signup Here']"));
	}

	//Return Full Name Element on Registration Form
	public WebElement fullName() {
		return driver.findElement(By.xpath("//input[@name='fullname']"));
	}

	//Return Mobile Number Element on Registration Form
	public WebElement mobilenumber() {
		return driver.findElement(By.xpath("//input[@name='mobileno']"));
	}

	//Return Email Address Element on Registration Form
	public WebElement emailaddress() {
		return driver.findElement(By.xpath("//input[@name='emailid']"));
	}

	//Return Password Text Box Element on Registration Form
	public WebElement password() {
		return driver.findElement(By.xpath("//input[@name='password' and @placeholder='Password']"));
	}

	//Return Confirm Password Text Box Element on Registration Form
	public WebElement confirmpassword() {
		return driver.findElement(By.xpath("//input[@name='confirmpassword' and @placeholder='Confirm Password']"));
	}

	//Return Sign Up Button Element on Registration Form
	public WebElement signUpButton() {
		return driver.findElement(By.xpath("//input[@name='signup']"));
	}

	

}
