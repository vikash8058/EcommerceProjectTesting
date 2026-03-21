package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.WaitUtil;
import java.util.List;

public class SearchResultsPage extends BasePage {

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[contains(text(),'Ratings') or contains(text(),'Rating')]")
    private WebElement ratingsFilterButton;

    public boolean isResultsDisplayed() {
        try {
            Thread.sleep(3000);
            List<WebElement> courses = driver.findElements(
                By.xpath("//a[contains(@href,'/course/')]")
            );
            return courses.size() > 0;
        } catch (Exception e) {
            return driver.getCurrentUrl().toLowerCase()
                    .contains("search") ||
                   driver.getCurrentUrl().toLowerCase()
                    .contains("courses");
        }
    }

    public void clickFirstCourse() {
        try {
            Thread.sleep(3000);
            List<WebElement> courses = driver.findElements(
                By.xpath("//a[contains(@href,'/course/')]")
            );
            if (courses.size() > 0) {
                String href = courses.get(0).getAttribute("href");
                System.out.println("Navigating to: " + href);
                ((JavascriptExecutor) driver)
                    .executeScript("window.location.href='" + href + "'");
                Thread.sleep(3000);
            } else {
                System.out.println("No courses found on results page");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void applyRatingsFilter() {
        try {
            WaitUtil.waitForElementClickable(driver, ratingsFilterButton);
            ratingsFilterButton.click();
        } catch (Exception e) {
            System.out.println("Rating filter not available");
        }
    }

    // Added back for SearchResultsTest
    public int getCourseCount() {
        try {
            List<WebElement> courses = driver.findElements(
                By.xpath("//a[contains(@href,'/course/')]")
            );
            return courses.size();
        } catch (Exception e) {
            return 0;
        }
    }
}