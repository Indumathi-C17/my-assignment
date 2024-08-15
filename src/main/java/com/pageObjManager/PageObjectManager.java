package com.pageObjManager;

import org.openqa.selenium.WebDriver;

import com.POMClass.CalculatorPage;
import com.configProperty.ConfigReader;
import com.utility.UtilityClass;



public class PageObjectManager {

	private static PageObjectManager instance;
	private static CalculatorPage calculatorPagInstance;
	private static ConfigReader configInstance;
	private static UtilityClass utilityInstance;
	
	
	private PageObjectManager() {	
		
	}
	
	public static PageObjectManager getTheInstance() {
		if(instance==null) {
			
			instance = new  PageObjectManager();
		}
	
		return instance;
	}
	
	public static CalculatorPage getCalculPagInstance(WebDriver driver) {
		if(calculatorPagInstance ==null) {
			
			calculatorPagInstance = new CalculatorPage(driver);
		}
	
		return calculatorPagInstance;
	}
	
	public static ConfigReader getConfigInstance() {
		if(configInstance==null) {
			
			configInstance = new ConfigReader();
		}
	
		return configInstance;
	}
	
	public static UtilityClass getUtilityInstance() {
		if(utilityInstance==null) {
			
			utilityInstance = new UtilityClass();
		}
	
		return utilityInstance;
	}
	
}

