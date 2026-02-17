package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickRegister() {
        driver.findElement(By.linkText("Register")).click();
    }

    public void clickLogin() {
        driver.findElement(By.name("username")).click();
    }

    public void clickOpenAccount() {
        driver.findElement(By.linkText("Open New Account")).click();
    }

    public void clickTransferFunds() {
        driver.findElement(By.linkText("Transfer Funds")).click();
    }

    public void clickBillPay() {
        driver.findElement(By.linkText("Bill Pay")).click();
    }

    public void clickFindTransactions() {
        driver.findElement(By.linkText("Find Transactions")).click();
    }

    public void clickUpdateContactInfo() {
        driver.findElement(By.linkText("Update Contact Info")).click();
    }
}
