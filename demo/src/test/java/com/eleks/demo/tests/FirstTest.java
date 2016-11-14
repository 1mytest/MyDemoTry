package com.eleks.demo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.eleks.demo.core.BaseTest;
import com.eleks.demo.core.web.pages.LoginPage;
import com.eleks.demo.core.web.pages.MailPage;


public class FirstTest extends BaseTest {
	@Test
	public void testMethod() {
	final String userName = "tester_demo";
	final String passWord = "TesterDemo1";
	final String subject = "new";
	
	MailPage mailPage = new LoginPage(driver)
		.loadAndWaitUntillAvailable()
		.loginAs(userName, passWord);
	Assert.assertTrue(mailPage.isSubjectPresent(subject), subject+" is not inbox");
	
	try {
		Thread.sleep(2000);
	} catch (Exception e) {}
	}
}
