package com.POMInterface;

public interface CalculatorPageInterface {
	
	String age = "current-age";
	String retirement_age= "retirement-age";
	String current_income = "//input[@id = 'current-income']";
	String spouse_income= "//input[@id = 'spouse-income']";
	String current_savings = "current-total-savings";
	String annual_savings = "current-annual-savings";
	String saving_rate = "savings-increase-rate";
	String social_benefits = "//label[@for='yes-social-benefits']";
	String social_benefitsno = "//label[@for='no-social-benefits']";
	String marital_status = "//label[@for='married']";
	String marital_status_single = "//label[@for='single']";
	String social_security = "social-security-override";
	String calculator_btn ="//button[contains(text(), 'Calculate')]";
	String resultMsg ="result-message";
	String defaultValue = "//a[contains(text(), 'Adjust default values')]";
	String addIncome = "additional-income";
	String retire_duration = "retirement-duration";
	String inflation = "//label[@for='include-inflation']";
	String expectInflation = "expected-inflation-rate";
	String retirIncome = "retirement-annual-income";
	String preRetirIncome = "pre-retirement-roi";
	String postRetirIncome = "post-retirement-roi";
	String save_Btn = "//button[contains(text(), 'Save changes')]";
	
	
	
}
