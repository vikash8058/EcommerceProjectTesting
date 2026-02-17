package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends BasePage {

	public RegisterPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// Locators
	@FindBy(linkText = "Register")
	WebElement registerLink;

	@FindBy(id = "customer.firstName")
	WebElement firstName;

	@FindBy(id = "customer.lastName")
	WebElement lastName;

	@FindBy(id = "customer.address.street")
	WebElement address;

	@FindBy(id = "customer.address.city")
	WebElement city;

	@FindBy(id = "customer.address.state")
	WebElement state;

	@FindBy(id = "customer.address.zipCode")
	WebElement zipCode;

	@FindBy(id = "customer.phoneNumber")
	WebElement phone;

	@FindBy(id = "customer.ssn")
	WebElement ssn;

	@FindBy(id = "customer.username")
	WebElement username;

	@FindBy(id = "customer.password")
	WebElement password;

	@FindBy(id = "repeatedPassword")
	WebElement confirmPassword;

	@FindBy(xpath = "//input[@value='Register']")
	WebElement registerBtn;

	@FindBy(xpath = "//h1[contains(text(),'Welcome')]")
	WebElement successMessage;

	// Actions
	public void openRegisterPage() {
		registerLink.click();
	}

	public void fillRegistrationForm(String fname, String lname, String addr, String cityName, String stateName,
			String zip, String phoneNo, String ssnNo, String user, String pass) {

		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		address.sendKeys(addr);
		city.sendKeys(cityName);
		state.sendKeys(stateName);
		zipCode.sendKeys(zip);
		phone.sendKeys(phoneNo);
		ssn.sendKeys(ssnNo);
		username.sendKeys(user);
		password.sendKeys(pass);
		confirmPassword.sendKeys(pass);
	}

	public void clickRegister() {
		registerBtn.click();
	}

	public boolean isRegistrationSuccessful() {
		return successMessage.isDisplayed();
	}
}
