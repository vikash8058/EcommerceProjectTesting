package listeners;

import base.DriverFactory;
import utils.ExtentReportManager;
import utils.ScreenshotUtil;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.*;

public class TestListener implements ITestListener {

	ExtentReports extent = ExtentReportManager.getReport();
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		test.pass("Test Passed");
	}

	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());
		String path = ScreenshotUtil.captureScreenshot(DriverFactory.getDriver(), result.getName());
		test.addScreenCaptureFromPath(path);
	}

	public void onFinish(org.testng.ITestContext context) {
		extent.flush();
	}
}
