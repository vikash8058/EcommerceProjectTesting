package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;

public class HomePageTest extends BaseTest {

	@Test
	public void verifyTitle() {

		String title = driver.getTitle();
		Assert.assertTrue(title.contains("4892"));
	}
}
