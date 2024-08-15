package com.StepDef;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.POMClass.CalculatorPage;
import com.baseClass.BaseClass;
import com.pageObjManager.PageObjectManager;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CalculatorPage_StepDef extends BaseClass {
	
	public static CalculatorPage cal;
	public static PageObjectManager instance;

	
	
	@After
	public void setUp() {
		
		cal = new CalculatorPage(driver);
	}
	
	@Given("the user is on the Retirement Savings Calculator page")
	public void the_user_is_on_the_retirement_savings_calculator_page() {
		cal = new CalculatorPage(driver); 
	 	 cal.getBrowserUrl();
	    
	}
	
	@When("the user enters the current age")
	public void the_user_enters_the_current_age() throws IOException {
		
		cal = new CalculatorPage(driver); 
		scroll(driver, 0, 450);
		cal.getAge();
	}
	
	@When("the user enters the retirement age")
	public void the_user_enters_the_retirement_age() throws IOException {
		cal.getRetireAge();
	}
	@When("the user enters the current annual income")
	public void the_user_enters_the_current_annual_income() throws IOException {
	    
		cal.getAnnualIncome();
	}
	@When("the user enters the spouse’s annual income")
	public void the_user_enters_the_spouse_s_annual_income() throws IOException {
	    
		cal.getSpouseAnnualIncome();
	}
	@When("the user enters the current retirement savings")
	public void the_user_enters_the_current_retirement_savings() throws IOException {
	    
	    cal.getSavingBalance();
	}
	@When("the user enters the current retirement contribution")
	public void the_user_enters_the_current_retirement_contribution() throws IOException {
	    
	    cal.getAnnualSaving();
	}
	@When("the user enters the annual retirement contribution increase")
	public void the_user_enters_the_annual_retirement_contribution_increase() throws IOException {
	    
	    cal.getRate();
	}
	
	@When("the user toggles Social Security Income as Yes")
	public void the_user_toggles_social_security_income_as_yes() {

		cal.getSocialBenefitsYes();
	}
	
	@When("the user toggles Social Security Income as No")
	public void the_user_toggles_social_security_income_as_no() {

		cal.getSocialBenefitsNo();
	}
	
	@When("the user selects relationship status")
	public void the_user_selects_relationship_status() throws IOException {
	    
	    cal.getMaritalStatus();
	}
	@When("the user enters the Social Security Override amount")
	public void the_user_enters_the_social_security_override_amount() throws IOException {
	   
		cal.getSecurityOverride();
	    
	}
	@When("the user enters additional\\/other income")
	public void the_user_enters_additional_other_income() throws IOException {
	 
		cal.clickDefaultValue();
		cal.getAddIncome();
	    
	}
	@When("the user enters the number of years retirement needs to last")
	public void the_user_enters_the_number_of_years_retirement_needs_to_last() throws IOException {
	    
		cal.getNoYrs();
	    
	}
	
	@When("the user selects post-retirement income increase with inflation as Yes")
	public void the_user_selects_post_retirement_income_increase_with_inflation_as_yes() throws IOException  {
	
		cal.getInflation();
	}
	
	@When("the user enters the expected inflation rate")
	public void the_user_enters_the_expected_inflation_rate() throws IOException {
	    
		cal.getExpectedInflation();
	    
	}
	@When("the user enters the percent of final annual income desired")
	public void the_user_enters_the_percent_of_final_annual_income_desired() throws IOException {
		cal.getFinalIncome();
	    
	}
	@When("the user enters the pre-retirement investment return")
	public void the_user_enters_the_pre_retirement_investment_return() throws IOException {
	    
		cal.getPreRetire();
	    
	}
	@When("the user enters the post-retirement investment return")
	public void the_user_enters_the_post_retirement_investment_return() throws IOException {
		cal.getPostRetireInv();
		cal.clickSave();
	}
	@When("the user submits the form")
	public void the_user_submits_the_form() throws IOException {
	    cal.getClickCalculator();
	    
	}
	@Then("the calculator should display the retirement savings results")
	public void the_calculator_should_display_the_retirement_savings_results() throws IOException {
	    
	    cal.getResultMessage();
	    
	}

	@After
	public void tearDown() {
		
		terminatebBrowser();
		
	}
	
}
