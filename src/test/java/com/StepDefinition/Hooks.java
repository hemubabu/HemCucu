package com.StepDefinition;

import com.baseclass.CommonMethods;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends CommonMethods {
	CommonMethods C = new CommonMethods();

	static long startTime;
	@Before
	public void beforeScenario() {
		System.out.println("Before Scenario");
		startTime=System.currentTimeMillis();
		C.launch();
		System.out.println(startTime);
		
	}
	@After
	public void afterScenario() {
		System.out.println("After Scenario");
		driver.quit();	
		long endtime = System.currentTimeMillis();
		System.out.println(endtime-startTime);
	}
}
