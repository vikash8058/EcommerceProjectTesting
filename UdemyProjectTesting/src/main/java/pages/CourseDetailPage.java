package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.WaitUtil;

public class CourseDetailPage extends BasePage {

	public CourseDetailPage(WebDriver driver) {
		super(driver);
	}

	// Generic title XPath - works for any course
	@FindBy(xpath = "//h1")
	private WebElement courseTitle;

	// Generic rating XPath - works for any rating value
	@FindBy(xpath = "//span[contains(@class,'rating-number')]")
	private WebElement courseRating;

	// Try multiple XPaths for instructor
	@FindBy(xpath = "//a[contains(@href,'/user/')]")
	private WebElement instructorName;

	public boolean isCoursePageDisplayed() {
		try {
			Thread.sleep(3000);
			WaitUtil.waitForElementVisible(driver, courseTitle);
			return courseTitle.isDisplayed();
		} catch (Exception e) {
			return driver.getCurrentUrl().contains("udemy.com/course");
		}
	}

	public String getCourseTitle() {
		try {
			WaitUtil.waitForElementVisible(driver, courseTitle);
			return courseTitle.getText();
		} catch (Exception e) {
			return "";
		}
	}

	public String getCourseRating() {
		try {
			WaitUtil.waitForElementVisible(driver, courseRating);
			return courseRating.getText();
		} catch (Exception e) {
			return "";
		}
	}

	public String getInstructorName() {
		try {
			WaitUtil.waitForElementVisible(driver, instructorName);
			return instructorName.getText();
		} catch (Exception e) {
			return "";
		}
	}
}