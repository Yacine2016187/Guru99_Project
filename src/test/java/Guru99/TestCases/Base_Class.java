package Guru99.TestCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import Guru99.Utilities.ReadConfig;


public class Base_Class {

	ReadConfig readconfig=new ReadConfig();
	
public String baseURL=readconfig.GetApplicationURl();
public String UserID =readconfig.Getusername();
public String Password= readconfig.GetPassword();
public static WebDriver driver;	
public static Logger logger;
@Parameters("browser")
@BeforeClass 
	public void setup(String br)
{
		
		 logger=Logger.getLogger("eBanking");
		PropertyConfigurator.configure("log4j.properties");
		
		
		if (br.equals("chrome")) {
		
			System.setProperty("webdriver.chrome.driver", readconfig.GetChromePath());
		 driver=new ChromeDriver();
		}
		
		else if(br.equals("Mozilla")) {
			
			System.setProperty("webdriver.gecko.driver", readconfig.GetMozillaPath());
			driver=new FirefoxDriver();
		}
		driver.get(baseURL);
	}
	
@AfterClass
public void teardown() {
	
	driver.quit();
}
	

}
