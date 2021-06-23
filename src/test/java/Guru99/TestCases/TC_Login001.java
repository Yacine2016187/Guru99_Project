package Guru99.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Guru99.PageObject.Login_Page;


public class TC_Login001 extends Base_Class  {


	@Test
	public void logintest() {
		
		
		logger.info("URL is opened");
		Login_Page lp=new Login_Page(driver);
		
		
		lp.setUserName(UserID);
		logger.info("Entrend Username");
		
		lp.setPassword(Password);
		logger.info("Entred Password");
		lp.clickSubmit();
		
		if(driver.getTitle().equals(" Guru99 Bank Home Page ") ) {
			
			Assert.assertTrue(true);
		}else {
			Assert.assertFalse(false);
		}
	}

}
