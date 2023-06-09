package SeleniumTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
public static void main(String[] args) {
	ExtentReporter extent = new ExtentReporter() {
	};
	ExtentSparkReporter spark= new ExtentSparkReporter("G:/Automation/SeleniumFrameWork/test-output");
	((ExtentReports) extent).attachReporter(spark);
}
}

