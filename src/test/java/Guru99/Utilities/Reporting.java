package Guru99.Utilities;

import java.io.File;
import java.util.Date;
import java.text.SimpleDateFormat;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;



public class Reporting extends TestListenerAdapter{

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	public void onStart() {
		
		String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName="Test-report-"+timestamp+"html";
		 htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/"+repName);
         extent=new ExtentReports();
         
         extent.attachReporter(htmlReporter);
         extent.setSystemInfo("Host name", "Local Host");
         extent.setSystemInfo("Environement", "QA");
         extent.setSystemInfo("User", "Yacine");
         
         htmlReporter.config().setDocumentTitle("Ebanking Test Project");
         htmlReporter.config().setReportName("Functional Test Auto Report");
         htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
         htmlReporter.config().setTheme(Theme.DARK);
	}
         public void onTestSuccess(ITestResult tr)
         {
        	 logger=extent.createTest(tr.getName());
        	 logger.log(Status.PASS	,MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
         }
         public void onTestFailure(ITestResult tr)
         {
        	 logger=extent.createTest(tr.getName());
        	 logger.log(Status.FAIL	,MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
        	 
        	 String screenShotPath=System.getProperty("user.dir"+ "\\ScreenShot\\"+tr.getName()+".png");
        	 File f=new File(screenShotPath);
        	 if (f.exists())
        	 {
        		 try {
					logger.fail("ScreenShot is below:"+logger.addScreenCaptureFromPath(screenShotPath));
				} catch (Exception e) {
					e.printStackTrace();
				}
        	 }
        	 
         }
         public void onTeskSkipped(ITestResult tr)
    	 {
    		 logger=extent.createTest(tr.getName());
    		 logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
    	 }
        /* public void onFinish(ITestContext testcontext)
         {
        	 extent.flush();
         }*/
	}

