package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.RegisterPage;

public class RegisterTest extends BaseTest {

	// Test 1 → Valid Registration
	@Test
	public void verifyUserRegistrationValid() {

		RegisterPage register = new RegisterPage(driver);

		register.openRegisterPage();

		String username = "rahul" + System.currentTimeMillis();

		register.fillRegistrationForm("Rahul", "Sharma", "MG Road", "Bhopal", "MP", "462001", "9876543210", "12345",
				username, "12345");

		register.clickRegister();

		Assert.assertTrue(register.isRegistrationSuccessful(), "Registration failed");
	}

	// Test 2 → Another user registration
	@Test
	public void verifySecondUserRegistration() {

		RegisterPage register = new RegisterPage(driver);

		register.openRegisterPage();

		String username = "vikash" + System.currentTimeMillis();

		register.fillRegistrationForm("Vikash", "Prajapati", "Indrapuri", "Bhopal", "MP", "462022", "9123456780",
				"54321", username, "12345");

		register.clickRegister();

		Assert.assertTrue(register.isRegistrationSuccessful(), "Second Registration failed");
	}
}
