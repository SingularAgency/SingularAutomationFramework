package BKGT.AppiumFramework;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;



import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentManager {
	
	
	 private static ExtentReports extent;
	    private static ExtentSparkReporter spark;

	    public synchronized static ExtentReports getInstance() throws IOException {
	        if (extent == null) {
	        	FileUtils.deleteDirectory(new File("test-output"));

	            extent = new ExtentReports();
	            spark = new ExtentSparkReporter("test-output/ExtentReport.html");
	            extent.attachReporter(spark);
	        }
	        return extent;
	    }

	    public synchronized static ExtentTest createTest(String testName) {
	        return extent.createTest(testName);
	    }

	
}
