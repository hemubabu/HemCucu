package com.baseclass;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonMethods {
	public static WebDriver driver;
	public void launch() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver(); 
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public void sendText(WebElement ele,String input) {
		ele.sendKeys(input,Keys.ENTER);
		
		
	}
	public void windowsHandle() throws Throwable {
		Thread.sleep(3000);
		String PWin=driver.getWindowHandle();
		Set<String> CWin=driver.getWindowHandles();
		List <String> child= new ArrayList<String>(CWin);
		String Childwindow = child.get(1);
		Thread.sleep(3000);
		driver.switchTo().window(Childwindow);	

	}

}
