package Guru99.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {

	WebDriver driver ;
		
	public Login_Page(WebDriver driver){
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (name="uid")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy (name="password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy (name="btnLogin")
	@CacheLookup
	WebElement btnLogin ;
	
	
	public void setUserName(String Uname) {
		txtUserName.sendKeys(Uname);	
		
	}
	
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);	
		
	}
	
	public void clickSubmit() {
		btnLogin.click();	
		
	}

	}


