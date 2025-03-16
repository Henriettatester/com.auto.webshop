package com.webshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterPageTests extends BaseTest{
	
	@Test(priority = 3)
	public void testExistingUserValidation()
	{
		Logger = report.createTest("Test Existing User Validation");
		String homePageTitle = homePage.getHomePageTitle();
		Logger.pass("Getting home page title");
		System.out.println(homePageTitle);
		Assert.assertTrue(homePageTitle.contains("Demo Web Shop"));
		Logger.pass("home page title validated");
		homePage.clickRegisterLink();
		Logger.pass("Clicked register link");
		registerPage.clickMaleRadioButton();
		Logger.pass("Clicked Male radio button");
		registerPage.enterFirstName("ab");
		Logger.pass("Entered ab as First name");
		registerPage.enterLastName("cd");
		Logger.pass("Entered cd as Last name");
		registerPage.enterEmail("ab@test.com");
		Logger.pass("Entered ab@test.com as email");
		registerPage.enterPassword("pass@123");
		Logger.pass("Entered pass@123 as password");
		registerPage.enterConfirmPassword("pass@123");
		Logger.pass("Entered pass@123 as confirm password");
		registerPage.clickregisterButton();
		Logger.pass("Clicked register button");
		String errMessage = registerPage.getEmailExistsText();
		System.out.println(errMessage);		
		Assert.assertTrue(errMessage.contains("email already exists"));
		Logger.pass("Verified error message for existing user");
	}
	
	@Test(priority = 1)
	public void testRegisterPageLanding()
	{	
		Logger = report.createTest("Test RegisterPage Landing");
		homePage.clickRegisterLink();
		Logger.pass("Clicked register link");
		String registerPageTitle = registerPage.getRegisterPageTitle();
		System.out.println(registerPageTitle);
		Assert.assertTrue(registerPageTitle.contains("Register"));
		Logger.pass("validated register page title");
		boolean registerText = registerPage.isRegisterTextDisplayed();
		System.out.println(registerText);
		Assert.assertTrue(registerText);
		Logger.pass("validated register text present on page");
	}
	
	@Test(priority = 2)
		public void testRegisterform() {
		String homePageTitle = homePage.getHomePageTitle();
		System.out.println(homePageTitle);
		homePage.clickRegisterLink();
		registerPage.clickMaleRadioButton();
		registerPage.enterFirstName("John");
		registerPage.enterLastName("Doe");
		registerPage.enterEmail("johndoe@test.com");
		registerPage.enterPassword("pass@123");
		registerPage.enterConfirmPassword("pass@123");
	}

}
