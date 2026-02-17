package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

	public static ExtentReports extent;

	public static ExtentReports getReport() {

		if (extent == null) {
			String path = System.getProperty("user.dir") + "/reports/ExtentReport.html";
			ExtentSparkReporter reporter = new ExtentSparkReporter(path);
			extent = new ExtentReports();
			extent.attachReporter(reporter);
		}
		return extent;
	}
}
