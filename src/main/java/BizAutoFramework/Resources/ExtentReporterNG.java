package BizAutoFramework.Resources;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporterNG {
	
	
	public static ExtentReports getReportObject()
	{
		Date d = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("E_dd-MM-yyyy_HH-mm-ss");
		dateFormat.setTimeZone(TimeZone.getTimeZone("IST")); // Set the time zone explicitly
		String fileName = "AutomationReport_" + dateFormat.format(d) + "_IST.html";
	
		String path = System.getProperty("user.dir")+"//Reports//"+fileName;
		ExtentSparkReporter reporter  = new ExtentSparkReporter(path);
		reporter.config().setTheme(Theme.STANDARD);
		reporter.config().setEncoding("utf-8");
		reporter.config().setReportName("Mahesh");
		reporter.config().setDocumentTitle("Automation Results");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Mahesh");
		extent.setSystemInfo("Organization", "BizAcuity");
		return extent;
		
		
	}

}
