package com.eleks.demo.core.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eleks.demo.core.web.WebPage;
import com.eleks.demo.core.web.elements.Button;
import com.eleks.demo.core.web.elements.Link;
import com.eleks.demo.core.web.elements.TextInput;

public class LoginPage extends WebPage<LoginPage> {
	
	private static final String Page_Url = "https://mail.ukr.net/desktop/login";

	public LoginPage(WebDriver driver) {
		super(driver);
	
	}

	@Override
	public LoginPage load() {
		driver.get(Page_Url);
		return this;
	}

	@Override
	public boolean isAvailable() {
		return getUsernameInput().isAvailable() && 
				getPasswordInput().isAvailable() &&
				getLoginButton().isAvailable();
	}
	public MailPage loginAs(String username, String password){
		getUsernameInput().inputText(username);
		getPasswordInput().inputText(password);
		getLoginButton().click();
		return new MailPage(driver).waitUntillAvailable();
	} 
	
	private TextInput getUsernameInput(){
		return new TextInput(driver, By.id("login")); 
	}
	private TextInput getPasswordInput(){
		return new TextInput(driver, By.id("password")); 
	}
	private Button getLoginButton(){
		return new Button(driver, By.xpath("//*[@id='login-form']/div[3]/button"));
	}

	
}