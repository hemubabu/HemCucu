package com.StepDefinition;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.baseclass.CommonMethods;
import com.objectrepository.Locators;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipOilStepDefinition extends CommonMethods {
	CommonMethods C = new CommonMethods();
	Locators L = new Locators();
	//public static WebDriver driver;// static int a;
	public static String Oil;
	public static String Price;

	
	

	@Given("User quits the button")
	public void user_quits_the_button() {
		
		L.getClose().click();	    
	}

	@When("User enters beard oil name")
	public void user_enters_beard_oil_name() {
		
		L.getSearch();
		C.sendText(L.getSearch(),"ustra beard growth oil");
	}

	@When("User choose the beard oil")
	public void user_choose_the_beard_oil() throws InterruptedException {
		 WebElement beardoil=driver.findElement(By.xpath("(//a[contains(text(),'USTRAA ')])[1]"));
		 Oil = beardoil.getText();
		 System.out.println(Oil);
		 Thread.sleep(3000);
		 beardoil.click();	 
		
	}

	@Then("User Validates the price")
	public void user_validates_the_price() throws Throwable {
		
		C.windowsHandle();
		
		WebElement price=driver.findElement(By.xpath("(//div[text()='₹297'])[1]"));
		String Price =price.getText();
		System.out.println("Price of beard growth oil is" +Price);
		
		Map<String,String>M = new HashMap<>();
		M.put(Oil, Price);
		System.out.println(M);
	    	}

}
