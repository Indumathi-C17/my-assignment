package com.TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions (
		
		features = "src\\test\\java\\com\\featureFile\\Retirement_Savings_Calculator.feature",	
				
		glue = "com.StepDef",
		
		tags = "@calculator1 or @calculator2 or @update",
		

		//dryRun = true, 
		
		//	publish = true, 
		
				
		plugin = {"html:HTMLReports1/report.html", 
				
				"json:JsonReports1/report.json",

				"pretty"
				
		
				
		}
		)

public class TestRunner {

}
