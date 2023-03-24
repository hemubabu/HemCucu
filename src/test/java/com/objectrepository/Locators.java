package com.objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.CommonMethods;

public class Locators extends CommonMethods{
	public Locators(){
		PageFactory.initElements(driver,this);
		
	}
	@FindBy(xpath="//button[text()='✕']")
	private WebElement close;
	
	public WebElement getClose() {
		return close;
	}
	
	
	
	
	@FindBy(name="q")
	private WebElement search;
	
	public WebElement getSearch() {
		return search;
	}

}
