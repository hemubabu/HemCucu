package com.StepDefinition;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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

public class FlipPhonesstepdefinition extends CommonMethods{
	CommonMethods C = new CommonMethods();
	Locators L = new Locators();
	static String phone;
	static File F;
	
	@Given("User quit the button")
	public void user_quit_the_button() {
	   L.getClose().click();
	}

	@When("User enters the phone name")
	public void user_enters_the_phone_name() {
		L.getSearch();
		C.sendText(L.getSearch(), "OnePlus");
	}

	@Then("User prints the phone name")
	public void user_prints_the_phone_name() throws InterruptedException, Throwable {
		
		System.out.println("OnePlus Models");
		Thread.sleep(3000);
		List<WebElement> oneplus = driver.findElements(By.xpath("//a[contains(@title,'OnePlus ')]"));
		for(int i=0;i<oneplus.size();i++) {
			WebElement oneplusphoneslist = oneplus.get(i);
			String Onepluslist = oneplusphoneslist.getText();
			System.out.println(Onepluslist);
		}	
		}
	@When("User enters the multiple phones names {string}")
	public void user_enters_the_multiple_phones_names(String Phones) {
	    phone=Phones;
	    L.getSearch();
	    C.sendText(L.getSearch(), phone);
		
	}

	@Then("User Validates the multiple phone names")
	public void user_validates_the_multiple_phone_names() throws InterruptedException, Throwable {
		File F = new File("C:\\Users\\HEMU\\eclipse-workspace2\\MarCucumber\\target\\Models.xlsx");
		Workbook W = new XSSFWorkbook();
		Sheet S = W.createSheet("Models Sheet");
		System.out.println("Samsung LG Oppo Models");
		Thread.sleep(3000);
		List<WebElement> Phones = driver.findElements(By.xpath("//a[contains(@title,'"+phone+"')]"));
		for(int i=0;i<Phones.size();i++) {
			WebElement phones = Phones.get(i);
			String phoneslist = phones.getText();
			Row r = S.createRow(i);
			Cell c = r.createCell(0);
			c.setCellValue(phoneslist);
			System.out.println(phoneslist);
		}
		FileOutputStream Fout = new FileOutputStream(F);
		W.write(Fout);
		
	    
	}
	   


}