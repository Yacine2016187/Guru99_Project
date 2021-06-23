package Guru99.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

		Properties pro;
		
		public ReadConfig()
		{
			File src=new File("./Configuration\\config.properties");
			try {
				FileInputStream fis=new FileInputStream(src);
				pro=new Properties();
				pro.load(fis);
			} catch (Exception e) {
				System.out.println("Exception is "+e.getMessage());
			}
			
			
			
		}
		public String GetApplicationURl() {
			String url=pro.getProperty("baseURL");
			return url;
			
		}
		public String Getusername() {
			String username=pro.getProperty("UserID");
			return username;
			
		}
		public String GetPassword() {
			String password=pro.getProperty("Password");
			return password;
			
		}
		public String GetChromePath() {
			String Chrome=pro.getProperty("ChromePath");
			return Chrome;
			
		}
		
		public String GetMozillaPath() {
			String Mozilla=pro.getProperty("MozillaPath");
					return Mozilla;
		}
}
