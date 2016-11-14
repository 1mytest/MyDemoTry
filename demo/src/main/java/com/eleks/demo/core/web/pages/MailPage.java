package com.eleks.demo.core.web.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.eleks.demo.core.web.WebPage;
import com.eleks.demo.core.web.elements.Link;

public class MailPage extends WebPage<MailPage> {
	
	private static final String Page_Url = "https://mail.ukr.net/desktop#msglist/f0/p0";

	public MailPage(WebDriver driver) {
		super(driver);
	
	}
	
	@Override
	public MailPage load() {
		driver.get(Page_Url);
		return this;
	}

	@Override
	public boolean isAvailable() {
		
		return getInboxLink().isAvailable();
	}
	public List<WebElement> getSubject(){
		return driver.findElements(By.className("msglist__row_href"));
	}
	public boolean isSubjectPresent(String subject) {
		List<WebElement> list = getSubject();
		for(int i=0; i<list.size(); i++){
			System.out.println(list.get(i).getText());
			if (list.get(i).getText().startsWith(subject)){
				return true;
			}		
		}
		return false;
	}
	
	
	private Link getInboxLink(){
		return new Link(driver, By.className("sidebar__list-link-name"));
	}

}
